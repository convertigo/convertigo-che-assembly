package org.eclipse.che.plugin.convertigo.information.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.information.ide.action.ShowInformationAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Extension(title = "Information")
@Singleton
public class InformationViewExtension {

    @Inject
    private void configureActions(final ActionManager actionManager, final ShowInformationAction showPropertiesViewAction) {
        actionManager.registerAction(ShowInformationAction.ACTION_ID, showPropertiesViewAction);
    }
}
