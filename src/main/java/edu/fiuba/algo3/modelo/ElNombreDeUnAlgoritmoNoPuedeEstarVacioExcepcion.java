package edu.fiuba.algo3.modelo;

public class ElNombreDeUnAlgoritmoNoPuedeEstarVacioExcepcion extends IllegalArgumentException {
    public ElNombreDeUnAlgoritmoNoPuedeEstarVacioExcepcion(String mensaje) {
        super(mensaje);
    }
}
