package edu.fiuba.algo3.modelo;

import java.util.Dictionary;
import java.util.Hashtable;

public class TableroAlgoritmo {
    private Algoritmo algoritmo = new Algoritmo();
    private Personaje actor;
    private Hashtable hashAlgoritmos = new Hashtable<String, IBloque>() ;


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

    public void guardarAlgoritmo(String nombreAlgoritmo) {
        if (this.algoritmo.estaVacio()){
            throw new NoHayBloquesEnElAlgoritmoAGuardarExcepcion("No es posible guardar un algoritmo sin bloques");
        }
        hashAlgoritmos.put(nombreAlgoritmo, this.algoritmo);
        this.resetear();
    }

    public IBloque devolverAlgoritmoConNombre(String nombreAlgoritmo){
        if (!hashAlgoritmos.containsKey(nombreAlgoritmo)) {
            throw new NoHayAlgoritmoGuardadoExcepcion("El algoritmo pedido no esta guardado");
        }
        IBloque algoritmo = (IBloque) hashAlgoritmos.get(nombreAlgoritmo);   // Agregar excepcion
        return algoritmo;
    }

    public void resetear() {
        this.algoritmo = new Algoritmo();
        this.actor.resetear();
    }

    public void eliminarAlgoritmosPersonalizados() {
        hashAlgoritmos.clear();
    }
}
