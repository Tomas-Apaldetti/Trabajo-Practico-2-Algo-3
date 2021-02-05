package edu.fiuba.algo3;

public class BloqueBajarLapiz implements IAccion {

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.bajarLapiz();
    }
}
