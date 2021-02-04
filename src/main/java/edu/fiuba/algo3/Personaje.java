package edu.fiuba.algo3;

public class Personaje {
    private Posicion posicion = new Posicion(0,0);


    public void moverDerecha() {
        this.posicion = this.posicion.posicionDerecha();
    }

    public void moverIzquierda() {
        this.posicion = this.posicion.posicionIzquierda();
    }

    public void moverAbajo() {
        this.posicion = this.posicion.posicionAbajo();
    }

    public void moverArriba() {
        this.posicion = this.posicion.posicionArriba();
    }

    public Posicion obtenerPosicion() {
        return this.posicion;
    }
}
