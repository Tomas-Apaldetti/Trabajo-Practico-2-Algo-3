package edu.fiuba.algo3;

import java.util.ArrayList;

public class Algoritmo implements IAccion {
    private ArrayList<IAccion> acciones = new ArrayList<>();

    @Override
    public void ejecutar(Personaje personaje) {
        for (IAccion accion : this.acciones) {
            accion.ejecutar(personaje);
        }
    }
        /*
    @Override
    public void ejecutarReversa(Personaje personaje) {
        for (IAccion accion : this.acciones) {
            accion.ejecutarReversa(personaje);
        }
    }
    */
    public void agregarAccion(IAccion accion) {
        acciones.add(accion);
    }
}