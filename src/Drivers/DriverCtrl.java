/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers;

import domini.Camp;
import domini.CtrlDominio;
import domini.Graph;
import domini.Node;
import domini.PathException;
import domini.PlantillaPerfil;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Ibáñez
 */
public class DriverCtrl {
    
    
    public static void main(String [] args) throws PathException, IOException {
    System.out.println("Puede realizar las siguientes acciones introduciendo el numero indicado: \n"
                + 
                "2.- Generar un perfil.\n" +
                "Si desea salir del test introduzca un 1. \n");
        ArrayList<Camp> c = new ArrayList<>();
        Camp campo = new Camp();
        campo.setPath("Publicacions","Publicacions d'un autor","APCPA");
        campo.setQuant(0.8f);
        campo.setMinim(-1);
        c.add(campo);        
        PlantillaPerfil pp = new PlantillaPerfil("PlantillaTest",Node.Type.Autor,c);
        //Publicacions
        Scanner in = new Scanner (System.in);
        int op = Integer.parseInt(in.nextLine());
        Boolean end = false;
        while (!end) {
            switch(op) {
                case 1:
                    end = true;
                    break;
                   
                case 2:
                    System.out.print("Se va a generar el perfil con la PlantillaPerfil"
                            + "predeterminada de Autor\n");
                    CtrlDominio ctrl = new CtrlDominio();
                    ctrl.generarPerfil(pp);
                    break;
           }   
    
         }
    }
}
