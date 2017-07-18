package org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.sequence;

import org.eclipse.che.plugin.convertigo.graphiceditors.ide.editor.AbstractGraphicEditor;
import org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class SequenceEditorProvider extends AbstractGraphicEditor {

    @Inject
    public SequenceEditorProvider(Provider<GraphicEditorsViewPresenter> graphicEditorsViewPesenter) {
        super(graphicEditorsViewPesenter, "sequenceEditor",  "Sequence Editor");
    }
}
