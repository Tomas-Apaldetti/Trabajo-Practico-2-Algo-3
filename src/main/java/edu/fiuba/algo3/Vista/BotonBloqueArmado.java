package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.CambiarATabMouseEvent;
import edu.fiuba.algo3.Control.FocusBloqueArmadoMouseEvent;
import edu.fiuba.algo3.modelo.IBloque;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

public class BotonBloqueArmado extends Button {

    private final IBloque bloquePadre;
    private final IBloque bloque;
    private final PanelArmado panelArmado;
    private final BotonEliminar botonEliminar;
    private final VBox contenedorPadre;
    private ITabArmadoBloques tabAsociada = new TabBloquesSimples();

    public BotonBloqueArmado(String identificador, PanelArmado panelArmado, BotonEliminar botonEliminar, IBloque bloquePadre, IBloque bloque, VBox panelAsociado)
    {
        super(identificador);
        this.estilizar();
        this.panelArmado = panelArmado;
        this.botonEliminar = botonEliminar;
        this.bloquePadre = bloquePadre;
        this.bloque = bloque;
        this.contenedorPadre = panelAsociado;
        this.habilitarFocus();
    }

    private void estilizar() {
        this.setMinWidth(80);
        this.setMaxHeight(15);
        this.setFont(Font.font("Impact", 30));
        this.setStyle("-fx-background-color: #fa8072; -fx-border-color: white; -fx-border-width: 3px; -fx-text-fill: white;");
    }

    private void habilitarFocus() {
        this.setOnMouseClicked(new FocusBloqueArmadoMouseEvent(this, this.botonEliminar));
    }


    public void tratarComoBloqueComplejo(ITabArmadoBloques tab) {
        this.tabAsociada = tab;
        this.panelArmado.getTabs().add((Tab) this.tabAsociada);
        this.asociarTab();
    }

    private void asociarTab() {
        this.setOnMouseClicked(new CambiarATabMouseEvent(this.panelArmado, this.tabAsociada, this.botonEliminar, this));
    }

    public void eliminarHijos() {
        this.tabAsociada.eliminarHijos();
    }

    public void desseleccionar() {
        this.setStyle("-fx-background-color: #fa8072; -fx-border-color: white; -fx-border-width: 3px; -fx-text-fill: white;");
    }


    public void seleccionar() {
        this.setStyle("-fx-background-color: #fa8072; -fx-border-color: black; -fx-border-width: 3px; -fx-text-fill: white;");
    }


    public IBloque obtenerBloquePadre() {
        return this.bloquePadre;
    }

    public IBloque obtenerBloque() {
        return this.bloque;
    }


    public void eliminarSelf() {
        ObservableList<Node> contenedor = this.contenedorPadre.getChildren();
        int inicio = contenedor.indexOf(this);
        int fin = contenedor.size();
        List<Node> botonesAbajo = contenedor.subList(inicio,fin);
        for (Node botonAbajo : botonesAbajo)
        {
            BotonBloqueArmado botonBloqueAbajo = (BotonBloqueArmado) botonAbajo;
            botonBloqueAbajo.eliminarHijos();
        }
        contenedor.remove(inicio,fin);
    }
}
