package org.eclipse.che.plugin.convertigo.secondtab.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface SecondTabView extends View<SecondTabView.ActionDelegate> {

	interface ActionDelegate extends BaseActionDelegate {
    }
}
