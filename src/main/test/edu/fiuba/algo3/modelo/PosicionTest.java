package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class PosicionTest {

    @Test
    public void obtenerLaPosicionSinMoverseObtieneLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        int yEsperado = 0;
        int xEsperado = 0;
        assertEquals(xEsperado, posicion.obtenerCoordenadaX());
        assertEquals(yEsperado, posicion.obtenerCoordenadaY());
    }

    @Test
    public void desplazandoLaPosicionHaciaArribaObtengoLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        posicion = posicion.posicionArriba();
        int yEsperado = 1;
        int xEsperado = 0;
        assertEquals(xEsperado, posicion.obtenerCoordenadaX());
        assertEquals(yEsperado, posicion.obtenerCoordenadaY());

    }

    @Test
    public void desplazandoLaPosicionHaciaLaDerechaObtengoLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        posicion = posicion.posicionDerecha();
        int yEsperado = 0;
        int xEsperado = 1;
        assertEquals(xEsperado, posicion.obtenerCoordenadaX());
        assertEquals(yEsperado, posicion.obtenerCoordenadaY());
    }

    @Test
    public void desplazandoLaPosicionHaciaLaIzquierdaObtengoLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        posicion = posicion.posicionIzquierda();
        int yEsperado = 0;
        int xEsperado = -1;
        assertEquals(xEsperado, posicion.obtenerCoordenadaX());
        assertEquals(yEsperado, posicion.obtenerCoordenadaY());
    }

    @Test
    public void desplazandoLaPosicionHaciaAbajoObtengoLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        posicion = posicion.posicionAbajo();
        int yEsperado = -1;
        int xEsperado = 0;
        assertEquals(xEsperado, posicion.obtenerCoordenadaX());
        assertEquals(yEsperado, posicion.obtenerCoordenadaY());
    }

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
