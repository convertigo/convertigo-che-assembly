package org.eclipse.che.plugin.convertigo.information.ide.view;

import org.eclipse.che.ide.api.parts.base.BasePresenter;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class InformationViewPresenter extends BasePresenter implements InformationView.ActionDelegate {
    
	private final InformationView informationView;

	@Inject
	public InformationViewPresenter(InformationView informationView) {
		this.informationView = informationView;
	}
	
	@Override
	public String getTitle() {
		return "Information";
	}

	@Override
	public IsWidget getView() {
		return informationView;
	}

	@Override
	public String getTitleToolTip() {
		return getTitle();
	}

	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(informationView);
	}
}
