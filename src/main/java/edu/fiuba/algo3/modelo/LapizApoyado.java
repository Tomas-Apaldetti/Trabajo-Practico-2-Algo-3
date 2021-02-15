package edu.fiuba.algo3.modelo;

public class LapizApoyado implements ILapiz{

    @Override
    public void pintar(Posicion unaPosicion){
        unaPosicion.colorear();
    }
}
