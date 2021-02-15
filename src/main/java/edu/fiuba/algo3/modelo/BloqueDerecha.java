package edu.fiuba.algo3.modelo;

public class BloqueDerecha implements IAccion {
    @Override
    public void ejecutar(Personaje personaje){
        personaje.moverDerecha();
    }
    @Override
    public void ejecutarInversa(Personaje personaje){
        new BloqueIzquierda().ejecutar(personaje);
    }
}
