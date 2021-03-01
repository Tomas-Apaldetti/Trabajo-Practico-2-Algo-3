package edu.fiuba.algo3.Control.draggable;

import edu.fiuba.algo3.Vista.IdentificarBloque;
import edu.fiuba.algo3.Vista.PanelArmado;
import edu.fiuba.algo3.Vista.TabBloquesComplejos;
import edu.fiuba.algo3.modelo.IBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BloquesInternosDragDroppedEventHandler implements EventHandler<DragEvent> {

    private final IBloque bloqueAsociado;
    private final VBox panelAsociado;
    private final PanelArmado panelPrincipal;
    private final IdentificarBloque identificadorBloque;
    private final TableroAlgoritmo armadorAlgoritmo;
    public BloquesInternosDragDroppedEventHandler(IBloque bloqueInterno, VBox panelAsociado, PanelArmado panelPrincipal, TableroAlgoritmo armadorAlgoritmo)
    {
        this.bloqueAsociado = bloqueInterno;
        this.panelAsociado = panelAsociado;
        this.panelPrincipal = panelPrincipal;
        this.identificadorBloque = new IdentificarBloque();
        this.armadorAlgoritmo = armadorAlgoritmo;
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
        IBloque bloque = this.identificadorBloque.devolverBloque(simbolo, this.armadorAlgoritmo);
        bloqueAsociado.agregarAccion(bloque);
        Button button = new Button(dragboard.getString());
        button.setMaxWidth(80);
        button.setMaxHeight(15);
        button.setFont(Font.font("Impact", 30));
        button.setStyle("-fx-background-color: #fa8072; -fx-border-color: white; -fx-border-width: 3px; -fx-text-fill: white;");
        panelAsociado.getChildren().add(button);
        if(simbolo.equals("⟳") || simbolo.equals("⇄"))
        {
            String s;
            if(simbolo.equals("⟳")) {
                s="Repetir";
            }
            else{
                s="Invertir";
            }
            TabBloquesComplejos tab = new TabBloquesComplejos(s, this.panelPrincipal, bloque, this.armadorAlgoritmo);
            this.panelPrincipal.getTabs().add(tab);
            button.setOnAction(e-> this.panelPrincipal.getSelectionModel().select(tab));
            this.panelPrincipal.getSelectionModel().select(tab);
        }
    }
}
