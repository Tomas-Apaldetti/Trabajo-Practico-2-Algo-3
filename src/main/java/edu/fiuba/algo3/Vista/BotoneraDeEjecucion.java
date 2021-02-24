package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotoneraDeEjecucion extends HBox {

    private BotonAlgoritmoPersonalizado personalizados;

    BotoneraDeEjecucion(Stage stage) {
        this.setStyle("-fx-background-color: #896bab; -fx-border-color: black; -fx-border-width: 3px");
        this.setSpacing(50);

        Button botonEjecutar = new Button("Ejecutar");
        //TODO: Agregar eventHandler
        Button botonGuardar = new Button("Guardar");
        //TODO: Agregar eventHandler
        Button botonLimpiar = new Button("Limpiar");
        //TODO: Agregar eventHandler
        personalizados = new BotonAlgoritmoPersonalizado(stage,"Algoritmos Guardados");

        this.estilizarBotones(botonEjecutar, botonGuardar, botonLimpiar, personalizados);

        this.getChildren().addAll(botonEjecutar,botonGuardar,botonLimpiar,personalizados);
    }

    private void estilizarBotones(ButtonBase... botones) {
        for(ButtonBase boton : botones)
        {
            boton.setFont(Font.font("Impact", 15));
            boton.setStyle("-fx-background-color: #896bab; -fx-border-color: #896bab; -fx-border-width: 0px; -fx-text-fill: white;");
        }
    }
}
