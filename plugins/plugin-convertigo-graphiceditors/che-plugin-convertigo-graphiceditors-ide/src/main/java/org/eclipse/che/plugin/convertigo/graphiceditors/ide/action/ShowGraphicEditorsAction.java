package org.eclipse.che.plugin.convertigo.graphiceditors.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ShowGraphicEditorsAction extends Action {

    public final static String ACTION_ID = "showGraphicEditorsAction";

    @Inject
    public ShowGraphicEditorsAction(WorkspaceAgent workspaceAgent, GraphicEditorsViewPresenter graphicEditorsViewPresenter) {
        super();
        
        workspaceAgent.openPart(graphicEditorsViewPresenter, PartStackType.TOOLING);
        workspaceAgent.setActivePart(graphicEditorsViewPresenter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
