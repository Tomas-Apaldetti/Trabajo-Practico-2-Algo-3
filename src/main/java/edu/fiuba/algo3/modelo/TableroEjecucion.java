package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class TableroEjecucion implements IObservaMovimientos {
    private List<Posicion> movimientos = new ArrayList<>();
    @Override
    public void avisarMovimiento(Posicion posicion1, Posicion posicion2) {
        if(!(movimientos.isEmpty()))
        {
            Posicion ultimaPosicion = movimientos.get(movimientos.size()-1);
            if(ultimaPosicion.equals(posicion1))
                movimientos.remove(movimientos.size()-1);
        }
        movimientos.add(posicion1);
        movimientos.add(posicion2);
    }

    @Override
    public List<Posicion> obtenerMovimientos() {
        return movimientos;
    }
}
