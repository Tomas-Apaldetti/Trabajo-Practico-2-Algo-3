package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BloqueRepetirTest {

    @Test
    public void repetirBloqueIzquierdaDosVecesEsCorrecto(){
        Personaje personaje = new Personaje();
        BloqueRepetir bloqueRepetir = new BloqueRepetir(2);
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        Posicion posicionFinal = new Posicion(-2,0);

        bloqueRepetir.agregarAccion(bloqueIzquierda);
        bloqueRepetir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);

    }
}
