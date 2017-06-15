package org.eclipse.che.plugin.convertigo.properties.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.properties.ide.view.PropertiesViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ShowPropertiesAction extends Action {

    public final static String ACTION_ID = "showPropertiesAction";

	@Inject
	public ShowPropertiesAction(WorkspaceAgent workspaceAgent, PropertiesViewPresenter propertiesViewPresenter) {
		super();

		// Open the properties view at the bottom
        workspaceAgent.openPart(propertiesViewPresenter, PartStackType.INFORMATION);
        workspaceAgent.setActivePart(propertiesViewPresenter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
