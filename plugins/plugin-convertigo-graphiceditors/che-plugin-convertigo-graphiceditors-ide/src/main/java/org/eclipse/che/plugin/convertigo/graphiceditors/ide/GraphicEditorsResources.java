package org.eclipse.che.plugin.convertigo.graphiceditors.ide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import org.vectomatic.dom.svg.ui.SVGResource;

public interface GraphicEditorsResources extends ClientBundle {

    GraphicEditorsResources INSTANCE = GWT.create(GraphicEditorsResources.class);

    @Source("icons/trace.svg")
    SVGResource icon();
}
