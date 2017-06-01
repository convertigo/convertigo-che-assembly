package org.eclipse.che.plugin.convertigo.main.ide.view;

import java.util.Iterator;

import org.eclipse.che.api.core.model.machine.Server;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.machine.MachineEntity;
import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MainViewPresenter extends BasePresenter implements MainView.ActionDelegate {

	private final MainView mainView;
	private final AppContext appContext;

	private static String convertigoMachineUrl = null;

    @Inject
    public MainViewPresenter(MainView mainView, AppContext appContext) {
    	this.mainView = mainView;
    	this.appContext = appContext;

    	exportGetKeyConvertigoMachineUrl();
    	exportInjectConvertigoCoreScripts();
    	exportGetConvertigoMachineUrl();
    	
		defineConvertigoUrl(getConvertigoMachineUrl());
    	
    	final String jsFile = "init.js";
    	ScriptInjector.fromUrl(GWT.getModuleBaseURL() + jsFile)
	        .setWindow(ScriptInjector.TOP_WINDOW)
	        .setCallback(new Callback<Void, Exception>() {
	            @Override
	            public void onSuccess(final Void result) {
	                Log.info(MainViewPresenter.class, jsFile + " loaded.");
	            }
	
	            @Override
	            public void onFailure(final Exception e) {
	                Log.error(MainViewPresenter.class, "Unable to load " + jsFile, e);
	            }
	        })
	        .inject();
    }
    
    private MachineEntity getConvertigoMachine() {
    	Iterator<MachineEntity> it = appContext.getActiveRuntime().getMachines().iterator();
    	while (it.hasNext()) {
    		MachineEntity machine = it.next();
    		if ("convertigo".equals(machine.getDisplayName())) {
    			return machine;
    		}
    	}
    	return null;
    }
    
    private native void exportGetConvertigoMachineUrl() /*-{
    	var that = this;
    	$wnd.getConvertigoMachineUrl = function () {
    		return that.@org.eclipse.che.plugin.convertigo.main.ide.view.MainViewPresenter::getConvertigoMachineUrl()();
    	}
    }-*/;
    
    private String getConvertigoMachineUrl() {
    	if (convertigoMachineUrl == null) {
	    	MachineEntity convertigoMachine = getConvertigoMachine();
	    	if (convertigoMachine == null) {
	    		// By default we choose localhost
	    		convertigoMachineUrl = "http://localhost:18080";
	    	}
	    	else {
		    	Server server = convertigoMachine
						.getServers()
						.values()
						.iterator()
						.next();
		    	convertigoMachineUrl = "http://" + server.getAddress();
	    	}
    	}
    	
    	return convertigoMachineUrl;
    }
    
    private native void exportGetKeyConvertigoMachineUrl() /*-{
        var that = this;
    	$wnd.getKeyConvertigoMachineUrl = function () {
			return "convertigoMachineUrl";
    	}
    }-*/;
    
    private native void defineConvertigoUrl(String convertigoUrl) /*-{
    	var key = $wnd.getKeyConvertigoMachineUrl();
    	if (localStorage.getItem(key) === null) {
    		localStorage.setItem(key, convertigoUrl);
    	}
	}-*/;
    
    private native void exportInjectConvertigoCoreScripts() /*-{
        var that = this;
    	$wnd.injectConvertigoCoreScripts = function (convertigoMachineUrl) {
    		that.@org.eclipse.che.plugin.convertigo.main.ide.view.MainViewPresenter::injectConvertigoCoreScripts(Ljava/lang/String;)(convertigoMachineUrl);
    	}
    }-*/;

    private void injectConvertigoCoreScripts(final String convertigoMachineUrl) {
    	final String convertigoCoreUrl = convertigoMachineUrl + "/convertigo/studio/js/core/";

        // Inject convertigo.js
        final String convertigoJsUrl = convertigoCoreUrl + "convertigo.js";
        ScriptInjector
        	.fromUrl(convertigoJsUrl)
        	.setWindow(ScriptInjector.TOP_WINDOW)
        	.setCallback(new Callback<Void, Exception>() {
				@Override
				public void onSuccess(Void result) {
			        // Inject main.js
			        final String mainJsUrl = convertigoCoreUrl + "main.js";
			        ScriptInjector
			        	.fromUrl(mainJsUrl)
			        	.setWindow(ScriptInjector.TOP_WINDOW)
			        	.setCallback(new Callback<Void, Exception>() {
							@Override
							public void onSuccess(Void result) {
							}
			        		
							@Override
							public void onFailure(Exception reason) {
								Window.alert("Failed to load " + mainJsUrl);
							}
						})
			        	.inject();
				}

				@Override
				public void onFailure(Exception reason) {
					Window.alert(
						"Failed to load " + convertigoJsUrl + ", the " + convertigoMachineUrl + " URL might be invalid." +
						"\nPlease try to enter another URL in the Convertigo URL panel (pattern: http://{hostname}:{port})."
					);
				}
			})
        	.inject();
    }
    
	@Override
	public String getTitle() {
		// TODO: remove title
		return "Convertigo URL";
	}

	@Override
	public IsWidget getView() {
		return mainView;
	}

	@Override
	public String getTitleToolTip() {
		return getTitle();
	}

	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(mainView);
	}
}