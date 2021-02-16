package edu.fiuba.algo3.modelo;

public abstract class BloqueSimple implements IBloque {

    @Override
    public void agregarAccion(IBloque accion) {
        throw new OperacionInvalidaBloqueSimpleExcepcion("No es posible agregar acciones a un bloque simple");
    }

    @Override
    public void eliminarBloque(int posicionBloque) {
        throw new OperacionInvalidaBloqueSimpleExcepcion("No es posible eliminar un bloque simple solitario, debe eliminarse desde un nivel superior");
    }

    @Override
    public void eliminarBloque(IBloque bloque) {
        throw new OperacionInvalidaBloqueSimpleExcepcion("No es posible eliminar un bloque simple solitario, debe eliminarse desde un nivel superior");
    }

    @Override
    public IBloque obtenerBloque(int posicionBloque) {
        if(posicionBloque == 1)
            return this;
        else
            throw new OperacionInvalidaBloqueSimpleExcepcion("Un bloque simple no contiene mas elementos");
    }
}
