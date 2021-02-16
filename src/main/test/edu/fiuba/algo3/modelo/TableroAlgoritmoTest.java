package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TableroAlgoritmoTest {

    @Test
    public void tableroAlgoritmoEjecutaElBloqueAgregadoCorrectamente()
    {
        Personaje personaje = new Personaje();
        TableroAlgoritmo tableroAlgoritmo = new TableroAlgoritmo(personaje);
        IBloque bloque = mock(IBloque.class);
        tableroAlgoritmo.agregarAccion(bloque);
        tableroAlgoritmo.ejecutarAlgoritmo();
        verify(bloque).ejecutar(any());
    }

    @Test
    public void tableroAlgoritmoEjecutaVariosBloqueAgregadosCorrectamente()
    {
        Personaje personaje = new Personaje();
        TableroAlgoritmo tableroAlgoritmo = new TableroAlgoritmo(personaje);
        IBloque bloque = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        tableroAlgoritmo.agregarAccion(bloque);
        tableroAlgoritmo.agregarAccion(bloque2);
        tableroAlgoritmo.agregarAccion(bloque3);

        tableroAlgoritmo.ejecutarAlgoritmo();

        verify(bloque).ejecutar(any());
        verify(bloque2).ejecutar(any());
        verify(bloque3).ejecutar(any());
    }

    @Test
    public void tableroAlgoritmoEjecutaVariosBloquesEnOrdenCorrecto()
    {
        Personaje personaje = new Personaje();
        TableroAlgoritmo tableroAlgoritmo = new TableroAlgoritmo(personaje);
        IBloque bloque = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        tableroAlgoritmo.agregarAccion(bloque);
        tableroAlgoritmo.agregarAccion(bloque2);
        tableroAlgoritmo.agregarAccion(bloque3);

        tableroAlgoritmo.ejecutarAlgoritmo();

        InOrder orden = inOrder(bloque,bloque2,bloque3);

        orden.verify(bloque).ejecutar(any());
        orden.verify(bloque2).ejecutar(any());
        orden.verify(bloque3).ejecutar(any());

    }

    @Test
    public void tableroAlgoritmoEjecutaBloquesCompuestosCorrectamente()
    {
        Personaje personaje = new Personaje();
        TableroAlgoritmo tableroAlgoritmo = new TableroAlgoritmo(personaje);
        IBloque bloque = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloqueCompuesto = new BloqueRepetir(2);
        bloqueCompuesto.agregarAccion(bloque);
        bloqueCompuesto.agregarAccion(bloque2);
        tableroAlgoritmo.agregarAccion(bloqueCompuesto);
        tableroAlgoritmo.ejecutarAlgoritmo();
        verify(bloque,times(2)).ejecutar(any());
        verify(bloque,times(2)).ejecutar(any());
    }

    @Test
    public void tableroAlgoritmoGuardaUnAlgoritmoConBloques()
    {
        Personaje personaje = new Personaje();
        TableroAlgoritmo tableroAlgoritmo = new TableroAlgoritmo(personaje);
        IBloque bloque = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        tableroAlgoritmo.agregarAccion(bloque);
        tableroAlgoritmo.agregarAccion(bloque2);

        IBloque algoritmoGuardado = tableroAlgoritmo.guardarAlgoritmo();

        algoritmoGuardado.ejecutar(personaje);

        verify(bloque).ejecutar(any());
        verify(bloque2).ejecutar(any());
    }

    @Test
    public void tableroAlgoritmoGuardaUnAlgoritmoPeroSigueEnElTablero()
    {
        Personaje personaje = new Personaje();
        TableroAlgoritmo tableroAlgoritmo = new TableroAlgoritmo(personaje);
        IBloque bloque = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        tableroAlgoritmo.agregarAccion(bloque);
        tableroAlgoritmo.agregarAccion(bloque2);

        tableroAlgoritmo.guardarAlgoritmo();

        tableroAlgoritmo.ejecutarAlgoritmo();

        verify(bloque).ejecutar(any());
        verify(bloque2).ejecutar(any());
    }

    @Test
    public void tableroAlgoritmoResetEliminaTodosLosBloquesEnElTablero()
    {
        Personaje personaje = new Personaje();
        TableroAlgoritmo tableroAlgoritmo = new TableroAlgoritmo(personaje);
        IBloque bloque = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        tableroAlgoritmo.agregarAccion(bloque);
        tableroAlgoritmo.agregarAccion(bloque2);

        tableroAlgoritmo.resetear();
        tableroAlgoritmo.ejecutarAlgoritmo();

        verifyNoInteractions(bloque,bloque2);
    }

}
