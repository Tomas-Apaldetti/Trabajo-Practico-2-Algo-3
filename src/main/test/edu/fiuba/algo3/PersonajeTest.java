package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
}
