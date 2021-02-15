package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueMovimientoTest {
    @Test
    public void BloqueMueveAPersonajeALaDerechaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = personaje.obtenerPosicion().posicionDerecha();
        IAccion bloque = new BloqueDerecha();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
     @Test
    public void BloqueMueveAPersonajeALaIzquierdaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = personaje.obtenerPosicion().posicionIzquierda();
        IAccion bloque = new BloqueIzquierda();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
     @Test
    public void BloqueMueveAPersonajeAbajoEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = personaje.obtenerPosicion().posicionAbajo();
        IAccion bloque = new BloqueAbajo();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
   @Test
    public void BloqueMueveAPersonajeArribaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = personaje.obtenerPosicion().posicionArriba();
        IAccion bloque = new BloqueArriba();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());


    }

    @Test
    public void BloqueBajarLapizYMuevePersonajePintaPosicionFinal(){

        Personaje personaje = new Personaje();
        IAccion bloque = new BloqueBajarLapiz();
        bloque.ejecutar(personaje);
        personaje.moverAbajo();
        assertTrue(personaje.obtenerPosicion().estaPintado());
    }

    @Test
    public void BloqueBajarLapizYSubirloNoPintaLaPosicionFinalAlMoverAlPersonaje(){
        Personaje personaje = new Personaje();
        IAccion bloqueSubir = new BloqueSubirLapiz();
        IAccion bloqueBajar = new BloqueBajarLapiz();

        bloqueBajar.ejecutar(personaje);
        bloqueSubir.ejecutar(personaje);

        personaje.moverAbajo();
        assertFalse(personaje.obtenerPosicion().estaPintado());
    }
}
