package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {

    @Test
    public void SeEjecutaUnAlgoritmoConUnBloqueCorrectamente(){
        Personaje personaje = new Personaje();
        Algoritmo algoritmo = new Algoritmo();
        BloqueDerecha bloque = new BloqueDerecha();
        Posicion posicionFinal = new Posicion(1,0);

        algoritmo.agregarAccion(bloque);
        algoritmo.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }

    @Test
    public void SeEjecutaUnAlgoritmoConUnTresBloqueCorrectamente(){
        Personaje personaje = new Personaje();
        Algoritmo algoritmo = new Algoritmo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueBajarLapiz bloqueBajarLapiz = new BloqueBajarLapiz();

        algoritmo.agregarAccion(bloqueBajarLapiz);
        algoritmo.agregarAccion(bloqueDerecha);
        algoritmo.agregarAccion(bloqueAbajo);
        algoritmo.ejecutar(personaje);

        assertTrue(personaje.obtenerPosicion().estaPintado());
    }

}
