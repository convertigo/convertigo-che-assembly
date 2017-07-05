package org.eclipse.che.plugin.convertigo.graphiceditors.ide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

public interface MyResources extends ClientBundle {

    MyResources INSTANCE = GWT.create(MyResources.class);

    @Source("icons/trace.svg")
    SVGResource icon();
}
