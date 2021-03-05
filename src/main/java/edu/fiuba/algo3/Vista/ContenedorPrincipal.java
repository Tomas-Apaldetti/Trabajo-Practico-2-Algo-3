package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    private Stage root;
    private PanelDibujo panelDibujo;
    private PanelArmado panelArmado;
    private MenuAlgoritmoPersonalizados menuAlgoritmoPersonalizados;
    private Personaje personaje;
    private TableroAlgoritmo armadorAlgoritmo;

    public ContenedorPrincipal(Stage stage, Personaje personaje, TableroAlgoritmo armadorAlgoritmo)
    {
        this.setMinSize(1000,500);
        this.setMaxSize(1250,720);
        this.root = stage;
        this.setStyle("-fx-background-color: #6C548C;");
        this.personaje = personaje;
        this.armadorAlgoritmo = armadorAlgoritmo;
        menuAlgoritmoPersonalizados = this.crearMenuAlgoritmoPersonalizados();
        panelDibujo = this.crearPanelDibujo();
        panelArmado = this.crearPanelArmado();
        this.crearBotoneraEjecucion();
        this.crearBotoneraAccion();
    }


    private MenuAlgoritmoPersonalizados crearMenuAlgoritmoPersonalizados() {
        MenuAlgoritmoPersonalizados menu = new MenuAlgoritmoPersonalizados();
        this.setRight(menu);
        return menu;
    }


    private PanelArmado crearPanelArmado() {
        PanelArmado panel = new PanelArmado(this.armadorAlgoritmo);
        this.setCenter(panel);
        return panel;
    }

    private PanelDibujo crearPanelDibujo() {
        PanelDibujo panel = new PanelDibujo(root, personaje);
        personaje.aniadirObservador(panel);
        this.setLeft(panel);
        this.setAlignment(panel, Pos.CENTER_LEFT);
        return panel;
    }

    private void crearBotoneraEjecucion() {
        BotoneraDeEjecucion botonera = new BotoneraDeEjecucion(root, armadorAlgoritmo, panelArmado, panelDibujo,menuAlgoritmoPersonalizados);
        this.setTop(botonera);
    }

    private void crearBotoneraAccion(){
        BotoneraDeAcciones botonera = new BotoneraDeAcciones();
        this.setBottom(botonera);
    }




}
