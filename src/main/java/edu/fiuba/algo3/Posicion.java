package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

public class Posicion implements IPosicion {
    private int x;
    private int y;
    String color = "sin-pintar";

    Posicion(int coordenadaX, int coordenadaY){
        this.x = coordenadaX;
        this.y = coordenadaY;
    }

    @Override
    public IPosicion obtenerDerecha() {
        return new Posicion(this.x+1, this.y);
    }

    @Override
    public IPosicion obtenerIzquierda() {
        return new Posicion(this.x-1, this.y);
    }

    @Override
    public IPosicion obtenerArriba() {
        return new Posicion(this.x, this.y+1);
    }

    @Override
    public IPosicion obtenerAbajo() {
        return new Posicion(this.x, this.y-1);
    }

    @Override
    public String color() {
        return this.color;
    }

    @Override
    public void pintar(String color) {
        this.color = color;
    }

    @Override
    public ArrayList<Integer> obtenerCoordenadas() {
        ArrayList<Integer> coordenadas = new ArrayList<>();
        coordenadas.add(this.x);
        coordenadas.add(this.y);
        return coordenadas;
    }

    @Override
    public Boolean iguales(IPosicion otraPosicion) {
        return this.obtenerCoordenadas().equals(otraPosicion.obtenerCoordenadas());
    }
}
