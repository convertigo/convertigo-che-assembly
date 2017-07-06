package org.eclipse.che.plugin.convertigo.secondtab.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.secondtab.ide.view.SecondTabViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ShowSecondTabAction extends Action {

    public final static String ACTION_ID = "showSecondTabAction";

	@Inject
	public ShowSecondTabAction(WorkspaceAgent workspaceAgent, SecondTabViewPresenter secondTabViewPresenter) {
		super();

		// Open the second tab view at the bottom
        workspaceAgent.openPart(secondTabViewPresenter, PartStackType.INFORMATION);
        workspaceAgent.setActivePart(secondTabViewPresenter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
