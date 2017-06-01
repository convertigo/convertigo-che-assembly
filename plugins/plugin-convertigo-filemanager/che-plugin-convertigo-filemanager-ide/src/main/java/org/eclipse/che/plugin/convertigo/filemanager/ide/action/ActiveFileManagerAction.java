package org.eclipse.che.plugin.convertigo.filemanager.ide.action;

import org.eclipse.che.ide.api.action.Action;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.plugin.convertigo.filemanager.ide.view.FileManagerPresenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ActiveFileManagerAction extends Action {

    public final static String ACTION_ID = "activeFileManagerAction";

    @Inject
    public ActiveFileManagerAction(WorkspaceAgent workspaceAgent, FileManagerPresenter fileManagerPresenter) {
        super();
        
        workspaceAgent.setActivePart(fileManagerPresenter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
