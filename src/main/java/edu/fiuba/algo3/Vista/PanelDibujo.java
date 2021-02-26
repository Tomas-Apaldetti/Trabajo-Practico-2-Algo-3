package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.IObservaMovimientos;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    public void resetear(){
        }

    public void dibujarAlgoritmo(){
        for (Posicion posicion: movimientos){
            dibujante.setFill(Color.BLACK);
            dibujante.fillOval(posicion.obtenerCoordenadaX()*20 +256, posicion.obtenerCoordenadaY()*-20+ 150, 20 ,20);
            }

    }

    @Override
    public void avisarMovimiento(Posicion posicionActual, Posicion posicionFinal) {
        if(!(movimientos.isEmpty()))
        {
            Posicion ultimaPosicion = movimientos.get(movimientos.size()-1);   //Creo que ya podria sacarse directamente
            if(ultimaPosicion.equals(posicionActual));                         // No se si ahce falta tanta lógica
                movimientos.remove(movimientos.size()-1);
        }
        movimientos.add(posicionActual);
        movimientos.add(posicionFinal);
    }

    @Override
    public List<Posicion> obtenerMovimientos() {
        return null;
    }
}
