package edu.fiuba.algo3.Control.draggable;

import edu.fiuba.algo3.Vista.IdentificarBloque;
import edu.fiuba.algo3.Vista.PanelArmado;
import edu.fiuba.algo3.Vista.TabBloquesComplejos;
import edu.fiuba.algo3.modelo.IBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DragDroppedEventHandler implements EventHandler<DragEvent> {

    private PanelArmado panelArmado;
    private VBox panelActivo;
    private TableroAlgoritmo armadorAlgoritmo;
    private IdentificarBloque identificadorBloque;

    public DragDroppedEventHandler(PanelArmado panelArmado, VBox panel, TableroAlgoritmo armadorAlgoritmo) {
        this.identificadorBloque = new IdentificarBloque();
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.panelArmado = panelArmado;
        this.panelActivo = panel;
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
        IBloque bloque = this.identificadorBloque.devolverBloque(simbolo);
        armadorAlgoritmo.agregarAccion(bloque);
        Button button = new Button(dragboard.getString());
        button.setMaxWidth(80);
        button.setMaxHeight(15);
        button.setFont(Font.font("Impact", 30));
        button.setStyle("-fx-background-color: #fa8072; -fx-border-color: white; -fx-border-width: 3px; -fx-text-fill: white;");
        panelActivo.getChildren().add(button);
        if(simbolo.equals("⟳") || simbolo.equals("⇄"))
        {
            String s;
            if(simbolo.equals("⟳")) {
                s="Repetir";
            }
            else{
                s="Invertir";
            }
            TabBloquesComplejos tab = new TabBloquesComplejos(s, this.panelArmado, bloque);
            this.panelArmado.getTabs().add(tab);
            button.setOnAction(e-> this.panelArmado.getSelectionModel().select(tab));
            this.panelArmado.getSelectionModel().select(tab);
        }

    }
}
