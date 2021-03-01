package edu.fiuba.algo3.Control;

import edu.fiuba.algo3.Vista.BotonBloqueArmado;
import edu.fiuba.algo3.Vista.BotonEliminar;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class FocusBloqueArmadoMouseEvent implements EventHandler<MouseEvent> {
    private final BotonBloqueArmado botonAsociado;
    private final int CLICKS_NECESARIOS = 1;
    private final BotonEliminar botonEliminar;

    public FocusBloqueArmadoMouseEvent(BotonBloqueArmado botonBloqueArmado, BotonEliminar botonEliminar) {
        this.botonAsociado = botonBloqueArmado;
        this.botonEliminar = botonEliminar;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY))
            if(mouseEvent.getClickCount() == CLICKS_NECESARIOS)
            {
                botonEliminar.setBloqueABorrar(this.botonAsociado);
            }

    }
}
