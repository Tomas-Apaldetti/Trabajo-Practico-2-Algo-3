package edu.fiuba.algo3.Control;

import edu.fiuba.algo3.Vista.BotonBloqueArmado;
import edu.fiuba.algo3.Vista.BotonEliminar;
import edu.fiuba.algo3.Vista.ITabArmadoBloques;
import edu.fiuba.algo3.Vista.PanelArmado;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class CambiarATabMouseEvent implements EventHandler<MouseEvent> {
    private final ITabArmadoBloques tab;
    private final PanelArmado panel;
    private final BotonEliminar botonEliminar;
    private final BotonBloqueArmado botonBloqueArmado;

    private final int FOCUS = 1;
    private final int CAMBIAR_TAB = 2;



    public CambiarATabMouseEvent(PanelArmado panelArmado, ITabArmadoBloques tabAsociada, BotonEliminar botonEliminar, BotonBloqueArmado botonBloqueArmado) {
        this.tab = tabAsociada;
        this.panel = panelArmado;
        this.botonEliminar = botonEliminar;
        this.botonBloqueArmado = botonBloqueArmado;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY))
            if(mouseEvent.getClickCount() == FOCUS)
                this.botonEliminar.setBloqueABorrar(this.botonBloqueArmado);
            else if(mouseEvent.getClickCount() == CAMBIAR_TAB)
                this.panel.getSelectionModel().select((Tab) tab);
    }
}
