package org.eclipse.che.plugin.convertigo.main.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.plugin.convertigo.main.ide.view.MainView;
import org.eclipse.che.plugin.convertigo.main.ide.view.MainViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;

@ExtensionGinModule
public class MainViewGinModule  extends AbstractGinModule {

	@Override
	protected void configure() {
        bind(MainView.class).to(MainViewImpl.class);
	}
}
