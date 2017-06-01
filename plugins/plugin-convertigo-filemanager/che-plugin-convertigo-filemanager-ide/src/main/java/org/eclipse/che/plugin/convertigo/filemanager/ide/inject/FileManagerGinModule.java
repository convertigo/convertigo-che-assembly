package org.eclipse.che.plugin.convertigo.filemanager.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.resources.ResourceInterceptor;
import org.eclipse.che.plugin.convertigo.filemanager.ide.view.EditorResourceInterceptor;
import org.eclipse.che.plugin.convertigo.filemanager.ide.view.FileManager;
import org.eclipse.che.plugin.convertigo.filemanager.ide.view.FileManagerImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;

@ExtensionGinModule
public class FileManagerGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
        bind(FileManager.class).to(FileManagerImpl.class);
        GinMultibinder.newSetBinder(binder(), ResourceInterceptor.class).addBinding().to(EditorResourceInterceptor.class);
	}
}
