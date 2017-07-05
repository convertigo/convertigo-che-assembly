package org.eclipse.che.plugin.convertigo.graphiceditors.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class GraphicEditorsViewImpl extends BaseView<GraphicEditorsView.ActionDelegate> implements GraphicEditorsView  {

    interface GraphicsEditorsViewImplUiBinder extends UiBinder<Widget, GraphicEditorsViewImpl> {
    }

    private final static GraphicsEditorsViewImplUiBinder UI_BINDER = GWT.create(GraphicsEditorsViewImplUiBinder.class);

    @UiField
    FlowPanel graphicEditorsViewPanel;

    @Inject
    public GraphicEditorsViewImpl(PartStackUIResources resources) {
        super(resources);

        setContentWidget(UI_BINDER.createAndBindUi(this));
        graphicEditorsViewPanel.getElement().addClassName("graphicEditorsView");
    }
}
