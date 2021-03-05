package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.BotonEjecutarEventHandler;
import edu.fiuba.algo3.Control.BotonEliminarAlgoritmosPersonalizadosEventHandler;
import edu.fiuba.algo3.Control.BotonGuardarEventHandler;
import edu.fiuba.algo3.Control.BotonLimpiarEventHandler;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BotoneraDeEjecucion extends HBox {


    BotoneraDeEjecucion(Stage stage, TableroAlgoritmo armadorAlgoritmo, PanelArmado panelArmado, PanelDibujo panelDibujo, MenuAlgoritmoPersonalizados menuAlgortimos) {
        this.setPadding(new Insets(5));
        this.setMinHeight(40);
        this.setSpacing(50);
        Button botonEjecutar = new Button("Ejecutar");
        botonEjecutar.setOnAction(new BotonEjecutarEventHandler(armadorAlgoritmo, panelDibujo));
        this.estilizarBotonEjecutar(botonEjecutar);

        Button botonGuardar = new Button("Guardar");

        BotonEliminar botonEliminar = new BotonEliminar("Eliminar");
        panelArmado.asociarBotonEliminar(botonEliminar);

        Button botonLimpiar = new Button("Limpiar");
        botonLimpiar.setOnAction(new BotonLimpiarEventHandler(armadorAlgoritmo, panelArmado));

        botonGuardar.setOnAction(new BotonGuardarEventHandler(stage,armadorAlgoritmo,menuAlgortimos,panelArmado));

        Button botonEliminarAlgoritmosPersonalizados = new Button("Limpiar algoritmos personalizados");
        botonEliminarAlgoritmosPersonalizados.setOnAction(new BotonEliminarAlgoritmosPersonalizadosEventHandler(armadorAlgoritmo, menuAlgortimos));

        this.estilizarBotones(botonGuardar, botonLimpiar, botonEliminarAlgoritmosPersonalizados,botonEliminar);

        this.getChildren().addAll(botonEjecutar,botonGuardar,botonLimpiar, botonEliminarAlgoritmosPersonalizados,botonEliminar);
    }

    private void estilizarBotonEjecutar(Button botonEjecutar) {
        botonEjecutar.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD,20));
        botonEjecutar.setStyle("-fx-background-color:#262626;" +
                " -fx-border-color: #121212;" +
                " -fx-border-insets: -1;" +
                " -fx-border-radius: 13;" +
                " -fx-border-width: 2;" +
                " -fx-text-fill: #C5C5C5;" +
                " -fx-background-radius: 15");
        botonEjecutar.setOnMouseEntered(e->
        {
            botonEjecutar.setScaleY(1.1);
            botonEjecutar.setScaleX(1.1);
        });

        botonEjecutar.setOnMouseExited(e->
        {
            botonEjecutar.setScaleY(1);
            botonEjecutar.setScaleX(1);
        });
    }

    private void estilizarBotones(ButtonBase... botones) {
        for(ButtonBase boton : botones)
        {
            boton.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD,15));
            boton.setStyle("-fx-background-color:#6C548C;" +
                    " -fx-border-color: #C5C5C5;" +
                    " -fx-border-insets: -1;" +
                    " -fx-border-radius: 13;" +
                    " -fx-border-width: 2;" +
                    " -fx-text-fill: #C5C5C5;" +
                    " -fx-background-radius: 15");
            boton.setOnMouseEntered(event -> {
                boton.setScaleX(1.1);
                boton.setScaleY(1.1);
            });
            boton.setOnMouseExited(event -> {
                boton.setScaleX(1);
                boton.setScaleY(1);
            });
        }
    }
}
