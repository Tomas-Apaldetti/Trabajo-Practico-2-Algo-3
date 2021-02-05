package edu.fiuba.algo3;

public class BloqueIzquierda implements IAccion {
    @Override
    public void ejecutar(Personaje personaje){
        personaje.moverIzquierda();
    }

}
