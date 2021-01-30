package edu.fiuba.algo3;

import edu.fiuba.algo3.IPosicion;
import edu.fiuba.algo3.Personaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {
    @Test
    public void personajeSeMueveALaDerechaLaPosicionEsLaCorrecta()
    {
        Personaje personaje = new Personaje();
        IPosicion posicionInicial = personaje.posicionActual();
        IPosicion posicionFinal = posicionInicial.obtenerDerecha();

        personaje.mover(posicionFinal);

        assertEquals(posicionFinal, personaje.posicionActual());
    }

    @Test
    public void personajeSeMueveConLapizLevantadoNoPintaLaPosicion()
    {
        Personaje personaje = new Personaje();
        IPosicion posicionAnterior = personaje.posicionActual();
        String colorSinPintar = posicionAnterior.color();

        personaje.mover(posicionAnterior.obtenerDerecha());

        assertEquals(colorSinPintar,posicionAnterior.color());
    }

    @Test
    public void personajeApoyaElLapizYSeMuevePintandoLaPosicionAnterior()
    {
        Personaje personaje = new Personaje();
        personaje.apoyarLapiz();
        IPosicion posicionAnterior = personaje.posicionActual();
        String colorSinPintar = posicionAnterior.color();

        personaje.mover(posicionAnterior.obtenerDerecha());

        assertNotEquals(colorSinPintar, posicionAnterior.color());
    }

    @Test
    public void personajeSeMueveConLapizApoyadoLaNuevaPosicionNoSePinta()
    {
        Personaje personaje = new Personaje();
        personaje.apoyarLapiz();
        IPosicion posicionAnterior = personaje.posicionActual();
        IPosicion posicionNueva = posicionAnterior.obtenerDerecha();
        String colorSinPintar = posicionNueva.color();
        personaje.mover(posicionNueva);

        assertEquals(colorSinPintar, posicionNueva.color());
    }
}
