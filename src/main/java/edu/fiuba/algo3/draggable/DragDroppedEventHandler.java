package edu.fiuba.algo3.draggable;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class DragDroppedEventHandler implements EventHandler<DragEvent> {

    private VBox vBox;

    public DragDroppedEventHandler(VBox vBox) {
        this.vBox = vBox;
    }

    @Override
    public void handle(DragEvent dragEvent) {

        Dragboard dragboard = dragEvent.getDragboard();
        if (dragboard.hasString()) {
            dragEvent.setDropCompleted(true);
        } else {
            dragEvent.setDropCompleted(false);
        }

        Button button = new Button(dragboard.getString());
        vBox.getChildren().add(button);
    }
}
