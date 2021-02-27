package edu.fiuba.algo3.modelo;

import static edu.fiuba.algo3.modelo.Pintado.PINTADA;
import static edu.fiuba.algo3.modelo.Pintado.SIN_PINTAR;

public class Posicion {

    final private int desplazamiento = 1;
    private int x;
    private int y;
    private Pintado pintada = SIN_PINTAR;


    Posicion(int coordenadaX, int coordenadaY) {
        this.x = coordenadaX;
        this.y = coordenadaY;
    }

    public boolean estaPintado(){
        return this.pintada == PINTADA;
    }

    public Posicion posicionDerecha() {
        return new Posicion(x + desplazamiento, y);
    }

    public Posicion posicionIzquierda() {
        return new Posicion(x - desplazamiento, y);
    }

    public Posicion posicionArriba() {
        return new Posicion(x , y + desplazamiento);
    }

    public Posicion posicionAbajo() {
        return new Posicion(x , y - desplazamiento);
    }


    public int obtenerCoordenadaX()
    {
        return this.x;
    }

    public int obtenerCoordenadaY()
    {
        return this.y;
    }

    @Override
    public boolean equals(Object otraPosicion) {
        if (otraPosicion == this)
            return true;
        if (!(otraPosicion instanceof Posicion))
            return false;
        Posicion posicion2 = (Posicion) otraPosicion;

        boolean xIguales = this.obtenerCoordenadaX() == posicion2.obtenerCoordenadaX();
        boolean yIguales = this.obtenerCoordenadaY() == posicion2.obtenerCoordenadaY();
        return xIguales && yIguales;
    }

    public void colorear() {
        this.pintada = PINTADA;
    }
}

