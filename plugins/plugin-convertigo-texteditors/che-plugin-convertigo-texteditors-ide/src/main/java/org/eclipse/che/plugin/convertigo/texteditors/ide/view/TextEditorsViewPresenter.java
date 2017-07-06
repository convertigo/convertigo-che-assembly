package org.eclipse.che.plugin.convertigo.texteditors.ide.view;

import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.editor.EditorAgent;
import org.eclipse.che.ide.api.event.FileEvent;
import org.eclipse.che.ide.api.event.FileEvent.FileEventHandler;
import org.eclipse.che.ide.api.event.FileEvent.FileOperation;
import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.ide.api.resources.File;
import org.eclipse.che.ide.api.resources.VirtualFile;
import org.eclipse.che.ide.resources.impl.ResourceManager;
import org.eclipse.che.plugin.convertigo.texteditors.ide.common.TextEditorsEvent;
import org.eclipse.che.plugin.convertigo.texteditors.ide.common.TextEditorsPrefix;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

@Singleton
public class TextEditorsViewPresenter extends BasePresenter implements TextEditorsView.ActionDelegate, FileEventHandler {

	private final TextEditorsView textEditorsView;

	private final ResourceManager.ResourceManagerFactory resourceManagerFactory;
	private final ResourceManager resourceManager;
	private final EditorAgent editorAgent;

    @Inject
    public TextEditorsViewPresenter(
            AppContext appContext,
            TextEditorsView textViewEditors,
            ResourceManager.ResourceManagerFactory resourceManagerFactory,
    		EditorAgent editorAgent,
    		EventBus eventBus) {
    	this.textEditorsView = textViewEditors;

    	this.resourceManagerFactory = resourceManagerFactory;
        resourceManager = resourceManagerFactory.newResourceManager(appContext.getDevMachine());
        this.editorAgent = editorAgent;

    	eventBus.addHandler(FileEvent.TYPE, this);
    	exportOpenEditor();
    }

    private native void exportOpenEditor() /*-{
		var that = this;
		$wnd.CheGWTOpenTextEditor = function (filePath, qname) {
    		that.@org.eclipse.che.plugin.convertigo.texteditors.ide.view.TextEditorsViewPresenter::openEditor(Ljava/lang/String;Ljava/lang/String;)(filePath, qname);
		};
	}-*/;

    private void openEditor(String filePath, String qname) {
    	resourceManager
    		.getWorkspaceRoot()
    		.getFile(filePath)
    		.then((file) -> {
    			if (file.isPresent()) {
    				File fileToOpen = file.get();
    				setFileQname(fileToOpen, qname);
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
		return textEditorsView;
	}

	@Override
	public String getTitleToolTip() {
		return getTitle();
	}

	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(textEditorsView);
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

	private native void setFileQname(VirtualFile file, String qname) /*-{
		localStorage.setItem(file, qname);
	}-*/;

	private native String getQname(VirtualFile file) /*-{
		return localStorage.getItem(file);
	}-*/;

	private void triggerEvent(VirtualFile file, String event) {
		file.getContent().then((content) -> {
			String qname = getQname(file);
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
			if (file.getName().endsWith(TextEditorsPrefix.C8O_JSCRIPT_STEP_EDITOR)) {
				eventName = TextEditorsEvent.SAVE_JSCRIPT_STEP;
			}
			// save handler transaction
			else if (file.getName().endsWith(TextEditorsPrefix.C8O_JSCRIPT_TRANSACTION_EDITOR)) {
				eventName = TextEditorsEvent.SAVE_JSCRIPT_TRANSACTION;
			}

			if (eventName != null) {
				triggerEvent(file, eventName);
			}
		}
	}
}
