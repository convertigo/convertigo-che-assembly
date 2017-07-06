package org.eclipse.che.plugin.convertigo.secondtab.ide.view;

import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.plugin.convertigo.secondtab.ide.SecondTabResources;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SecondTabViewPresenter extends BasePresenter implements SecondTabView.ActionDelegate {

	private final SecondTabView secondTabView;

	@Inject
	public SecondTabViewPresenter(SecondTabView secondTabView) {
		this.secondTabView = secondTabView;
	}

	@Override
	public String getTitle() {
		return "Convertigo";
	}

    @Override
    public SVGResource getTitleImage() {
        return (SecondTabResources.INSTANCE.icon());
    }

	@Override
	public IsWidget getView() {
		return secondTabView;
	}

	@Override
	public String getTitleToolTip() {
		return getTitle();
	}

	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(secondTabView);
	}
}
