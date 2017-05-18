package org.eclipse.che.plugin.convertigo.information.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.plugin.convertigo.information.ide.view.InformationView;
import org.eclipse.che.plugin.convertigo.information.ide.view.InformationViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;

@ExtensionGinModule
public class InformationViewGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(InformationView.class).to(InformationViewImpl.class);
    }   
}
