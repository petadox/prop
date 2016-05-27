/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domini;

import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

import persistencia.CtrlDataGraph;
import persistencia.GestioDades;

import java.util.Scanner;
import persistencia.ControladorGD;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author Alejandro Ibáñez
 */


public class CtrlDominio {
	protected static Graph actual;
	private static Perfil perfilActual;
	private static PlantillaPerfil plantillaActual;
	
	private static CtrlDataGraph CtrlDG;
    private static ControladorGD CtrlGD;
	
    public CtrlDominio() {
    	actual = new Graph();
    	perfilActual = new Perfil();
    	plantillaActual = new PlantillaPerfil();
    	CtrlDG = new CtrlDataGraph();
    	CtrlGD = new ControladorGD();
        
    }
    
    private ArrayList<String> convert (ArrayList<Pair<Integer,Float>> array, Camp c,Node n) throws IOException {
        ArrayList<String> res = new ArrayList<String>();
        
        Collections.sort(array, Comparator.comparing(p -> -p.second));
        Collections.reverse(array);
        // Queda el ArrayList ordenado de mayor a menor (1 y va bajando);
        
        int size = array.size();
        String nomReal;
        float quant = c.getQuant();
        int min = c.getMinim();
        if (min == -1) {
	        for (int i = size - 1; i >= 0; --i) {
	        	if (array.get(i).second >= quant) {
	        		if (!array.get(i).first.equals(n.getId())) {
	                nomReal = nomNode(array.get(i).first,c.getPath().tipoUltimaLetra(c.getPath().getStringPath()));
	                res.add(nomReal);
	        		}
	        	}
	        }
	        return res;
        }
        else { // Aqui Quant ser� -1 y he de sacar los min elementos mas importantes;
        	if (size < min) min = size;
        	for (int i = min-1; i >= 0; --i) {
	                nomReal = nomNode(array.get(i).first,c.getPath().tipoUltimaLetra(c.getPath().getStringPath()));
	                res.add(nomReal);
	        }
        	return res;
        }
    }
    
    public  void generarPerfil(PlantillaPerfil p,Node n,String nom) throws PathException, IOException {
       HeteSanic hetesanic = new HeteSanic();
       hetesanic.setGraph(actual);
       ArrayList<Camp> c = p.getInfo();
       perfilActual = new Perfil(p,n,nom);
            for (int i = 0; i < c.size(); i++) {
                ArrayList<Pair<Integer,Float>> res = new ArrayList<Pair<Integer,Float>>();
                res = hetesanic.getHeteSim(c.get(i).getPath(), n);
                perfilActual.anadirFila(convert(res,c.get(i),n));
            }
    }
    
    public void mostrarPerfil(Perfil p) {
       ArrayList< ArrayList<String> > a = p.getCampPle();
       for (int i = 0; i < a.size(); i++) {          
    	   for (int j = 0; j < a.get(i).size(); j++) {
               System.out.print("Holi: " + a.get(i).get(j) + " ");
           }
           System.out.print("\n");
       }
    }
    
    public Node.Type stringToType(String aux) {
        int i = aux.length();
        --i;
        char c = aux.charAt(i);
        switch(c) {
            case 'A':
                return Node.Type.Autor;
            case 'C':
                return Node.Type.Conferencia;
            case 'P':
                return Node.Type.Paper;
            case 'T':
                return Node.Type.Terme;
            default:
                return null;
        }
    }
    
    public String nomGraf() {
    	return actual.getNom();
    }
    
    public void setNomActual(String n) {
    	actual.setNom(n);
    }
    
    private String nomNode(int id,Node.Type tipus) throws IOException {
        CtrlImport ctrl = new CtrlImport("C:\\Users\\chus\\Documents\\PracticaPROPEclipse\\ProjectePROP\\BaseDades\\DBLP_four_area");
        ctrl.loadGraphInfo();
        Graph g = ctrl.getGraph();
        Node n = g.getNode(id, tipus);
        return n.getNom();
    }
    
    public void guardarPerfil() throws IOException, FicheroYaExistente, FicheroNoExiste {
    	ControladorGD.guardarPerfil(perfilActual);
    }
    
    public void cargarPlantilla(String ruta) throws NumberFormatException, FicheroNoExiste, IOException {
    	plantillaActual.borrarCamps();
    	ArrayList<String> aux = ControladorGD.cargarPlantilla(ruta);
    	plantillaActual.setNom(aux.get(0));
    	if(aux.get(1).equals("Autor")) plantillaActual.setTipus(Node.Type.Autor);
    	else if(aux.get(1).equals("Conferencia")) plantillaActual.setTipus(Node.Type.Conferencia);
    	else if(aux.get(1).equals("Terme")) plantillaActual.setTipus(Node.Type.Terme);
    	else if(aux.get(1).equals("Paper")) plantillaActual.setTipus(Node.Type.Paper);
    	for(int i=2; i<aux.size(); i++){
	    	Camp c = new Camp();
	    	String s1, s2, s3, s4, s5;
	    	s1 = aux.get(i);i++; s2 = aux.get(i); i++; s3 = aux.get(i);i++; s4 = aux.get(i);i++; s5 = aux.get(i);
	    	c.setPath(s2, s1, s3);
	    	c.setQuant(Float.parseFloat(s4));
	    	c.setMinim(Integer.parseInt(s5));
	    	plantillaActual.setInfo(c);
    	}
    }

    
    public Perfil cargarPerfil(String ruta) throws FicheroNoExiste, IOException {
        return ControladorGD.cargarPerfil(ruta);
    }
        
    public void guardarPerfil(Perfil p) throws IOException, FicheroYaExistente, FicheroNoExiste {
        ControladorGD.guardarPerfil(p);
    }
    
    public Graph getCurrentGraph() throws IOException {
       CtrlImport ctrl = new CtrlImport("directorio");
       ctrl.loadGraphInfo();
       actual = ctrl.getGraph();
       return actual;
    }
    
    public void actualizarGraph(Graph g) {
    	actual = g;
    }
    
    public void guardarGraph(String path) throws FileNotFoundException, IOException {
    	CtrlDG.saveGraph(actual,path);
    }
    
    public void guardarNode(String tipus,String nom) throws IOException {
    	if (tipus == "Autor") { actual.addNode(Node.Type.Autor,nom); }
    	else if (tipus == "Conferencia") { actual.addNode(Node.Type.Conferencia,nom); }
    	else if (tipus == "Paper") { actual.addNode(Node.Type.Paper,nom); }
    	else if (tipus == "Term") { actual.addNode(Node.Type.Terme,nom); }
    }
    
    public void borrarNodo(String nom,Integer index,int tipus) {
    	Node n = new Node();
    	if (tipus == 0) {
    		//es autor
    		ArrayList<Node> autors = actual.getAutors();
    		for (int i = 0; i < autors.size(); i++) {
    			if (autors.get(i).getNom().equals(nom) && i == index) {
    				n.initialize(Node.Type.Autor, index, nom);
    			}
    		}
    	}
    	
    	else if (tipus == 1) {
    		//conferencia
    		ArrayList<Node> conf = actual.getConferencies();
    		for (int i = 0; i < conf.size(); i++) {
    			if (conf.get(i).getNom().equals(nom) && i == index) {
    				n.initialize(Node.Type.Conferencia, index, nom);
    			}
    		}
    	}
    	
    	else if (tipus == 2) {
    		//terme
    		ArrayList<Node> termes = actual.getTermes();
    		for (int i = 0; i < termes.size(); i++) {
    			if (termes.get(i).getNom().equals(nom) && i == index) {
    				n.initialize(Node.Type.Terme, index, nom);
    			}
    		}
    	}
    	
    	else if (tipus == 3) {
    		//paper
    		ArrayList<Node> papers = actual.getPapers();
    		for (int i = 0; i < papers.size(); i++) {
    			if (papers.get(i).getNom().equals(nom) && i == index) {
    				n.initialize(Node.Type.Paper, index, nom);
    			}
    		}
    	}
    	actual.deleteNode(n);
    }
    
    public ArrayList<Pair<Integer,String>> arrayAutores() {
    	ArrayList<Pair<Integer,String>> ret = new ArrayList<Pair<Integer,String>>();
    	ArrayList<Node> n = actual.getAutors();
    	for (int i = 0; i < n.size(); i++) {
    		if (n.get(i) != null) {
    		Pair p = new Pair(n.get(i).getId(), n.get(i).getNom());
    		ret.add(p);
    		}
    	}
    	return ret;
    }
    
    public ArrayList<Pair<Integer,String>> arrayConferencies() {
    	ArrayList<Pair<Integer,String>> ret = new ArrayList<Pair<Integer,String>>();
    	ArrayList<Node> n = actual.getConferencies();
    	for (int i = 0; i < n.size(); i++) {
    		Pair p = new Pair(n.get(i).getId(), n.get(i).getNom());
    		ret.add(p);
    	}
    	return ret;
    }
    
    public ArrayList<Pair<Integer,String>> arrayPapers() {
    	ArrayList<Pair<Integer,String>> ret = new ArrayList<Pair<Integer,String>>();
    	ArrayList<Node> n = actual.getPapers();
    	for (int i = 0; i < n.size(); i++) {
    		Pair p = new Pair(n.get(i).getId(), n.get(i).getNom());
    		ret.add(p);
    	}
    	return ret;
    }
    
    public ArrayList<Pair<Integer,String>> arrayTermes() {
    	ArrayList<Pair<Integer,String>> ret = new ArrayList<Pair<Integer,String>>();
    	ArrayList<Node> n = actual.getTermes();
    	for (int i = 0; i < n.size(); i++) {
    		Pair p = new Pair(n.get(i).getId(), n.get(i).getNom());
    		ret.add(p);
    	}
    	return ret;
    }
    
    public HashMap<Integer,Float> getRelacionsAutor(Integer index) {
    	return actual.getMatrixAuthor().getRow(index);
    }
    
    /*public HashMap<Integer,Float> getRelacionsPapers(Integer index) {
    	
    }*/
    
    public HashMap<Integer,Float> getRelacionsTermes(Integer index) {
    	return actual.getMatrixTerm().getRow(index);
    }
    
    public HashMap<Integer,Float> getRelacionsConferencies(Integer index) {
    	return actual.getMatrixConf().getRow(index);
    }
    
    public void esborraGraph(String path) throws FileNotFoundException, IOException {
    	CtrlDG.deleteGraphFile(path);
    }
    
    public void carregaGraph(String path) throws FileNotFoundException, IOException {
    	actual = CtrlDG.loadGraph(path);
    }
    
    public void getCurrentGraph(String path) throws IOException {
        CtrlImport ctrl = new CtrlImport(path);
        ctrl.loadGraphInfo();
        actual = ctrl.getGraph();
    }
    
    public ArrayList<ArrayList<String>> getCampPle() {
		return perfilActual.getCampPle();
	}
	
	public String getNomPerfil() {
		return perfilActual.getNomPerfil();
	}
	
	public ArrayList<String> getNomPath() {
		return plantillaActual.getNomPath();
	}
	
	public String getNomPlantilla() {
		return plantillaActual.getNom();
	}

	public String getTipusPlantilla() {
		
		switch(plantillaActual.getTipus()) {
        case Autor:
            return "Autor";
        case Conferencia:
            return "Conferencia";
        case Paper:
            return "Paper";
        case Terme:
            return "Terme";
        default:
            return null;
		}
	}

	public int getSise() {
		return plantillaActual.getTam();
	}

	
	public void deleteP(String ruta) throws FicheroNoExiste, IOException{
		GestioDades.Borrar_archivo(ruta);
	}
	
	public void deletePP(String ruta) throws FicheroNoExiste, IOException{
		GestioDades.Borrar_archivo(ruta);
	}
	
	public void guardarPlantilla(String nom, String tipus, ArrayList<ArrayList<String>> camp) throws IOException, FicheroNoExiste, FicheroYaExistente {
		ControladorGD.guardarPlantilla(plantillaActual, tipus, nom);
		plantillaActual.borrarCamps();
    }
	
	public void crearPlantilla(String nomPP, String tipus, ArrayList<ArrayList<String>> camp){
		plantillaActual.borrarCamps();
		plantillaActual.setNom(nomPP);
		if(tipus.equals("Autor")) plantillaActual.setTipus(Node.Type.Autor);
		else if(tipus.equals("Conferencia")) plantillaActual.setTipus(Node.Type.Conferencia);
		else if(tipus.equals("Terme")) plantillaActual.setTipus(Node.Type.Terme);
		else plantillaActual.setTipus(Node.Type.Paper);
		for(int i=0; i<camp.size(); i++){
			Camp c = new Camp();
			ArrayList<String> aux = camp.get(i);
			c.setPath(aux.get(0), aux.get(1), aux.get(2));
			c.setQuant(Float.parseFloat(aux.get(3)));
			c.setMinim(Integer.parseInt(aux.get(4)));
			plantillaActual.setInfo(c);
		}
	}
	
	public static void modificarNode(String nomAntic, String tipus, String newNom, Integer pos) {
		Node n = new Node();
		switch(tipus) {
			case "Autor": n.initialize(Node.Type.Autor, pos, nomAntic);	break;
			case "Conferencia": n.initialize(Node.Type.Conferencia, pos, nomAntic);	break;
			case "Paper": n.initialize(Node.Type.Paper, pos, nomAntic);	break;
			case "Terme": n.initialize(Node.Type.Terme, pos, nomAntic);	break;
		}
		actual.setNode(n, newNom);
	}
	
	public ArrayList<Integer> relacionesPapers(String tipus, Integer paperId) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		switch(tipus) {
			case "Autor":	
				ArrayList< HashMap<Integer,Float> > AP = actual.getMatrixAuthor().retornarM();
				for (int i = 0; i < AP.size(); ++i) if (AP.get(i).containsKey(paperId)) res.add(i);
				break;
			case "Conferencia":
				ArrayList< HashMap<Integer,Float> > CP = actual.getMatrixConf().retornarM();
				for (int i = 0; i < CP.size(); ++i) if (CP.get(i).containsKey(paperId)) res.add(i);
				break;
			case "Terme":
				ArrayList< HashMap<Integer,Float> > TP = actual.getMatrixTerm().retornarM();
				for (int i = 0; i < TP.size(); ++i) if (TP.get(i).containsKey(paperId)) res.add(i);
				break;
			default: break;
		}
		return res;
	}
	
	public String getLabel(String tipus, Integer Id) {
		Node.Label aux = null;
		switch(tipus) {
			case "Autor": 
				aux = actual.getNode(Id, Node.Type.Autor).getLabel();
				break;
			case "Conferencia":
				aux = actual.getNode(Id, Node.Type.Conferencia).getLabel();
				break;
			case "Paper":
				aux = actual.getNode(Id, Node.Type.Paper).getLabel();
				break;
			case "Terme":
				aux = actual.getNode(Id, Node.Type.Terme).getLabel();
				break;
			default: break;
		}
		if (aux != null) {
			switch(aux) {
				case Database: return "Database";	
				case DataMining: return "Datamining";
				case AI: return "AI";
				case InformationRetrieval: return "InformationRetrieval";
				default: break;
			}
		}
		return "No tiene";
	}
	
	public void newRelacion(String tipus, Integer IdNodo, Integer IdPaper) {
		switch(tipus) {
			case "Autor":	
				if (!actual.getMatrixAuthor().existeixArc(IdNodo, IdPaper)) actual.getMatrixAuthor().afegirArc(IdNodo, IdPaper);
				break;
			case "Conferencia":
				if (!actual.getMatrixConf().existeixArc(IdNodo, IdPaper)) actual.getMatrixConf().afegirArc(IdNodo, IdPaper);
				break;
			case "Terme":
				if (!actual.getMatrixTerm().existeixArc(IdNodo, IdPaper)) actual.getMatrixTerm().afegirArc(IdNodo, IdPaper);
				break;
			default: break;
		}
	}
	
	public void deleteRelacion(String tipus, Integer IdNodo, Integer IdPaper) {
		switch(tipus) {
			case "Autor":	
				if (actual.getMatrixAuthor().existeixArc(IdNodo, IdPaper)) actual.getMatrixAuthor().esborrarArc(IdNodo, IdPaper);
				break;
			case "Conferencia":
				if (actual.getMatrixConf().existeixArc(IdNodo, IdPaper)) actual.getMatrixConf().esborrarArc(IdNodo, IdPaper);
				break;
			case "Terme":
				if (actual.getMatrixTerm().existeixArc(IdNodo, IdPaper)) actual.getMatrixTerm().esborrarArc(IdNodo, IdPaper);
				break;
			default: break;
		}
	}
	
	public boolean consRelacion(String tipus, Integer IdNodo, Integer IdPaper) {
		switch(tipus) {
			case "Autor":	
				if (actual.getMatrixAuthor().existeixArc(IdNodo, IdPaper)) return true;
				else return false;
			case "Conferencia":
				if (actual.getMatrixConf().existeixArc(IdNodo, IdPaper)) return true;
				else return false;
			case "Terme":
				if (actual.getMatrixTerm().existeixArc(IdNodo, IdPaper)) return true;
				else return false;
			default: return false;
		}
	}
	
	public void modRelacion(String tipus, Integer IdNodo, Integer IdPaper) {
		switch(tipus) {
			case "Autor":	
				if (actual.getMatrixAuthor().existeixArc(IdNodo, IdPaper)) actual.getMatrixAuthor().esborrarArc(IdNodo, IdPaper);
				else actual.getMatrixAuthor().afegirArc(IdNodo, IdPaper);
				break;
			case "Conferencia":
				if (actual.getMatrixConf().existeixArc(IdNodo, IdPaper)) actual.getMatrixConf().esborrarArc(IdNodo, IdPaper);
				else actual.getMatrixConf().afegirArc(IdNodo, IdPaper);
				break;
			case "Terme":
				if (actual.getMatrixTerm().existeixArc(IdNodo, IdPaper)) actual.getMatrixTerm().esborrarArc(IdNodo, IdPaper);
				else actual.getMatrixTerm().esborrarArc(IdNodo, IdPaper);
				break;
			default: break;
		}
	}
	public ArrayList<ArrayList<String>> getCampPlant(){
		ArrayList<Camp> camp = plantillaActual.getInfo();
		ArrayList<ArrayList<String>> campsPlant = new ArrayList<ArrayList<String>>();
		for(int i=0; i<plantillaActual.getTam(); i++){
			Camp c = new Camp();
			c = camp.get(i);
			ArrayList<String> aux = new ArrayList<String>();
			aux.add(c.getDescripcioPath());
			aux.add(c.getNomPath());
			aux.add(c.getStringPath());
			aux.add(String.valueOf(c.getQuant()));
			aux.add(String.valueOf(c.getMinim()));
			campsPlant.add(aux);
		}
		return campsPlant;
	}
	
	public static int getLastId(String tipus) throws IOException{return ControladorGD.getLastId(tipus);}

	public void crearPerfilMem(String ruta, String nomP) throws NumberFormatException, FicheroNoExiste, IOException, PathException {
		cargarPlantilla(ruta);
		int id = 0;
		Node.Type tip = plantillaActual.getTipus();
		if(tip.equals("Autor")) id=getLastId("Autor")+1;
		else if(tip.equals("Conferencia")) id = getLastId("Conferencia")+1;
		else if(tip.equals("Terme")) id = getLastId("Terme")+1;
		else if(tip.equals("Paper")) id = getLastId("Paper")+1;
		Random rnd = new Random();
		int aux = (int)(rnd.nextDouble() * 3 + 0);
		Node n = new Node();
		n.setId(id);
		if(aux == 0) n.setLabel(Node.Label.AI);
		else if(aux == 1) n.setLabel(Node.Label.Database);
		else if(aux == 2) n.setLabel(Node.Label.DataMining);
		else n.setLabel(Node.Label.InformationRetrieval);
		n.setNom(nomP);
		n.setTipus(tip);
		generarPerfil(plantillaActual, n, nomP);
	}

	public void crearPerfil(String nomPP, String tipus, ArrayList<ArrayList<String>> camp, String nomP,Integer idPerfil) throws IOException, PathException {
		crearPlantilla(nomPP, tipus, camp);
		Node n = new Node();
		Node.Type tip = plantillaActual.getTipus();
		n.initialize(tip, idPerfil, nomP);
		Random rnd = new Random();
		int aux = (int)(rnd.nextDouble() * 3 + 0);
		if(aux == 0) n.setLabel(Node.Label.AI);
		else if(aux == 1) n.setLabel(Node.Label.Database);
		else if(aux == 2) n.setLabel(Node.Label.DataMining);
		else n.setLabel(Node.Label.InformationRetrieval);
		generarPerfil(plantillaActual, n, nomP);
	}
	
	public void setNomPlant(String s){plantillaActual.setNom(s);}

	public void setTipusPlant(String auxt) {
		Node.Type tip = Node.Type.Autor;
		if(auxt == "Conferencia") tip = Node.Type.Conferencia;
		else if(auxt == "Terme") tip = Node.Type.Terme;
		else if(auxt == "Paper") tip = Node.Type.Paper;
		plantillaActual.setTipus(tip);
	}

	public void getTamPlantAct() {System.out.print(plantillaActual.getTam());}

}
