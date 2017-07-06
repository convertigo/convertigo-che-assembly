package org.eclipse.che.plugin.convertigo.maintab.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.plugin.convertigo.maintab.ide.view.MainTabView;
import org.eclipse.che.plugin.convertigo.maintab.ide.view.MainTabViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;

@ExtensionGinModule
public class MainTabViewGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(MainTabView.class).to(MainTabViewImpl.class);
    }    
}
