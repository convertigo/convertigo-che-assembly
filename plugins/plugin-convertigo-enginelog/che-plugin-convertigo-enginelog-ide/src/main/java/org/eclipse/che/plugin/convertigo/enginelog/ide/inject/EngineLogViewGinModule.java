package org.eclipse.che.plugin.convertigo.enginelog.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.plugin.convertigo.enginelog.ide.view.EngineLogView;
import org.eclipse.che.plugin.convertigo.enginelog.ide.view.EngineLogViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;

@ExtensionGinModule
public class EngineLogViewGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EngineLogView.class).to(EngineLogViewImpl.class);
    }   
}
