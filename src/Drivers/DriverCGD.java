package Drivers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;
import domini.Camp;
import domini.Node;
import domini.Perfil;
import domini.PlantillaPerfil;
import persistencia.ControladorGD;

public class DriverCGD {
	private static void action() throws IOException {
        System.out.println("Puede realizar las siguientes acciones introduciendo el numero indicado: \n"
        		+ "Se han generado una plantilla perfil y un perfil para testear esta clase \n"
                + "1 - Guardar Perfil.\n" +
                "2.- Guardar Plantilla.\n" +
                "3 - Cargar Perfil.\n" +
                "4 - Cargar Plantilla.\n" +
                
                "Si desea salir del test introduzca un 0. \n");
    }
	
	public static void main (String args[]) throws IOException, FicheroNoExiste, FicheroYaExistente{
		Camp c = new Camp();
		c.setPath("path de prova", "Albert", "APA");
		c.setQuant((float)0.7);
		c.setMinim(-1);
		ArrayList<Camp> info = new ArrayList<Camp>();
		info.add(c);
        PlantillaPerfil pp = new PlantillaPerfil("nomPlantilla", Node.Type.Autor , info);
        Node n = new Node();
        n.initialize(Node.Type.Autor, 007, "Albert R");
        Perfil p = new Perfil(pp, n, "nomPerfil");
        
        Scanner in = new Scanner(System.in);
        Boolean end = false;
        while (!end) {
        	action();
        	int op = Integer.parseInt(in.nextLine());
            switch (op) {
                case 0:
                    end = true;
                    break;

                case 1:
                	System.out.println("Introdueix nom pel Perfil\n");
                	String nomP = in.nextLine();
                	ControladorGD.guardarPerfil(p, nomP);
                	System.out.println("Perfil guardat correctament \n");
                	
                case 2:
                	System.out.println("Introdueix nom per la PlantillaPerfil\n");
                	String nomPP = in.nextLine();
                	ControladorGD.guardarPlantilla(pp, nomPP);
                	System.out.println("Plantilla guardada correctament \n");
                	
                case 3:
                	System.out.println("Quin perfil vol cargar? \n");
                	String nomPC = in.nextLine();
                	p = ControladorGD.cargarPerfil(nomPC);
                	System.out.println("Carregat el perfil " + p.getNomPerfil() + " correctament \n");
                	
                case 4:
                	System.out.println("Quina plantilla de perfil vol cargar? \n");
                	String nomPPC = in.nextLine();
                	pp = ControladorGD.cargarPlantilla(nomPPC);
                	System.out.println("Carregada la plantilla "+ pp.getNom() + " correctament \n");
                	
            }
        }
	}
}
