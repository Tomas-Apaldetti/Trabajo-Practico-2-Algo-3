package edu.fiuba.algo3.modelo;

public class BloqueArriba extends BloqueSimple {
    
    @Override
    public void ejecutar(Personaje personaje){
        personaje.moverArriba();
    }


    @Override
    public void ejecutarInversa(Personaje personaje){
        new BloqueAbajo().ejecutar(personaje);
    }
}
