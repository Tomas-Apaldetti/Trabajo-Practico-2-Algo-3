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
        ArrayList<Integer> coordenadasEsperadas = new ArrayList<>();
        coordenadasEsperadas.add(0);
        coordenadasEsperadas.add(0);

        assertEquals(posicion.obtenerCoordenadas(), coordenadasEsperadas);
    }

    @Test
    public void desplazandoLaPosicionHaciaArribaObtengoLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        ArrayList<Integer> coordenadasEsperadas = new ArrayList<>();
        coordenadasEsperadas.add(0);
        coordenadasEsperadas.add(1);

        Posicion posicionFinal = posicion.posicionArriba();

        assertEquals(posicionFinal.obtenerCoordenadas(), coordenadasEsperadas);
    }

    @Test
    public void desplazandoLaPosicionHaciaLaDerechaObtengoLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        ArrayList<Integer> coordenadasEsperadas = new ArrayList<>();
        coordenadasEsperadas.add(1);
        coordenadasEsperadas.add(0);

        Posicion posicionFinal = posicion.posicionDerecha();

        assertEquals(posicionFinal.obtenerCoordenadas(), coordenadasEsperadas);
    }

    @Test
    public void desplazandoLaPosicionHaciaLaIzquierdaObtengoLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        ArrayList<Integer> coordenadasEsperadas = new ArrayList<>();
        coordenadasEsperadas.add(-1);
        coordenadasEsperadas.add(0);

        Posicion posicionFinal = posicion.posicionIzquierda();

        assertEquals(posicionFinal.obtenerCoordenadas(), coordenadasEsperadas);
    }

    @Test
    public void desplazandoLaPosicionHaciaAbajoObtengoLasCoordenadasCorrectas() {
        Posicion posicion = new Posicion(0, 0);
        ArrayList<Integer> coordenadasEsperadas = new ArrayList<>();
        coordenadasEsperadas.add(0);
        coordenadasEsperadas.add(-1);

        Posicion posicionFinal = posicion.posicionAbajo();

        assertEquals(posicionFinal.obtenerCoordenadas(), coordenadasEsperadas);
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
