package edu.fiuba.algo3;

public class BloqueSubirLapiz implements IBloque {
    @Override
    public void ejecutar(Personaje unPersonaje){
        unPersonaje.subirLapiz();
    }
}
