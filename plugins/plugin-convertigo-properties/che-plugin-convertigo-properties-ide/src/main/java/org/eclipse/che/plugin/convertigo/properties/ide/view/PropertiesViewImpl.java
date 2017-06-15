package org.eclipse.che.plugin.convertigo.properties.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class PropertiesViewImpl extends BaseView<PropertiesView.ActionDelegate> implements PropertiesView {

	interface PropertiesViewImplUiBinder extends UiBinder<Widget, PropertiesViewImpl> {
	}

    private final static PropertiesViewImplUiBinder UI_BINDER = GWT.create(PropertiesViewImplUiBinder.class);

    @UiField
    FlowPanel propertiesViewPanel;

	@Inject
	public PropertiesViewImpl(PartStackUIResources resources) {
        super(resources);

        setContentWidget(UI_BINDER.createAndBindUi(this));
        propertiesViewPanel.getElement().setClassName("propertiesView");
	}
}
