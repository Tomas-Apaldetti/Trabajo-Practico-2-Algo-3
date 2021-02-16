package edu.fiuba.algo3.modelo;

public class BloqueAbajo extends BloqueSimple {

    @Override
    public void ejecutar(Personaje personaje){
        personaje.moverAbajo();
    }

    @Override
    public void ejecutarInversa(Personaje personaje){
        new BloqueArriba().ejecutar(personaje);
    }
}
