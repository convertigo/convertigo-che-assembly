package org.eclipse.che.plugin.convertigo.graphiceditors.ide;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.editor.EditorRegistry;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.filetypes.FileTypeRegistry;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.action.ShowGraphicEditorsAction;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.SequenceEditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.SqlConnectorEditorProvider;

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

            // Sql connector
            final @Named("SqlConnectorType") FileType sqlConnectorType,
            final SqlConnectorEditorProvider sqlConnectorEditorProvider) {
        // Sequence
        fileTypeRegistry.registerFileType(sequenceType);
        editorRegistry.registerDefaultEditor(sequenceType, sequenceEditorProvider);

        // Sql connector
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
