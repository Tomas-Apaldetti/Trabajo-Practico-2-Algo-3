package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.IBloque;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class PanelArmado extends TabPane {

    private IBloque algoritmoPrincipal;
    private TableroAlgoritmo armadorAlgoritmo;
    private ITabArmadoBloques tabPrincipal;
    private BotonEliminar botonEliminar;

    PanelArmado(TableroAlgoritmo armadorAlgoritmo){
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.algoritmoPrincipal = this.armadorAlgoritmo.obtenerAlgoritmo();
        this.estilizar();
        this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
    }

    private void inicializarTabPrincipal() {
        this.tabPrincipal = new TabBloquesComplejos("Algoritmo Principal", this, this.algoritmoPrincipal, armadorAlgoritmo, botonEliminar);
        this.agregarTabArmado(this.tabPrincipal);
        this.tabPrincipal.agregarLabel("Al ejecutar ▶");
    }

    public void agregarTabArmado(ITabArmadoBloques tab) {
        this.getTabs().add((Tab) tab);
    }

    public void eliminarTabArmado(TabBloquesComplejos tab) {
        this.getTabs().remove(tab);
    }

    public void limpiarTablero() {
        this.botonEliminar.deshabilitar();
        this.getTabs().clear();
        this.algoritmoPrincipal = this.armadorAlgoritmo.obtenerAlgoritmo();
        this.inicializarTabPrincipal();
    }

    public void asociarBotonEliminar(BotonEliminar botonEliminar) {
        this.botonEliminar = botonEliminar;
        this.inicializarTabPrincipal();
    }

    private void estilizar()
    {
        this.setStyle("-fx-border-color: #121212; -fx-border-width: 5");
        this.setMinSize(225,382);
        this.setPrefWidth(400);
        this.setMaxSize(Double.MAX_VALUE, 2000);
    }


}
