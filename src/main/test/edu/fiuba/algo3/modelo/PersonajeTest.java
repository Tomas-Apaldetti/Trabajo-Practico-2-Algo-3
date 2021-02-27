package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class PersonajeTest {

    @Test
    public void personajeBajaElLapizSinMoverseYNoPintaLaPosicionActual() {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();

        assertFalse(personaje.obtenerPosicion().estaPintado());
    }

    @Test
    public void personajeSeMueveHaciaAbajoSinEsCorrecto() {
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(0, -1);

        personaje.moverAbajo();

        assertEquals(personaje.obtenerPosicion(), posicionEsperada);
        assertFalse(posicionVieja.estaPintado());
    }

    @Test
    public void personajeSeMueveHaciaLaDerechaEsCorrecto() {
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(1, 0);

        personaje.moverDerecha();

        assertEquals(personaje.obtenerPosicion(), posicionEsperada);
    }

    @Test
    public void personajeSeMueveHaciaLaIzquierdaEsCorrecto() {
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(-1, 0);

        personaje.moverIzquierda();

        assertEquals(personaje.obtenerPosicion(), posicionEsperada);
    }

    @Test
    public void personajeComienzaConLapizLevantadoNoPintaLaPosicionAlMoverse(){
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        personaje.moverArriba();
        assertFalse(posicionVieja.estaPintado());
    }

    @Test
    public void personajeApoyaElLapizPintandoLaViejaPosicion(){
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        personaje.bajarLapiz();
        personaje.moverArriba();
        assertTrue(posicionVieja.estaPintado());
    }
    @Test
    public void personajeSeMueveDeUnaPosicionPintadaConLapizLevantadoLaNuevaPosicionNoSePinta()
    {
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        personaje.moverArriba();
        personaje.moverArriba();
        personaje.subirLapiz();
        personaje.moverDerecha();

        assertFalse(personaje.obtenerPosicion().estaPintado());
    }

    @Test
    public void personajeRealizaUnMovimientoAvisandoAUnObservador()
    {
        Personaje personaje = new Personaje();
        IObservador observador = Mockito.mock(IObservador.class);
        personaje.aniadirObservador(observador);
        personaje.moverArriba();
        verify(observador).actualizar();
    }

    @Test
    public void personajeRealiza3MovimientosConsecutivosAvisando3VecesAUnObservador()
    {
        Personaje personaje = new Personaje();
        IObservador observador = Mockito.mock(IObservador.class);
        personaje.aniadirObservador(observador);
        personaje.moverArriba();
        personaje.moverArriba();
        personaje.moverArriba();
        verify(observador, times(3)).actualizar();
    }

    @Test
    public void seQuitaObservadorDeUnPersonajeNoNotificaDeUnMovimiento()
    {
        Personaje personaje = new Personaje();
        IObservador observador = Mockito.mock(IObservador.class);
        personaje.aniadirObservador(observador);
        personaje.quitarObservador(observador);
        personaje.moverArriba();
        verify(observador, never()).actualizar();
    }

    @Test
    public void seQuitaObservadorDeUnPersonajeLuegoDe2MovimientosParaLuegoSeguirMoviendoseSoloNotifico2Veces()
    {
        Personaje personaje = new Personaje();
        IObservador observador = Mockito.mock(IObservador.class);
        personaje.aniadirObservador(observador);
        personaje.moverArriba();
        personaje.moverArriba();
        personaje.quitarObservador(observador);
        personaje.moverArriba();
        verify(observador, times(2)).actualizar();
    }

    @Test
    public void seReseteaPersonajeVuelveAlaPosicionInicial()
    {
        Personaje personaje = new Personaje();
        Posicion posicionInicial = personaje.obtenerPosicion();

        personaje.moverDerecha();
        personaje.moverDerecha();

        personaje.resetear();
        assertEquals(posicionInicial, personaje.obtenerPosicion());
    }
}
