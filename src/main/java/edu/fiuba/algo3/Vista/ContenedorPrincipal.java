package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends VBox {
    private Stage root;
    private BotoneraDeEjecucion botoneraDeEjecucion;
    private BotoneraDeAcciones botoneraDeAcciones;
    private PanelDibujo panelDibujo;
    private PanelArmado panelArmado;
    private GridPane grilla = new GridPane();

    public ContenedorPrincipal(Stage stage)
    {
        root = stage;
        grilla.setHgap(20);
        grilla.setVgap(20);
        this.setStyle("-fx-background-color: #4e2e78;");
        botoneraDeEjecucion = this.crearBotoneraEjecucion();
        botoneraDeAcciones = this.crearBotoneraAccion();
        panelDibujo = this.crearPanelDibujo();
        panelArmado = this.crearPanelArmado();
        this.getChildren().add(grilla);
    }

    private PanelArmado crearPanelArmado() {
        PanelArmado panel = new PanelArmado();
        grilla.add(panel,1,0,1,2);
        return panel;
    }

    private PanelDibujo crearPanelDibujo() {
        PanelDibujo panel = new PanelDibujo(root);
        grilla.add(panel,0,0);
        return panel;

    }

    private BotoneraDeEjecucion crearBotoneraEjecucion() {
        BotoneraDeEjecucion botonera = new BotoneraDeEjecucion(root);
        this.getChildren().add(botonera);
        return botonera;
    }

    private BotoneraDeAcciones crearBotoneraAccion(){
        BotoneraDeAcciones botonera = new BotoneraDeAcciones(root);
        this.grilla.add(botonera,0,1);
        return botonera;
    }




}
