package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Personaje implements IObservable {
    private ILapiz lapiz = new LapizLevantado();
    private Posicion posicion = new Posicion(0,0);
    private Collection<IObservador> observadores = new ArrayList<>();

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
        this.posicion = nuevaPosicion;
        notificar();
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
    public void aniadirObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificar() {
        for (IObservador observador : this.observadores)
            observador.actualizar();
    }

    @Override
    public void quitarObservador(IObservador observador) {
        this.observadores.remove(observador);
    }

    public void resetear() {
        this.posicion = new Posicion(0,0);
        this.subirLapiz();
    }
}
