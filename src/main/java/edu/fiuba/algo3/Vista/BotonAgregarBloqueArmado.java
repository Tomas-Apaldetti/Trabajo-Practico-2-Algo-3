package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.draggable.DragDetectedEventHandler;
import edu.fiuba.algo3.Control.draggable.DragDoneEventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonAgregarBloqueArmado extends Button {

    public BotonAgregarBloqueArmado(String identificador) {
        super(identificador);
        this.setPrefHeight(60);
        this.setPrefWidth(60);
        this.setMaxWidth(Double.MAX_VALUE);
        this.estilizar();
        this.agregarDragAndDrop();
    }

    private void agregarDragAndDrop() {
        this.setOnDragDetected(new DragDetectedEventHandler(this));
        this.setOnDragDone(new DragDoneEventHandler(this));
    }

    private void estilizar() {
        this.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD,20));
        this.setStyle("-fx-background-color: #6C548C;" +
                " -fx-background-radius: 23;" +
                " -fx-border-color: #C5C5C5;" +
                " -fx-border-width: 3;" +
                " -fx-border-radius: 20;" +
                " -fx-border-insets: -1;" +
                " -fx-text-fill: #C5C5C5;");
    }
}
