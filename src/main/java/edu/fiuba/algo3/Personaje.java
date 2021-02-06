package edu.fiuba.algo3;

public class Personaje {
    private ILapiz lapiz = new LapizLevantado();
    private Posicion posicion = new Posicion(0,0);


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
        lapiz.pintar(this.posicion);
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
}
