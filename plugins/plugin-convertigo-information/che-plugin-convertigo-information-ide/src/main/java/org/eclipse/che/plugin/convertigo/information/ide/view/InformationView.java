package org.eclipse.che.plugin.convertigo.information.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface InformationView  extends View<InformationView.ActionDelegate> {
    
	interface ActionDelegate extends BaseActionDelegate {
    }
}
