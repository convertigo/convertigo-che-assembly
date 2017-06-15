package org.eclipse.che.plugin.convertigo.properties.ide.view;

import org.eclipse.che.ide.api.parts.base.BasePresenter;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PropertiesViewPresenter extends BasePresenter implements PropertiesView.ActionDelegate {

	private final PropertiesView propertiesView;

	@Inject
	public PropertiesViewPresenter(PropertiesView propertiesView) {
		this.propertiesView = propertiesView;
	}

	@Override
	public String getTitle() {
		return "Properties";
	}

	@Override
	public IsWidget getView() {
		return propertiesView;
	}

	@Override
	public String getTitleToolTip() {
		return getTitle();
	}

	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(propertiesView);
	}
}
