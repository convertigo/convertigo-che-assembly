package org.eclipse.che.plugin.convertigo.main.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MainViewImpl extends BaseView<MainView.ActionDelegate> implements MainView {

	interface MainViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {
	}
	
    private final static MainViewImplUiBinder UI_BINDER = GWT.create(MainViewImplUiBinder.class);
	
    @UiField
    FlowPanel mainViewPanel;
    
	@Inject
	public MainViewImpl(PartStackUIResources resources) {
		super(resources);
		
        setContentWidget(UI_BINDER.createAndBindUi(this));
        mainViewPanel.getElement().setId("mainView");
	}
}
