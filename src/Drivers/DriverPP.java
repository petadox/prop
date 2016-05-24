package Drivers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import domini.Camp;
import domini.Node;
import domini.PlantillaPerfil;
import persistencia.ControladorGD;


public class DriverPP {
	
	private static void action() throws IOException {
        System.out.println("Puede realizar las siguientes acciones introduciendo el numero indicado: \n"
                + "1 - Set nom.\n" +
                "2.- Set tipus.\n" +
                "3 - Set info.\n" +
                "4 - Get nom.\n" +
                "5 - Get tipus.\n" +
                "6 - Get info.\n" +
                "7 - Get tamany.\n" +
                "8 - Modificar la plantilla.\n" +
                
                "Si desea salir del test introduzca un 0. \n");
    }
	
	public static void main (String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
        PlantillaPerfil pp = new PlantillaPerfil();
        System.out.println("Quina plantilla de perfil vol cargar? \n");
    	String nomPPC = in.nextLine();
        pp = ControladorGD.cargarPlantilla(nomPPC);
        ArrayList<Camp> aux = new ArrayList<Camp>();
        Boolean end = false;
        while (!end) {
        	action();
        	int op = Integer.parseInt(in.nextLine());
            switch (op) {
                case 0:
                    end = true;
                    break;

                case 1:
                	System.out.println("Introdueix el nom de la plantilla: \n");
                	pp.setNom(in.nextLine());
                	System.out.println("OK! \n");
                    break;

                case 2:
                    System.out.println("Introduzca el type de la plantilla: \n");
                    String tipo = in.nextLine();
                    if(tipo == "Autor"){
                    	pp.setTipus(Node.Type.Autor);
                    }
                    else if(tipo == "Conferencia"){
                    	pp.setTipus(Node.Type.Conferencia);
                    }
                    else if(tipo == "Terme"){
                    	pp.setTipus(Node.Type.Terme);
                    }
                    else if(tipo == "Paper"){
                    	pp.setTipus(Node.Type.Paper);
                    }
                    System.out.println("OK! \n");
                    break;
                    
                case 3:
                    Boolean next = true;
                    Camp c = new Camp();
                    while(next){
	                    System.out.println("Introduzca la informacion de la plantilla:\n");
	                    System.out.println("Descripcio camp: ");
	                    String descC = in.nextLine();
	                    System.out.println("\n");
	                    System.out.println("Nom camp: ");
	                    String nomC = in.nextLine();
	                    System.out.println("\n");
	                    System.out.println("Path camp: ");
	                    String pathC = in.nextLine();
	                    System.out.println("\n");
	                    c.setPath(descC, nomC, pathC);
	                    System.out.println("Quant camp: ");
	                    Float quant = Float.parseFloat(in.nextLine());
	                    c.setQuant(quant);
	                    System.out.println("\n");
	                    System.out.println("Minim camp: ");
	                    int minim = Integer.parseInt(in.nextLine());
	                    c.setMinim(minim);
	                    System.out.println("\n");
	                    pp.setInfo(c);
	                    
	                    System.out.println("Si quiere introducir mas campos pulse 1, sino pulse 0: ");
	                    next = Boolean.parseBoolean(in.nextLine());
	                    
	                    System.out.println("Ok! \n");
                    }
                    
                	System.out.println("Plantilla creada.\n");
                    break;

                case 4:
                	System.out.println("El nombre de la plantilla es: " + pp.getNom() + "\n");
                	break;
                
                case 5:
                	Node.Type tipus = pp.getTipus();
                	String s = "Paper";
                	if(tipus == Node.Type.Autor) s = "Autor";
                	else if(tipus == Node.Type.Conferencia) s = "Conferencia";
                	else if(tipus == Node.Type.Terme) s = "Terme";
                	System.out.println("El tipus de la plantilla es: " + s + "\n");
                	break;
                	
                case 6:
                	aux = pp.getInfo();
                	Iterator<Camp> it = aux.iterator();
                	while(it.hasNext()){
            			c = it.next();
            			s = c.getPath().getNom();
            			System.out.println("Nom del Camp: " + s + "\n");
            			s = c.getPath().getStringPath();
            			System.out.println("Path del Camp: " + s + "\n");
            			s = c.getPath().getDescripcio();
            			System.out.println("Descripcio del Camp: " + s + "\n");
            			s = c.getQuant().toString();
            			System.out.println("Quant del Camp: " + s + "\n");
            			s = Integer.toString(c.getMinim());
            			System.out.println("Minim del Camp: " + s + "\n");
            		}
                	break;
                	
                case 7:
                	System.out.println("La longitud del vector de camps es de : " + Integer.toString(pp.getTam()) + "\n");
                	break;
                
                case 8:
                	System.out.println("Introdueixi valors per a modificar la plantilla\n");
                	String accio, element, nou;
                	System.out.println("Introdueixi accio (afegir/modificar/borrar).\n");
                	accio = in.nextLine();
                	System.out.println("Introdueixi element (nom/path/descripcio/quant/minim).\n");
                	element = in.nextLine();
                	System.out.println("Introdueixi un nou nom si ha elegit modificar, altrament introdueixi cualsevol caracter.\n");
                	nou = in.nextLine();
                	pp.modificarPlant(accio, element, nou);
                	System.out.println("Plantilla modificada\n");
                	break;
                	
                case 9:
                	pp.ppArticleDet();
            }
        }
	}
}
