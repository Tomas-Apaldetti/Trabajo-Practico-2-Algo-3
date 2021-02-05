package edu.fiuba.algo3;

public class BloqueSubirLapiz implements IAccion {
    @Override
    public void ejecutar(Personaje unPersonaje){
        unPersonaje.subirLapiz();
    }
}
