package edu.fiuba.algo3.Vista;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuAlgoritmoPersonalizados extends VBox {

    private Label encabezado = new Label("Algoritmos\nGuardados");

    public MenuAlgoritmoPersonalizados(){
        this.setMinSize(120,250);
        this.setPrefWidth(200);
        this.agregarEncabezado();
    }

    private void estilizarEncabezado() {
        this.encabezado.wrapTextProperty().setValue(true);
        this.encabezado.setStyle("-fx-background-color:#262626;" +
                " -fx-padding: 10px;" +
                " -fx-border-color: #121212;" +
                " -fx-border-radius: 27;" +
                " -fx-border-width: 3;" +
                " -fx-text-fill: #C5C5C5;" +
                " -fx-background-radius: 30");
        this.encabezado.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD, 25));
    }

    public void agregarBotonAlgoritmoPersonalizado (String nombreAlgoritmo){
        BotonAgregarBloqueArmado botonNuevoAlgoritmo = new BotonAgregarBloqueArmado(nombreAlgoritmo);
        this.getChildren().add(botonNuevoAlgoritmo);
    }

    public void agregarEncabezado() {
        this.estilizarEncabezado();
        this.getChildren().add(encabezado);
    }

    public void limpiarMenu() {
        this.getChildren().clear();
        this.agregarEncabezado();
    }
}
