package edu.fiuba.algo3.Vista;

import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

public class BotonAlgoritmoPersonalizado extends MenuButton {
    private Stage root;

    public BotonAlgoritmoPersonalizado(Stage stage, String label) {
        super(label);
        root = stage;
    }
}
