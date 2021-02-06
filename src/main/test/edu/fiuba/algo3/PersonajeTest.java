package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PersonajeTest {

    @Test
    public void PersonajeComienzaConElLapizLevantadoNoPintaPosicionActual(){
        Personaje personaje = new Personaje();
        assertFalse(personaje.obtenerPosicion().estaPintado());
    }

    @Test
    public void PersonajeSeMueveConLapizLevantadoNoPintaNuevaPosicion(){
        Personaje personaje = new Personaje();
        personaje.moverArriba();
        assertFalse(personaje.obtenerPosicion().estaPintado());
    }

    /* @Test
    public void personajeSeMueveConLapizApoyadoPintaLaPosicionVieja()
    {
        Personaje personaje = new Personaje();
        Posicion posicionVieja = personaje.obtenerPosicion();
        personaje.bajarLapiz();
        personaje.moverArriba();

        assertEquals(posicionVieja.estaPintado(), true);
    }*/


}
