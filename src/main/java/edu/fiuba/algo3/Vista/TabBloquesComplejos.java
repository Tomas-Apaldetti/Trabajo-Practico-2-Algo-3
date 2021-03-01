package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.draggable.*;
import edu.fiuba.algo3.modelo.IBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class TabBloquesComplejos extends Tab implements ITabArmadoBloques{

    private final PanelArmado panelArmado;
    private final IBloque bloqueAsociado;
    private final VBox panelAsociado;
    private final TableroAlgoritmo armadorAlgoritmo;
    private final BotonEliminar botonEliminar;
    private Label label;

    public TabBloquesComplejos(String nombre, PanelArmado panelArmado, IBloque bloqueAsociado, TableroAlgoritmo armadorAlgoritmo, BotonEliminar botonEliminar)
    {
        super(nombre);
        this.panelArmado = panelArmado;
        this.bloqueAsociado = bloqueAsociado;
        this.panelAsociado = new VBox();
        this.botonEliminar = botonEliminar;
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.agregarLabelDnD(nombre);
        this.setContent(this.panelAsociado);


    }

    private void agregarLabelDnD(String nombre) {
        Label labelDnD = new Label(nombre);
        this.label = labelDnD;
        labelDnD.setStyle("-fx-background-color: #eea023; -fx-padding: 10px; -fx-border-color: #eea023; -fx-border-width: 3px; -fx-text-fill: white;");
        labelDnD.setFont(new Font("Arial", 20.0));
        labelDnD.setOnDragOver(new DragOverEventHandler());
        labelDnD.setOnDragEntered(new DragEnteredEventHandler(labelDnD));
        labelDnD.setOnDragExited(new DragExitedEventHandler(labelDnD));
        labelDnD.setOnDragDropped(new BloquesArmadoDragDroppedEventHandler(this.bloqueAsociado, this.panelAsociado, this.panelArmado, this.armadorAlgoritmo, this.botonEliminar));
        this.panelAsociado.getChildren().add(labelDnD);
    }

    @Override
    public void eliminarHijos() {
        panelAsociado.getChildren().remove(label);
        ObservableList<Node> hijos = panelAsociado.getChildren();
        for(Node hijo : hijos){
            BotonBloqueArmado h = (BotonBloqueArmado) hijo;
            h.eliminarHijos();
        }
        this.panelArmado.getTabs().remove(this);
    }
}
