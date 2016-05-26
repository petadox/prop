package persistencia;
//@Author Albert Ripol

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;
import domini.Camp;
import domini.Node;
import domini.Perfil;
import domini.PlantillaPerfil;

public class ControladorGD{	//controlador gestio dades
	/*public static void guardarPerfil(String nomP, String entitat, PlantillaPerfil pp) throws IOException, FicheroNoExiste, FicheroYaExistente{
		String ruta = "BaseDades/Perfil/" + entitat + "/";
		
		ArrayList<ArrayList<String>> CampsPerfil = new ArrayList<ArrayList<String>>();
		CampsPerfil = p.getCampPle();
		
		GestioDades.Crear_archivo(nomP, ruta);
		GestioDades.Escribir_string(nomP, "salto", nomP, ruta);
		GestioDades.Escribir_string(nomPlantilla, "salto", nomP, ruta);
		Iterator<ArrayList<String>> i = CampsPerfil.iterator();
		while(i.hasNext()){
			ArrayList<String> aux = i.next();
			Iterator<String> j = aux.iterator();
			while(j.hasNext()){
				String s = j.next();
				GestioDades.Escribir_string(s, " ", nomP, ruta);
			}
			GestioDades.Escribir_string("", "salto", nomP, ruta);
		}
		
	}*/
	
	public static void guardarPerfil(Perfil p) throws IOException, FicheroNoExiste, FicheroYaExistente{
		String nomP = p.getNomPerfil();
		String nomPP = p.getNomPlantilla();
		String tipus = p.getTipus();
		ArrayList<ArrayList<String>> CampsPerfil = p.getCampPle();
		
		String ruta = "BaseDades/Perfil/" + tipus + "/";
		
		GestioDades.Crear_archivo(nomP, ruta);
		GestioDades.Escribir_string(nomP, "salto", nomP, ruta);
		GestioDades.Escribir_string(nomPP, "salto", nomP, ruta);
		Iterator<ArrayList<String>> i = CampsPerfil.iterator();
		while(i.hasNext()){
			ArrayList<String> aux = i.next();
			Iterator<String> j = aux.iterator();
			while(j.hasNext()){
				String s = j.next();
				GestioDades.Escribir_string(s, " ", nomP, ruta);
			}
			GestioDades.Escribir_string("", "salto", nomP, ruta);
		}
		
	}
	
	public static Perfil cargarPerfil(String ruta) throws FicheroNoExiste, IOException{
		Perfil perf = new Perfil();
		String s;
		FileReader f = new FileReader(ruta);
		BufferedReader b = new BufferedReader(f);
		int cont = 0;
		ArrayList<ArrayList<String>> mat = new ArrayList<ArrayList<String>>();
		
		while((s = b.readLine())!=null){
			if(cont==0){
				perf.setNomPerfil(s);
			}
			else if(cont==1){
				perf.setNomPlantilla(s);
			}
			else{
				ArrayList<String> aux = new ArrayList<String>();
				String s2 = "";
				for(int x = 0; x < s.length(); x++){
					char c = s.charAt(x);
					if(c != ' ') s2 = s2+c;
					else{
						aux.add(s2);
						s2 = "";
					}
				}
				mat.add(aux);
			}
			cont++;
		}
		b.close();
		return perf;
	}
	
	public static ArrayList<String> cargarPlantilla(String ruta) throws NumberFormatException, FicheroNoExiste, IOException{
		ArrayList<String> plant = new ArrayList<String>();
		String s;
		FileReader f = new FileReader(ruta);
		BufferedReader b = new BufferedReader(f);
		while((s = b.readLine())!=null){
			plant.add(s);
		}
		b.close();
		return plant;
	}
	
	public static void guardarPlantilla(PlantillaPerfil pp, String tipus, String nomPP) throws IOException, FicheroNoExiste, FicheroYaExistente{
		String ruta = "BaseDades/PlantillaPerfil/" + tipus + "/";
		GestioDades.Crear_archivo(nomPP, ruta);
		GestioDades.Escribir_string(nomPP, "salto", nomPP, ruta);
		GestioDades.Escribir_string(tipus, "salto", nomPP, ruta);
		ArrayList<Camp> info = pp.getInfo();
		Camp c;
		
		for(int i = 0; i < pp.getTam(); i++){
			c = info.get(i);
			GestioDades.Escribir_string(c.getPath().getNom(), "salto", nomPP, ruta);
			GestioDades.Escribir_string(c.getPath().getDescripcio(), "salto", nomPP, ruta);
			GestioDades.Escribir_string(c.getPath().getStringPath(), "salto", nomPP, ruta);
			GestioDades.Escribir_string(c.getQuant().toString(), "salto", nomPP, ruta);
			GestioDades.Escribir_string(Integer.toString(c.getMinim()) , "salto", nomPP, ruta);
		}
	}
	
	public static int getLastId(String tipus) throws IOException{return GestioDades.getLastId(tipus);}
}