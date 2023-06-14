/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudades;

/**
 *
 * @author juane
 */
public class Htica {
    
    String id;
    int heu;
    
    public Htica(String id, int heu){
        this.id = id;
        this.heu = heu;
    }
    
    @Override
    public String toString() {
        return id+" : "+heu;
    }
    
}
