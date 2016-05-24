package Drivers;

import java.util.Scanner;

import domini.Camp;

/**
 *
 * @author chus
 */
public class CampTest {
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println ("Probamos la clase Camp");
        System.out.println ("1. set nom");
        System.out.println ("2. set path");
        System.out.println ("3. set descripcio");
        System.out.println ("4. set quant");
        System.out.println ("5. set minim");
        System.out.println ("6. get nom");
        System.out.println ("7. get path");
        System.out.println ("8. get descripcio");
        System.out.println ("9. get quant");
        System.out.println ("10. get minim");
        System.out.println ("-1. para salir");
        System.out.println ("Por favor introduce una opcion:");
        
        Scanner in = new Scanner (System.in); //Creación de un objeto Scanner
        int op = Integer.parseInt(in.nextLine()); //Invocamos un método sobre un objeto Scanner
        Camp c = new Camp();
        String nom;
        while (op != -1) {
            switch(op) {
                case 1:
                    nom = in.nextLine();
                    c.getPath().setNom(nom);
                    break;
                case 2:
                    String path = in.nextLine();
                    c.getPath().setContingut(path);
                    break;
                case 3:
                    String descripcio = in.nextLine();
                    c.getPath().setDescripcio(descripcio);
                    break;
                case 4:
                    Float quant = Float.parseFloat(in.nextLine());
                    c.setQuant(quant);
                    break;
                case 5:
                    int minim = Integer.parseInt(in.nextLine());
                    c.setMinim(minim);
                    break;
                case 6:
                    System.out.println ("Devuelve el nom: " + c.getPath().getNom() + "");
                    break;
                case 7:
                    System.out.println ("Devuelve el path: " + c.getPath().getStringPath() + "");
                    break;
                case 8:
                    System.out.println ("Devuelve la descripcio: " + c.getPath().getDescripcio() + "");
                    break;
                case 9:
                    System.out.println ("Devuelve el quant: " + c.getQuant() + "");
                    break;
                case 10:
                    System.out.println ("Devuelve el minim: " + c.getMinim() + "");
                    break;
                default: System.out.println("Opcion no valida.");
                    break;
            }
            System.out.println ("Por favor introduce una opcion: ");
            op = Integer.parseInt(in.nextLine());
        }
    }
} 
