package edu.fiuba.algo3.modelo;

public interface IBloque {

    void ejecutar(Personaje personaje);

    void ejecutarInversa(Personaje personaje);

    void agregarAccion(IBloque accion);

    void eliminarBloque(int posicionBloque);

    void eliminarBloque(IBloque bloque);

    IBloque obtenerBloque(int posicionBloque);
}
