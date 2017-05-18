package org.eclipse.che.plugin.convertigo.projects.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.projects.ide.view.ProjectsViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ShowProjectsAction extends Action {

    public final static String ACTION_ID = "showProjectsAction";

    @Inject
    public ShowProjectsAction(WorkspaceAgent workspaceAgent, ProjectsViewPresenter projectsViewPresenter) {
        super();
        
		// Open the projects view on the left
        workspaceAgent.openPart(projectsViewPresenter, PartStackType.NAVIGATION);
        workspaceAgent.setActivePart(projectsViewPresenter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
