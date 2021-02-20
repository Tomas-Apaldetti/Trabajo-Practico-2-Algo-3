package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

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

    public ArrayList<Integer> obtenerCoordenadas(){
        ArrayList<Integer> coordenadas = new ArrayList<>();
        coordenadas.add(this.x);
        coordenadas.add(this.y);
        return coordenadas;
    }

    @Override
    public boolean equals(Object otraPosicion) {
        if (otraPosicion == this)
            return true;
        if (!(otraPosicion instanceof Posicion))
            return false;
        Posicion posicion2 = (Posicion) otraPosicion;
        return this.obtenerCoordenadas().equals(posicion2.obtenerCoordenadas());
    }

    public void colorear() {
        this.pintada = PINTADA;
    }
}

