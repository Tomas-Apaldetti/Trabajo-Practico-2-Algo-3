package edu.fiuba.algo3;

import java.util.ArrayList;

public class Algoritmo implements IAccionCompuesta {
    private ArrayList<IAccion> acciones = new ArrayList<>();

    @Override
    public void ejecutar(Personaje personaje) {
        for (IAccion accion : this.acciones) {
            accion.ejecutar(personaje);
        }
    }

    @Override
    public void ejecutarInversa(Personaje personaje) {
        for (IAccion accion : this.acciones) {
            accion.ejecutarInversa(personaje);
        }
    }
    @Override
    public void agregarAccion(IAccion accion){
        acciones.add(accion);
    }

}
