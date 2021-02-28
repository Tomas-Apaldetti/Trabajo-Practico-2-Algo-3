package edu.fiuba.algo3.Control.draggable;

import edu.fiuba.algo3.Vista.IdentificarBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;
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
        button.setMaxWidth(80);
        button.setMaxHeight(15);
        button.setFont(Font.font("Impact", 30));
        button.setStyle("-fx-background-color: #fa8072; -fx-border-color: white; -fx-border-width: 3px; -fx-text-fill: white;");
        vBox.getChildren().add(button);

    }
}
