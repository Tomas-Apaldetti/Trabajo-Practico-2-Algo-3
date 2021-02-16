package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class BloqueInvertir extends BloqueCompuesto{

    @Override
    public void ejecutar(Personaje personaje){
        for (IBloque accion : acciones) {
            accion.ejecutarInversa(personaje);
        }
    }

    @Override
    public void ejecutarInversa(Personaje personaje) {
        for (IBloque accion : acciones) {
            accion.ejecutar(personaje);
        }
    }
}
