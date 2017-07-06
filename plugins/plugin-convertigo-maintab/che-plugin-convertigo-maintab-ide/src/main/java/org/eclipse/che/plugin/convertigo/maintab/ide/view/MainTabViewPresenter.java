package org.eclipse.che.plugin.convertigo.maintab.ide.view;

import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.plugin.convertigo.maintab.ide.MainTabResources;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MainTabViewPresenter extends BasePresenter implements MainTabView.ActionDelegate {

    private final MainTabView mainTabView;

    @Inject
    public MainTabViewPresenter(final MainTabView mainTabView) {
        this.mainTabView = mainTabView;
    }

    @Override
    public String getTitle() {
        return "Convertigo";
    }

    @Override
    public SVGResource getTitleImage() {
        return (MainTabResources.INSTANCE.icon());
    }

    @Override
    public IsWidget getView() {
        return mainTabView;
    }

    @Override
    public String getTitleToolTip() {
        return getTitle();
    }

    @Override
    public void go(AcceptsOneWidget container) {
        container.setWidget(mainTabView);
    }
}
