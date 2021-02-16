package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BloqueAlgoritmoGuardadoTest {

    @Test
    public void seGuardaUnAlgoritmoConBloquesSimplesSeEjecutaCorrectamente()
    {
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        IBloque algoritmo = new Algoritmo();
        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);
        algoritmo.agregarAccion(bloque3);
        IBloque algoritmoGuardado = new BloqueAlgoritmoGuardado(algoritmo);

        algoritmoGuardado.ejecutar(mock(Personaje.class));
        verify(bloque1).ejecutar(any());
        verify(bloque2).ejecutar(any());
        verify(bloque3).ejecutar(any());
    }

    @Test
    public void seGuardaUnAlgoritmoConBloquesSimplesSeEjecutaInversaCorrectamente()
    {
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        IBloque algoritmo = new Algoritmo();
        algoritmo.agregarAccion(bloque1);
        algoritmo.agregarAccion(bloque2);
        algoritmo.agregarAccion(bloque3);
        IBloque algoritmoGuardado = new BloqueAlgoritmoGuardado(algoritmo);

        algoritmoGuardado.ejecutarInversa(new Personaje());
        verify(bloque1).ejecutarInversa(any());
        verify(bloque2).ejecutarInversa(any());
        verify(bloque3).ejecutarInversa(any());
    }

    @Test
    public void seGuardaUnAlgoritmoConBloquesCompuestosSeEjecutaCorrectamente()
    {
        IBloque bloque1 = mock(IBloque.class);
        IBloque bloque2 = mock(IBloque.class);
        IBloque bloque3 = mock(IBloque.class);
        IBloque repeticion = new BloqueRepetir(2);
        IBloque inversa = new BloqueInvertir();
        IBloque algoritmo = new Algoritmo();
        repeticion.agregarAccion(bloque1);
        repeticion.agregarAccion(bloque2);
        inversa.agregarAccion(bloque3);
        algoritmo.agregarAccion(repeticion);
        algoritmo.agregarAccion(inversa);
        IBloque algoritmoGuardado = new BloqueAlgoritmoGuardado(algoritmo);

        algoritmoGuardado.ejecutar(new Personaje());

        verify(bloque1,times(2)).ejecutar(any());
        verify(bloque2,times(2)).ejecutar(any());
        verify(bloque3).ejecutarInversa(any());
    }
}
