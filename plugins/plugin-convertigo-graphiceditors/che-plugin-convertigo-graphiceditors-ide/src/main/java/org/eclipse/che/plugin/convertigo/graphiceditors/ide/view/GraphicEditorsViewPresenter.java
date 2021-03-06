package org.eclipse.che.plugin.convertigo.graphiceditors.ide.view;


import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.editor.AbstractEditorPresenter;
import org.eclipse.che.ide.api.editor.EditorAgent;
import org.eclipse.che.ide.api.editor.EditorAgent.OpenEditorCallback;
import org.eclipse.che.ide.api.editor.EditorInput;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.ide.api.resources.Container;
import org.eclipse.che.ide.api.resources.File;
import org.eclipse.che.ide.api.resources.Project;
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
        exportOpenConnectorEditor();
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

    private void openGraphicEditor(String projectName, String dboName, String marker, String ext, String event) {
        final String idSelector = projectName + "-" + dboName;
        final String filePath = idSelector + "." + ext;

        resourceManager.getWorkspaceProjects().then(projects -> {
            for (Project project : projects) {
                // Get project
                if (project.getName().equals(projectName)) {
                    project.getContainer("_private")
                        // "_private" folder already exist
                        .then(privateCont -> {
                            if (privateCont.isPresent()) {
                                openGraphicEditor(privateCont.get(), filePath, projectName, dboName, marker, ext, event, idSelector);
                            }
                        })
                        // Create "_private" folder if it does not exist
                        .catchError(onRejected -> {
                            project.newFolder("_private").then(privateCont -> {
                                openGraphicEditor((Container) privateCont, filePath, projectName, dboName, marker, ext, event, idSelector);
                            });
                        });
                    break;
                }
            }
        });
    }

    private void openGraphicEditor(Container container, String filePath, String project, String dboName, String marker, String ext, String event, String idSelector) {
        container.newFile(filePath, "")
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

    private void openGraphicEditor(File file, String project, String dboName, String idSelector, String marker, String ext, String event) {
        editorAgent.openEditor(file);
        file.addMarker(new PresentableTextMarker(project + " [" + marker + ": " + dboName + "]"));

        // Notify that the editor is opened
        String id = idSelector + "-" + ext;
        String qname = project + "." + dboName;
        triggerEvent(event, id, qname);
    }

    private native void triggerEvent(String event, String id, String qname) /*-{
        var event = new CustomEvent(event, {
            "detail": {
                "id": id,
                "qname": qname
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

    private native void exportOpenConnectorEditor() /*-{
        var that = this;
        $wnd.CheGWTOpenConnectorEditor = function (projectName, connectorName, typeEditor) {
            var extension = null;
            var event = null;
            // CICS
            if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::CICS_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::CICS_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_CICS_CONNECTOR_EDITOR;
            }
            // Couch DB
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::COUCHDB_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::COUCHDB_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_COUCHDB_CONNECTOR_EDITOR;
            }
            // FullSync
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::FULLSYNC_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::FULLSYNC_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_FULLSYNC_CONNECTOR_EDITOR;
            }
            // HTML
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::HTML_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::HTML_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_HTML_CONNECTOR_EDITOR;
            }
            // HTTP
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::HTTP_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::HTTP_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_HTTP_CONNECTOR_EDITOR;
            }
            // Javelin
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::JAVELIN_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::JAVELIN_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_JAVELIN_CONNECTOR_EDITOR;
            }
            // Proxy HTTP
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::PROXYHTTP_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::PROXYHTTP_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_PROXYHTTP_CONNECTOR_EDITOR;
            }
            // Sap Jco
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::SAPJCO_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::SAPJCO_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_SAPJCO_CONNECTOR_EDITOR;
            }
            // Site Clipper
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::SITECLIPPER_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::SITECLIPPER_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_SITECLIPPER_CONNECTOR_EDITOR;
            }
            // SQL
            else if (typeEditor === @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::SQL_CONNECTOR_EDITOR_EXTENSION) {
                extension = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsExtension::SQL_CONNECTOR_EDITOR_EXTENSION;
                event = @org.eclipse.che.plugin.convertigo.graphiceditors.ide.common.GraphicEditorsEvent::OPEN_SQL_CONNECTOR_EDITOR;
            }

            if (extension && event) {
                that.@org.eclipse.che.plugin.convertigo.graphiceditors.ide.view.GraphicEditorsViewPresenter::openGraphicEditor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(projectName, connectorName, "C", extension, event);
            }
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
