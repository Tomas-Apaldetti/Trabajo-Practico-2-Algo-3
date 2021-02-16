package edu.fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AlgoritmoTest {

    @Test
    public void SeEjecutaUnAlgoritmoConUnBloqueCorrectamente(){
        Personaje personaje = new Personaje();
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque = new BloqueDerecha();
        Posicion posicionFinal = new Posicion(1,0);

        algoritmo.agregarAccion(bloque);
        algoritmo.ejecutar(personaje);

        Assert.assertEquals(personaje.obtenerPosicion(),posicionFinal);

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

    @Test
    public void algoritmoConBloqueInvertirDentroDeBloqueDeRepeticionYLapizBajoInvertidoSeEjecutaCorrectamente()
    {
        Personaje personaje = new Personaje();
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloqueBajarLapiz = new BloqueBajarLapiz();
        IAccion bloqueArriba = new BloqueArriba();
        IAccion bloqueIzquierda = new BloqueIzquierda();
        IAccionCompuesta bloqueRepetir = new BloqueRepetir(3);
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();

        Posicion posicionEsperada = new Posicion(3, -3);

        algoritmo.agregarAccion(bloqueBajarLapiz);
        bloqueInvertir.agregarAccion(bloqueIzquierda);
        bloqueInvertir.agregarAccion(bloqueArriba);
        bloqueInvertir.agregarAccion(bloqueBajarLapiz);
        bloqueRepetir.agregarAccion(bloqueInvertir);
        algoritmo.agregarAccion(bloqueRepetir);
        algoritmo.ejecutar(personaje);

        assertEquals(posicionEsperada, personaje.obtenerPosicion());
        assertFalse(personaje.obtenerPosicion().estaPintado());

    }

    @Test
    public void algoritmoConBloqueRepetirDentroDeBloqueInvertirInvierteTodasLasAccionesDentroDelBloqueRepetir()
    {
        Personaje personaje = new Personaje();
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccionCompuesta bloqueRepetir = new BloqueRepetir(3);
        IAccionCompuesta bloqueInvertir = new BloqueInvertir();
        IAccion bloqueAbajo = new BloqueAbajo();
        IAccion bloqueDerecha = new BloqueDerecha();
        IAccion bloqueSubirLapiz = new BloqueSubirLapiz();

        Posicion posicionEsperada = new Posicion(-3, 3);

        bloqueRepetir.agregarAccion(bloqueSubirLapiz);
        bloqueRepetir.agregarAccion(bloqueDerecha);
        bloqueRepetir.agregarAccion(bloqueAbajo);
        bloqueInvertir.agregarAccion(bloqueRepetir);
        algoritmo.agregarAccion(bloqueInvertir);
        algoritmo.ejecutar(personaje);

        assertEquals(posicionEsperada, personaje.obtenerPosicion());
        assertTrue(personaje.obtenerPosicion().estaPintado());
    }

    @Test
    public void seEliminaElPrimerBloqueDeUnAlgoritmoConBloqueSimplesTodosLosBloquesSiguientesSonEliminados()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);

        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);
        algoritmo.agregarAccion(bloque3);

        algoritmo.eliminarBloque(1);
        algoritmo.ejecutar(new Personaje());

        verifyNoInteractions(bloque1,bloque2,bloque3);
    }

    @Test
    public void seEliminaElSegundoBloqueDeUnAlgoritmoConBloquesSimplesSeEjecutaElPrimeroPeroNoLosSiguientes()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);

        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);
        algoritmo.agregarAccion(bloque3);

        algoritmo.eliminarBloque(2);
        algoritmo.ejecutar(new Personaje());

        verify(bloque1).ejecutar(any());
        verifyNoInteractions(bloque2,bloque3);
    }

    @Test
    public void seEliminaElBloque10DeUnAlgoritmoCon2LanzaBloqueFueraDeRangoExcepcion()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);

        assertThrows(BloqueFueraDeRangoExcepcion.class ,
                    () -> {
                            algoritmo.eliminarBloque(10);
                        });
    }

    @Test
    public void seEliminaElUltimoBloqueDeUnAlgoritmoConBloquesSimplesSeEjecutaCorrectamente()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);

        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);
        algoritmo.agregarAccion(bloque3);

        algoritmo.eliminarBloque(3);
        algoritmo.ejecutar(new Personaje());

        verify(bloque1).ejecutar(any());
        verify(bloque2).ejecutar(any());
        verifyNoInteractions(bloque3);
    }

    @Test
    public void seEliminaUnBloqueCompuestoDeUnAlgoritmoEliminandoTodosLosBloquesEnElYLosSubsiguientes()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccionCompuesta bloqueCompuesto = new Algoritmo();
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);
        IAccion bloque4 = mock(IAccion.class);

        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloqueCompuesto);
        algoritmo.agregarAccion(bloque4);

        algoritmo.eliminarBloque(2);

        algoritmo.ejecutar(new Personaje());

        verify(bloque1).ejecutar(any());
        verifyNoInteractions(bloque2,bloque3,bloque4);
    }

    @Test
    public void seEliminaUnBloqueCompuestoComoUnicoBloqueNoSeEjecutaNada()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccionCompuesta bloqueCompuesto = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);
        bloqueCompuesto.agregarAccion(bloque1);
        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        algoritmo.agregarAccion(bloqueCompuesto);

        algoritmo.eliminarBloque(1);
        algoritmo.ejecutar(new Personaje());

        verifyNoInteractions(bloque1,bloque2,bloque3);
    }
    @Test
    public void eliminarBloqueConIndiceNegativoArrojaBloqueFueraDeRangoExcepcion()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        algoritmo.agregarAccion(bloque1);
        algoritmo.ejecutar(new Personaje());

        assertThrows(BloqueFueraDeRangoExcepcion.class, () -> {
            algoritmo.eliminarBloque(-1);
        });
    }

    @Test
    public void seEliminaUnBloqueConocidoEliminandoTodosLosBloquesSubsiguientes()
    {
        IAccionCompuesta algoritmo= new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);

        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);
        algoritmo.agregarAccion(bloque3);

        algoritmo.eliminarBloque(bloque2);
        algoritmo.ejecutar(new Personaje());

        verify(bloque1).ejecutar(any());
        verifyNoInteractions(bloque2,bloque3);
    }

    @Test
    public void seEliminaUnBloqueQueNoSeEncuentraEnElAlgoritmoLanzaBloqueNoEncontradoExcepcion()
    {
        IAccionCompuesta algoritmo= new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);

        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);

        assertThrows(BloqueNoEncontradoExcepcion.class, ()->{algoritmo.eliminarBloque(bloque3);});
    }

    @Test
    public void seObtieneUnBloqueEnLaPosicion2EsElCorrecto()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);

        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);
        algoritmo.agregarAccion(bloque3);

        assertEquals(bloque2, algoritmo.obtenerBloque(2));
    }

    @Test
    public void seObtieneUnBloqueCompuestoEnLaPosicion2EsElCorrecto()
    {
        IAccionCompuesta algoritmo = new Algoritmo();
        IAccion bloque1 = mock(IAccion.class);
        IAccion bloque2 = mock(IAccion.class);
        IAccion bloque3 = mock(IAccion.class);
        IAccionCompuesta bloqueCompuesto = new Algoritmo();

        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloqueCompuesto);

        assertEquals(bloqueCompuesto, algoritmo.obtenerBloque(2));
    }

    @Test
    public void seObtieneBloqueConPosicionMayorALaContenidaLanzaBloqueFueraDeRangoExcepcion()
    {
        IAccionCompuesta algoritmo = new Algoritmo();

        assertThrows(BloqueFueraDeRangoExcepcion.class, ()->{
            algoritmo.obtenerBloque(1);
        });
    }

    @Test
    public void seObtieneBloqueConPosicionNegativaLanzaBloqueFueraDeRangoExcepcion()
    {
        IAccionCompuesta algoritmo = new Algoritmo();

        assertThrows(BloqueFueraDeRangoExcepcion.class, ()->{
            algoritmo.obtenerBloque(-10);
        });
    }
}
