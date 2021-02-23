package edu.fiuba.algo3;

import edu.fiuba.algo3.draggable.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application{

    @Override
    public void start(Stage stage) {

        stage.setTitle("TP2");
        stage.setWidth(1000);
        stage.setHeight(800);

        VBox root = new VBox();                             //Marco Principal
        root.setStyle("-fx-background-color: #4e2e78;");

        HBox botoneraDeEjecucion = new HBox();
        botoneraDeEjecucion.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 3px" );
        //botoneraDeEjecucion.setAlignment(Pos.CENTER_LEFT);
        Button botonEjecutar = new Button("Ejecutar");
        Button botonLimpiar = new Button("Limpiar");
        Button botonPersonalizado = new Button("Personalizado");
        Button botonEliminar = new Button("Eliminar");

        ArrayList<Button> botonesMenu = new ArrayList<>(Arrays.asList(botonEjecutar, botonLimpiar, botonPersonalizado, botonEliminar));
        for (Button boton : botonesMenu) {
            boton.setFont(Font.font("Impact", 15));
            boton.setStyle("-fx-background-color: #896bab; -fx-border-color: #896bab; -fx-border-width: 2px; -fx-text-fill: white;");
        }

        botoneraDeEjecucion.setSpacing(30);
        botoneraDeEjecucion.getChildren().addAll(botonEjecutar, botonLimpiar, botonPersonalizado, botonEliminar);
        botoneraDeEjecucion.setStyle("-fx-background-color: #896bab;");
        root.getChildren().add(botoneraDeEjecucion);

        HBox contenedorInferior = new HBox();
        VBox contenedorInferiorIzquierda = new VBox();


        VBox botoneraDeAcciones = new VBox();
        botoneraDeAcciones.setSpacing(60);
        botoneraDeAcciones.setAlignment(Pos.CENTER);
        Button botonMoverAbajo = new Button("↓");
        Button botonMoverIzquierda = new Button("←");
        Button botonMoverDerecha = new Button("→");
        Button botonMoverArriba = new Button("↑");
        Button botonBajarLapiz = new Button("✎");
        Button botonSubirLapiz = new Button("✐");
        Button botonRepetir = new Button("⟳");
        Button botonInvertir = new Button("⇄");

        //todosLosBotonesIguales
        ArrayList<Button> listaBotonesEspeciales = new ArrayList<>(Arrays.asList(botonInvertir, botonBajarLapiz, botonSubirLapiz, botonRepetir));
        for (Button boton : listaBotonesEspeciales) {
            boton.setFont(Font.font("Impact", 32));
            boton.setShape(new Circle(2.5));
            boton.setStyle("-fx-background-color: #896bab; -fx-border-color: white; -fx-border-width: 2px; -fx-text-fill: white;");

        }

        ArrayList<Button> listaBotonesMovimiento = new ArrayList<>(Arrays.asList(botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha, botonMoverArriba));
        for (Button boton : listaBotonesMovimiento) {
            boton.setFont(Font.font("Impact", 30));
            boton.setStyle("-fx-background-radius: 20; -fx-background-color: #896bab; -fx-border-color: white; -fx-border-width: 2px;; -fx-border-radius: 20; -fx-text-fill: white;");
            boton.setMinSize(30, 30);
        }




        VBox botoneraMovimiento = new VBox();
        HBox botonesMovimiento = new HBox();
        botonesMovimiento.setAlignment(Pos.CENTER);
        botoneraMovimiento.setAlignment(Pos.CENTER);
        botoneraMovimiento.setSpacing(10);
        botonesMovimiento.setSpacing(10);
        botonesMovimiento.getChildren().addAll(botonMoverIzquierda, botonMoverAbajo, botonMoverDerecha);
        botoneraMovimiento.getChildren().addAll(botonMoverArriba, botonesMovimiento);

        HBox botonesEspeciales = new HBox();
        botonesEspeciales.setAlignment(Pos.CENTER);
        botonesEspeciales.setSpacing(10);
        botonesEspeciales.getChildren().addAll(botonBajarLapiz, botonSubirLapiz, botonRepetir, botonInvertir);

        botoneraDeAcciones.getChildren().addAll(botoneraMovimiento, botonesEspeciales);
        botoneraDeAcciones.setStyle("-fx-background-color: #231e1e; -fx-border-color: black; -fx-border-width: 3px" );
        botoneraDeAcciones.setMinSize(368.5,368.5);



        VBox zonaDeDibujo = new VBox();   // Esto puede ser otro tipo de nodo deah
        zonaDeDibujo.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 3px" );
        zonaDeDibujo.setMinSize(368.5,368.5);

        VBox zonaDeConstruccion = new VBox();
        Text texto = new Text("When run");
        zonaDeConstruccion.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 3px" );
        zonaDeConstruccion.setMinWidth(630);
        zonaDeConstruccion.getChildren().add(texto);
        contenedorInferiorIzquierda.getChildren().addAll(zonaDeDibujo, botoneraDeAcciones);
        contenedorInferior.getChildren().addAll(contenedorInferiorIzquierda, zonaDeConstruccion);


        /* drag & drop */
        ArrayList<Button> listaTodosLosBotones = new ArrayList<>(Arrays.asList(botonInvertir, botonBajarLapiz, botonSubirLapiz, botonRepetir));
        listaTodosLosBotones.addAll(listaBotonesMovimiento);
        llenarBotonesConEventos(listaTodosLosBotones, zonaDeConstruccion);
        transformarEnObjetivo(zonaDeConstruccion, texto);

        root.getChildren().add(contenedorInferior);





        Scene scene = new Scene(root);                      //Agrego el root a la escena
        stage.setScene(scene);
        stage.show();

    }

    public void llenarBotonesConEventos(ArrayList<Button> buttons, VBox vBox) {
        for (Button button : buttons) {
            trasnformarEnArrastrable(button, vBox);
        }
    }

    void trasnformarEnArrastrable(Button button, VBox vBox) {
        button.setOnDragDetected(new DragDetectedEventHandler(button));
        button.setOnDragDone(new DragDoneEventHandler(button));
    }

    void transformarEnObjetivo(VBox vBox, Text texto) {
        texto.setOnDragOver(new DragOverEventHandler());
        texto.setOnDragEntered(new DragEnteredEventHandler(texto));
        texto.setOnDragExited(new DragExitedEventHandler(texto));
        texto.setOnDragDropped(new DragDroppedEventHandler(vBox));
    }

    public static void main(String[] args) {
        launch();
    }

}