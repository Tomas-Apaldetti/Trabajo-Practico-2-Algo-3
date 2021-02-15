package edu.fiuba.algo3.modelo;

public class BloqueBajarLapiz implements IAccion {

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.bajarLapiz();
    }

    @Override
    public void ejecutarInversa(Personaje personaje){
        new BloqueSubirLapiz().ejecutar(personaje);
    }
}
