package org.eclipse.che.plugin.convertigo.texteditors.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface TextEditorsView extends View<TextEditorsView.ActionDelegate> {

    interface ActionDelegate extends BaseActionDelegate {
    }
}
