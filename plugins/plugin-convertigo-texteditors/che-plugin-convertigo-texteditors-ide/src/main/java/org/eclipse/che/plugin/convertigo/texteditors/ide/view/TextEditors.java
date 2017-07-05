package org.eclipse.che.plugin.convertigo.texteditors.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface TextEditors extends View<TextEditors.ActionDelegate> {

    interface ActionDelegate extends BaseActionDelegate {
    }
}
