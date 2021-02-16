package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BloqueInvertirComportamientoTest {

    @Test
    public void invertirBloqueDerechaMueveALaIzquierdaEsCorrecto(){
        Personaje personaje = new Personaje();
        IBloque bloqueDerecha = new BloqueDerecha();
        IBloque bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionIzquierda();

        bloqueInvertir.agregarAccion(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje);

        Assertions.assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueIzquierdaMueveALaDerechaEsCorrecto(){
        Personaje personaje = new Personaje();
        IBloque bloqueIzquierda = new BloqueIzquierda();
        IBloque bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionDerecha();

        bloqueInvertir.agregarAccion(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);

        Assertions.assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueAbajoMueveArribaEsCorrecto(){
        Personaje personaje = new Personaje();
        IBloque bloqueAbajo = new BloqueAbajo();
        IBloque bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionArriba();

        bloqueInvertir.agregarAccion(bloqueAbajo);
        bloqueInvertir.ejecutar(personaje);

        Assertions.assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

     @Test
    public void invertirBloqueArribaMueveAbajoEsCorrecto(){
        Personaje personaje = new Personaje();
         IBloque bloqueArriba = new BloqueArriba();
         IBloque bloqueInvertir = new BloqueInvertir();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionAbajo();

        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.ejecutar(personaje);

        Assertions.assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void invertirBloqueSubirLapizBajaElLapiz(){
        Personaje personaje = new Personaje();
        IBloque bloqueSubirLapiz = new BloqueSubirLapiz();
        IBloque bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueSubirLapiz);
        bloqueInvertir.ejecutar(personaje);
        personaje.moverAbajo();

        Assertions.assertTrue(personaje.obtenerPosicion().estaPintado());

    }

    @Test
    public void invertirBloqueBajarLapizConElLapizAbajoSubeElLapiz(){
        Personaje personaje = new Personaje();
        personaje.bajarLapiz();
        IBloque bloqueBajarLapiz = new BloqueBajarLapiz();
        IBloque bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueBajarLapiz);
        bloqueInvertir.ejecutar(personaje);
        personaje.moverAbajo();

        Assertions.assertFalse(personaje.obtenerPosicion().estaPintado());

    }

    @Test
    public void InvertirComportamientoDeVariosBloquesALaVezEsCorrecto(){
        Personaje personaje = new Personaje();
        Posicion posicionFinal = new Posicion(1,-1);
        IBloque bloqueArriba = new BloqueArriba();
        IBloque bloqueAbajo = new BloqueAbajo();
        IBloque bloqueIzquierda = new BloqueIzquierda();
        IBloque bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.agregarAccion(bloqueAbajo);
        bloqueInvertir.agregarAccion(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);


        Assertions.assertEquals(personaje.obtenerPosicion(),posicionFinal);
    }

    @Test
    public void invertirComportamientoDosNivelesRealizaLaAccionNormal()
    {
        Personaje personaje = new Personaje();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionAbajo();
        IBloque bloqueAbajo = new BloqueAbajo();
        IBloque invertirNivel1 = new BloqueInvertir();
        IBloque invertirNivel2 = new BloqueInvertir();

        invertirNivel1.agregarAccion(bloqueAbajo);
        invertirNivel2.agregarAccion(invertirNivel1);

        invertirNivel2.ejecutar(personaje);

        Assertions.assertEquals(posicionFinal, personaje.obtenerPosicion());
    }

    @Test
    public void invertirComportamientosTresNivelesRealizaLaAccionInvertida()
    {
        Personaje personaje = new Personaje();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionArriba();
        IBloque bloqueAbajo = new BloqueAbajo();
        IBloque invertirNivel1 = new BloqueInvertir();
        IBloque invertirNivel2 = new BloqueInvertir();
        IBloque invertirNivel3 = new BloqueInvertir();

        invertirNivel1.agregarAccion(bloqueAbajo);
        invertirNivel2.agregarAccion(invertirNivel1);
        invertirNivel3.agregarAccion(invertirNivel2);
        invertirNivel3.ejecutar(personaje);

        Assertions.assertEquals(posicionFinal, personaje.obtenerPosicion());
    }
}

