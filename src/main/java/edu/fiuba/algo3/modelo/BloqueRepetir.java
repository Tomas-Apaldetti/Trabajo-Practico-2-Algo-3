package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class BloqueRepetir implements IAccionCompuesta{
    private ArrayList<IAccion> acciones = new ArrayList<>();
    private int iteraciones;


    public BloqueRepetir(int iteraciones){
        this.iteraciones = iteraciones;
    }
    @Override
    public void ejecutar(Personaje personaje) {
        for (int i = 0; i < iteraciones; i++) {
            for (IAccion accion : this.acciones){
                accion.ejecutar(personaje);
            }
        }
    }

    @Override
    public void ejecutarInversa(Personaje personaje){
        for (int i = 0; i < iteraciones; i++) {
            for (IAccion accion : this.acciones){
                accion.ejecutarInversa(personaje);
            }
        }
    }
    @Override
    public void agregarAccion(IAccion accion) {
        acciones.add(accion);
    }

    @Override
    public void eliminarBloque(int posicionBloque) {
        return;
    }

    @Override
    public void eliminarBloque(IAccion bloque) {
        return;
    }

    @Override
    public IAccion obtenerBloque(int posicionBloque) {
        return null;
    }
}