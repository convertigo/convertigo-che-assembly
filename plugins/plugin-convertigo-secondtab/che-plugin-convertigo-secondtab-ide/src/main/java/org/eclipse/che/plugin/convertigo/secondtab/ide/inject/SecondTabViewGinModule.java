package org.eclipse.che.plugin.convertigo.secondtab.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.plugin.convertigo.secondtab.ide.view.SecondTabView;
import org.eclipse.che.plugin.convertigo.secondtab.ide.view.SecondTabViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;

@ExtensionGinModule
public class SecondTabViewGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(SecondTabView.class).to(SecondTabViewImpl.class);
    }   
}
