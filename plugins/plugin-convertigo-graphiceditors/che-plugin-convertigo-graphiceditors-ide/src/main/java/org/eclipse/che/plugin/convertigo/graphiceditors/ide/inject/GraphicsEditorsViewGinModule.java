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

    // Sequence
    @Provides
    @Singleton
    @Named("SequenceType")
    protected FileType provideSequenceFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.SEQUENCE_EDITOR_EXTENSION);
    }

    // Connectors
    @Provides
    @Singleton
    @Named("CICSConnectorType")
    protected FileType provideCICSConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.CICS_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("CouchDBConnectorType")
    protected FileType provideCouchDBConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.COUCHDB_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("FullSyncConnectorType")
    protected FileType provideFullSyncConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.FULLSYNC_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("HtmlConnectorType")
    protected FileType provideHtmlConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.HTML_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("HttpConnectorType")
    protected FileType provideHttpConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.HTTP_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("JavelinConnectorType")
    protected FileType provideJavelinConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.JAVELIN_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("ProxyHttpConnectorType")
    protected FileType provideProxyHttpConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.PROXYHTTP_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("SapJcoConnectorType")
    protected FileType provideSapJcoConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.SAPJCO_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("SiteClipperConnectorType")
    protected FileType provideSiteClipperConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.SITECLIPPER_CONNECTOR_EDITOR_EXTENSION);
    }

    @Provides
    @Singleton
    @Named("SqlConnectorType")
    protected FileType provideSqlConnectorFile() {
        return new FileType(GraphicEditorsResources.INSTANCE.icon(), GraphicEditorsExtension.SQL_CONNECTOR_EDITOR_EXTENSION);
    }
}
