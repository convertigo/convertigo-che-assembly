package org.eclipse.che.plugin.convertigo.information.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class InformationViewImpl extends BaseView<InformationView.ActionDelegate> implements InformationView {
	
	interface InformationViewImplUiBinder extends UiBinder<Widget, InformationViewImpl> {
	}
	
    private final static InformationViewImplUiBinder UI_BINDER = GWT.create(InformationViewImplUiBinder.class);

    @UiField
    FlowPanel informationViewPanel;
    
	@Inject
	public InformationViewImpl(PartStackUIResources resources) {
		super(resources);
		
        setContentWidget(UI_BINDER.createAndBindUi(this));
        informationViewPanel.getElement().setClassName("informationView");
	}
}
