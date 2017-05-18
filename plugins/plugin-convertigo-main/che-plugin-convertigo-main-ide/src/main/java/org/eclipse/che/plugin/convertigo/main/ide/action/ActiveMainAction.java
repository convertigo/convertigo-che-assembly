package org.eclipse.che.plugin.convertigo.main.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.main.ide.view.MainViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ActiveMainAction extends Action {

    public final static String ACTION_ID = "activeMainAction";

    @Inject
    public ActiveMainAction(WorkspaceAgent workspaceAgent, MainViewPresenter mainViewPresenter) {
        super();
        
        workspaceAgent.setActivePart(mainViewPresenter);
        // TODO: remove when the URL won't be taken from the user anymore
        workspaceAgent.openPart(mainViewPresenter, PartStackType.NAVIGATION);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
