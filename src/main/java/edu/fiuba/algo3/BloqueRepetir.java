package edu.fiuba.algo3;

import java.util.ArrayList;

public class BloqueRepetir implements IAccion{
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

    public void agregarAccion(IAccion accion) {
        acciones.add(accion);
    }

}