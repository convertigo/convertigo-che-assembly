package org.eclipse.che.plugin.convertigo.information.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.information.ide.view.InformationViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ShowInformationAction extends Action {

    public final static String ACTION_ID = "showInformationAction";
	
	@Inject
	public ShowInformationAction(WorkspaceAgent workspaceAgent, InformationViewPresenter informationViewPresenter) {
		super();
		
		// Open the information view at the bottom
        workspaceAgent.openPart(informationViewPresenter, PartStackType.INFORMATION);
        workspaceAgent.setActivePart(informationViewPresenter);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
