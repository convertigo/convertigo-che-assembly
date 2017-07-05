package org.eclipse.che.plugin.convertigo.texteditors.ide.view;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class TextEditorsImpl extends BaseView<TextEditors.ActionDelegate> implements TextEditors {

	interface TextEditorsImplUiBinder extends UiBinder<Widget, TextEditorsImpl> {
	}

    private final static TextEditorsImplUiBinder UI_BINDER = GWT.create(TextEditorsImplUiBinder.class);

    @UiField
    FlowPanel textEditorsPanel;

	@Inject
	public TextEditorsImpl(PartStackUIResources resources) {
		super(resources);

        setContentWidget(UI_BINDER.createAndBindUi(this));
	}
}
