package edu.fiuba.algo3;

public class LevantarLapiz implements IAccion {
    @Override
    public void ejecutar(Personaje personaje) {
        personaje.levantarLapiz();
    }

    @Override
    public void ejecutarReversa(Personaje personaje) {
        new ApoyarLapiz().ejecutar(personaje);
    }
}
