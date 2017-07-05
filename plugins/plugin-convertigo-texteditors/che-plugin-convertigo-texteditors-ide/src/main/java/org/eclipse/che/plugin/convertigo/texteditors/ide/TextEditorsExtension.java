package org.eclipse.che.plugin.convertigo.texteditors.ide;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.editor.filetype.MultipleMethodFileIdentifier;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.plugin.convertigo.texteditors.ide.action.ActiveTextEditorsAction;
import org.eclipse.che.plugin.convertigo.texteditors.ide.common.TextEditorsPrefix;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Extension(title = "Text editors")
@Singleton
public class TextEditorsExtension {

	@Inject
	private void configureActions(
	        final ActionManager actionManager,
	        final ActiveTextEditorsAction activeTextEditorsAction,
	        final MultipleMethodFileIdentifier multipleMethodFileIdentifier) {
		actionManager.registerAction(ActiveTextEditorsAction.ACTION_ID, activeTextEditorsAction);

        final List<String> contentTypes = new ArrayList<>(2);
        contentTypes.add("application/javascript");
        contentTypes.add("text/javascript");

        // Add JS highlight and completion
		multipleMethodFileIdentifier.registerNewExtension(TextEditorsPrefix.C8O_JSCRIPT_STEP_EDITOR, contentTypes);
		multipleMethodFileIdentifier.registerNewExtension(TextEditorsPrefix.C8O_JSCRIPT_TRANSACTION_EDITOR, contentTypes);
	}
}
