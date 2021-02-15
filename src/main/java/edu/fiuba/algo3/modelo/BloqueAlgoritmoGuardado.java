package edu.fiuba.algo3.modelo;

public class BloqueAlgoritmoGuardado implements IAccion {

    private IAccionCompuesta algoritmo;
    BloqueAlgoritmoGuardado(IAccionCompuesta algoritmo)
    {
        this.algoritmo = algoritmo;
    }

    @Override
    public void ejecutar(Personaje personaje) {
        algoritmo.ejecutar(personaje);
    }

    @Override
    public void ejecutarInversa(Personaje personaje) {
        algoritmo.ejecutarInversa(personaje);
    }
}
