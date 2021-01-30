package edu.fiuba.algo3;

import edu.fiuba.algo3.ILapiz;
import edu.fiuba.algo3.IPosicion;
import edu.fiuba.algo3.LapizApoyado;
import edu.fiuba.algo3.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LapizApoyadoTest {
    @Test
    public void lapizApoyadoPintaUnaPosicionConElColorCorrespondiente()
    {
        String color = "negro";
        ILapiz lapiz = new LapizApoyado(color);
        IPosicion posicion = new Posicion(0,0);
        lapiz.pintar(posicion);
        assertEquals(color, posicion.color());
    }
}
