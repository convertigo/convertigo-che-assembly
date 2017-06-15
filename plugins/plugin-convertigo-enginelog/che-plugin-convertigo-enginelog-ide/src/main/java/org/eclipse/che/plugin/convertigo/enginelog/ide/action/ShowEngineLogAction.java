package org.eclipse.che.plugin.convertigo.enginelog.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.enginelog.ide.view.EngineLogViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ShowEngineLogAction extends Action {

    public final static String ACTION_ID = "showEngineLogAction";

	@Inject
	public ShowEngineLogAction(WorkspaceAgent workspaceAgent, EngineLogViewPresenter engineLogViewPresenter) {
		super();

		// Open the Engine Log view at the bottom
        workspaceAgent.openPart(engineLogViewPresenter, PartStackType.INFORMATION);
        workspaceAgent.setActivePart(engineLogViewPresenter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
