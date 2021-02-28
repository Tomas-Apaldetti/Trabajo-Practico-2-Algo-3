package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.IObservador;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class PanelDibujo extends Pane implements IObservador {

    private List<Posicion> movimientos = new ArrayList<>();
    private Personaje personaje;
    private ImageView sprite;

    private final String RUTA_PERSONAJE = "harry.jpeg";
    private final int BLOQUE = 50;
    private final int PAUSA_MS = 350;

    PanelDibujo(Stage stage, Personaje personaje)
    {
        this.personaje = personaje;
        Posicion posicionInicial = this.personaje.obtenerPosicion();
        movimientos.add(posicionInicial);
        this.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 5px; -fx-border-radius:10; -fx-background-radius:20");
        this.setMinSize(500,250);
       // this.setMaxSize(640,640);
        this.clipear();
        this.setSprite(RUTA_PERSONAJE);
    }

    private void clipear() {
        final Rectangle outputClip = new Rectangle();
        outputClip.setWidth(512);
        outputClip.setHeight(512);
        outputClip.setArcHeight(30);
        outputClip.setArcWidth(30);
        this.setClip(outputClip);
    }

    private void setSprite(String rutaSprite) {
        Image harryImg = new Image(rutaSprite);
        ImageView harry = new ImageView();
        harry.setFitHeight(BLOQUE);
        harry.setFitWidth(BLOQUE);
        harry.setImage(harryImg);
        this.sprite = harry;
        Translate translate = new Translate(256-(BLOQUE/2),256-(BLOQUE/2));
        sprite.getTransforms().add(translate);
        this.getChildren().add(this.sprite);
    }

    public void resetear(){
        this.getChildren().clear();
        this.movimientos.clear();
        this.personaje.resetear();
        movimientos.add(this.personaje.obtenerPosicion());
        this.setSprite(RUTA_PERSONAJE);
    }

    public void dibujarAlgoritmo(){
        Timeline animacionMovimiento = new Timeline();
        int i = 1;
        for (Posicion posicion: movimientos){
            Color color = Color.TRANSPARENT;
            if(posicion.estaPintado())
                color = Color.BLACK;

            Ellipse espacio = new Ellipse(posicion.obtenerCoordenadaX() * BLOQUE + 256,
                    posicion.obtenerCoordenadaY() * (-BLOQUE) + 256,
                    BLOQUE/2,
                    BLOQUE/2);
            espacio.setFill(Color.TRANSPARENT);

            KeyValue coloracion = new KeyValue(espacio.fillProperty(),color);

            KeyValue movimientoX = new KeyValue(this.sprite.xProperty(),posicion.obtenerCoordenadaX() * BLOQUE);
            KeyValue movimientoY = new KeyValue(this.sprite.yProperty(),posicion.obtenerCoordenadaY() * (-BLOQUE));

            KeyFrame frame = new KeyFrame(Duration.millis(PAUSA_MS*i), e-> {
                this.getChildren().add(espacio);
            },coloracion, movimientoX, movimientoY);

            animacionMovimiento.getKeyFrames().add(frame);
            i++;
        }
        animacionMovimiento.play();
    }

    @Override
    public void actualizar() {
        Posicion posicionActual = this.personaje.obtenerPosicion();
        movimientos.add(posicionActual);
    }

}
