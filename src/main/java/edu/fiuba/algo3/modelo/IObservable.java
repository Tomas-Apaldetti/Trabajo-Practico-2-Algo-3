package edu.fiuba.algo3.modelo;

public interface IObservable {
     void aniadirObservador(IObservador observador);

     void notificar();

    void quitarObservador(IObservador observador);
}
