package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PersonajeTest {

    @Test
    public void PersonajeComienzaConElLapizLevantadoNoPintaPosicionActual(){
        Personaje personaje = new Personaje();
        assertEquals(personaje.obtenerPosicion().estaPintado(), false);
    }

    @Test
    public void PersonajeSeMueveConLapizLevantadoNoPintaNuevaPosicion(){
        Personaje personaje = new Personaje();
        personaje.moverArriba();
        assertEquals(personaje.obtenerPosicion().estaPintado(), false);
    }


}
