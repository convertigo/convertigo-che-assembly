package org.eclipse.che.plugin.convertigo.maintab.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MainTabViewImpl extends BaseView<MainTabView.ActionDelegate> implements MainTabView {

    interface MainTabViewImplUiBinder extends UiBinder<Widget, MainTabViewImpl> {
    }

    private final static MainTabViewImplUiBinder UI_BINDER = GWT.create(MainTabViewImplUiBinder.class);

    @UiField
    FlowPanel mainTabViewPanel;

    @Inject
    public MainTabViewImpl(PartStackUIResources resources) {
        super(resources);

        setContentWidget(UI_BINDER.createAndBindUi(this));
        mainTabViewPanel.getElement().setClassName("mainTabView");
    }
}
