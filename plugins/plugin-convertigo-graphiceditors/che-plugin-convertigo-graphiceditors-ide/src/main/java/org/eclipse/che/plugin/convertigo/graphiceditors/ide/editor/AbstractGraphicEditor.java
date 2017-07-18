package org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor;

import org.eclipse.che.ide.api.editor.EditorPartPresenter;
import org.eclipse.che.ide.api.editor.EditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class AbstractGraphicEditor implements EditorProvider {

    private Provider<GraphicEditorsViewPresenter> graphicEditorsViewPesenter;
    private String id;
    private String description;

    @Inject
    public AbstractGraphicEditor(Provider<GraphicEditorsViewPresenter> graphicEditorsViewPesenter, String id, String description) {
        super();
        this.graphicEditorsViewPesenter = graphicEditorsViewPesenter;
        this.id = id;
        this.description = description;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public EditorPartPresenter getEditor() {
        return graphicEditorsViewPesenter.get();
    }
}
