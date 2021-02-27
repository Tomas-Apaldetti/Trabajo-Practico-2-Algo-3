package edu.fiuba.algo3.draggable;

import edu.fiuba.algo3.Vista.IdentificarBloque;
import javafx.event.EventHandler;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import edu.fiuba.algo3.modelo.IBloque;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class DragDroppedEventHandler implements EventHandler<DragEvent> {

    private VBox vBox;
    private TableroAlgoritmo armadorAlgoritmo;
    private IdentificarBloque identificadorBloque;

    public DragDroppedEventHandler(VBox vBox,TableroAlgoritmo armadorAlgoritmo) {
        this.identificadorBloque = new IdentificarBloque();
        this.armadorAlgoritmo = armadorAlgoritmo;
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
        String simbolo = dragboard.getString();
        armadorAlgoritmo.agregarAccion(this.identificadorBloque.devolverBloque(simbolo));
        Button button = new Button(dragboard.getString());
        button.setFont(Font.font("Impact", 30));
        button.setStyle("-fx-background-color: #fa8072; -fx-border-color: white; -fx-border-width: 3px; -fx-text-fill: white;");
        vBox.getChildren().add(button);

    }
}
