package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BloqueRepetirTest {

    @Test
    public void repetirBloqueIzquierdaDosVecesEsCorrecto(){
        Personaje personaje = new Personaje();
        BloqueRepetir bloqueRepetir = new BloqueRepetir(2);
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionIzquierda().posicionIzquierda();

        bloqueRepetir.agregarAccion(bloqueIzquierda);
        bloqueRepetir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);
    }

    @Test
    public void repetirBloqueInvertidoRealizaLaAccionInvertidaDosVeces()
    {
        Personaje personaje = new Personaje();
        BloqueRepetir bloqueRepetir = new BloqueRepetir(2);
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionDerecha().posicionDerecha();

        bloqueRepetir.agregarAccion(bloqueIzquierda);
        bloqueRepetir.ejecutarInversa(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);
    }

    @Test
    public void repetirBloqueIzquierdayBloqueArribaDosVecesSeMueveCorectamente()
    {
        Personaje personaje = new Personaje();
        IAccionCompuesta bloqueRepetir = new BloqueRepetir(2);
        IAccion bloqueIzquierda = new BloqueIzquierda();
        IAccion bloqueArriba = new BloqueArriba();
        Posicion posicionFinal = personaje.obtenerPosicion();

        for(int i=0;i<2;i++)
            posicionFinal = posicionFinal.posicionIzquierda().posicionArriba();

        bloqueRepetir.agregarAccion(bloqueIzquierda);
        bloqueRepetir.agregarAccion(bloqueArriba);
        bloqueRepetir.ejecutar(personaje);

        assertEquals(posicionFinal,personaje.obtenerPosicion());
    }

    @Test
    public void repetirTresVecesBloqueArribaInsertadoDosVecesSeMueveCorrectamente()
    {
        Personaje personaje = new Personaje();
        IAccionCompuesta bloqueRepetir = new BloqueRepetir(3);
        IAccion bloqueArriba = new BloqueArriba();
        Posicion posicionFinal = personaje.obtenerPosicion();

        for(int i=0;i<6;i++)
            posicionFinal = posicionFinal.posicionArriba();

        bloqueRepetir.agregarAccion(bloqueArriba);
        bloqueRepetir.agregarAccion(bloqueArriba);
        bloqueRepetir.ejecutar(personaje);

        assertEquals(posicionFinal,personaje.obtenerPosicion());
    }
}
