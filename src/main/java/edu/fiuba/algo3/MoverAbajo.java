package edu.fiuba.algo3;

public class MoverAbajo implements IAccion {
    @Override
    public void ejecutar(Personaje personaje) {
        personaje.mover(personaje.posicionActual().obtenerAbajo());
    }

    @Override
    public void ejecutarReversa(Personaje personaje) {
        new MoverArriba().ejecutar(personaje);
    }
}
