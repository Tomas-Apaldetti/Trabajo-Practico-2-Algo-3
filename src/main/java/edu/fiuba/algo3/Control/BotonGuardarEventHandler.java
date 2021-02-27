package edu.fiuba.algo3.Control;

import edu.fiuba.algo3.Vista.BotonAlgoritmoPersonalizado;
import edu.fiuba.algo3.modelo.IBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BotonGuardarEventHandler implements EventHandler<ActionEvent> {

    private final BotonAlgoritmoPersonalizado botonAlgoritmoGuardados;
    private final TableroAlgoritmo armadorAlgoritmo;
    private final Stage primaryStage;
    private String nombreAlgoritmo = "";

    public BotonGuardarEventHandler(Stage stage, TableroAlgoritmo armadorAlgoritmo, BotonAlgoritmoPersonalizado personalizados) {
        this.primaryStage = stage;
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.botonAlgoritmoGuardados = personalizados;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pedirNombre();
    }

    private void pedirNombre() {
        Stage dialogoStage = new Stage();
        dialogoStage.setHeight(150);
        dialogoStage.setWidth(450);
        dialogoStage.initModality(Modality.WINDOW_MODAL);
        dialogoStage.initOwner(primaryStage);
        dialogoStage.setTitle("Nombre del Algoritmo(Max: 20 Char.)");
        dialogoStage.initStyle(StageStyle.UTILITY);


        VBox contenedorNombre = new VBox();
        contenedorNombre.setSpacing(15);
        contenedorNombre.setPadding(new Insets(10));
        contenedorNombre.setAlignment(Pos.CENTER);
        contenedorNombre.setStyle("-fx-background-color: #4e2e78;");

        TextField nombreTextField = new TextField();
        nombreTextField.setStyle("-fx-background-color: #896bab;" +
                " -fx-border-color: white;" +
                " -fx-border-width: 2px;" +
                " -fx-border-radius: 80;" +
                " -fx-background-radius: 80;" +
                " -fx-text-fill: black;" +
                " -fx-font-weight: bold;");

        Button botonAceptar = new Button("ACEPTAR");
        botonAceptar.setStyle("-fx-background-color: #896bab;" +
                " -fx-border-color: white;" +
                " -fx-border-width: 2px;" +
                " -fx-border-radius: 80;" +
                " -fx-background-radius: 80;" +
                " -fx-text-fill: white;" +
                " -fx-font-weight: bold;");

        contenedorNombre.getChildren().addAll(nombreTextField,botonAceptar);
        dialogoStage.setScene(new Scene(contenedorNombre,100,450));
        botonAceptar.setOnAction(new BotonNombreAlgoritmoEventHandler(dialogoStage,nombreTextField,this));
        dialogoStage.show();
    }

    public void establecerNombreAlgoritmo(String nombre)
    {
        this.nombreAlgoritmo = nombre;
    }

    public void guardarAlgoritmo()
    {
        IBloque algoritmo= armadorAlgoritmo.guardarAlgoritmo();
        if(!this.nombreAlgoritmo.isBlank())
            botonAlgoritmoGuardados.guardarNuevoAlgoritmo(algoritmo, this.nombreAlgoritmo);
        this.nombreAlgoritmo = "";
    }
}
