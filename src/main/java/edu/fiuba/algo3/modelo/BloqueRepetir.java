package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class BloqueRepetir extends BloqueCompuesto{
    private int iteraciones;


    public BloqueRepetir(int iteraciones){
        this.iteraciones = iteraciones;
    }
    @Override
    public void ejecutar(Personaje personaje) {
        for (int i = 0; i < iteraciones; i++) {
            for (IBloque accion : acciones){
                accion.ejecutar(personaje);
            }
        }
    }

    @Override
    public void ejecutarInversa(Personaje personaje){
        for (int i = 0; i < iteraciones; i++) {
            for (IBloque accion : acciones){
                accion.ejecutarInversa(personaje);
            }
        }
    }

}