package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PersonajeTest {

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
