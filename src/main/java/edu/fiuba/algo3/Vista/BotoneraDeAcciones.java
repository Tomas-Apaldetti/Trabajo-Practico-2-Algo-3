package edu.fiuba.algo3.Vista;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;


public class BotoneraDeAcciones extends HBox {

    public BotoneraDeAcciones()
    {
        this.agregarBotones();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(40);
        this.setPrefHeight(75);
    }

    private void agregarBotones() {
        BotonAgregarBloqueArmado botonMoverAbajo = new BotonAgregarBloqueArmado("↓");
        BotonAgregarBloqueArmado botonMoverIzquierda = new BotonAgregarBloqueArmado("←");
        BotonAgregarBloqueArmado botonMoverDerecha = new BotonAgregarBloqueArmado("→");
        BotonAgregarBloqueArmado botonMoverArriba = new BotonAgregarBloqueArmado("↑");

        BotonAgregarBloqueArmado botonBajarLapiz = new BotonAgregarBloqueArmado("✎");
        BotonAgregarBloqueArmado botonSubirLapiz = new BotonAgregarBloqueArmado("✐");
        BotonAgregarBloqueArmado botonRepetir = new BotonAgregarBloqueArmado("⟳");
        BotonAgregarBloqueArmado botonInvertir = new BotonAgregarBloqueArmado("⇄");

        this.getChildren().addAll(botonMoverAbajo,botonMoverIzquierda,botonMoverDerecha,botonMoverArriba,botonBajarLapiz,botonSubirLapiz,botonRepetir,botonInvertir);
    }
}
