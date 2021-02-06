package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BloqueInvertirComportamientoTest {

    @Test
    public void invertirBloqueDerechaMueveALaIzquierdaEsCorrecto(){
        Personaje personaje = new Personaje();
        IAccion bloqueDerecha = new BloqueDerecha();
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionIzquierda();

        bloqueInvertir.agregarAccion(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueIzquierdaMueveALaDerechaEsCorrecto(){
        Personaje personaje = new Personaje();
        IAccion bloqueIzquierda = new BloqueIzquierda();
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionDerecha();

        bloqueInvertir.agregarAccion(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueAbajoMueveArribaEsCorrecto(){
        Personaje personaje = new Personaje();
        IAccion bloqueAbajo = new BloqueAbajo();
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionArriba();

        bloqueInvertir.agregarAccion(bloqueAbajo);
        bloqueInvertir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

     @Test
    public void invertirBloqueArribaMueveAbajoEsCorrecto(){
        Personaje personaje = new Personaje();
        IAccion bloqueArriba = new BloqueArriba();
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionAbajo();

        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueSubirLapizBajaElLapiz(){
        Personaje personaje = new Personaje();
        IAccion bloqueSubirLapiz = new BloqueSubirLapiz();
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueSubirLapiz);
        bloqueInvertir.ejecutar(personaje);
        personaje.moverAbajo();

        assertTrue(personaje.obtenerPosicion().estaPintado());

    }

    @Test
    public void invertirBloqueBajarLapizConElLapizAbajoSubeElLapiz(){
        Personaje personaje = new Personaje();
        personaje.bajarLapiz();
        IAccion bloqueBajarLapiz = new BloqueBajarLapiz();
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueBajarLapiz);
        bloqueInvertir.ejecutar(personaje);
        personaje.moverAbajo();

        assertFalse(personaje.obtenerPosicion().estaPintado());

    }

    @Test
    public void InvertirComportamientoDeVariosBloquesALaVezEsCorrecto(){
        Personaje personaje = new Personaje();
        Posicion posicionFinal = new Posicion(1,-1);
        IAccion bloqueArriba = new BloqueArriba();
        IAccion bloqueAbajo = new BloqueAbajo();
        IAccion bloqueIzquierda = new BloqueIzquierda();
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.agregarAccion(bloqueAbajo);
        bloqueInvertir.agregarAccion(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);


        assertEquals(personaje.obtenerPosicion(),posicionFinal);
    }

    @Test
    public void invertirComportamientoDosNivelesRealizaLaAccionNormal()
    {
        Personaje personaje = new Personaje();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionAbajo();
        IAccion bloqueAbajo = new BloqueAbajo();
        IAccionCompuesta invertirNivel1 = new BloqueInvertir();
        IAccionCompuesta invertirNivel2 = new BloqueInvertir();

        invertirNivel1.agregarAccion(bloqueAbajo);
        invertirNivel2.agregarAccion(invertirNivel1);

        invertirNivel2.ejecutar(personaje);

        assertEquals(posicionFinal, personaje.obtenerPosicion());
    }

    @Test
    public void invertirComportamientosTresNivelesRealizaLaAccionInvertida()
    {
        Personaje personaje = new Personaje();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionArriba();
        IAccion bloqueAbajo = new BloqueAbajo();
        IAccionCompuesta invertirNivel1 = new BloqueInvertir();
        IAccionCompuesta invertirNivel2 = new BloqueInvertir();
        IAccionCompuesta invertirNivel3 = new BloqueInvertir();

        invertirNivel1.agregarAccion(bloqueAbajo);
        invertirNivel2.agregarAccion(invertirNivel1);
        invertirNivel3.agregarAccion(invertirNivel2);
        invertirNivel3.ejecutar(personaje);

        assertEquals(posicionFinal, personaje.obtenerPosicion());
    }
}

