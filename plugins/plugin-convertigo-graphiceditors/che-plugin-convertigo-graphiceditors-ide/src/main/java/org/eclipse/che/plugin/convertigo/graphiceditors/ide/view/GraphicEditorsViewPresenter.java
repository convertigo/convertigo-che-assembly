package org.eclipse.che.plugin.convertigo.graphiceditors.ide.view;

import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.editor.AbstractEditorPresenter;
import org.eclipse.che.ide.api.editor.EditorAgent;
import org.eclipse.che.ide.api.editor.EditorAgent.OpenEditorCallback;
import org.eclipse.che.ide.api.editor.EditorInput;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.ide.api.resources.File;
import org.eclipse.che.ide.api.resources.marker.PresentableTextMarker;
import org.eclipse.che.ide.resources.impl.ResourceManager;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

public class GraphicEditorsViewPresenter extends AbstractEditorPresenter {

    private final GraphicEditorsView graphicEditorsView;
    private final ResourceManager resourceManager;
    private final WorkspaceAgent workspaceAgent;
    private final EditorAgent editorAgent;

    @Inject
    public GraphicEditorsViewPresenter(
            GraphicEditorsView graphicEditorsView,
            AppContext appContext,
            WorkspaceAgent workspaceAgent,
            EditorAgent editorAgent,
            ResourceManager.ResourceManagerFactory resourceManagerFactory) {
        this.graphicEditorsView = graphicEditorsView;
        this.workspaceAgent = workspaceAgent;
        this.resourceManager = resourceManagerFactory.newResourceManager(appContext.getDevMachine());
        this.editorAgent = editorAgent;

        exportOpenSequenceEditor();
        exportOpenSqlConnectorEditor();
    }

    @Override
    public void doSave() {
    }

    @Override
    public void doSave(AsyncCallback<EditorInput> callback) {
    }

    @Override
    public SVGResource getTitleImage() {
        return input.getSVGResource();
    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public void activate() {
    }

    private void openGraphicEditor(String project, String dboName, String marker, String ext, String event) {
        final String idSelector = project + "-" + dboName;
        final String filePath = idSelector + "." + ext;

        // Get private folder of the project to create a temp file related to the editor
        resourceManager.getWorkspaceRoot().getContainer(project + "/_private").then(container -> {
            if (container.isPresent()) {
                container.get().newFile(filePath, "")
                    // Create the file if it does not exit
                    .then(file -> {
                        openGraphicEditor(file, project, dboName, idSelector, marker, ext, event);
                    })
                    // else, just open the related tab editor
                    .catchError(onRejected -> {
                        resourceManager.getWorkspaceRoot().getFile(project + "/_private/" + filePath).then((file) -> {
                            if (file.isPresent()) {
                                openGraphicEditor(file.get(), project, dboName, idSelector, marker, ext, event);
                            }
                        });
                });
            }
        });
    }

    private void openGraphicEditor(File file, String project, String dboName, String idSelector, String marker, String ext, String event) {
        editorAgent.openEditor(file);
        file.addMarker(new PresentableTextMarker(project + " [" + marker + ": " + dboName + "]"));

        // Notify that the editor is opened
        String id = idSelector + "-" + ext;
        triggerEvent(event, id);
    }

    private native void triggerEvent(String event, String id) /*-{
        var event = new CustomEvent(event, {
            "detail": {
                "id": id
            }
        });
        $doc.dispatchEvent(event);
    }-*/;

    private native void exportOpenSequenceEditor() /*-{
        var that = this;
        var extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::SEQUENCE_EDITOR_EXTENSION;
        var event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_SEQUENCE_EDITOR;
        $wnd.CheGWTOpenSequenceEditor = function (projectName, sequenceName) {
            that.@org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter::openGraphicEditor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(projectName, sequenceName, "S", extension, event);
        };
    }-*/;

    private native void exportOpenSqlConnectorEditor() /*-{
        var that = this;
        var extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::SQL_CONNECTOR_EDITOR_EXTENSION;
        var event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_SQL_CONNECTOR_EDITOR;
        $wnd.CheGWTOpenSqlConnectorEditor = function (projectName, sqlConnectorName) {
            that.@org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter::openGraphicEditor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(projectName, sqlConnectorName, "C", extension, event);
        };
    }-*/;

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getTitleToolTip() {
        return getTitle();
    }

    @Override
    public void go(AcceptsOneWidget container) {
        container.setWidget(graphicEditorsView);
    }

    @Override
    protected void initializeEditor(OpenEditorCallback callback) {
    }

    @Override
    public IsWidget getView() {
        return graphicEditorsView;
    }

    @Override
    public void close(boolean save) {
        workspaceAgent.removePart(this);
    }
}
