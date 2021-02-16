package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class BloqueCompuesto implements IBloque{

    protected ArrayList<IBloque> acciones = new ArrayList<>();

    @Override
    public void agregarAccion(IBloque accion){
        acciones.add(accion);
    }

    @Override
    public void eliminarBloque(int posicionBloque) {
        if(posicionBloque <= 0)
            throw new BloqueFueraDeRangoExcepcion("No se aceptan indices menores a 1");
        if(posicionBloque > acciones.size())
            throw new BloqueFueraDeRangoExcepcion(String.format("Bloque %d no se encuentra en algoritmo tamanio: %d",
                    posicionBloque,
                    acciones.size()));
        acciones.subList(posicionBloque-1, acciones.size()).clear();
    }

    @Override
    public void eliminarBloque(IBloque bloque) {
        int index = acciones.indexOf(bloque);
        if(index == -1)
            throw new BloqueNoEncontradoExcepcion("El Bloque a eliminar no se encuentra en este nivel del algoritmo");
        this.eliminarBloque(index+1);
    }

    @Override
    public IBloque obtenerBloque(int posicionBloque) {
        try {
            return acciones.get(posicionBloque - 1);
        }
        catch (RuntimeException IndexOutOfBoundsException) {
            throw  new BloqueFueraDeRangoExcepcion(String.format("Bloque %d no se encuentra en algoritmo tamanio: %d",
                    posicionBloque,
                    acciones.size()));
        }
    }
}
