package edu.fiuba.algo3.modelo;

public class NoHayBloquesEnElAlgoritmoAGuardarExcepcion extends IllegalStateException {
    public NoHayBloquesEnElAlgoritmoAGuardarExcepcion(String mensaje) {
        super(mensaje);
    }
}
