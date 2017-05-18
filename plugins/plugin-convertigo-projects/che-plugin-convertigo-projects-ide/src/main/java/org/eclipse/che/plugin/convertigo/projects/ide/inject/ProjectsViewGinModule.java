package org.eclipse.che.plugin.convertigo.projects.ide.inject;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;
import org.eclipse.che.plugin.convertigo.projects.ide.view.ProjectsView;
import org.eclipse.che.plugin.convertigo.projects.ide.view.ProjectsViewImpl;

import com.google.gwt.inject.client.AbstractGinModule;

@ExtensionGinModule
public class ProjectsViewGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(ProjectsView.class).to(ProjectsViewImpl.class);
    }    
}
