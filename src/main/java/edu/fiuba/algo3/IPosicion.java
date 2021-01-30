package edu.fiuba.algo3;

public interface IPosicion {
    IPosicion obtenerDerecha();

    IPosicion obtenerIzquierda();

    IPosicion obtenerArriba();

    IPosicion obtenerAbajo();

    String color();

    void pintar(String color);
}
