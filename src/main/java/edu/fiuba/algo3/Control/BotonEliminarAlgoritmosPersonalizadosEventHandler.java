package edu.fiuba.algo3.Control;

import edu.fiuba.algo3.Vista.MenuAlgoritmoPersonalizados;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEliminarAlgoritmosPersonalizadosEventHandler implements EventHandler<ActionEvent> {

    private final MenuAlgoritmoPersonalizados menuAlgoritmos;
    private final TableroAlgoritmo armadorAlgoritmo;

    public BotonEliminarAlgoritmosPersonalizadosEventHandler(TableroAlgoritmo armadorAlgoritmo, MenuAlgoritmoPersonalizados menuAlgoritmos) {
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.menuAlgoritmos = menuAlgoritmos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        armadorAlgoritmo.eliminarAlgoritmosPersonalizados();
        menuAlgoritmos.limpiarMenu();
    }
}
