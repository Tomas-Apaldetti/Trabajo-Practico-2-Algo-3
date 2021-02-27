package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;


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
        Posicion posicionSupuestaAPintar = personaje.obtenerPosicion();
        IBloque bloqueSubirLapiz = new BloqueSubirLapiz();
        IBloque bloqueInvertir = new BloqueInvertir();

        bloqueInvertir.agregarAccion(bloqueSubirLapiz);
        bloqueInvertir.ejecutar(personaje);
        personaje.moverAbajo();

        Assertions.assertTrue(posicionSupuestaAPintar.estaPintado());

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

    @Test
    public void seEliminaElPrimerBloqueDeUnBloqueInvertirConBloqueSimplesTodosLosBloquesSiguientesSonEliminados()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloque2);
        bloqueInvertir.agregarAccion(bloque3);

        bloqueInvertir.eliminarBloque(1);
        bloqueInvertir.ejecutar(new Personaje());

        verifyNoInteractions(bloque1,bloque2,bloque3);
    }

    @Test
    public void seEliminaElSegundoBloqueDeUnBloqueInvertirConBloquesSimplesSeEjecutaElPrimeroPeroNoLosSiguientes()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloque2);
        bloqueInvertir.agregarAccion(bloque3);

        bloqueInvertir.eliminarBloque(2);
        bloqueInvertir.ejecutar(new Personaje());

        verify(bloque1).ejecutarInversa(any());
        verifyNoInteractions(bloque2,bloque3);
    }

    @Test
    public void seEliminaElBloque10DeUnBloqueInvertirCon2LanzaBloqueFueraDeRangoExcepcion()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloque2);

        assertThrows(BloqueFueraDeRangoExcepcion.class ,
                () -> {
                    bloqueInvertir.eliminarBloque(10);
                });
    }

    @Test
    public void seEliminaElUltimoBloqueDeUnBloqueInvertirConBloquesSimplesSeEjecutaCorrectamente()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloque2);
        bloqueInvertir.agregarAccion(bloque3);

        bloqueInvertir.eliminarBloque(3);
        bloqueInvertir.ejecutar(new Personaje());

        verify(bloque1).ejecutarInversa(any());
        verify(bloque2).ejecutarInversa(any());
        verifyNoInteractions(bloque3);
    }

    @Test
    public void seEliminaUnBloqueCompuestoDeUnBloqueInvertirEliminandoTodosLosBloquesEnElYLosSubsiguientes()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloqueCompuesto = new Algoritmo();
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        IBloque bloque4 = mock(IBloque.class);

        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloqueCompuesto);
        bloqueInvertir.agregarAccion(bloque4);

        bloqueInvertir.eliminarBloque(2);

        bloqueInvertir.ejecutar(new Personaje());

        verify(bloque1).ejecutarInversa(any());
        verifyNoInteractions(bloque2,bloque3,bloque4);
    }

    @Test
    public void seEliminaUnBloqueCompuestoComoUnicoBloqueNoSeEjecutaNada()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloqueCompuesto = new Algoritmo();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        bloqueCompuesto.agregarAccion(bloque1);
        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        bloqueInvertir.agregarAccion(bloqueCompuesto);

        bloqueInvertir.eliminarBloque(1);
        bloqueInvertir.ejecutar(new Personaje());

        verifyNoInteractions(bloque1,bloque2,bloque3);
    }
    @Test
    public void eliminarBloqueConIndiceNegativoArrojaBloqueFueraDeRangoExcepcion()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        bloqueInvertir.agregarAccion(bloque1);

        assertThrows(BloqueFueraDeRangoExcepcion.class, () -> {
            bloqueInvertir.eliminarBloque(-1);
        });
    }

    @Test
    public void seEliminaUnBloqueConocidoEliminandoTodosLosBloquesSubsiguientes()
    {
        IBloque bloqueInvertir= new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloque2);
        bloqueInvertir.agregarAccion(bloque3);

        bloqueInvertir.eliminarBloque(bloque2);
        bloqueInvertir.ejecutar(new Personaje());

        verify(bloque1).ejecutarInversa(any());
        verifyNoInteractions(bloque2,bloque3);
    }

    @Test
    public void seEliminaUnBloqueQueNoSeEncuentraEnElAlgoritmoLanzaBloqueNoEncontradoExcepcion()
    {
        IBloque bloqueInvertir= new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloque2);

        assertThrows(BloqueNoEncontradoExcepcion.class, ()->{bloqueInvertir.eliminarBloque(bloque3);});
    }

    @Test
    public void seObtieneUnBloqueEnLaPosicion2EsElCorrecto()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);

        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloque2);
        bloqueInvertir.agregarAccion(bloque3);

        assertEquals(bloque2, bloqueInvertir.obtenerBloque(2));
    }

    @Test
    public void seObtieneUnBloqueCompuestoEnLaPosicion2EsElCorrecto()
    {
        IBloque bloqueInvertir = new BloqueInvertir();
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        IBloque bloqueCompuesto = new Algoritmo();

        bloqueCompuesto.agregarAccion(bloque2);
        bloqueCompuesto.agregarAccion(bloque3);

        bloqueInvertir.agregarAccion(bloque1);
        bloqueInvertir.agregarAccion(bloqueCompuesto);

        assertEquals(bloqueCompuesto, bloqueInvertir.obtenerBloque(2));
    }

    @Test
    public void seObtieneBloqueConPosicionMayorALaContenidaLanzaBloqueFueraDeRangoExcepcion()
    {
        IBloque bloqueInvertir = new BloqueInvertir();

        assertThrows(BloqueFueraDeRangoExcepcion.class, ()->{
            bloqueInvertir.obtenerBloque(1);
        });
    }

    @Test
    public void seObtieneBloqueConPosicionNegativaLanzaBloqueFueraDeRangoExcepcion()
    {
        IBloque bloqueInvertir = new BloqueInvertir();

        assertThrows(BloqueFueraDeRangoExcepcion.class, ()->{
            bloqueInvertir.obtenerBloque(-10);
        });
    }
}

