package org.eclipse.che.plugin.convertigo.enginelog.ide.view;

import org.eclipse.che.ide.api.parts.base.BasePresenter;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class EngineLogViewPresenter extends BasePresenter implements EngineLogView.ActionDelegate {

	private final EngineLogView engineLogView;

	@Inject
	public EngineLogViewPresenter(EngineLogView engineLogView) {
		this.engineLogView = engineLogView;
	}

	@Override
	public String getTitle() {
		return "Engine Log";
	}

	@Override
	public IsWidget getView() {
		return engineLogView;
	}

	@Override
	public String getTitleToolTip() {
		return getTitle();
	}

	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(engineLogView);
	}
}
