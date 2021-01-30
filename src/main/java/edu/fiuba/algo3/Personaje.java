package edu.fiuba.algo3;

import edu.fiuba.algo3.ILapiz;
import edu.fiuba.algo3.IPosicion;
import edu.fiuba.algo3.LapizLevantado;

public class Personaje {
    private IPosicion posicion = new Posicion(0,0);
    private ILapiz lapiz = new LapizLevantado();
    String color = "negro";

    public IPosicion posicionActual() {
        return this.posicion;
    }

    public void mover(IPosicion siguientePosicion) {
        lapiz.pintar(this.posicion);
        this.posicion = siguientePosicion;
    }

    public void apoyarLapiz() {
        this.lapiz = new LapizApoyado(this.color);
    }
}
