/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudades;

/**
 *
 * @author juane
 */
public class Explorar {
    
    String ady;
    String anterior;
    int peso;
    int hm;
    
    public Explorar(String a, String b, int c, int d){
        this.ady = a;
        this.anterior = b;
        this.peso = c;
        this.hm = d;
    }
    
    @Override
    public String toString() {
        return "Ady: "+ady+" Anterior: "+anterior+" Peso: "+peso+" Explorar: "+hm;
    }
    
}
