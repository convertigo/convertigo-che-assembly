package org.eclipse.che.plugin.convertigo.projects.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.projects.ide.action.ShowProjectsAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;


@Extension(title = "Projects view")
@Singleton
public class ProjectsViewExtension {

    @Inject
    private void configureActions(final ActionManager actionManager, final ShowProjectsAction showProjectsAction) {
        actionManager.registerAction(ShowProjectsAction.ACTION_ID, showProjectsAction);
    }
}
