package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.IBloque;
import javafx.scene.control.Button;

public class BotonEliminar extends Button {

    private BotonBloqueArmado botonBloqueABorrar;

    public BotonEliminar(String identificador)
    {
        super(identificador);
        this.deshabilitar();
    }

    public void deshabilitar() {
        this.botonBloqueABorrar = null;
        this.setVisible(false);
        this.setDisable(true);
    }

    public void setBloqueABorrar(BotonBloqueArmado botonAsociado) {
        if (botonBloqueABorrar != null)
            this.botonBloqueABorrar.desseleccionar();
        this.botonBloqueABorrar = botonAsociado;
        this.botonBloqueABorrar.seleccionar();
        this.habilitar();

    }

    private void habilitar() {
        this.setVisible(true);
        this.setDisable(false);
        this.darFuncionalidad();
    }

    private void darFuncionalidad() {
        this.setOnAction(e -> this.borrarBloqueSeleccionado());
    }

    private void borrarBloqueSeleccionado() {
        IBloque bloquePadre = this.botonBloqueABorrar.obtenerBloquePadre();
        IBloque bloqueABorrar = this.botonBloqueABorrar.obtenerBloque();
        bloquePadre.eliminarBloque(bloqueABorrar);
        this.botonBloqueABorrar.eliminarHijos();
        this.botonBloqueABorrar.eliminarSelf();
        this.deshabilitar();
    }


}
