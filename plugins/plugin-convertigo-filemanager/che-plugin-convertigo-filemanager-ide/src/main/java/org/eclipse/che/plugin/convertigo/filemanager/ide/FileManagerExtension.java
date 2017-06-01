package org.eclipse.che.plugin.convertigo.filemanager.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.filemanager.ide.action.ActiveFileManagerAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Extension(title = "File manager")
@Singleton
public class FileManagerExtension {

	@Inject
	private void configureActions(final ActionManager actionManager, final ActiveFileManagerAction activeFileManagerAction) {
		actionManager.registerAction(ActiveFileManagerAction.ACTION_ID, activeFileManagerAction);
	}
}
