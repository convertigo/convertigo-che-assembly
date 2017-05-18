package org.eclipse.che.plugin.convertigo.projects.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface ProjectsView extends View<ProjectsView.ActionDelegate> {

    interface ActionDelegate extends BaseActionDelegate {
    }
}
