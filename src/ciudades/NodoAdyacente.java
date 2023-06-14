/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudades;

/**
 *
 * @author juane
 */
public class NodoAdyacente {
    
    String id;
    int peso;
    NodoAdyacente sig;
    
    public NodoAdyacente (String id, int peso) {
        this.id = id;
        this.peso = peso;
        sig = null;
    }
    
    @Override
    public String toString(){
        return id+"("+peso+") -> ";
    }
    
}
