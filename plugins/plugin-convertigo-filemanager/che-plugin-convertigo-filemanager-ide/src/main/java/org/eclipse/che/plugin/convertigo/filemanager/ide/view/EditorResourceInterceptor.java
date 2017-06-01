package org.eclipse.che.plugin.convertigo.filemanager.ide.view;

import org.eclipse.che.ide.api.resources.Resource;
import org.eclipse.che.ide.api.resources.ResourceInterceptor;
import org.eclipse.che.ide.api.resources.marker.PresentableTextMarker;
import org.eclipse.che.plugin.convertigo.filemanager.ide.common.Editor;

import com.google.inject.Singleton;

@Singleton
public class EditorResourceInterceptor implements ResourceInterceptor {
	
	@Override
	public void intercept(Resource resource) {
		if (resource.isFile()) {
			String resourceName = resource.getName();
			String newTabTitle = null;
			
			if (resourceName.startsWith(Editor.c8o_JscriptStepEditor.toString())) {
				newTabTitle = removeExtension(resourceName.replaceAll("^.* ", ""));
			}
			else if (resourceName.startsWith(Editor.c8o_JscriptTransactionEditor.toString())) {
				newTabTitle = removeExtension(resourceName.replace(Editor.c8o_JscriptTransactionEditor.toString(), ""));
			}
			
			// Update tab title
			if (newTabTitle != null) {
				resource.addMarker(new PresentableTextMarker(newTabTitle));
			}
        }
	}
	
	private String removeExtension(String text) {
		return text.replaceAll("\\..+$", "");
	}
}
