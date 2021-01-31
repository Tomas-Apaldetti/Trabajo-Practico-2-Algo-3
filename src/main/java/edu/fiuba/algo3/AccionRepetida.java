package edu.fiuba.algo3;

public class AccionRepetida implements IAccion {
    private IAccion aRepetir;
    private int iteraciones;
    public AccionRepetida(IAccion accion, int iteraciones) {
        this.aRepetir = accion;
        this.iteraciones = iteraciones;
    }

    @Override
    public void ejecutar(Personaje personaje) {
        for (int i = 0; i < iteraciones; i++)
        {
            aRepetir.ejecutar(personaje);
        }
    }

    @Override
    public void ejecutarReversa(Personaje personaje) {
        for (int i = 0; i < iteraciones; i++)
        {
            aRepetir.ejecutarReversa(personaje);
        }
    }
}
