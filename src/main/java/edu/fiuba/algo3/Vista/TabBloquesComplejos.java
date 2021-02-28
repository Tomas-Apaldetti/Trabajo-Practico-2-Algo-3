package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.draggable.*;
import edu.fiuba.algo3.modelo.IBloque;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TabBloquesComplejos extends Tab {

    private final PanelArmado panelArmado;
    private final IBloque bloqueAsociado;
    private final VBox panelAsociado;

    public TabBloquesComplejos(String nombre, PanelArmado panelArmado, IBloque bloqueAsociado)
    {
        super(nombre);
        this.panelArmado = panelArmado;
        this.bloqueAsociado = bloqueAsociado;
        this.panelAsociado = new VBox();
        this.agregarLabelDnD(nombre);
        this.setContent(this.panelAsociado);
    }

    private void agregarLabelDnD(String nombre) {
        Label labelDnD= new Label(nombre);
        labelDnD.setStyle("-fx-background-color: #eea023; -fx-padding: 10px; -fx-border-color: #eea023; -fx-border-width: 3px; -fx-text-fill: white;");
        labelDnD.setFont(new Font("Arial", 20.0));
        labelDnD.setOnDragOver(new DragOverEventHandler());
        labelDnD.setOnDragEntered(new DragEnteredEventHandler(labelDnD));
        labelDnD.setOnDragExited(new DragExitedEventHandler(labelDnD));
        labelDnD.setOnDragDropped(new BloquesInternosDragDroppedEventHandler(this.bloqueAsociado, this.panelAsociado, this.panelArmado));
        this.panelAsociado.getChildren().add(labelDnD);
    }


}
