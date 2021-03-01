package edu.fiuba.algo3.modelo;

import java.util.Dictionary;
import java.util.Hashtable;

public class TableroAlgoritmo {
    private IBloque algoritmo = new Algoritmo();
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
        hashAlgoritmos.put(nombreAlgoritmo, this.algoritmo);
        //return new BloqueAlgoritmoGuardado(this.algoritmo);   //RErecibe una string y se lo guarda con ese nombre
    }

    public IBloque devolverAlgoritmoConNombre(String nombreAlgoritmo){
        IBloque algoritmo = (IBloque) hashAlgoritmos.get(nombreAlgoritmo);   // Agregar excepcion
        return algoritmo;
    }

    public void resetear() {
        this.algoritmo = new Algoritmo();
        this.actor.resetear();
    }
}
