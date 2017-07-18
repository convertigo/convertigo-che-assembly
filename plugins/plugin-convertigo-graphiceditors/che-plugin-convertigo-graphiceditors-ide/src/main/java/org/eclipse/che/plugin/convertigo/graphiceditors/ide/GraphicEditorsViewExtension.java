package org.eclipse.che.plugin.convertigo.graphiceditors.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.editor.EditorRegistry;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.filetypes.FileTypeRegistry;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.action.ShowGraphicEditorsAction;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.CICSConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.CouchDBConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.FullSyncConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.HtmlConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.HttpConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.JavelinConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.ProxyHttpConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.SapJcoConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.SiteClipperConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector.SqlConnectorEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.sequence.SequenceEditorProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Extension(title = "Graphic editors")
@Singleton
public class GraphicEditorsViewExtension {

    @Inject
    public GraphicEditorsViewExtension(
            final EditorRegistry editorRegistry,
            final FileTypeRegistry fileTypeRegistry,

            // Sequence
            final @Named("SequenceType") FileType sequenceType,
            final SequenceEditorProvider sequenceEditorProvider,

            // Connectors
            final @Named("CICSConnectorType") FileType cicsConnectorType,
            final CICSConnectorEditorProvider cicsConnectorEditorProvider,

            final @Named("CouchDBConnectorType") FileType couchDBConnectorType,
            final CouchDBConnectorEditorProvider couchDBConnectorEditorProvider,

            final @Named("FullSyncConnectorType") FileType fullSyncConnectorType,
            final FullSyncConnectorEditorProvider fullSyncConnectorEditorProvider,

            final @Named("HtmlConnectorType") FileType htmlConnectorType,
            final HtmlConnectorEditorProvider htmlConnectorEditorProvider,

            final @Named("HttpConnectorType") FileType httpConnectorType,
            final HttpConnectorEditorProvider httpConnectorEditorProvider,

            final @Named("JavelinConnectorType") FileType javelinConnectorType,
            final JavelinConnectorEditorProvider javelinConnectorEditorProvider,

            final @Named("ProxyHttpConnectorType") FileType proxyHttpConnectorType,
            final ProxyHttpConnectorEditorProvider proxyHttpConnectorEditorProvider,

            final @Named("SapJcoConnectorType") FileType sapJcoConnectorType,
            final SapJcoConnectorEditorProvider sapJcoConnectorEditorProvider,

            final @Named("SiteClipperConnectorType") FileType siteClipperConnectorType,
            final SiteClipperConnectorEditorProvider siteClipperConnectorEditorProvider,

            final @Named("SqlConnectorType") FileType sqlConnectorType,
            final SqlConnectorEditorProvider sqlConnectorEditorProvider) {
        // Sequence
        fileTypeRegistry.registerFileType(sequenceType);
        editorRegistry.registerDefaultEditor(sequenceType, sequenceEditorProvider);

        // Connectors
        fileTypeRegistry.registerFileType(cicsConnectorType);
        editorRegistry.registerDefaultEditor(cicsConnectorType, cicsConnectorEditorProvider);

        fileTypeRegistry.registerFileType(couchDBConnectorType);
        editorRegistry.registerDefaultEditor(couchDBConnectorType, couchDBConnectorEditorProvider);

        fileTypeRegistry.registerFileType(fullSyncConnectorType);
        editorRegistry.registerDefaultEditor(fullSyncConnectorType, fullSyncConnectorEditorProvider);

        fileTypeRegistry.registerFileType(htmlConnectorType);
        editorRegistry.registerDefaultEditor(htmlConnectorType, htmlConnectorEditorProvider);

        fileTypeRegistry.registerFileType(httpConnectorType);
        editorRegistry.registerDefaultEditor(httpConnectorType, httpConnectorEditorProvider);

        fileTypeRegistry.registerFileType(javelinConnectorType);
        editorRegistry.registerDefaultEditor(javelinConnectorType, httpConnectorEditorProvider);

        fileTypeRegistry.registerFileType(javelinConnectorType);
        editorRegistry.registerDefaultEditor(javelinConnectorType, javelinConnectorEditorProvider);

        fileTypeRegistry.registerFileType(proxyHttpConnectorType);
        editorRegistry.registerDefaultEditor(proxyHttpConnectorType, proxyHttpConnectorEditorProvider);

        fileTypeRegistry.registerFileType(sapJcoConnectorType);
        editorRegistry.registerDefaultEditor(sapJcoConnectorType, sapJcoConnectorEditorProvider);

        fileTypeRegistry.registerFileType(siteClipperConnectorType);
        editorRegistry.registerDefaultEditor(siteClipperConnectorType, siteClipperConnectorEditorProvider);

        fileTypeRegistry.registerFileType(sqlConnectorType);
        editorRegistry.registerDefaultEditor(sqlConnectorType, sqlConnectorEditorProvider);
    }

    @Inject
    private void configureActions(
            final ActionManager actionManager,
            final ShowGraphicEditorsAction showGraphicEditorsViewAction) {
        actionManager.registerAction(ShowGraphicEditorsAction.ACTION_ID, showGraphicEditorsViewAction);
    }
}
