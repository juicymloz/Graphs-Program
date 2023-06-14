/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudades;

/**
 *
 * @author juane
 */
public class Nodo {
    
    String id;
    int rep;
    boolean proc;
    Nodo sig;
    NodoAdyacente sigA;
    
    public Nodo (String id) {
        this.id = id;
        rep = 0;
        proc = false;
        sig = null;
        sigA = null;
    }
    
    @Override
    public String toString(){
        return id+" : ";
    }
    
}
