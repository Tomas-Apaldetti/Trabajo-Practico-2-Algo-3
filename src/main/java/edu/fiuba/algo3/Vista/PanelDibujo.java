package edu.fiuba.algo3.Vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PanelDibujo extends VBox {

    private Canvas canvas = new Canvas(512,512);
    private GraphicsContext dibujante = canvas.getGraphicsContext2D();

    PanelDibujo(Stage stage)
    {
        this.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 3px");
        this.setMinSize(256,256);
        this.getChildren().add(canvas);
    }
}
