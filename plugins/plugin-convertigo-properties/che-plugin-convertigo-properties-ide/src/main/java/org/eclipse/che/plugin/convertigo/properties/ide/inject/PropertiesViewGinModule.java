package org.eclipse.che.plugin.convertigo.properties.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.plugin.convertigo.properties.ide.view.PropertiesView;
import org.eclipse.che.plugin.convertigo.properties.ide.view.PropertiesViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;

@ExtensionGinModule
public class PropertiesViewGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(PropertiesView.class).to(PropertiesViewImpl.class);
    }
}
