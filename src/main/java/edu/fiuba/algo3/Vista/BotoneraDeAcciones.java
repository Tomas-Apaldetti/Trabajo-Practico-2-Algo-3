package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.draggable.DragDetectedEventHandler;
import edu.fiuba.algo3.Control.draggable.DragDoneEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotoneraDeAcciones extends GridPane {

    BotoneraDeAcciones(Stage stage)
    {
        this.setAlignment(Pos.CENTER);
        for (int i = 0; i < 5; i++) {
            ColumnConstraints columna = new ColumnConstraints();
            columna.setPercentWidth(20);
            this.getColumnConstraints().add(columna);
        }
        for (int i = 0; i < 5; i++) {
            RowConstraints fila = new RowConstraints();
            fila.setPercentHeight(20);
            this.getRowConstraints().add(fila);
        }


        this.setHgap(15);
        this.setVgap(15);

        this.crearMovimiento();
        this.crearAcciones();

    }

    private void crearMovimiento(Button... botones)
    {
        Button botonMoverAbajo = new Button("↓");
        Button botonMoverIzquierda = new Button("←");
        Button botonMoverDerecha = new Button("→");
        Button botonMoverArriba = new Button("↑");

        this.estilizarBotones(botonMoverAbajo,botonMoverIzquierda,botonMoverDerecha,botonMoverArriba);

        this.add(botonMoverArriba,2,1);
        this.add(botonMoverAbajo,2,2);
        this.add(botonMoverIzquierda,1,2);
        this.add(botonMoverDerecha,3,2);

        agregarEventos(botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha, botonMoverArriba);
    }

    private void crearAcciones()
    {
        Button botonBajarLapiz = new Button("✎");
        Button botonSubirLapiz = new Button("✐");
        Button botonRepetir = new Button("⟳");
        Button botonInvertir = new Button("⇄");

        this.estilizarAcciones(botonBajarLapiz,botonSubirLapiz,botonRepetir,botonInvertir);

        this.add(botonBajarLapiz,0,4);
        this.add(botonSubirLapiz,1,4);
        this.add(botonRepetir,3,4);
        this.add(botonInvertir, 4,4);

        agregarEventos(botonBajarLapiz, botonSubirLapiz, botonRepetir, botonInvertir);
    }

    private void estilizarBotones(Button... botones)
    {
        for (Button boton : botones) {
            boton.setFont(Font.font("Impact", 30));
            boton.setStyle( " -fx-background-radius: 20;" +
                            " -fx-background-color: #896bab;" +
                            " -fx-border-color: white;" +
                            " -fx-border-width: 2px;" +
                            " -fx-border-radius: 20;" +
                            " -fx-text-fill: white;");
            boton.setPrefSize(80,80);
            boton.setOnMouseEntered(event -> {
                boton.setScaleY(1.1);
                boton.setScaleX(1.1);
            });
            boton.setOnMouseExited(event -> {
                boton.setScaleY(1);
                boton.setScaleX(1);
            });
        }
    }

    private void estilizarAcciones(Button... botones)
    {
        for (Button boton : botones) {
            boton.setFont(Font.font("Impact", 30));
            boton.setStyle( "-fx-background-color: #896bab;" +
                            " -fx-border-color: white;" +
                            " -fx-border-width: 2px;" +
                            " -fx-border-radius: 80;" +
                            " -fx-background-radius: 80;" +
                            " -fx-text-fill: white;");
            boton.setPrefSize(80,80);
            boton.setOnMouseEntered(event -> {
                boton.setScaleY(1.1);
                boton.setScaleX(1.1);
            });
            boton.setOnMouseExited(event -> {
                boton.setScaleY(1);
                boton.setScaleX(1);
            });

        }
    }

    private void agregarEventos(Button... botones) {
        for (Button boton : botones) {
            transformarEnArrastrable(boton);
        }
    }

    private void transformarEnArrastrable(Button boton) {
        boton.setOnDragDetected(new DragDetectedEventHandler(boton));
        boton.setOnDragDone(new DragDoneEventHandler(boton));
    }
}
