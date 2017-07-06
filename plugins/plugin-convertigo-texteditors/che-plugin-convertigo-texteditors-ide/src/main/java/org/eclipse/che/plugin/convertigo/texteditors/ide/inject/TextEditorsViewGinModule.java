package org.eclipse.che.plugin.convertigo.texteditors.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.resources.ResourceInterceptor;
import org.eclipse.che.plugin.convertigo.texteditors.ide.editor.interceptor.TextEditorsResourceInterceptor;
import org.eclipse.che.plugin.convertigo.texteditors.ide.view.TextEditorsView;
import org.eclipse.che.plugin.convertigo.texteditors.ide.view.TextEditorsViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;

@ExtensionGinModule
public class TextEditorsViewGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
        bind(TextEditorsView.class).to(TextEditorsViewImpl.class);
        GinMultibinder.newSetBinder(binder(), ResourceInterceptor.class).addBinding().to(TextEditorsResourceInterceptor.class);
	}
}
