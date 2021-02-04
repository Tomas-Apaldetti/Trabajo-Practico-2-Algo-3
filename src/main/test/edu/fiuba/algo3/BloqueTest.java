package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueTest {
    @Test
    public void BloqueMueveAPersonajeALaDerechaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = new Posicion(1,0);
        BloqueDerecha bloque = new BloqueDerecha();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
     @Test
    public void BloqueMueveAPersonajeALaIzquierdaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = new Posicion(-1,0);
        BloqueIzquierda bloque = new BloqueIzquierda();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
     @Test
    public void BloqueMueveAPersonajeAbajoEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = new Posicion(0,-1);
        BloqueAbajo bloque = new BloqueAbajo();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
   @Test
    public void BloqueMueveAPersonajeArribaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = new Posicion(0,1);
        BloqueArriba bloque = new BloqueArriba();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
}
