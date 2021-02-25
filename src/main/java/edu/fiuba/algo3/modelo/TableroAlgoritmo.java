package edu.fiuba.algo3.modelo;

public class TableroAlgoritmo {
    private IBloque algoritmo = new Algoritmo();
    private Personaje actor;

    public TableroAlgoritmo(Personaje actor)
    {
        this.actor = actor;
    }

    public void agregarAccion(IBloque bloque) {
        this.algoritmo.agregarAccion(bloque);
    }

    public void ejecutarAlgoritmo() {
        this.algoritmo.ejecutar(this.actor);
    }

    public IBloque guardarAlgoritmo() {
        return new BloqueAlgoritmoGuardado(this.algoritmo);
    }

    public void resetear() {
        this.algoritmo = new Algoritmo();
    }
}
