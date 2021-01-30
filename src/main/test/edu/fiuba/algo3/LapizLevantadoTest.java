package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LapizLevantadoTest {
    @Test
    public void lapizLevantadoNoCambiaElColorDeUnaPosicion()
    {
        IPosicion posicion = new Posicion(0,0);
        ILapiz lapiz = new LapizLevantado();
        String colorAnterior = posicion.color();
        lapiz.pintar(posicion);
        String colorActual = posicion.color();
        assertEquals(colorAnterior, colorActual);
    }
}
