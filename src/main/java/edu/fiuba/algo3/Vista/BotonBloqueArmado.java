package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Control.CambiarATabMouseEvent;
import edu.fiuba.algo3.Control.FocusBloqueArmadoMouseEvent;
import edu.fiuba.algo3.modelo.IBloque;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;

public class BotonBloqueArmado extends Button {

    private final IBloque bloquePadre;
    private final IBloque bloque;
    private final PanelArmado panelArmado;
    private final BotonEliminar botonEliminar;
    private final VBox contenedorPadre;
    private ITabArmadoBloques tabAsociada = new TabBloquesSimples();

    private final static String DESELECCIONADO = "-fx-background-color: #B4ADBF;" +
            " -fx-background-radius: 23;" +
            " -fx-border-color: #C5C5C5;" +
            " -fx-border-width: 3;" +
            " -fx-border-radius: 20;" +
            " -fx-border-insets: -1;" +
            " -fx-text-fill: #121212;";

    private final static String SELECCIONADO = "-fx-background-color: #B4ADBF;" +
            " -fx-background-radius: 23;" +
            " -fx-border-color:#262626;" +
            " -fx-border-width: 3;" +
            " -fx-border-radius: 20;" +
            " -fx-border-insets: -1;" +
            " -fx-text-fill: #121212;";

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
        this.setFont(Font.font("Roboto", FontWeight.EXTRA_BOLD,30));
        this.setStyle(BotonBloqueArmado.DESELECCIONADO);
    }

    private void habilitarFocus() {
        this.setOnMouseClicked(new FocusBloqueArmadoMouseEvent(this, this.botonEliminar));
    }

    public void tratarComoBloqueComplejo(ITabArmadoBloques tab) {
        this.tabAsociada = tab;
        this.panelArmado.agregarTabArmado(tab);
        this.dobleClickCambioEventHandler();
    }

    private void dobleClickCambioEventHandler() {
        this.setOnMouseClicked(new CambiarATabMouseEvent(this.panelArmado, this.tabAsociada, this.botonEliminar, this));
    }

    public void eliminarHijos() {
        this.tabAsociada.eliminarHijos();
    }

    public void desseleccionar() {
        this.setStyle(BotonBloqueArmado.DESELECCIONADO);
    }

    public void seleccionar() {
        this.setStyle(BotonBloqueArmado.SELECCIONADO);
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
            BotonBloqueArmado botonBloqueInferior = (BotonBloqueArmado) botonAbajo;
            botonBloqueInferior.eliminarHijos();
        }
        contenedor.remove(inicio,fin);
    }
}
