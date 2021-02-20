package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;


public class BloqueSimpleTest {

    @Test
    public void seIntentaAgregarUnBloqueAUnBloqueSimpleLanzaOperacionInvalidaBloqueSimpleExcepcion()
    {
        IBloque bloqueSimple =  mock(BloqueSimple.class, CALLS_REAL_METHODS);

        assertThrows(OperacionInvalidaBloqueSimpleExcepcion.class,
                ()->{
            bloqueSimple.agregarAccion(mock(IBloque.class));
        });

    }

    @Test
    public void seIntentaEliminarUnBloqueDeUnBloqueSimpleLanzaOperacionInvalidaBloqueSimpleExcepcion()
    {
        IBloque bloqueSimple = mock(BloqueSimple.class, CALLS_REAL_METHODS);

        assertThrows(OperacionInvalidaBloqueSimpleExcepcion.class,
                ()->{
            bloqueSimple.eliminarBloque(mock(IBloque.class));
                });
    }

    @Test
    public void seIntentaEliminarUnBloqueConIndiceDeUnBloqueSimpleLanzaOperacionInvalidaBloqueSimpleExcepcion()
    {
        IBloque bloqueSimple = mock(BloqueSimple.class, CALLS_REAL_METHODS);

        assertThrows(OperacionInvalidaBloqueSimpleExcepcion.class,
                ()->{
                    bloqueSimple.eliminarBloque(1);
                });
    }

    @Test
    public void seObtieneUnBloqueDentroDeUnBloqueSimpleLanzaOperacionInvalidaBloqueSimpleExcepcion()
    {
        IBloque bloqueSimple = mock(BloqueSimple.class, CALLS_REAL_METHODS);

        assertThrows(OperacionInvalidaBloqueSimpleExcepcion.class,
                ()->{
                    bloqueSimple.obtenerBloque(2);
                });
    }

    @Test
    public void seObtieneElPrimerBloqueDeUnBloqueSimpleEsElMismoBloque()
    {
        IBloque bloqueSimple = mock(BloqueSimple.class, CALLS_REAL_METHODS);
        IBloque bloqueObtenido = bloqueSimple.obtenerBloque(1);

        assertEquals(bloqueSimple,bloqueObtenido);
    }

}
