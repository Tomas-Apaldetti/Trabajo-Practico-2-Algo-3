package edu.fiuba.algo3.modelo;

public class BloqueIzquierda extends BloqueSimple {
    @Override
    public void ejecutar(Personaje personaje){
        personaje.moverIzquierda();
    }

    @Override
    public void ejecutarInversa(Personaje personaje){
        new BloqueDerecha().ejecutar(personaje);
    }
}
