package edu.fiuba.algo3.Control;

import edu.fiuba.algo3.Vista.PanelArmado;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonLimpiarEventHandler implements EventHandler<ActionEvent> {
    private final PanelArmado panelArmado;
    private final TableroAlgoritmo armadorAlgoritmo;

    public BotonLimpiarEventHandler(TableroAlgoritmo armadorAlgoritmo, PanelArmado panelArmado) {
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.panelArmado = panelArmado;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        armadorAlgoritmo.resetear();
        panelArmado.limpiarTablero();
        }
}
