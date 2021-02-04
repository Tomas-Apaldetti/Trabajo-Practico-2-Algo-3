package edu.fiuba.algo3;

public class BloqueDerecha implements IBloque {
    @Override
    public void ejecutar(Personaje personaje){
        personaje.moverDerecha();
    }

}
