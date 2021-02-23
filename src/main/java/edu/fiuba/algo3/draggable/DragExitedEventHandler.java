package edu.fiuba.algo3.draggable;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class DragExitedEventHandler implements EventHandler<DragEvent> {

    private Text texto;

    public DragExitedEventHandler(Text texto) {
        this.texto = texto;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        texto.setFill(Color.BLACK);
    }
}
