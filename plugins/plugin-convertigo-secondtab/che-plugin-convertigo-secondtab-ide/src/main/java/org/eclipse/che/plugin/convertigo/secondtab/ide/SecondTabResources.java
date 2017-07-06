package org.eclipse.che.plugin.convertigo.secondtab.ide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

public interface SecondTabResources extends ClientBundle {

    SecondTabResources INSTANCE = GWT.create(SecondTabResources.class);

    @Source("svg/icon.svg")
    SVGResource icon();
}
