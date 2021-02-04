package edu.fiuba.algo3;

import java.util.ArrayList;
public class Posicion {
    private int x;
    private int y;


    Posicion(int coordenadaX, int coordenadaY) {
        this.x = coordenadaX;
        this.y = coordenadaY;
    }
// sacar numeros magicos
    public Posicion posicionDerecha() {
        return new Posicion(x + 1, y);
    }

    public Posicion posicionIzquierda() {
        return new Posicion(x - 1, y);
    }

    public Posicion posicionArriba() {
        return new Posicion(x , y + 1);
    }

    public Posicion posicionAbajo() {
        return new Posicion(x , y - 1);
    }

    public ArrayList obtenerCoordenadas(){
        ArrayList<Integer> coordenadas = new ArrayList<>();
        coordenadas.add(this.x);
        coordenadas.add(this.y);
        return coordenadas;
    }

    @Override
    public boolean equals(Object otraPosicion) {
        return this.obtenerCoordenadas().equals(((Posicion)otraPosicion).obtenerCoordenadas());
    }
}

