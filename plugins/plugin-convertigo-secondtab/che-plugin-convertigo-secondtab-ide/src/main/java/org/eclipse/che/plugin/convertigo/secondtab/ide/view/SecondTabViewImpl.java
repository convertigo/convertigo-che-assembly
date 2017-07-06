package org.eclipse.che.plugin.convertigo.secondtab.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SecondTabViewImpl extends BaseView<SecondTabView.ActionDelegate> implements SecondTabView {

	interface SecondTabViewImplUiBinder extends UiBinder<Widget, SecondTabViewImpl> {
	}

    private final static SecondTabViewImplUiBinder UI_BINDER = GWT.create(SecondTabViewImplUiBinder.class);

    @UiField
    FlowPanel secondTabViewPanel;

	@Inject
	public SecondTabViewImpl(PartStackUIResources resources) {
		super(resources);

        setContentWidget(UI_BINDER.createAndBindUi(this));
        secondTabViewPanel.getElement().setClassName("secondTabView");
	}
}
