package org.eclipse.che.plugin.convertigo.maintab.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.maintab.ide.view.MainTabViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MainTabAction extends Action {

    public final static String ACTION_ID = "mainTabAction";

    @Inject
    public MainTabAction(WorkspaceAgent workspaceAgent, MainTabViewPresenter mainTabViewPresenter) {
        super();

		// Open the tab on the left
        workspaceAgent.openPart(mainTabViewPresenter, PartStackType.NAVIGATION);
        workspaceAgent.setActivePart(mainTabViewPresenter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
