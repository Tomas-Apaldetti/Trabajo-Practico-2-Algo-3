package edu.fiuba.algo3.modelo;

public class BloqueAlgoritmoGuardado extends BloqueSimple {

    private IBloque algoritmo;
    BloqueAlgoritmoGuardado(IBloque algoritmo)
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
