package org.eclipse.che.plugin.convertigo.main.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface MainView extends View<MainView.ActionDelegate> {

    interface ActionDelegate extends BaseActionDelegate {
    }
}
