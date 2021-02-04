package edu.fiuba.algo3;

public class BloqueIzquierda implements IBloque {
    @Override
    public void ejecutar(Personaje personaje){
        personaje.moverIzquierda();
    }

}
