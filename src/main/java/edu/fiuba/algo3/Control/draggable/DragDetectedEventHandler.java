package edu.fiuba.algo3.Control.draggable;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class DragDetectedEventHandler implements EventHandler<MouseEvent> {

    private Button button;
    public DragDetectedEventHandler(Button button) {
        this.button = button;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Dragboard dragboard = button.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(button.getText());
        dragboard.setContent(content);
    }
}
