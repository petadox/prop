
package Drivers;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

import domini.Perfil;

/**
 *
 * @author Eduard Maestro
 */
public class PerfilTest {
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println ("Probamos la clase Perfil");
        System.out.println ("Por favor introduce una opcion:");
        System.out.println ("1. set nomPerfil");
        System.out.println ("2. set nomPlantilla");
        System.out.println ("3. get nomPerfil");
        System.out.println ("4. get nomPlantilla");// No se probarlo;
        System.out.println ("5. anadir fila"); // Tambien comprueba getCampPle;
        System.out.println ("6. get Camp"); // Retorna una fila de la matriz;
        
        Scanner in = new Scanner (System.in); //Creación de un objeto Scanner
        int op = Integer.parseInt(in.nextLine()); //Invocamos un método sobre un objeto Scanner
        Perfil p = new Perfil();
        String nom;
        Integer id;
        
        ArrayList<String> b = new ArrayList<>();
        b.add("Holaaa"); b.add("Adiioioios!");
        ArrayList<String> a = new ArrayList<>();
        a.add("A");
        p.anadirFila(a);
        a = new ArrayList<>();
        a.add("A");
        a.add("Bah");
        p.anadirFila(a);
                    
        while (op != -1) {
            switch(op) {
                case 1:// set nomPerfil;
                    nom = in.nextLine();
                    p.setNomPerfil(nom);
                    break;
                case 2: // set nomPlantilla;
                    nom = in.nextLine();
                    p.setNomPlantilla(nom);
                    break;
                case 3:// seta y nomPerfiloso!
                    System.out.println ("Devuelve el nombre del perfil: " + p.getNomPerfil() + "");
                    break;
                case 4:
                    System.out.println ("Devuelve el nombre de la plantilla: " + p.getNomPlantilla() + "");
                    break;
                case 5: 
                    // En este comprobamos que funciona tanto getCampPle(enseña bien por pantalla la matriz)
                    // como anadirFila, que va añadiendo el vector a la matriz.
                    p.anadirFila(b);
                    System.out.println ("Ensenamos por pantalla la matriz" + p.getCampPle() + "");
                    break;
                case 6:
                    id = parseInt(in.nextLine(),10);
                    System.out.println ("La fila " + id + " contiene: " + p.getCamp(id) + "");
                    break;
                default: System.out.println("Opcion no valida.");
                    break;
            }
            System.out.println ("Por favor introduce una opcion: ");
            op = Integer.parseInt(in.nextLine());
        }
    }
}
