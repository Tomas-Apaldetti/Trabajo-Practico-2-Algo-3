package edu.fiuba.algo3;

public class BloqueBajarLapiz implements IBloque{

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.bajarLapiz();
    }
}
