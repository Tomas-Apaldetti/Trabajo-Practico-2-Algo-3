package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {

    @Test
    public void seColoreaUnaPosicionEstaSeEncuentraPintada(){
        Posicion posicion = new Posicion(0,0);
        posicion.colorear();
        assertTrue(posicion.estaPintado());
    }
    @Test
    public void unaPosicionNuevaNoEstaPintada(){
        Posicion posicion = new Posicion(0,0);
        assertFalse(posicion.estaPintado());
    }
}
