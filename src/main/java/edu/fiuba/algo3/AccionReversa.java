package edu.fiuba.algo3;

public class AccionReversa implements IAccion {
    private IAccion aRevertir;
    public AccionReversa(IAccion accion) {
        this.aRevertir = accion;
    }

    @Override
    public void ejecutar(Personaje personaje) {
        this.aRevertir.ejecutarReversa(personaje);
    }

    @Override
    public void ejecutarReversa(Personaje personaje) {
        this.aRevertir.ejecutar(personaje);
    }
}
