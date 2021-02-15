package edu.fiuba.algo3.modelo;

public class BloqueSubirLapiz implements IAccion {
    @Override
    public void ejecutar(Personaje unPersonaje){
        unPersonaje.subirLapiz();
    }

    @Override
    public void ejecutarInversa(Personaje personaje){
        new BloqueBajarLapiz().ejecutar(personaje);
    }
}

