package edu.fiuba.algo3;

public class MoverArriba implements IAccion {

    @Override
    public void ejecutar(Personaje personaje) {
        IPosicion posicionSiguiente = personaje.posicionActual().obtenerArriba();
        personaje.mover(posicionSiguiente);
    }

    @Override
    public void ejecutarReversa(Personaje personaje) {
        new MoverAbajo().ejecutar(personaje);
    }
}
