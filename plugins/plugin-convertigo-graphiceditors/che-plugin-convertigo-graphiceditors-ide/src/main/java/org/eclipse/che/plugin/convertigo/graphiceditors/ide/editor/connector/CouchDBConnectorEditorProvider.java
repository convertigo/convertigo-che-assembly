package org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.connector;

import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.AbstractGraphicEditor;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class CouchDBConnectorEditorProvider extends AbstractGraphicEditor {

    @Inject
    public CouchDBConnectorEditorProvider(Provider<GraphicEditorsViewPresenter> graphicEditorsViewPesenter) {
        super(graphicEditorsViewPesenter, "couchDBConnectorEditor", "Couch DB Connector Editor");
    }
}
