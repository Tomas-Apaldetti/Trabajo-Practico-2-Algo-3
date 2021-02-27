package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.*;


public class IdentificarBloque {
    public IdentificarBloque(){

    }

    public IBloque devolverBloque(String string){
        if (string.equals("✐") ){
            return new BloqueSubirLapiz();
        }
        if (string.equals("✎") ){
            return new BloqueBajarLapiz();
        }
        if (string.equals("↓" )){
            return new BloqueAbajo();
        }
        if (string.equals("←") ){
            return new BloqueIzquierda();
        }
        if (string.equals("↑")){
            return new BloqueArriba();
        }

        if (string.equals("⟳") ){
            return new BloqueRepetir(2);
        }
        
        if (string.equals("⇄")){
            return new BloqueIzquierda();
        }


        return new BloqueDerecha();
    }

}
