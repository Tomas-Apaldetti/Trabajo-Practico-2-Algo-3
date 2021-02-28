package edu.fiuba.algo3.Control.draggable;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class DragOverEventHandler implements EventHandler<DragEvent> {

    @Override
    public void handle(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
    }
}
