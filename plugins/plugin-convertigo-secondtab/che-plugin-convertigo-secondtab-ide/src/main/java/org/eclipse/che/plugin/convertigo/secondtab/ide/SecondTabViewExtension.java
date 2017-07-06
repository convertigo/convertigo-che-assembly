package org.eclipse.che.plugin.convertigo.secondtab.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.secondtab.ide.action.ShowSecondTabAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Extension(title = "Second tab")
@Singleton
public class SecondTabViewExtension {

    @Inject
    private void configureActions(final ActionManager actionManager, final ShowSecondTabAction showSecondTabAction) {
        actionManager.registerAction(ShowSecondTabAction.ACTION_ID, showSecondTabAction);
    }
}
