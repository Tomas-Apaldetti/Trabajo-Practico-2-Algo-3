package edu.fiuba.algo3.modelo;

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

    @Override
    public void eliminarBloque(int posicionBloque) {
        if(posicionBloque <= 0)
            throw new BloqueFueraDeRangoExcepcion("No se aceptan indices menores a 1");
        if(posicionBloque > this.acciones.size())
            throw new BloqueFueraDeRangoExcepcion(String.format("Bloque %d no se encuentra en algoritmo tamanio: %d",
                                                    posicionBloque,
                                                    this.acciones.size()));
        this.acciones.subList(posicionBloque-1, this.acciones.size()).clear();
    }

    @Override
    public void eliminarBloque(IAccion bloque) {
        int index = this.acciones.indexOf(bloque);
        if(index == -1)
            throw new BloqueNoEncontradoExcepcion("El Bloque a eliminar no se encuentra en este nivel del algoritmo");
        this.eliminarBloque(index+1);
    }

    @Override
    public IAccion obtenerBloque(int posicionBloque) {
        try {
             return this.acciones.get(posicionBloque - 1);
        }
        catch (RuntimeException IndexOutOfBoundsException) {
            throw  new BloqueFueraDeRangoExcepcion(String.format("Bloque %d no se encuentra en algoritmo tamanio: %d",
                    posicionBloque,
                    this.acciones.size()));
        }
    }
}
