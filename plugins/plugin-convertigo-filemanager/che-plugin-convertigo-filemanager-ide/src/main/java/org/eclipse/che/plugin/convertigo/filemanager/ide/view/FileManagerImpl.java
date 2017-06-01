package org.eclipse.che.plugin.convertigo.filemanager.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class FileManagerImpl extends BaseView<FileManager.ActionDelegate> implements FileManager {

	interface FileManagerImplUiBinder extends UiBinder<Widget, FileManagerImpl> {
	}
	
    private final static FileManagerImplUiBinder UI_BINDER = GWT.create(FileManagerImplUiBinder.class);
	
    @UiField
    FlowPanel fileManagerPanel;
    
	@Inject
	public FileManagerImpl(PartStackUIResources resources) {
		super(resources);
		
        setContentWidget(UI_BINDER.createAndBindUi(this));
	}
}
