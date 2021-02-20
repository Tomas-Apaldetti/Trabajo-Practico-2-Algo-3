package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;


public class BloqueRepetirTest {

    @Test
    public void repetirBloqueIzquierdaDosVecesEsCorrecto(){
        Personaje personaje = new Personaje();
        IBloque bloqueRepetir = new BloqueRepetir(2);
        IBloque bloqueIzquierda = new BloqueIzquierda();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionIzquierda().posicionIzquierda();

        bloqueRepetir.agregarAccion(bloqueIzquierda);
        bloqueRepetir.ejecutar(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);
    }

    @Test
    public void repetirBloqueInvertidoRealizaLaAccionInvertidaDosVeces()
    {
        Personaje personaje = new Personaje();
        IBloque bloqueRepetir = new BloqueRepetir(2);
        IBloque bloqueIzquierda = new BloqueIzquierda();
        Posicion posicionFinal = personaje.obtenerPosicion().posicionDerecha().posicionDerecha();

        bloqueRepetir.agregarAccion(bloqueIzquierda);
        bloqueRepetir.ejecutarInversa(personaje);

        assertEquals(personaje.obtenerPosicion(),posicionFinal);
    }

    @Test
    public void repetirBloqueIzquierdayBloqueArribaDosVecesSeMueveCorectamente()
    {
        Personaje personaje = new Personaje();
        IBloque bloqueRepetir = new BloqueRepetir(2);
        IBloque bloqueIzquierda = new BloqueIzquierda();
        IBloque bloqueArriba = new BloqueArriba();
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
        IBloque bloqueRepetir = new BloqueRepetir(3);
        IBloque bloqueArriba = new BloqueArriba();
        Posicion posicionFinal = personaje.obtenerPosicion();

        for(int i=0;i<6;i++)
            posicionFinal = posicionFinal.posicionArriba();

        bloqueRepetir.agregarAccion(bloqueArriba);
        bloqueRepetir.agregarAccion(bloqueArriba);
        bloqueRepetir.ejecutar(personaje);

        assertEquals(posicionFinal,personaje.obtenerPosicion());
    }

    @Test
    public void seEliminaElPrimerBloqueDeUnBloqueRepetirConBloqueSimplesTodosLosBloquesSiguientesSonEliminados()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloque2);
        repetir.agregarAccion(bloque3);

        repetir.eliminarBloque(1);
        repetir.ejecutar(new Personaje());

        verifyNoInteractions(bloque1,bloque2,bloque3);
    }

    @Test
    public void seEliminaElSegundoBloqueDeUnBloqueRepetirConBloquesSimplesSeEjecutaElPrimeroPeroNoLosSiguientes()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloque2);
        repetir.agregarAccion(bloque3);

        repetir.eliminarBloque(2);
        repetir.ejecutar(new Personaje());

        verify(bloque1,times(2)).ejecutar(any());
        verifyNoInteractions(bloque2,bloque3);
    }

    @Test
    public void seEliminaElBloque10DeUnBloqueRepetirCon2LanzaBloqueFueraDeRangoExcepcion()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloque2);

        assertThrows(BloqueFueraDeRangoExcepcion.class ,
                () -> {
                    repetir.eliminarBloque(10);
                });
    }

    @Test
    public void seEliminaElUltimoBloqueDeUnBloqueRepetirConBloquesSimplesSeEjecutaCorrectamente()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloque2);
        repetir.agregarAccion(bloque3);

        repetir.eliminarBloque(3);
        repetir.ejecutar(new Personaje());

        verify(bloque1,times(2)).ejecutar(any());
        verify(bloque2,times(2)).ejecutar(any());
        verifyNoInteractions(bloque3);
    }

    @Test
    public void seEliminaUnBloqueCompuestoDeUnBloqueRepetirEliminandoTodosLosBloquesEnElYLosSubsiguientes()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloqueCompuesto = new Algoritmo();
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        IBloque bloque4 = mock(IBloque.class);

        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloqueCompuesto);
        repetir.agregarAccion(bloque4);

        repetir.eliminarBloque(2);

        repetir.ejecutar(new Personaje());

        verify(bloque1,times(2)).ejecutar(any());
        verifyNoInteractions(bloque2,bloque3,bloque4);
    }

    @Test
    public void seEliminaUnBloqueCompuestoComoUnicoBloqueNoSeEjecutaNada()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloqueCompuesto = new Algoritmo();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        bloqueCompuesto.agregarAccion(bloque1);
        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        repetir.agregarAccion(bloqueCompuesto);

        repetir.eliminarBloque(1);
        repetir.ejecutar(new Personaje());

        verifyNoInteractions(bloque1,bloque2,bloque3);
    }

    @Test
    public void eliminarBloqueConIndiceNegativoArrojaBloqueFueraDeRangoExcepcion()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        repetir.agregarAccion(bloque1);

        assertThrows(BloqueFueraDeRangoExcepcion.class, () -> {
            repetir.eliminarBloque(-1);
        });
    }

    @Test
    public void seEliminaUnBloqueConocidoEliminandoTodosLosBloquesSubsiguientes()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloque2);
        repetir.agregarAccion(bloque3);

        repetir.eliminarBloque(bloque2);
        repetir.ejecutar(new Personaje());

        verify(bloque1,times(2)).ejecutar(any());
        verifyNoInteractions(bloque2,bloque3);
    }

    @Test
    public void seEliminaUnBloqueQueNoSeEncuentraEnElBloqueRepetirLanzaBloqueNoEncontradoExcepcion()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloque2);

        assertThrows(BloqueNoEncontradoExcepcion.class, ()->{repetir.eliminarBloque(bloque3);});
    }

    @Test
    public void seObtieneUnBloqueEnLaPosicion2EsElCorrecto()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloque2);
        repetir.agregarAccion(bloque3);

        assertEquals(bloque2, repetir.obtenerBloque(2));
    }

    @Test
    public void seObtieneUnBloqueCompuestoEnLaPosicion2EsElCorrecto()
    {
        IBloque repetir = new BloqueRepetir(2);
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        IBloque bloqueCompuesto = new Algoritmo();

        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        repetir.agregarAccion(bloque1);
        repetir.agregarAccion(bloqueCompuesto);

        assertEquals(bloqueCompuesto, repetir.obtenerBloque(2));
    }

    @Test
    public void seObtieneBloqueConPosicionMayorALaContenidaLanzaBloqueFueraDeRangoExcepcion()
    {
        IBloque repetir = new BloqueRepetir(2);

        assertThrows(BloqueFueraDeRangoExcepcion.class, ()->{
            repetir.obtenerBloque(1);
        });
    }

    @Test
    public void seObtieneBloqueConPosicionNegativaLanzaBloqueFueraDeRangoExcepcion()
    {
        IBloque repetir = new BloqueRepetir(2);

        assertThrows(BloqueFueraDeRangoExcepcion.class, ()->{
            repetir.obtenerBloque(-10);
        });
    }
}
