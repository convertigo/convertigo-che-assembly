package org.eclipse.che.plugin.convertigo.maintab.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.maintab.ide.action.MainTabAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Extension(title = "Main tab view")
@Singleton
public class MainTabViewExtension {

    @Inject
    private void configureActions(final ActionManager actionManager, final MainTabAction showMainTabAction) {
        actionManager.registerAction(MainTabAction.ACTION_ID, showMainTabAction);
    }
}
