package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.IObservaMovimientos;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PanelDibujo extends VBox implements IObservaMovimientos {

    private List<Posicion> movimientos = new ArrayList<>();

    private Canvas canvas = new Canvas(512,512);
    private GraphicsContext dibujante = canvas.getGraphicsContext2D();

    PanelDibujo(Stage stage, Personaje personaje)
    {
        this.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 3px");
        this.setMinSize(256,256);
        this.getChildren().add(canvas);
    }


    @Override
    public void avisarMovimiento(Posicion posicion1, Posicion posicion2) {
        if(!(movimientos.isEmpty()))
        {
            Posicion ultimaPosicion = movimientos.get(movimientos.size()-1);
            if(ultimaPosicion.equals(posicion1))
                movimientos.remove(movimientos.size()-1);
        }
        movimientos.add(posicion1);
        movimientos.add(posicion2);
    }

    @Override
    public List<Posicion> obtenerMovimientos() {
        return null;
    }
}
