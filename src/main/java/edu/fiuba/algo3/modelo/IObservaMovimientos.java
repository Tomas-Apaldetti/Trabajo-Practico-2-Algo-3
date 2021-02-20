package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IObservaMovimientos {

    void avisarMovimiento(Posicion posicion1, Posicion posicion2);

    List<Posicion> obtenerMovimientos();
}
