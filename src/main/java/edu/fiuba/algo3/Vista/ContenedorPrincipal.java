package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
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
    private MenuAlgoritmoPersonalizados menuAlgoritmoPersonalizados;
    private GridPane grilla = new GridPane();
    private Personaje personaje;
    private TableroAlgoritmo armadorAlgoritmo;

    public ContenedorPrincipal(Stage stage, Personaje personaje, TableroAlgoritmo armadorAlgoritmo)
    {
        root = stage;
        grilla.setHgap(20);
        grilla.setVgap(20);
        this.setStyle("-fx-background-color: #4e2e78;");
        this.personaje = personaje;
        this.armadorAlgoritmo = armadorAlgoritmo;
        panelArmado = this.crearPanelArmado();
        panelDibujo = this.crearPanelDibujo();
        menuAlgoritmoPersonalizados = this.crearMenuAlgoritmoPersonalizados();
        botoneraDeEjecucion = this.crearBotoneraEjecucion();
        botoneraDeAcciones = this.crearBotoneraAccion();
        this.getChildren().add(grilla);
    }

    private MenuAlgoritmoPersonalizados crearMenuAlgoritmoPersonalizados() {
        MenuAlgoritmoPersonalizados menu = new MenuAlgoritmoPersonalizados();
        grilla.add(menu,2,0,1,1);
        return menu;
    }


    private PanelArmado crearPanelArmado() {
        PanelArmado panel = new PanelArmado(this.armadorAlgoritmo);
        grilla.add(panel,1,0,1,2);
        return panel;
    }

    private PanelDibujo crearPanelDibujo() {
        PanelDibujo panel = new PanelDibujo(root, personaje);
        personaje.aniadirObservador(panel);
        grilla.add(panel,0,0);
        return panel;
    }

    private BotoneraDeEjecucion crearBotoneraEjecucion() {
        BotoneraDeEjecucion botonera = new BotoneraDeEjecucion(root, armadorAlgoritmo, panelArmado, panelDibujo,menuAlgoritmoPersonalizados);
        this.getChildren().add(botonera);
        return botonera;
    }

    private BotoneraDeAcciones crearBotoneraAccion(){
        BotoneraDeAcciones botonera = new BotoneraDeAcciones(root);
        this.grilla.add(botonera,0,1);
        return botonera;
    }




}
