package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

public interface IPosicion {
    IPosicion obtenerDerecha();

    IPosicion obtenerIzquierda();

    IPosicion obtenerArriba();

    IPosicion obtenerAbajo();

    String color();

    void pintar(String color);

    ArrayList<Integer> obtenerCoordenadas();

    Boolean iguales(IPosicion otraPosicion);
}
