package edu.fiuba.algo3.modelo;

public class NoHayBloquesEnElAlgoritmoAGuardarExcepcion extends RuntimeException {
    public NoHayBloquesEnElAlgoritmoAGuardarExcepcion(String mensaje) {
        super(mensaje);
    }
}
