package org.eclipse.che.plugin.convertigo.texteditors.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.resources.ResourceInterceptor;
import org.eclipse.che.plugin.convertigo.texteditors.ide.editor.interceptor.TextEditorsResourceInterceptor;
import org.eclipse.che.plugin.convertigo.texteditors.ide.view.TextEditors;
import org.eclipse.che.plugin.convertigo.texteditors.ide.view.TextEditorsImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;

@ExtensionGinModule
public class TextEditorsGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
        bind(TextEditors.class).to(TextEditorsImpl.class);
        GinMultibinder.newSetBinder(binder(), ResourceInterceptor.class).addBinding().to(TextEditorsResourceInterceptor.class);
	}
}
