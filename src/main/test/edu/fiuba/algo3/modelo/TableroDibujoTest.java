package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.IObservaMovimientos;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TableroEjecucion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableroDibujoTest {
    @Test
    public void unTableroRecibeUnaActualizacionDePosicionesLasGuardaCorrectamente()
    {
        IObservaMovimientos tablero = new TableroEjecucion();
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = posicion1.posicionAbajo();
        tablero.avisarMovimiento(posicion1,posicion2);

        ArrayList<Posicion> movimientos = tablero.obtenerMovimientos();
        boolean existenMovimientos = movimientos.contains(posicion1) && movimientos.contains(posicion2);

        assertTrue(existenMovimientos);
    }

    @Test
    public void unTableroDosActualizacionesConPosicionesConsecutivasGuardaLasPosiciones()
    {
        IObservaMovimientos tablero = new TableroEjecucion();
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = posicion1.posicionAbajo();
        tablero.avisarMovimiento(posicion1,posicion2);

        Posicion posicion3 = posicion2.posicionArriba();
        posicion2.colorear();

        tablero.avisarMovimiento(posicion2,posicion3);

        ArrayList<Posicion> movimientos = tablero.obtenerMovimientos();
        boolean existenMovimientos = movimientos.contains(posicion1) && movimientos.contains(posicion2) && movimientos.contains(posicion3);

        assertTrue(existenMovimientos);
    }

    @Test
    public void unTableroDosActualizacionesConPosicionesConsecutivasNoGuardaDuplicados()
    {
        IObservaMovimientos tablero = new TableroEjecucion();
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = posicion1.posicionAbajo();
        tablero.avisarMovimiento(posicion1,posicion2);

        Posicion posicion3 = posicion2.posicionArriba();

        tablero.avisarMovimiento(posicion2,posicion3);

        ArrayList<Posicion> movimientos = tablero.obtenerMovimientos();
        assertEquals(3,movimientos.size());
    }

    @Test
    public void unTableroDosAcutalizacionesNoConsecutivasGuardaTodosLosElementos()
    {
            IObservaMovimientos tablero = new TableroEjecucion();
            Posicion posicion1 = new Posicion(0,0);
            Posicion posicion2 = posicion1.posicionAbajo();

            Posicion posicion3 = posicion2.posicionArriba().posicionDerecha();
            Posicion posicion4 = posicion3.posicionArriba();

            tablero.avisarMovimiento(posicion1,posicion2);
            tablero.avisarMovimiento(posicion3,posicion4);

            ArrayList<Posicion> movimientos = tablero.obtenerMovimientos();
            assertEquals(4,movimientos.size());
    }

    @Test
    public void unTableroDosAcutalizacionesNoConsecutivasLosMovimientosSonCorrectos()
    {
        IObservaMovimientos tablero = new TableroEjecucion();
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = posicion1.posicionAbajo();

        Posicion posicion3 = posicion2.posicionArriba().posicionDerecha();
        Posicion posicion4 = posicion3.posicionArriba();

        tablero.avisarMovimiento(posicion1,posicion2);
        tablero.avisarMovimiento(posicion3,posicion4);

        ArrayList<Posicion> movimientos = tablero.obtenerMovimientos();

        boolean existenMovimientos = movimientos.contains(posicion1)
                && movimientos.contains(posicion2)
                && movimientos.contains(posicion3)
                && movimientos.contains(posicion4);

        assertTrue(existenMovimientos);
    }

    @Test
    public void unTableroDosActualizacionesConsecutivasConservaElOrdenDeLosMovimientos()
    {
        IObservaMovimientos tablero = new TableroEjecucion();
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = posicion1.posicionAbajo();
        tablero.avisarMovimiento(posicion1,posicion2);

        Posicion posicion3 = posicion2.posicionArriba();

        tablero.avisarMovimiento(posicion2,posicion3);

        ArrayList<Posicion> movimientosTeoricos = new ArrayList<>();
        movimientosTeoricos.add(posicion1);
        movimientosTeoricos.add(posicion2);
        movimientosTeoricos.add(posicion3);

        ArrayList<Posicion> movimientosReales = tablero.obtenerMovimientos();

        assertEquals(movimientosTeoricos,movimientosReales);
    }

    @Test
    public void unTableroDosActualizacionesNoConsecutivasConservaElOrdenDeLosMovimientos(){
        IObservaMovimientos tablero = new TableroEjecucion();
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = posicion1.posicionAbajo();

        Posicion posicion3 = posicion2.posicionArriba().posicionIzquierda();
        Posicion posicion4 = posicion3.posicionAbajo();

        tablero.avisarMovimiento(posicion1,posicion2);
        tablero.avisarMovimiento(posicion3,posicion4);

        ArrayList<Posicion> movimientosTeoricos = new ArrayList<>();
        movimientosTeoricos.add(posicion1);
        movimientosTeoricos.add(posicion2);
        movimientosTeoricos.add(posicion3);
        movimientosTeoricos.add(posicion4);

        ArrayList<Posicion> movimientosReales = tablero.obtenerMovimientos();

        assertEquals(movimientosTeoricos,movimientosReales);
    }
}
