package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Personaje implements IObservableMovimientos {
    private ILapiz lapiz = new LapizLevantado();
    private Posicion posicion = new Posicion(0,0);
    private ArrayList<IObservaMovimientos> observadores = new ArrayList<>();

    public void moverDerecha() {
        mover(this.posicion.posicionDerecha());
    }

    public void moverIzquierda() {
        mover(this.posicion.posicionIzquierda());
    }

    public void moverAbajo() {
        mover(this.posicion.posicionAbajo());
    }

    public void moverArriba() {
        mover(this.posicion.posicionArriba());
    }

    private void mover(Posicion nuevaPosicion)
    {
        lapiz.pintar(this.posicion);
        lapiz.pintar(nuevaPosicion);
        notificarObservadores(this.posicion, nuevaPosicion);
        this.posicion = nuevaPosicion;
    }

    public Posicion obtenerPosicion() {
        return this.posicion;
    }

    public void bajarLapiz() {
        this.lapiz = new LapizApoyado();
    }

    public void subirLapiz() {
        this.lapiz = new LapizLevantado();
    }

    @Override
    public void aniadirObservador(IObservaMovimientos observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservadores(Posicion posicionAnterior, Posicion posicionSiguiente) {
        for (IObservaMovimientos observador : this.observadores)
            observador.avisarMovimiento(posicionAnterior, posicionSiguiente);
    }

    @Override
    public void quitarObservador(IObservaMovimientos observador) {
        this.observadores.remove(observador);
    }
}
