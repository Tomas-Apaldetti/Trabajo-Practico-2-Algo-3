package edu.fiuba.algo3;

public interface IObservableMovimientos {
     void aniadirObservador(IObservaMovimientos observador);

     void notificarObservadores(Posicion posicionAnterior, Posicion posicionSiguiente);

    void quitarObservador(IObservaMovimientos observador);
}
