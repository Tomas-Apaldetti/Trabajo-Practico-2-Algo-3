package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.draggable.DragDroppedEventHandler;
import edu.fiuba.algo3.Control.draggable.DragEnteredEventHandler;
import edu.fiuba.algo3.Control.draggable.DragExitedEventHandler;
import edu.fiuba.algo3.Control.draggable.DragOverEventHandler;
import edu.fiuba.algo3.modelo.IBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PanelArmado extends TabPane {

    private Label label = new Label("Al ejecutar ▶");
    private TableroAlgoritmo armadorAlgoritmo;
    private Tab tabPrincipal;
    private VBox panelActivo;
    private VBox panelAlgoritmoPrincipal;

    PanelArmado(TableroAlgoritmo armadorAlgoritmo){
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.setStyle("-fx-background-color: #ffff; -fx-border-color: black; -fx-border-width: 5px; -fx-border-radius:10; -fx-background-radius:20");
        this.setMinSize(225,382);
        this.setMaxSize(525, 2000);
        Tab tabPrincipal = new Tab("Algoritmo Principal");
        this.tabPrincipal = tabPrincipal;
        this.panelActivo = new VBox();
        this.panelAlgoritmoPrincipal = this.panelActivo;
        tabPrincipal.setContent(this.panelActivo);
        this.agregarLabel(panelActivo);
        this.getTabs().add(this.tabPrincipal);
        this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
    }

    private void estilizarLabel(Label label) {
        label.setStyle("-fx-background-color: #eea023; -fx-padding: 10px; -fx-border-color: #eea023; -fx-border-width: 3px; -fx-text-fill: white;");
        label.setFont(new Font("Arial", 20.0));
    }

    private void transformarEnObjetivo(Label label,TableroAlgoritmo armadorAlgoritmo) {
        label.setOnDragOver(new DragOverEventHandler());
        label.setOnDragEntered(new DragEnteredEventHandler(label));
        label.setOnDragExited(new DragExitedEventHandler(label));
        label.setOnDragDropped(new DragDroppedEventHandler(this, this.panelActivo ,armadorAlgoritmo));
    }

    public void agregarLabel(VBox panel){
        panel.getChildren().add(label);
        estilizarLabel(label);
        transformarEnObjetivo(label,this.armadorAlgoritmo);
    }

    public void limpiarTablero() {
        panelActivo.getChildren().clear();
        this.agregarLabel(this.panelActivo);
       // panelActivo.(this.panelActivo);
    }

    public void cambiarPanelActivo(VBox panelActivar)
    {
    }
}
