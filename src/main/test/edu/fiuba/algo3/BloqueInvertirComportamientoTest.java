package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BloqueInvertirComportamientoTest {

    @Test
    public void invertirBloqueDerechaMueveALaIzquierdaEsCorrecto(){
        Personaje personaje = new Personaje();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        BloqueInvertir bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = new Posicion(-1,0);

        bloqueInvertir.agregarAccion(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueIzquierdaMueveALaDerechaEsCorrecto(){
        Personaje personaje = new Personaje();
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        BloqueInvertir bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = new Posicion(1,0);

        bloqueInvertir.agregarAccion(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueAbajoMueveArribaEsCorrecto(){
        Personaje personaje = new Personaje();
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueInvertir bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = new Posicion(0,1);

        bloqueInvertir.agregarAccion(bloqueAbajo);
        bloqueInvertir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

     @Test
    public void invertirBloqueArribaMueveAbajoEsCorrecto(){
        Personaje personaje = new Personaje();
        BloqueArriba bloqueArriba = new BloqueArriba();
        BloqueInvertir bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = new Posicion(0,-1);

        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueSubirLapizBajaElLapiz(){
        Personaje personaje = new Personaje();
        BloqueSubirLapiz bloqueSubirLapiz = new BloqueSubirLapiz();
        BloqueInvertir bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueSubirLapiz);
        bloqueInvertir.ejecutar(personaje);
        personaje.moverAbajo();

        assertTrue(personaje.obtenerPosicion().estaPintado());

    }

    @Test
    public void invertirBloqueBajarLapizConElLapizAbajoSubeElLapiz(){
        Personaje personaje = new Personaje();
        personaje.bajarLapiz();
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();
        BloqueInvertir bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueBajarLapiz);
        bloqueInvertir.ejecutar(personaje);
        personaje.moverAbajo();

        assertFalse(personaje.obtenerPosicion().estaPintado());

    }

    @Test
    public void InvertirComportamientoDeVariosBloquesALaVezEsCorrecto(){
        Personaje personaje = new Personaje();
        Posicion posicionFinal = new Posicion(1,-1);
        BloqueArriba bloqueArriba = new BloqueArriba();
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        BloqueInvertir bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.agregarAccion(bloqueAbajo);
        bloqueInvertir.agregarAccion(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);


        assertEquals(personaje.obtenerPosicion(),posicionFinal);
    }
}

