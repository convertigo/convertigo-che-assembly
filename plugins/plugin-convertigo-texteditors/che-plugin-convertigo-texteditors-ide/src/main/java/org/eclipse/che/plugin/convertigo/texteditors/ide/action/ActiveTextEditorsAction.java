package org.eclipse.che.plugin.convertigo.texteditors.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.texteditors.ide.view.TextEditorsPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ActiveTextEditorsAction extends Action {

    public final static String ACTION_ID = "activeTextEditorsAction";

    @Inject
    public ActiveTextEditorsAction(WorkspaceAgent workspaceAgent, TextEditorsPresenter textEditorsPresenter) {
        super();
        
        workspaceAgent.setActivePart(textEditorsPresenter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
