package domini;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduard Maestro
 */
public class Perfil {
  
    private String nomPerfil;
    private String nomPlantilla; // Un perfil se hace a base de una plantilla;
    Node node;
    private ArrayList<ArrayList<String>>  CampsPerfil;
    // Cada fila sera el equivalente a un camp del ArrayList<Camp> de
    // la clase Plantilla; La fila 0 equivaldra a la posición 0 del array.
    /*
        Plantilla tiene:
            protected string nomPlantilla;
            protected string tipus; // Entitats;
            protected ArrayList<Camp> info;
    */
    
    public Perfil() {
        nomPerfil = new String();
        nomPlantilla = new String();
        node = new Node();
        CampsPerfil = new ArrayList<>();
    }
    
    public Perfil(PlantillaPerfil plant, Node nodeparametre, String nom) {
        nomPerfil = new String();
        nomPerfil = nom;
        nomPlantilla = new String();
        node = new Node();
        node = nodeparametre;
        // int n = plant.getSize();
        nomPlantilla = plant.getNom();
        CampsPerfil = new ArrayList<>();
        
    }
    
    //Pre: Perfil esta creat.
    //Post: El nom del perfil pasa a ser "nom".
    public void setNomPerfil(String nom) {
        nomPerfil = nom;
    }
    
    //Pre: Perfil esta creat.
    //Post: El nomPlantilla de perfil pasa a ser "nom".
    public void setNomPlantilla (String nom) {
        nomPlantilla = nom;
    }
    
    //Pre: Cert.
    //Post: Retorna el nom del perfil.
    public String getNomPerfil() {
        return nomPerfil;
    }
    
    //Pre: Cert.
    //Post: Retorna el nom de la plantilla del perfil.
    public String getNomPlantilla() {
        return nomPlantilla;
    }

    //Pre: La fila numFila esta vacia.
    //Post: La fila numFila pasa a tener el ArrayList<Node> a.
    public void anadirFila(ArrayList<String> a) {
        CampsPerfil.add(a);
    }
    
    //Pre: Cert.
    //Post: Retorna la matriu entera.
    public ArrayList<ArrayList<String>> getCampPle() {
        return CampsPerfil;
    }
    
    /* Pre: Cert.
       Post: Retorna el ArrayList de la posicio "index" del ArrayList CampsPerfil.
       Si no es buit, aquest ArrayList es el ArrayList PLE de la posicio "index" del
       ArrayList de camps de la clase PlantillaPerfil.
    */
    public ArrayList<String> getCamp(int index) {
        return this.CampsPerfil.get(index);
    }
    
    public String getTipus(){
    	Node.Type tipus = node.getTipus();
    	if(tipus.equals("Autor")) return "Autor";
    	else if(tipus.equals("Paper")) return "Paper";
    	else if(tipus.equals("Conferencia")) return "Coferencia";
    	return "Terme";
    }

	public void actualizaNombre(Integer i, Integer j, String nomNou, Boolean borraNom) {
		ArrayList<String> array;
		array = this.CampsPerfil.get(i);
		array.remove(j.intValue());
		if (!borraNom) array.add(j, nomNou);
	}

	public void anadirNombre(Integer i, String nomNou) {
		this.CampsPerfil.get(i).add(nomNou);
	}
}
