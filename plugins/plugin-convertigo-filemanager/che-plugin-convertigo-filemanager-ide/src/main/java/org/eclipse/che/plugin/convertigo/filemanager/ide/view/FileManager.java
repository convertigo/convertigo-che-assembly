package org.eclipse.che.plugin.convertigo.filemanager.ide.view;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

public interface FileManager extends View<FileManager.ActionDelegate> {

    interface ActionDelegate extends BaseActionDelegate {
    }
}
