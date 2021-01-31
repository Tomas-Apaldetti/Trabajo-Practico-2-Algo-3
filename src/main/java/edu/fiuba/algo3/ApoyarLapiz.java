package edu.fiuba.algo3;

public class ApoyarLapiz implements IAccion {
    @Override
    public void ejecutar(Personaje personaje) {
        personaje.apoyarLapiz();
    }

    @Override
    public void ejecutarReversa(Personaje personaje) {
        new LevantarLapiz().ejecutar(personaje);
    }
}
