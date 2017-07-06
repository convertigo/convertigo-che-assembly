package org.eclipse.che.plugin.convertigo.maintab.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface MainTabView extends View<MainTabView.ActionDelegate> {

    interface ActionDelegate extends BaseActionDelegate {
    }
}
