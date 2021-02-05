package edu.fiuba.algo3;

public class LapizApoyado implements ILapiz{

    @Override
    public void pintar(Posicion unaPosicion){
        unaPosicion.colorear();
    }
}
