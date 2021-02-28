package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.draggable.DragDetectedEventHandler;
import edu.fiuba.algo3.Control.draggable.DragDoneEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MenuAlgoritmoPersonalizados extends VBox {


    MenuAlgoritmoPersonalizados(){
        this.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 5px; -fx-border-radius:10; -fx-background-radius:20");
        //this.setMinHeight(680);
        //this.setMinWidth(100);
        this.setMinSize(500,250);
        Label encabezado = new Label("Algoritmos Guardados");
        this.getChildren().add(encabezado);

        estilizarEncabezado(encabezado);
    }
    private void estilizarEncabezado(Label encabezado) {
        encabezado.setStyle("-fx-background-color: #eea023; -fx-padding: 10px; -fx-border-color: #eea023; -fx-border-width: 3px; -fx-text-fill: white;");
        encabezado.setFont(new Font("Arial", 20.0));
    }

    public void agregarBotonAlgoritmoPersonalizado (String nombreAlgoritmo){
        Button botonNuevoAlgoritmo = new Button(nombreAlgoritmo);
        botonNuevoAlgoritmo.setFont(Font.font("Impact", 30));
        botonNuevoAlgoritmo.setStyle("-fx-background-color: #2784C8; -fx-border-color: white; -fx-border-width: 3px; -fx-text-fill: white;");
        this.getChildren().add(botonNuevoAlgoritmo);
        botonNuevoAlgoritmo.setOnDragDetected(new DragDetectedEventHandler(botonNuevoAlgoritmo));
        botonNuevoAlgoritmo.setOnDragDone(new DragDoneEventHandler(botonNuevoAlgoritmo));
    }


}
