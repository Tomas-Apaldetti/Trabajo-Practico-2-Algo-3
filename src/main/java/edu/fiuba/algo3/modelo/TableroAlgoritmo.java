package edu.fiuba.algo3.modelo;

public class TableroAlgoritmo {
    private IAccionCompuesta algoritmo = new Algoritmo();
    private Personaje actor;

    TableroAlgoritmo(Personaje actor)
    {
        this.actor = actor;
    }

    public void agregarAccion(IAccion bloque) {
        this.algoritmo.agregarAccion(bloque);
    }

    public void ejecutarAlgoritmo() {
        this.algoritmo.ejecutar(this.actor);
    }

    public IAccion guardarAlgoritmo() {
        return new BloqueAlgoritmoGuardado(this.algoritmo);
    }

    public void resetear() {
        this.algoritmo = new Algoritmo();
    }
}
