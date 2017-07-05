package org.eclipse.che.plugin.convertigo.texteditors.ide.editor.interceptor;

import org.eclipse.che.ide.api.resources.File;
import org.eclipse.che.ide.api.resources.Resource;
import org.eclipse.che.ide.api.resources.ResourceInterceptor;
import org.eclipse.che.ide.api.resources.marker.PresentableTextMarker;
import org.eclipse.che.plugin.convertigo.texteditors.ide.common.TextEditorsPrefix;

import com.google.inject.Singleton;

@Singleton
public class TextEditorsResourceInterceptor implements ResourceInterceptor {

	@Override
	public void intercept(Resource resource) {
		if (resource.isFile()) {
			String resourceName = resource.getName();
			String newTabTitle = null;

			if (resourceName.endsWith(TextEditorsPrefix.C8O_JSCRIPT_STEP_EDITOR)) {
				newTabTitle = ((File) resource).getNameWithoutExtension().replaceAll("^.* ", "");
			}
			else if (resourceName.endsWith(TextEditorsPrefix.C8O_JSCRIPT_TRANSACTION_EDITOR)) {
				newTabTitle = ((File) resource).getNameWithoutExtension();
			}

			// Update tab title
			if (newTabTitle != null) {
				resource.addMarker(new PresentableTextMarker(newTabTitle));
			}
        }
	}
}
