package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Algoritmo extends BloqueCompuesto {
    Algoritmo()
    {
        super();
    }
    @Override
    public void ejecutar(Personaje personaje) {
        for (IBloque accion :
                acciones) {
            accion.ejecutar(personaje);
        }
    }

    @Override
    public void ejecutarInversa(Personaje personaje) {
        for (IBloque accion : acciones) {
            accion.ejecutarInversa(personaje);
        }
    }

}
