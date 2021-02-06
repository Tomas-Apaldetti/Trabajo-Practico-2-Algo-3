package edu.fiuba.algo3;

public class BloqueArriba implements IAccion {
    
    @Override
    public void ejecutar(Personaje personaje){
        personaje.moverArriba();
    }


    @Override
    public void ejecutarInversa(Personaje personaje){
        personaje.moverAbajo();
    }
}
