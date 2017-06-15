package org.eclipse.che.plugin.convertigo.enginelog.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class EngineLogViewImpl extends BaseView<EngineLogView.ActionDelegate> implements EngineLogView {

	interface EngineLogViewImplUiBinder extends UiBinder<Widget, EngineLogViewImpl> {
	}

    private final static EngineLogViewImplUiBinder UI_BINDER = GWT.create(EngineLogViewImplUiBinder.class);

    @UiField
    FlowPanel engineLogViewPanel;

	@Inject
	public EngineLogViewImpl(PartStackUIResources resources) {
		super(resources);

        setContentWidget(UI_BINDER.createAndBindUi(this));
        engineLogViewPanel.getElement().setClassName("engineLogView");
	}
}
