package edu.fiuba.algo3.draggable;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.VBox;

public class DragDoneEventHandler implements EventHandler<DragEvent> {

    private Button button;

    public DragDoneEventHandler(Button button) {
        this.button = button;
    }

    @Override
    public void handle(DragEvent dragEvent) {

    }
}
