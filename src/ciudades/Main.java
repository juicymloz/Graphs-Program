/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciudades;

import java.util.Scanner;

/**
 *
 * @author juane
 */
public class Main {
    
    public static void main(String[] args) {
        
        Grafo grafito = new Grafo();
        Scanner sc = new Scanner(System.in);
        int op, peso;
        String s1, s2;
        
        do{
            System.out.println("--MENU--\n"
                    + "1. Insertar Nodo\n"
                    + "2. Insertar Arista\n"
                    + "3. Imprimir Grafo\n"
                    + "4. Cargar de un Archivo\n"
                    + "5. Insertar Heuristicas\n"
                    + "6. Revisar Heuristicas\n"
                    + "7. Aplicar Greedy\n"
                    + "8. Aplicar A*\n"
                    + "9. Aplicar IDA*\n"
                    + "0. Terminar ejecucion");
            op = sc.nextInt();
            switch(op)
            {
                case 1:
                    System.out.print("Ingresa el nombre del nodo: ");
                    s1 = sc.next();
                    grafito.insertarNodo(s1);
                    break;
                case 2:
                    System.out.print("Ingresa el nombre del nodo origen: ");
                    s1 = sc.next();
                    System.out.print("Ingresa el nombre del nodo destino: ");
                    s2 = sc.next();
                    System.out.print("Ingresa el peso de la arista: ");
                    peso = sc.nextInt();
                    grafito.insertarArco(s1, s2, peso);
                    break;
                case 3:
                    System.out.println(grafito);
                    break;
                case 4:
                    System.out.print("Escribe el nombre de tu archivo: ");
                    s1 = sc.next();
                    System.out.print("Escribe 1-Grafo unidireccional, 2-Bidireccional: ");
                    s2 = sc.next();
                    grafito.cargarArchivo(s1, s2);
                    break;
                case 5:
                    grafito.insertarHeu();
                    break;
                case 6:
                    grafito.imprimirHeu();
                    break;
                case 7:
                    System.out.print("Introduce el nodo inicio: ");
                    s1 = sc.next();
                    System.out.print("Introduce el nodo destino: ");
                    s2 = sc.next();
                    grafito.greedy(s1, s2);
                    break;
                case 8:
                    System.out.print("Introduce el nodo inicio: ");
                    s1 = sc.next();
                    System.out.print("Introduce el nodo destino: ");
                    s2 = sc.next();
                    grafito.A_ast(s1, s2);
                    break;
                case 9:
                    System.out.print("Introduce el nodo inicio: ");
                    s1 = sc.next();
                    System.out.print("Introduce el nodo destino: ");
                    s2 = sc.next();
                    grafito.IDA(s1, s2);
                    break;
                case 0:
                    op = 0;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(op != 0);       
    
    }
    
}
