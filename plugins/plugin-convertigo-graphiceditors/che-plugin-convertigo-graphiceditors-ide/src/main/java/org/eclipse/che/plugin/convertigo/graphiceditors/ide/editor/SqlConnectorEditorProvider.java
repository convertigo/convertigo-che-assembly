package org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor;

import org.eclipse.che.ide.api.editor.EditorPartPresenter;
import org.eclipse.che.ide.api.editor.EditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class SqlConnectorEditorProvider implements EditorProvider {

    private Provider<GraphicEditorsViewPresenter> graphicsEditorsPesenter;

    @Inject
    public SqlConnectorEditorProvider(Provider<GraphicEditorsViewPresenter> graphicEditorsPesenter) {
        super();
        this.graphicsEditorsPesenter = graphicEditorsPesenter;
    }

    @Override
    public String getId() {
        return "sqlEditor";
    }

    @Override
    public String getDescription() {
        return "Sql Editor";
    }

    @Override
    public EditorPartPresenter getEditor() {
        return graphicsEditorsPesenter.get();
    }

}
