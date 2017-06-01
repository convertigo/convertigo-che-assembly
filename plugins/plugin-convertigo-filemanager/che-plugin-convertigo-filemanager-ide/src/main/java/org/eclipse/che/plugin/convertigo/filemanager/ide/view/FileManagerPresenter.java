package org.eclipse.che.plugin.convertigo.filemanager.ide.view;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.editor.EditorAgent;
import org.eclipse.che.ide.api.event.FileEvent;
import org.eclipse.che.ide.api.event.FileEvent.FileEventHandler;
import org.eclipse.che.ide.api.event.FileEvent.FileOperation;
import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.ide.api.resources.File;
import org.eclipse.che.ide.api.resources.VirtualFile;
import org.eclipse.che.ide.resources.impl.ResourceManager;
import org.eclipse.che.plugin.convertigo.filemanager.ide.common.Editor;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

@Singleton
public class FileManagerPresenter extends BasePresenter implements FileManager.ActionDelegate, FileEventHandler {

	private final FileManager fileManager;
	
	private final ResourceManager.ResourceManagerFactory resourceManagerFactory;
	private final ResourceManager resourceManager;
	private final EditorAgent editorAgent;
		
	private Map<File, String> fileToQname = new HashMap<>();

    @Inject
    public FileManagerPresenter(AppContext appContext, FileManager fileManager, ResourceManager.ResourceManagerFactory resourceManagerFactory,
    		EditorAgent editorAgent, EventBus eventBus) {
    	this.fileManager = fileManager;
    	
    	this.resourceManagerFactory = resourceManagerFactory;
        resourceManager = resourceManagerFactory.newResourceManager(appContext.getDevMachine());
        this.editorAgent = editorAgent;    	
        
    	eventBus.addHandler(FileEvent.TYPE, this);
    	exportOpenEditor();
    }
    
    private native void exportOpenEditor() /*-{
		var that = this;
		$wnd.openEditor = function (filePath, qname) {
    		that.@org.eclipse.che.plugin.convertigo.filemanager.ide.view.FileManagerPresenter::openEditor(Ljava/lang/String;Ljava/lang/String;)(filePath, qname);
		};
	}-*/;
    
    private void openEditor(String filePath, String qname) {
    	resourceManager
    		.getWorkspaceRoot()
    		.getFile(filePath)
    		.then((file) -> {
    			if (file.isPresent()) {
    				File fileToOpen = file.get();
    				fileToQname.put(fileToOpen, qname);
        			editorAgent.openEditor(fileToOpen);
    			}
    		});
    }
    
	@Override
	public String getTitle() {
		return "";
	}

	@Override
	public IsWidget getView() {
		return fileManager;
	}

	@Override
	public String getTitleToolTip() {
		return getTitle();
	}

	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(fileManager);
	}
	
	private native void triggerEvent(String event, String qname, String content) /*-{
		var event = new CustomEvent(event, {
		    "detail": {
		    	"qname": qname,
		    	"content": content
		    }
		});
		$doc.dispatchEvent(event);
	}-*/;

	private void triggerEvent(VirtualFile file, String event) {
		file.getContent().then((content) -> {
			String qname = fileToQname.get(file);
			if (qname != null) {
				triggerEvent(event, qname, content);
			}
		});
	}
	
	@Override
	public void onFileOperation(FileEvent event) {
		VirtualFile file = event.getFile();

		if (event.getOperationType() == FileOperation.SAVE) {
			String eventName = null;
			// save bean expression
			if (file.getName().startsWith(Editor.c8o_JscriptStepEditor.toString())) {
				eventName = "save_JscriptStep";
			}
			// save handler transaction
			else if (file.getName().startsWith(Editor.c8o_JscriptTransactionEditor.toString())) {
				eventName = "save_JscriptTransaction";
			}
			
			if (eventName != null) {
				triggerEvent(file, eventName);
			}
		}
	}
}
