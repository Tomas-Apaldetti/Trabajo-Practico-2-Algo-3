package edu.fiuba.algo3.draggable;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class DragExitedEventHandler implements EventHandler<DragEvent> {

    private Label label;

    public DragExitedEventHandler(Label label) {
        this.label = label;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        label.setTextFill(Color.WHITE);
    }
}
