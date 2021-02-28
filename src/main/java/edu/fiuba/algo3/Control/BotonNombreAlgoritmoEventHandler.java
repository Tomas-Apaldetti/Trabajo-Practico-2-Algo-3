package edu.fiuba.algo3.Control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonNombreAlgoritmoEventHandler implements EventHandler<ActionEvent> {
    private static final int LIMITE = 17;
    private Stage dialogoStage;
    private BotonGuardarEventHandler botonGuardar;
    private TextField textField;

    public BotonNombreAlgoritmoEventHandler(Stage dialogoStage, TextField textField, BotonGuardarEventHandler botonGuardar) {
        this.dialogoStage = dialogoStage;
        this.textField = textField;
        this.botonGuardar = botonGuardar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        String nombre = textField.getText();
        if(nombre.length() > LIMITE) nombre = nombre.substring(0, LIMITE);
        dialogoStage.close();
        botonGuardar.guardarBotonAlgoritmoPersonalizado(nombre);;
    }
}
