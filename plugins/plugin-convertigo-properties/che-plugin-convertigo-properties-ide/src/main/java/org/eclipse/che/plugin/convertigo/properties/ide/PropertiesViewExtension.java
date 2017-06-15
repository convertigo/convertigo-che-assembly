package org.eclipse.che.plugin.convertigo.properties.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.properties.ide.action.ShowPropertiesAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Extension(title = "Properties")
@Singleton
public class PropertiesViewExtension {

    @Inject
    private void configureActions(final ActionManager actionManager, final ShowPropertiesAction showPropertiesViewAction) {
        actionManager.registerAction(ShowPropertiesAction.ACTION_ID, showPropertiesViewAction);
    }
}
