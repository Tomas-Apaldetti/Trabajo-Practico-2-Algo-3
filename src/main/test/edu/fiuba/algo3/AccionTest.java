package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccionTest {
    @Test
    public void seMueveUnPersonajeHaciaLaPosicionArriba()
    {
        IAccion accion = new MoverArriba();
        Personaje personaje = new Personaje();
        IPosicion posicionAnterior = personaje.posicionActual();
        IPosicion posicionSiguienteTeorica = posicionAnterior.obtenerArriba();

        accion.ejecutar(personaje);
        assertTrue(posicionSiguienteTeorica.iguales(personaje.posicionActual()));
    }

    @Test
    public void seApoyaElLapizDibujandoCorrectamenteLasPosiciones()
    {
        IAccion accion = new ApoyarLapiz();
        Personaje personaje = new Personaje();
        IPosicion posicionAnterior = personaje.posicionActual();
        String colorSinPintar = posicionAnterior.color();
        IPosicion posicionSiguiente = posicionAnterior.obtenerArriba();

        accion.ejecutar(personaje);
        personaje.mover(posicionSiguiente);

        assertNotEquals(colorSinPintar, posicionAnterior.color());
    }

    @Test
    public void seLevantaElLapizNoSeDibujaLaPosicion()
    {
        IAccion accion = new LevantarLapiz();
        Personaje personaje = new Personaje();
        IPosicion posicionAnterior = personaje.posicionActual();
        String colorSinPintar = posicionAnterior.color();
        IPosicion posicionSiguiente = posicionAnterior.obtenerArriba();

        accion.ejecutar(personaje);
        personaje.mover(posicionSiguiente);

        assertEquals(colorSinPintar, posicionAnterior.color());
    }

    @Test
    public void seMuevePersonajeHaciaArribaConAccionInvertidaSeEncuetraEnLaPosicionCorrecta()
    {
        IAccion accion = new MoverAbajo();
        IAccion reversa = new AccionReversa(accion);
        Personaje personaje = new Personaje();
        IPosicion posicionAnterior = personaje.posicionActual();
        IPosicion posicionSiguienteTeorica = posicionAnterior.obtenerArriba();

        reversa.ejecutar(personaje);
        assertTrue(posicionSiguienteTeorica.iguales(personaje.posicionActual()));
    }

    @Test
    public void seMuevePersonajeHaciaAbajo3VecesConBloqueRepeticion()
    {
        IAccion accion = new MoverAbajo();
        IAccion repeticion = new AccionRepetida(accion, 3);
        Personaje personaje = new Personaje();
        IPosicion posicionAnterior = personaje.posicionActual();
        IPosicion posicionSiguienteTeorica = posicionAnterior.obtenerAbajo().obtenerAbajo().obtenerAbajo();

        repeticion.ejecutar(personaje);
        assertTrue(posicionSiguienteTeorica.iguales(personaje.posicionActual()));
    }
}
