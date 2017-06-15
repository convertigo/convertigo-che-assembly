package org.eclipse.che.plugin.convertigo.enginelog.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface EngineLogView extends View<EngineLogView.ActionDelegate> {

	interface ActionDelegate extends BaseActionDelegate {
    }
}
