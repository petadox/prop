
package Drivers;

import java.util.Scanner;

import domini.Path;

/**
 *
 * @author Eduard Maestro
 */
public class PathTest {
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println ("Probamos la clase Path");
        System.out.println ("Por favor introduce una opcion:");
        System.out.println ("1. set Contingut");
        System.out.println ("2. set Descripcio");
        System.out.println ("3. set Nom");
        System.out.println ("4. ReversePath");// No se probarlo;
        System.out.println ("5. get Length");
        System.out.println ("6. get Descripcio");
        System.out.println ("7. get Contingut");
        System.out.println ("8. get Nom");
        System.out.println ("9. get paths divididos"); // Devuelve los dos paths;
        System.out.println ("10. get String Path");
        // System.out.println ("11. String a Path"); //Ya funciona por que lo usa set contingut.
        //Como setContingut usa esta funcion, entiendo que si funciona una funcionan las dos.
        System.out.println ("-1. Para salir");
        
        Scanner in = new Scanner (System.in); //Creación de un objeto Scanner
        int op = Integer.parseInt(in.nextLine()); //Invocamos un método sobre un objeto Scanner
        Path p = new Path();
        String nom;
        while (op != -1) {
            switch(op) {
                case 1:// set contingudo;
                    nom = in.nextLine();
                    p.setContingut(nom);
                    break;
                case 2: // set descripciono
                    nom = in.nextLine();
                    p.setDescripcio(nom);
                    break;
                case 3:// seta y nombre!
                    nom = in.nextLine();
                    p.setNom(nom);
                    break;
                case 4:
                    System.out.println ("Devuelve path invertido: " + p.reversePath() + "");
                    break;
                case 5:
                    System.out.println ("Devuelve el length del path: " + p.getLength() + "");
                    break;
                case 6:
                    System.out.println ("Devuelve la descripcio: " + p.getDescripcio() + "");
                    break;
                case 7:
                    System.out.println ("Devuelve el contingut del path: " + p.getContingut() + "");
                    break;
                case 8:
                    System.out.println ("Devuelve el nom del path: " + p.getNom() + "");
                    break;
                case 9:
                    System.out.println ("Devuelve el nom del path: \n" + p.getPath().first + "\n" +
                            p.getPath().second + " ");
                    break;
                case 10:
                    System.out.println ("Devuelve el nom del path: " + p.getStringPath() + "");
                    break;
                default: System.out.println("Opcion no valida.");
                    break;
            }
            System.out.println ("Por favor introduce una opcion: ");
            op = Integer.parseInt(in.nextLine());
        }
    }
}
