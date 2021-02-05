package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {

    @Test
    public void seEjecutaUnAlgoritmoConUnBloqueCorrectamente(){
        Personaje personaje = new Personaje();
        Algoritmo algoritmo = new Algoritmo();
        BloqueDerecha bloque = new BloqueDerecha();
        Posicion posicionFinal = new Posicion(1,0);

        algoritmo.agregarAccion(bloque);
        algoritmo.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void seEjecutaUnAlgoritmoConUnTresBloqueCorrectamente(){
        Personaje personaje = new Personaje();
        Algoritmo algoritmo = new Algoritmo();
        BloqueDerecha bloque = new BloqueDerecha();
        Posicion posicionFinal = new Posicion(1,0);

        algoritmo.agregarAccion(bloque);
        algoritmo.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

}
