package edu.fiuba.algo3.Control.draggable;

import edu.fiuba.algo3.Vista.*;
import edu.fiuba.algo3.modelo.IBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

public class BloquesArmadoDragDroppedEventHandler implements EventHandler<DragEvent> {

    private final IBloque bloquePadre;
    private final VBox panelAsociado;
    private final PanelArmado panelPrincipal;
    private final TableroAlgoritmo armadorAlgoritmo;
    private final BotonEliminar botonEliminar;

    public BloquesArmadoDragDroppedEventHandler(IBloque bloquePadre, VBox panelAsociado, PanelArmado panelPrincipal, TableroAlgoritmo armadorAlgoritmo, BotonEliminar botonEliminar)
    {
        this.bloquePadre = bloquePadre;
        this.panelAsociado = panelAsociado;
        this.panelPrincipal = panelPrincipal;
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.botonEliminar = botonEliminar;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard dragboard = dragEvent.getDragboard();
        if (dragboard.hasString()) dragEvent.setDropCompleted(true);
        else dragEvent.setDropCompleted(false);
        String simbolo = dragboard.getString();

        IBloque bloque = IdentificarBloque.devolverBloque(simbolo, this.armadorAlgoritmo);
        BotonBloqueArmado boton = new BotonBloqueArmado(simbolo, this.panelPrincipal, this.botonEliminar, this.bloquePadre, bloque, this.panelAsociado);
        bloquePadre.agregarAccion(bloque);
        panelAsociado.getChildren().add(boton);
        if(simbolo.equals("⟳") || simbolo.equals("⇄"))
        {
            String s = "Invertir";
            if(simbolo.equals("⟳")) {
                s="Repetir";
            }

            ITabArmadoBloques tab = new TabBloquesComplejos(s, this.panelPrincipal, bloque, this.armadorAlgoritmo, this.botonEliminar);
            boton.tratarComoBloqueComplejo(tab);
            this.panelPrincipal.getSelectionModel().select((Tab) tab);
        }
    }
}
