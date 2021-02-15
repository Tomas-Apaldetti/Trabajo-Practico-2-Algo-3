package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.IObservaMovimientos;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
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
    public void personajeSeMueveHaciaAbajoSinPintarYSeMueveHaciaAbajoPintando() {
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(0, -1);

        personaje.moverAbajo();

        assertEquals(personaje.obtenerPosicion(), posicionEsperada);
        assertFalse(personaje.obtenerPosicion().estaPintado() && posicionVieja.estaPintado());

        personaje.bajarLapiz();
        personaje.moverAbajo();

        assertTrue(personaje.obtenerPosicion().estaPintado());
    }

    @Test
    public void personajeSeMueveHaciaLaDerechaSinPintarYSeMueveHaciaLaDerechaPintando() {
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(1, 0);

        personaje.moverDerecha();

        assertEquals(personaje.obtenerPosicion(), posicionEsperada);
        assertFalse(personaje.obtenerPosicion().estaPintado() && posicionVieja.estaPintado());

        personaje.bajarLapiz();
        personaje.moverDerecha();

        assertTrue(personaje.obtenerPosicion().estaPintado());
    }

    @Test
    public void personajeSeMueveHaciaLaIzquierdaSinPintarYSeMueveHaciaLaIzquierdaPintando() {
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(-1, 0);

        personaje.moverIzquierda();

        assertEquals(personaje.obtenerPosicion(), posicionEsperada);
        assertFalse(personaje.obtenerPosicion().estaPintado() && posicionVieja.estaPintado());

        personaje.bajarLapiz();
        personaje.moverIzquierda();

        assertTrue(personaje.obtenerPosicion().estaPintado());
    }

    @Test
    public void personajeComienzaConLapizLevantadoNoPintaLaPosicionAlMoverse(){
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        personaje.moverArriba();
        assertFalse(posicionVieja.estaPintado());
    }

    @Test
    public void personajeApoyaElLapizPintandoViejaYNuevaPosicionAlMoverse(){
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        personaje.bajarLapiz();
        personaje.moverArriba();
        assertTrue(personaje.obtenerPosicion().estaPintado() && posicionVieja.estaPintado());
    }
    @Test
    public void personajeSeMueveDeUnaPosicionPintadaConLapizLevantadoLaNuevaPosicionNoSePinta()
    {
        Personaje personaje = new Personaje();
        personaje.bajarLapiz();
        personaje.moverArriba();
        Posicion posicionPintada = personaje.obtenerPosicion();
        personaje.subirLapiz();
        personaje.moverArriba();
        assertFalse(personaje.obtenerPosicion().estaPintado());
        assertTrue(posicionPintada.estaPintado());
    }

    @Test
    public void personajeRealizaUnMovimientoAvisandoAUnObservador()
    {
        Personaje personaje = new Personaje();
        IObservaMovimientos observador = Mockito.mock(IObservaMovimientos.class);
        personaje.aniadirObservador(observador);
        personaje.moverArriba();
        verify(observador).avisarMovimiento(any(), any());
    }

    @Test
    public void personajeRealizaUnMovimientoAvisandoAUnObservadorConLasPosicionesCorrespondientes()
    {
        Personaje personaje = new Personaje();
        IObservaMovimientos observador = Mockito.mock(IObservaMovimientos.class);
        personaje.aniadirObservador(observador);
        Posicion posicionAnterior = personaje.obtenerPosicion();
        personaje.moverArriba();
        Posicion posicionActual = personaje.obtenerPosicion();

        verify(observador).avisarMovimiento(posicionAnterior,posicionActual);
    }

    @Test
    public void personajeRealiza3MovimientosConsecutivosAvisando3VecesAUnObservador()
    {
        Personaje personaje = new Personaje();
        IObservaMovimientos observador = Mockito.mock(IObservaMovimientos.class);
        personaje.aniadirObservador(observador);
        personaje.moverArriba();
        personaje.moverArriba();
        personaje.moverArriba();
        verify(observador, times(3)).avisarMovimiento(any(), any());
    }

    @Test
    public void seQuitaObservadorDeUnPersonajeNoNotificaDeUnMovimiento()
    {
        Personaje personaje = new Personaje();
        IObservaMovimientos observador = Mockito.mock(IObservaMovimientos.class);
        personaje.aniadirObservador(observador);
        personaje.quitarObservador(observador);
        personaje.moverArriba();
        verify(observador, never()).avisarMovimiento(any(), any());
    }

    @Test
    public void seQuitaObservadorDeUnPersonajeLuegoDe2MovimientosParaLuegoSeguirMoviendoseSoloNotifico2Veces()
    {
        Personaje personaje = new Personaje();
        IObservaMovimientos observador = Mockito.mock(IObservaMovimientos.class);
        personaje.aniadirObservador(observador);
        personaje.moverArriba();
        personaje.moverArriba();
        personaje.quitarObservador(observador);
        personaje.moverArriba();
        verify(observador, times(2)).avisarMovimiento(any(), any());
    }
}
