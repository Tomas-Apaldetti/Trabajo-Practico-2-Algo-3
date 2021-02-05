package edu.fiuba.algo3;

public class Personaje {
    private LapizApoyado lapizApoyado = new LapizApoyado();
    private LapizLevantado lapizLevantado = new LapizLevantado();
    private ILapiz lapiz = lapizLevantado;
    private Posicion posicion = new Posicion(0,0);


    public void moverDerecha() {
        this.posicion = this.posicion.posicionDerecha();
        lapiz.pintar(this.posicion);
    }

    public void moverIzquierda() {
        this.posicion = this.posicion.posicionIzquierda();
        lapiz.pintar(this.posicion);
    }

    public void moverAbajo() {
        this.posicion = this.posicion.posicionAbajo();
        lapiz.pintar(this.posicion);
    }

    public void moverArriba() {
        this.posicion = this.posicion.posicionArriba();
        lapiz.pintar(this.posicion);
    }


    public Posicion obtenerPosicion() {
        return this.posicion;
    }

    public void bajarLapiz() {
        this.lapiz = lapizApoyado;
    }

    public void subirLapiz() {
        this.lapiz = lapizLevantado;
    }
}
