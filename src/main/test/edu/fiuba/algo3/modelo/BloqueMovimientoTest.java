package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueMovimientoTest {
    @Test
    public void BloqueMueveAPersonajeALaDerechaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = personaje.obtenerPosicion().posicionDerecha();
        IBloque bloque = new BloqueDerecha();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
     @Test
    public void BloqueMueveAPersonajeALaIzquierdaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = personaje.obtenerPosicion().posicionIzquierda();
         IBloque bloque = new BloqueIzquierda();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
     @Test
    public void BloqueMueveAPersonajeAbajoEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = personaje.obtenerPosicion().posicionAbajo();
         IBloque bloque = new BloqueAbajo();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());

    }
   @Test
    public void BloqueMueveAPersonajeArribaEsCorrecto(){

        Personaje personaje = new Personaje();
        Posicion posicionEsperada = personaje.obtenerPosicion().posicionArriba();
       IBloque bloque = new BloqueArriba();

        bloque.ejecutar(personaje);

        assertEquals(posicionEsperada,personaje.obtenerPosicion());


    }

    @Test
    public void BloqueBajarLapizYMuevePersonajePintaPosicionDondeEstaba(){

        Personaje personaje = new Personaje();
        Posicion posicionDondeEstaba = personaje.obtenerPosicion();
        IBloque bloque = new BloqueBajarLapiz();
        bloque.ejecutar(personaje);
        personaje.moverAbajo();
        assertTrue(posicionDondeEstaba.estaPintado());
    }

    @Test
    public void BloqueBajarLapizYSubirloNoPintaLaPosicionFinalAlMoverAlPersonaje(){
        Personaje personaje = new Personaje();
        IBloque bloqueSubir = new BloqueSubirLapiz();
        IBloque bloqueBajar = new BloqueBajarLapiz();

        bloqueBajar.ejecutar(personaje);
        bloqueSubir.ejecutar(personaje);

        personaje.moverAbajo();
        assertFalse(personaje.obtenerPosicion().estaPintado());
    }
}
