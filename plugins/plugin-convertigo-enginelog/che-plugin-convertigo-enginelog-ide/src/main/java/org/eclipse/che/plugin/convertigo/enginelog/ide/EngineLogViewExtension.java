package org.eclipse.che.plugin.convertigo.enginelog.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.enginelog.ide.action.ShowEngineLogAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Extension(title = "Engine Log")
@Singleton
public class EngineLogViewExtension {

    @Inject
    private void configureActions(final ActionManager actionManager, final ShowEngineLogAction showEngineLogAction) {
        actionManager.registerAction(ShowEngineLogAction.ACTION_ID, showEngineLogAction);
    }
}
