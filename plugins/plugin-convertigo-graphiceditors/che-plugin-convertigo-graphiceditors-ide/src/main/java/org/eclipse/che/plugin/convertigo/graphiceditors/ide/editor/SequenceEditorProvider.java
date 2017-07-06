package org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor;

import org.eclipse.che.ide.api.editor.EditorPartPresenter;
import org.eclipse.che.ide.api.editor.EditorProvider;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class SequenceEditorProvider implements EditorProvider {

    private Provider<GraphicEditorsViewPresenter> graphicEditorsViewPesenter;

    @Inject
    public SequenceEditorProvider(Provider<GraphicEditorsViewPresenter> graphicEditorsViewPesenter) {
        super();
        this.graphicEditorsViewPesenter = graphicEditorsViewPesenter;
    }

    @Override
    public String getId() {
        return "sequenceEditor";
    }

    @Override
    public String getDescription() {
        return "Sequence Editor";
    }

    @Override
    public EditorPartPresenter getEditor() {
        return graphicEditorsViewPesenter.get();
    }
}
