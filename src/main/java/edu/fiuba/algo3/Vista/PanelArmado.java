package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.draggable.DragDroppedEventHandler;
import edu.fiuba.algo3.draggable.DragEnteredEventHandler;
import edu.fiuba.algo3.draggable.DragExitedEventHandler;
import edu.fiuba.algo3.draggable.DragOverEventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PanelArmado extends VBox {

    private Label label = new Label("Al ejecutar ▶");

    PanelArmado(){
        this.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 3px");
        this.setMinHeight(680);
        this.setMinWidth(600);
        this.getChildren().add(label);

        estilizarLabel(label);
        transformarEnObjetivo(label);
    }

    private void estilizarLabel(Label label) {
        label.setStyle("-fx-background-color: #eea023; -fx-padding: 10px; -fx-border-color: #eea023; -fx-border-width: 3px; -fx-text-fill: white;");
        label.setFont(new Font("Arial", 20.0));
    }

    private void transformarEnObjetivo(Label label) {
        label.setOnDragOver(new DragOverEventHandler());
        label.setOnDragEntered(new DragEnteredEventHandler(label));
        label.setOnDragExited(new DragExitedEventHandler(label));
        label.setOnDragDropped(new DragDroppedEventHandler(this));
    }
}
