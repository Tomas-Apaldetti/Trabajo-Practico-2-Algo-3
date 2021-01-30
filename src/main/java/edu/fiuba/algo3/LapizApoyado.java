package edu.fiuba.algo3;

public class LapizApoyado implements ILapiz {
    String color;
    public LapizApoyado(String color) {
        this.color = color;
    }

    @Override
    public void pintar(IPosicion posicion) {
        posicion.pintar(this.color);
    }
}
