package org.eclipse.che.plugin.convertigo.projects.ide.view;

import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.plugin.convertigo.projects.ide.ProjectsResources;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ProjectsViewPresenter extends BasePresenter implements ProjectsView.ActionDelegate {

    private final ProjectsView projectsView;

    @Inject
    public ProjectsViewPresenter(final ProjectsView projectsView) {
        this.projectsView = projectsView;
    }

    @Override
    public String getTitle() {
        return "Projects";
    }

    @Override
    public SVGResource getTitleImage() {
        return (ProjectsResources.INSTANCE.icon());
    }

    @Override
    public IsWidget getView() {
        return projectsView;
    }

    @Override
    public String getTitleToolTip() {
        return getTitle();
    }

    @Override
    public void go(AcceptsOneWidget container) {
        container.setWidget(projectsView);
    }
}
