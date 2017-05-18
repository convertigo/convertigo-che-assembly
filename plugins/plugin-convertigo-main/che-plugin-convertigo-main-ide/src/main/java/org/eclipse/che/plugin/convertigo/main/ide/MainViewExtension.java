package org.eclipse.che.plugin.convertigo.main.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.main.ide.action.ActiveMainAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Extension(title = "Main")
@Singleton
public class MainViewExtension {

	@Inject
	private void configureActions(final ActionManager actionManager, final ActiveMainAction activeMainAction) {
		actionManager.registerAction(ActiveMainAction.ACTION_ID, activeMainAction);
	}
}
