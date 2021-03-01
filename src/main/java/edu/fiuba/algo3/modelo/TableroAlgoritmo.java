package edu.fiuba.algo3.modelo;

import java.util.Hashtable;
import java.util.Map;

public class TableroAlgoritmo {
    private Algoritmo algoritmo = new Algoritmo();
    private Personaje actor;
    private Map<String, IBloque> hashAlgoritmos = new Hashtable<>() ;


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
        IBloque algoritmo = hashAlgoritmos.get(nombreAlgoritmo);
        if (algoritmo == null)
            throw new NoExisteTalAlgoritmoExcepcion("Algoritmo:" + nombreAlgoritmo + "no existe en los algoritmos guardados");
        return new BloqueAlgoritmoGuardado(algoritmo);
    }

    public void resetear() {
        this.algoritmo = new Algoritmo();
        this.actor.resetear();
    }

    public void eliminarAlgoritmosPersonalizados() {
        hashAlgoritmos.clear();
    }

    public IBloque obtenerAlgoritmo() {
        return algoritmo;
    }
}
