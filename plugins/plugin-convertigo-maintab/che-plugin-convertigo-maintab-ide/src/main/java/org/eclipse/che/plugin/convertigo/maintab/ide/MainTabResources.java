package org.eclipse.che.plugin.convertigo.maintab.ide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

public interface MainTabResources extends ClientBundle {

    MainTabResources INSTANCE = GWT.create(MainTabResources.class);

    @Source("svg/icon.svg")
    SVGResource icon();
}
