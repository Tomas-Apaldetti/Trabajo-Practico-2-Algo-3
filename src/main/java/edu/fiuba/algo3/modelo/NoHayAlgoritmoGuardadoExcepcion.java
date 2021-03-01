package edu.fiuba.algo3.modelo;

public class NoHayAlgoritmoGuardadoExcepcion extends RuntimeException{
    public NoHayAlgoritmoGuardadoExcepcion(String mensaje) {
        super(mensaje);
    }
}
