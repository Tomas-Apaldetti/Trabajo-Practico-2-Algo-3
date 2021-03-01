package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.BotonNombreAlgoritmoEventHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class IdentificarBloque {
    public IdentificarBloque(){

    }

    public IBloque devolverBloque(String string, TableroAlgoritmo tableroAlgoritmo){
        if (string.equals("✐") ){
            return new BloqueSubirLapiz();
        }
        if (string.equals("✎") ){
            return new BloqueBajarLapiz();
        }
        if (string.equals("↓" )){
            return new BloqueAbajo();
        }
        if (string.equals("←") ){
            return new BloqueIzquierda();
        }
        if (string.equals("↑")){
            return new BloqueArriba();
        }

        if (string.equals("→")){
            return new BloqueDerecha();
        }

        if (string.equals("⟳") ){
            int numeroRepeticiones = this.pedirNumeroRepeticiones();
            return new BloqueRepetir(numeroRepeticiones);
        }
        
        if (string.equals("⇄")){
            return new BloqueInvertir();
        }

        return tableroAlgoritmo.devolverAlgoritmoConNombre(string);
    }

    private int pedirNumeroRepeticiones() {
        Stage dialogoStage = new Stage();
        dialogoStage.setHeight(150);
        dialogoStage.setWidth(450);
        dialogoStage.initModality(Modality.APPLICATION_MODAL);
        dialogoStage.setTitle("Cantidad de Repeticiones(Default:2)");
        dialogoStage.initStyle(StageStyle.TRANSPARENT);

        VBox contenedorNombre = new VBox();
        contenedorNombre.setSpacing(15);
        contenedorNombre.setPadding(new Insets(10));
        contenedorNombre.setAlignment(Pos.CENTER);
        contenedorNombre.setStyle("-fx-background-color: #4e2e78;"+
                " -fx-border-color: black;" +
                " -fx-border-width: 2px;" +
                " -fx-border-radius: 80;" +
                " -fx-background-radius: 80;");

        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
        choiceBox.setStyle("-fx-background-color: #896bab;" +
                " -fx-border-color: white;" +
                " -fx-border-width: 2px;" +
                " -fx-border-radius: 80;" +
                " -fx-background-radius: 80;" +
                " -fx-text-fill: black;" +
                " -fx-font-weight: bold;");
        choiceBox.setValue(2);
        choiceBox.getItems().add(2);
        choiceBox.getItems().add(3);
        choiceBox.getItems().add(4);
        choiceBox.getItems().add(5);


        Button botonAceptar = new Button("ACEPTAR");
        botonAceptar.setStyle("-fx-background-color: #896bab;" +
                " -fx-border-color: white;" +
                " -fx-border-width: 2px;" +
                " -fx-border-radius: 80;" +
                " -fx-background-radius: 80;" +
                " -fx-text-fill: white;" +
                " -fx-font-weight: bold;");

        contenedorNombre.getChildren().addAll(choiceBox,botonAceptar);
        dialogoStage.setScene(new Scene(contenedorNombre,100,450));
        botonAceptar.setOnAction(e -> dialogoStage.close());
        dialogoStage.showAndWait();
        int seleccion = choiceBox.getSelectionModel().getSelectedItem();
        System.out.println(seleccion);
        return seleccion;
    }


}
