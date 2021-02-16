package edu.fiuba.algo3.modelo;

public interface IAccionCompuesta extends IAccion{
    void agregarAccion(IAccion accion);

    void eliminarBloque(int posicionBloque);

    void eliminarBloque(IAccion bloque);

    IAccion obtenerBloque(int posicionBloque);
}
