package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.draggable.*;
import edu.fiuba.algo3.modelo.IBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class TabBloquesComplejos extends Tab implements ITabArmadoBloques{

    private final PanelArmado panelArmado;
    private final IBloque bloqueAsociado;
    private final TableroAlgoritmo armadorAlgoritmo;
    private final BotonEliminar botonEliminar;
    private VBox panelAsociado;
    private Label label;

    public TabBloquesComplejos(String nombre, PanelArmado panelArmado, IBloque bloqueAsociado, TableroAlgoritmo armadorAlgoritmo, BotonEliminar botonEliminar)
    {
        super(nombre);
        this.panelArmado = panelArmado;
        this.bloqueAsociado = bloqueAsociado;
        this.botonEliminar = botonEliminar;
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.agregarZonaDnD();
    }

    private void agregarZonaDnD() {
        this.panelAsociado = new VBox();
        this.panelAsociado.setMinWidth(Double.MAX_VALUE);
        this.panelAsociado.setMinHeight(340);
        this.panelAsociado.setPrefHeight(Double.MAX_VALUE);
        this.panelAsociado.setSpacing(2);


        ScrollPane scrolleable = new ScrollPane();
        scrolleable.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrolleable.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrolleable.setContent(this.panelAsociado);
        this.panelAsociado.setStyle("-fx-background-color: #121212");
        this.setContent(scrolleable);
        this.convertirPanelAsociadoDnD();
    }

    private void convertirPanelAsociadoDnD() {
        this.panelAsociado.setOnDragOver(new DragOverEventHandler());
        this.panelAsociado.setOnDragEntered(e->this.panelAsociado.setStyle("-fx-background-color:#B9B9B9"));
        this.panelAsociado.setOnDragExited(e->this.panelAsociado.setStyle("-fx-background-color:#FFFFFF"));
        this.panelAsociado.setOnDragDropped(new BloquesArmadoDragDroppedEventHandler(this.bloqueAsociado,
                this.panelAsociado,
                this.panelArmado,
                this.armadorAlgoritmo,
                this.botonEliminar));
    }

    public void agregarLabel(String nombre) {
        this.label = new Label(nombre);
        this.label.setStyle("-fx-background-color:#262626;" +
                " -fx-padding: 10px;" +
                " -fx-border-color: #121212;" +
                " -fx-border-radius: 27;" +
                " -fx-border-width: 3;" +
                " -fx-text-fill: #C5C5C5;" +
                " -fx-background-radius: 30");
        this.label.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD,30));
        this.panelAsociado.getChildren().add(this.label);
    }

    @Override
    public void eliminarHijos() {
        panelAsociado.getChildren().remove(this.label);
        ObservableList<Node> hijos = panelAsociado.getChildren();
        for(Node hijo : hijos){
            BotonBloqueArmado h = (BotonBloqueArmado) hijo;
            h.eliminarHijos();
        }
        this.panelArmado.eliminarTabArmado(this);
    }
}
