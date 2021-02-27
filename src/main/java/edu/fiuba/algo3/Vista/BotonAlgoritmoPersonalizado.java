package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.IBloque;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BotonAlgoritmoPersonalizado extends MenuButton {
    private Stage root;

    public BotonAlgoritmoPersonalizado(Stage stage, String label) {
        super(label);
        root = stage;
    }

    public void guardarNuevoAlgoritmo(IBloque algoritmo, String nombreAlgoritmo) {
        MenuItem algoritmoPersonalizado = new MenuItem(nombreAlgoritmo);
        this.getItems().add(algoritmoPersonalizado);
    }
}
