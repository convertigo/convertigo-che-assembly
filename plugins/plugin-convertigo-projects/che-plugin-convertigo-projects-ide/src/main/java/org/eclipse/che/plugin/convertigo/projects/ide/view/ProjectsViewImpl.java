package org.eclipse.che.plugin.convertigo.projects.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ProjectsViewImpl extends BaseView<ProjectsView.ActionDelegate> implements ProjectsView {

    interface ProjectsViewImplUiBinder extends UiBinder<Widget, ProjectsViewImpl> {
    }

    private final static ProjectsViewImplUiBinder UI_BINDER = GWT.create(ProjectsViewImplUiBinder.class);

    @UiField
    FlowPanel projectsViewPanel;

    @Inject
    public ProjectsViewImpl(PartStackUIResources resources) {
        super(resources);
        
        setContentWidget(UI_BINDER.createAndBindUi(this));
        projectsViewPanel.getElement().setClassName("projectsView");
    }
}
