package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.BotonEjecutarEventHandler;
import edu.fiuba.algo3.Control.BotonGuardarEventHandler;
import edu.fiuba.algo3.Control.BotonLimpiarEventHandler;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotoneraDeEjecucion extends HBox {


    BotoneraDeEjecucion(Stage stage, TableroAlgoritmo armadorAlgoritmo,PanelArmado panelArmado, PanelDibujo panelDibujo,MenuAlgoritmoPersonalizados menuAlgortimos) {
        this.setStyle("-fx-background-color: #896bab; -fx-border-color: black; -fx-border-width: 3px");
        this.setMinHeight(40);
        this.setSpacing(50);
        Button botonEjecutar = new Button("Ejecutar");
        botonEjecutar.setOnAction(new BotonEjecutarEventHandler(armadorAlgoritmo, panelDibujo));

        Button botonLimpiar = new Button("Limpiar");
        botonLimpiar.setOnAction(new BotonLimpiarEventHandler(armadorAlgoritmo, panelArmado));

        Button botonGuardar = new Button("Guardar");
        botonGuardar.setOnAction(new BotonGuardarEventHandler(stage,armadorAlgoritmo,menuAlgortimos));

        this.estilizarBotones(botonEjecutar, botonGuardar, botonLimpiar);

        this.getChildren().addAll(botonEjecutar,botonGuardar,botonLimpiar);
    }

    private void estilizarBotones(ButtonBase... botones) {
        for(ButtonBase boton : botones)
        {
            boton.setFont(Font.font("Impact", 15));
            boton.setStyle("-fx-background-color: #896bab; -fx-border-color: #896bab; -fx-border-width: 2px; -fx-text-fill: white;");
            boton.setOnMouseEntered(event -> {
                boton.setStyle("-fx-background-color: #896bab;" +
                        " -fx-border-color: white;" +
                        " -fx-border-width: 2px;" +
                        " -fx-text-fill: white;" +
                        " -fx-border-radius: 5;");
            });
            boton.setOnMouseExited(event -> {
                boton.setStyle("-fx-background-color: #896bab; -fx-border-color: #896bab; -fx-border-width: 2px; -fx-text-fill: white;");
            });
        }
    }
}
