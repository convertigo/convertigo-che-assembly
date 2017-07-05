package org.eclipse.che.plugin.convertigo.graphiceditors.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface GraphicEditorsView extends View<GraphicEditorsView.ActionDelegate> {

    interface ActionDelegate extends BaseActionDelegate {
    }
}
