package edu.fiuba.algo3;

import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {

    @Test
    public void SeEjecutaUnAlgoritmoConUnBloqueCorrectamente(){
        Personaje personaje = new Personaje();
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque = new BloqueDerecha();
        Posicion posicionFinal = new Posicion(1,0);

        algoritmo.agregarAccion(bloque);
        algoritmo.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void SeEjecutaUnAlgoritmoConUnTresBloqueCorrectamente(){
        Personaje personaje = new Personaje();
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloqueDerecha = new BloqueDerecha();
        IAccion bloqueAbajo = new BloqueAbajo();
        IAccion bloqueBajarLapiz = new BloqueBajarLapiz();

        Posicion posicionEsperada = personaje.obtenerPosicion().posicionDerecha().posicionAbajo();

        algoritmo.agregarAccion(bloqueBajarLapiz);
        algoritmo.agregarAccion(bloqueDerecha);
        algoritmo.agregarAccion(bloqueAbajo);
        algoritmo.ejecutar(personaje);

        assertEquals(posicionEsperada, personaje.obtenerPosicion());
        assertTrue(personaje.obtenerPosicion().estaPintado());
    }
    @Test
    public void algoritmoConUnBloqueSeEjecutaInvertidoInvirtiendoElBloqueContenido()
    {
        Personaje personaje = new Personaje();
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque = new BloqueDerecha();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionIzquierda();

        algoritmo.agregarAccion(bloque);
        algoritmo.ejecutarInversa(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);
    }

    @Test
    public void algoritmoConTresBloquesSeEjecutaInvertidoInvirtiendoTodosLosBloques()
    {
        Personaje personaje = new Personaje();
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloqueDerecha = new BloqueDerecha();
        IAccion bloqueAbajo = new BloqueAbajo();
        IAccion bloqueBajarLapiz = new BloqueBajarLapiz();

        Posicion posicionEsperada = personaje.obtenerPosicion().posicionIzquierda().posicionArriba();

        algoritmo.agregarAccion(bloqueBajarLapiz);
        algoritmo.agregarAccion(bloqueDerecha);
        algoritmo.agregarAccion(bloqueAbajo);
        algoritmo.ejecutarInversa(personaje);

        assertEquals(posicionEsperada, personaje.obtenerPosicion());
        assertFalse(personaje.obtenerPosicion().estaPintado());
    }

}
