package Drivers;


import domini.Node;
import java.util.Scanner;

/**
 *
 * @author Alejandro Ibañez
 */
public class NodeTest {
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println ("Probamos la clase Node");
        System.out.println ("Por favor introduce una opcion:");
        System.out.println ("1. set nom");
        System.out.println ("2. set Id");
        System.out.println ("3. set label");
        System.out.println ("4. set Tipus");
        System.out.println ("5. get nom");
        System.out.println ("6. get id");
        System.out.println ("7. get label");
        System.out.println ("8. get tipus");
        System.out.println ("9. Inicializa un nodo");
        System.out.println ("-1. para salir");
        
        Scanner in = new Scanner (System.in); //Creación de un objeto Scanner
        int op = Integer.parseInt(in.nextLine()); //Invocamos un método sobre un objeto Scanner
        Node n = new Node();
        String nom;
        while (op != -1) {
            switch(op) {
                case 1:
                    nom = in.nextLine();
                    n.setNom(nom);
                    break;
                case 2:
                    int id = Integer.parseInt(in.nextLine());
                    n.setId(id);
                    break;
                case 3:
                    System.out.println ("El label por defecto es AI");
                    n.setLabel(Node.Label.AI);
                    break;
                case 4:
                    System.out.println ("La entidad por defecto es Autor");
                    n.setTipus(Node.Type.Autor);
                    break;
                case 5:
                    System.out.println ("Devuelve el nom: " + n.getNom() + "");
                    break;
                case 6:
                    System.out.println ("Devuelve el id: " + n.getId()+ "");
                    break;
                case 7:
                    System.out.println ("Devuelve el label: " + n.getLabel()+ "");
                    break;
                case 8:
                    System.out.println ("Devuelve el tipus: " + n.getTipus() + "");
                    break;
                case 9:
                    n.initialize(Node.Type.Autor, 0, "NodeTest");
                    //System.out.println ("Devuelve el tipus: " + n.getTipus() + "");
                    break;
                    
                default: System.out.println("Opcion no valida.");
                    break;
            }
            System.out.println ("Por favor introduce una opcion: ");
            op = Integer.parseInt(in.nextLine());
        }
    }
}
