package org.eclipse.che.plugin.convertigo.graphiceditors.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.GraphicEditorsResources;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsView;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@ExtensionGinModule
public class GraphicsEditorsViewGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(GraphicEditorsView.class).to(GraphicEditorsViewImpl.class);
    }

    @Provides
    @Singleton
    @Named("SequenceType")
    protected FileType provideSequenceFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.SEQUENCE_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("SqlConnectorType")
    protected FileType provideSqlConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.SQL_CONNECTOR_EDITOR_EXTENSION);
    }
}
