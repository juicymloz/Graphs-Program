/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juane
 */
public class Grafo {
    
    Nodo raiz;
    ArrayList<Htica> heu;
    
    public Grafo () {
        raiz = null;
        heu = null;
    }
    
    public Nodo buscarNodo (String nombre){
        Nodo i;
        for (i = raiz; i != null; i = i.sig){
            if (i.id.equals(nombre))
                return i;
        }
        return null;
    }
    
    public NodoAdyacente buscarAdyacente (String nombre, Nodo bO){
        NodoAdyacente i;
        Nodo j = bO;
        for(i = j.sigA; i != null; i = i.sig){
            if(i.id.equals(nombre))
                return i;
        }
        return null;
    }
    
    public void insertarNodo (String nombre){
        if (heu == null)
            heu = new ArrayList<>();
        Nodo b = buscarNodo(nombre), i;
        if (b == null)
        {
            Nodo v = new Nodo(nombre);
            Htica h = new Htica(nombre, 0);
            if(raiz != null)
            {
                for(i = raiz; i.sig != null; i = i.sig){}
                i.sig = v;
                heu.add(h);
            }else
            {
                heu.add(h);
                raiz = v;
            }
        }else{
            System.out.println("! Nodo ya existente !");
        }
    }
    
    public void insertarNodoArchivo (String nombre){
        if (heu == null)
            heu = new ArrayList<>();
        Nodo b = buscarNodo(nombre), i;
        if (b == null)
        {
            Nodo v = new Nodo(nombre);
            Htica h = new Htica(nombre, 0);
            if(raiz != null)
            {
                for(i = raiz; i.sig != null; i = i.sig){}
                i.sig = v;
                heu.add(h);
            }else
            {
                heu.add(h);
                raiz = v;
            }
        }
    }
   
    public void insertarArco (String nOrigen, String nDestino, int peso){
        Nodo bO, bD;
        NodoAdyacente v1, v2, i;
        bO = buscarNodo(nOrigen);
        bD = buscarNodo(nDestino);

        if(bO != null && bD != null)
        {
            v1 = buscarAdyacente(nOrigen, bD);
            v2 = buscarAdyacente(nDestino, bO);
            if (v1 != null && v2 != null){
                v1.peso = peso;
                v2.peso = peso;
            }else{
                v1 = new NodoAdyacente(nOrigen, peso);
                v2 = new NodoAdyacente(nDestino, peso);
                if(bO.sigA != null)
                {
                    for(i = bO.sigA; i.sig != null; i = i.sig){}
                    i.sig = v2;
                }else
                {
                    bO.sigA = v2;
                }
                if(bD.sigA != null)
                {
                    for(i = bD.sigA; i.sig != null; i = i.sig){}
                    i.sig = v1;
                }else
                {
                    bD.sigA = v1;
                }
            }
        }else{
            System.out.println("! Alguno de los nodos no existe !");
        }
    }
    
    public void insertarArcoArchivoBidi (String nOrigen, String nDestino, int peso){
        Nodo bO, bD;
        NodoAdyacente v1, v2, i;
        bO = buscarNodo(nOrigen);
        bD = buscarNodo(nDestino);

        if(bO != null && bD != null)
        {
            v1 = buscarAdyacente(nOrigen, bD);
            v2 = buscarAdyacente(nDestino, bO);
            if (v1 != null && v2 != null){
                v1.peso = peso;
                v2.peso = peso;
            }else{
                v1 = new NodoAdyacente(nOrigen, peso);
                v2 = new NodoAdyacente(nDestino, peso);
                if(bO.sigA != null)
                {
                    for(i = bO.sigA; i.sig != null; i = i.sig){}
                    i.sig = v2;
                }else
                {
                    bO.sigA = v2;
                }
                if(bD.sigA != null)
                {
                    for(i = bD.sigA; i.sig != null; i = i.sig){}
                    i.sig = v1;
                }else
                {
                    bD.sigA = v1;
                }
            }
        }
    }
    
    public void insertarArcoArchivoUni (String nOrigen, String nDestino, int peso){
        Nodo bO, bD;
        NodoAdyacente v, i;
        bO = buscarNodo(nOrigen);
        bD = buscarNodo(nDestino);

        if(bO != null && bD != null)
        {
            v = buscarAdyacente(nDestino, bO);
            if (v != null){
                v.peso = peso;
            }else{
                v = new NodoAdyacente(nDestino, peso);
                if(bO.sigA != null)
                {
                    for(i = bO.sigA; i.sig != null; i = i.sig){}
                    i.sig = v;
                }else
                {
                    bO.sigA = v;
                }
            }
        }
    }
    
    @Override
    public String toString () {
        String cad = "";
        Nodo i;
        NodoAdyacente j;
        for(i = raiz; i != null; i = i.sig){
            cad += i;
            for(j = i.sigA; j != null; j = j.sig){
                cad += j;
            }
            cad += "\n";
        }
        return cad;
    }
    
    public void cargarArchivo (String nombre, String opc){
        File v1 = new File(nombre);
        if (v1.exists())
        {
            try
            {
                BufferedReader br = new BufferedReader (new FileReader(nombre));
                String line;

                while((line = br.readLine()) != null)
                {
                    String parts [] = line.split("-");
                    this.insertarNodoArchivo(parts[0]);
                    for(int i = 1;i < parts.length; i+=2){
                        if(opc.equals("1")){
                            this.insertarArcoArchivoUni(parts[0], parts[i], parseInt(parts[i+1])); 
                        }else{
                            this.insertarArcoArchivoBidi(parts[0], parts[i], parseInt(parts[i+1]));                             
                        }
                    }
                }
            }catch(IOException e){
                System.out.println("ERROR de archivo");
            }         
        }
        else
            System.out.println("El Archivo no existe");     
    }
    
    public void insertarHeu(){
        if(heu == null){
            System.out.println("No existen nodos en el grafo");
        }else{
            Scanner sc = new Scanner(System.in);
            Htica h;
            for(int i=0; i<heu.size(); i++){
                h = heu.get(i);
                System.out.print("Inserta la heuristica para "+h.id+": ");
                h.heu = sc.nextInt();
                heu.set(i, h);
            }
        }
    }
    
    public void imprimirHeu(){
        if(heu == null){
            System.out.println("No existen nodos en el grafo");
        }else{
            Htica h;
            for(int i=0; i<heu.size(); i++){
                h = heu.get(i);
                System.out.println(h);
            }
        }
    }
    
    public void reiniciarRep () {
        Nodo aux;
        for (aux = raiz; aux != null; aux = aux.sig){
            aux.rep = 0;
        }
    }
    
    public void greedy (String ni, String nd) {
        Nodo init = buscarNodo(ni);
        Nodo dest = buscarNodo(nd);
        if (init != null && dest != null){
            NodoAdyacente aux;
            Nodo actual = init;
            String s, cod = init.id, cad = actual.id;
            Htica check;
            int i, better;
            reiniciarRep();
            while(!actual.id.equals(dest.id) && actual.rep != 3){
                better = 100000;
                for(aux = actual.sigA; aux != null; aux = aux.sig){
                    s = aux.id;
                    for(i=0; i<heu.size(); i++){
                        check = heu.get(i);
                        if(check.id.equals(s)){
                            if(check.heu < better){
                                better = check.heu;
                                cod = check.id;
                            }
                        }
                    }
                }
                cad+=" -> "+cod;
                actual = buscarNodo(cod);
                actual.rep++;
            }
            System.out.println(cad);
        }
    }
    
    public void A_ast (String ni, String nd) {
        Nodo init = buscarNodo(ni);
        Nodo dest = buscarNodo(nd);
        
        if(init != null && dest != null){ //Verificamos que exiten dichos nodos en el grafo.
            int i, lowcost, index;  //Declaracion de variables para el algoritmo.
            String fin = ni;
            NodoAdyacente aux;
            Nodo actual = init;
            Explorar expObj, expaux;
            Visitados visObj;
            Htica hticaObj;
            ArrayList<Explorar> exp = new ArrayList<>();
            ArrayList<Visitados> vis = new ArrayList<>();
            
            actual.proc = true;  //Procesamos el nodo de inicio.
            vis.add(new Visitados(actual.id, "//"));  //Agregamos dicho nodo al primer visitado.
            for(aux = actual.sigA; aux != null; aux = aux.sig){  //Ciclo para agregar los nodos adyacentes...
                expObj = null;                                   //... a la lista de nodos a explorar.
                for (i=0; i<heu.size(); i++){
                    hticaObj = heu.get(i);
                    if(hticaObj.id.equals(aux.id)){
                        expObj = new Explorar(aux.id, actual.id, aux.peso, (hticaObj.heu+aux.peso));
                    }
                }
                if(expObj != null)
                    exp.add(expObj);
            }

            while (!fin.equals(nd)){ //Proceso del algoritmo A*.
                lowcost = 100000;  //Se inicializa en un valor grande para remplazarce con el valor del costo mas bajo de los nodos a explorar.
                expaux = null;
                index = -1;  //Guarda la posicion del nodo a ser procesado para eliminarlo de la lista de nodos a explorar.
                for (i=0; i<exp.size(); i++){  //Proceso el cual encuentra el valor del costo mas bajo en la lista de nodos a explorar.
                    expObj = exp.get(i);
                    if(expObj.hm < lowcost){
                        expaux = expObj;
                        lowcost = expObj.hm;
                        index = i;
                    }
                }
                actual = buscarNodo(expaux.ady);  //Nos posicionanos en dicho nodo en el grafo para agregar sus adyacentes en caso de tener.
                actual.proc = true;  //Procesamos el nodo que estamos explorando.
                vis.add(new Visitados(expaux.ady, expaux.anterior));  //Se agrega a la lista de nodos visitados.
                exp.remove(index);  //Eliminamos el nodo como lo mencionamos un poco mas arriba.
                if(actual.sigA != null){  //Si el nodo que estamos explorando no tiene nodos adyacentes se salta todo esto.
                    for (aux = actual.sigA; aux != null; aux = aux.sig){  //Nos movemos 1 a 1 los nodos adyacentes del nodo en cuestion.
                        if(buscarNodo(aux.id).proc != true){  //Condicion para verificar que tal nodo adyacente no haya sido explorado anteriormente.
                            expObj = null;
                            for(i=0; i<heu.size(); i++){  //Recorremos la lista de heuristicas en busca de la heuristica del nodo adyacente.
                                hticaObj = heu.get(i);
                                if(hticaObj.id.equals(aux.id)){ //Una vez encontrado creamos el objeto (un nodo) para agregarlo a la lista de nodos a explorar.
                                    expObj = new Explorar(aux.id, actual.id, (aux.peso+expaux.peso), (aux.peso+expaux.peso+hticaObj.heu));
                                }
                            }
                            if(expObj != null)
                                exp.add(expObj);  //Agrega el nodo a la lista de nodos a explorar.
                        }
                    }
                }
                fin = actual.id;  //Actualizamos de que nodo acabamos de trabajar, para garantizar el ciclo while hasta que encuentre el nodo destino.
            }
            
            String cad = ""; //Declaracion de variables para imprimir el camino que ya se encuentra en la lista de nodos visitados.
            Visitados auxV;            
            
            visObj = vis.get(vis.size()-1);  //Obtenemos el ultimo elemento de dicha lista ya que es el que conecta el destino con su anterior.
            auxV = visObj;  //Auxiliar utilizado para el ciclo de abajo.
            cad += visObj+"\n";  //Agregamos dicho elemento a una cadena que mostrara el camino al final.
            while(!auxV.anterior.equals(ni)){  //Mientras no encontremos el nodo de inicio se buscara un anterior del elemento.
                for(i=0; i<vis.size(); i++) {  //Recorremos la lista de nodos visitados.
                    visObj = vis.get(i);
                    if(visObj.visitado.equals(auxV.anterior)){  //Condicion para actualizar el elemento anterior del ciclo while....
                        auxV = visObj;                          //... ,es decir, nos movemos 1 nodo hacia atras conforme al elemento auxV.
                        cad += auxV+"\n";  //Agregamos otra parte del camino.
                    }
                }
            }
            System.out.println(cad);  //Cuando finalize el ciclo imprimimos el camino correctamente.
        }
    }
    
    public void IDA (String ni, String nd){
        Nodo init = buscarNodo(ni);  //Buscamos los nodos inicio y destino
        Nodo dest = buscarNodo(nd);
        if(init != null && dest != null){  //Verificamos que dichos nodos existen en el grafo.
            ArrayList<String> path = new ArrayList();  //Declaracion de variables utilizadas en la primera parte del algoritmo.
            int i, umbral = 0, temp;
            Htica hticaObj;
            
            for(i = 0; i < heu.size(); i++){  //Se inicializa el umbral de acuerdo a la heuristica del nodo inicio.
                hticaObj = heu.get(i);
                if(hticaObj.id.equals(init.id))
                    umbral = hticaObj.heu;
            }
            path.add(init.id);  //Añadimos ese nodo a la pila que al final contendra el camino encontrado.
            while (true){  //Ciclo que mantiene el recorrido del algoritmo hasta sobrepasar el limite de umbral en este caso o cuando encuentre el nodo destino.
                temp = nextNode(path, 0, umbral, nd);  //este temp obtendra la informacion despues de hacer todo el recorrido con el umbral dado.
                if(temp == -1)  //Si se encontro el nodo destino finalizara el ciclo
                    break;
                if(temp > 7)  //Si no encontro el nodo destino y ya sobrepasamos el limite del umbral, detendra el ciclo igualmente.
                    break;
                umbral = temp;  //De no cumplirse los condiciones anteriores se modificara nuestro umbral al siguiente menor encontrado y vuelve a realizar el ciclo.
            }
            if(temp == -1){  //Si encontramos el camino, imprimimos la pila.
                for(String ls : path){
                    System.out.print(ls+" -> ");
                }
            }else  //Caso contrario no encontro el camino e informamos.
                System.out.println("No se encontro el camino.");
            System.out.print("\n");
        }
    }
    
    public int nextNode(ArrayList<String> path, int gscore, int umbral, String nd){  //Funcion recursiva que realiza el recorrido de acuerdo al umbral dado arriba.
        String s = path.get(path.size()-1);  //Declaracion de variables utilizadas en la funcion.
        Nodo act = buscarNodo(s);            //... Obtenemos el ultimo nodo de la pila, este sera evaluado.
        NodoAdyacente aux;
        Htica hticaObj;
        int f=0, min=100;
        
        
        for (int i = 0; i<heu.size(); i++){  //Encontramos la heurisitica de tal nodo y calculamos f(n) = g(n) + h(n)
            hticaObj = heu.get(i);
            if(hticaObj.id.equals(act.id))
               f = gscore + hticaObj.heu; 
        }
        if(f > umbral)  //Si f(n) sobrepasa el umbral no continuamos camino y podamos camino hasta aqui.
            return f;
        if(act.id.equals(nd))  //Si no sobrepasa el umbral y encontro el nodo destino retornamos -1, indicando que encontramos el nodo destino.
            return -1;
        if(act.sigA != null){  //Si ninguna de las dos condiciones se cumple, procedemos a seguir buscando el nodo destino. revisamos que dicho nodo tenga adyacentes.
            for(aux = act.sigA; aux != null; aux = aux.sig){  //Si tiene, nos movemos 1 a 1 a traves de ellos.
                path.add(aux.id);  //Agregamos dicho nodo al posible camino.
                int temp = nextNode(path, gscore+aux.peso, umbral, nd);  //Volvemos a llamar a la funcion para hacer todo el proceso anterior con el nuevo nodo.
                if(temp == -1)  //Si esta en funcion recursiva evaluamos al haber retorno. Si encontro el nodo destino retornamos -1 al temp principal de IDA.
                    return -1;
                if(temp < min)  //Si no encontro el destino evaluamos dicho valor de f(n) para posible valor del siguiente umbral.
                    min = temp;
                path.remove(path.size()-1);  //Y removemos el nodo puesto que no es camino a seguir por aqui.
            }
        }
        return min; //Si no encontro nodos adyacentes o termino de recorrer lo mas que pudo deacuerdo al umbral, retornamos el siguiente valor de umbral.
    }
    
}
