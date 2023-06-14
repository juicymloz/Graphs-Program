/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudades;

/**
 *
 * @author juane
 */
public class Visitados {
    
    String visitado;
    String anterior;
    
    public Visitados(String a, String b){
        this.visitado = a;
        this.anterior = b;
    }
    
    @Override
    public String toString () {
        return visitado+" -> "+anterior;
    }
}
