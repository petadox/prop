package Interficie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;
import domini.CompararArrays;
import domini.CtrlDominio;
import domini.Pair;

//@author Albert Ripol

public class ControladorInterficie {
	
	/*Variables de control*/
	
	private static String Menu2;
	private static String Element3;
	private static String Entidades4;
	private static String Nom5;
	private static String EntRel7;
	private static String SLPerfiles9;
	private static String Slentidades6;
	private static Integer entidades6;
	private static String consultarentidades;
	private static String nombreEntidad;
	private static String NomPlant11;
	private static String TipusPlant11;
	private static String consPlant17;
	private static Integer IdPaper;
	private static Integer IdNodo;
	private static ArrayList<ArrayList<String> > Camp12 = new ArrayList<ArrayList<String> >();
	private static int numCamp;
	private static String rutaPlant;

	
	/*Instancia*/
	
	private static CtrlDominio CtrlD = new CtrlDominio();
	
	/*Pantallas*/
	
	private static Principal1 prin1;
	private static Menu2 menu2;
	private static Elements3 elements3;
	private static Entidades4 entidades4;
	private static IntroduirNom5 introduirnom5;
	private static SLEntidades6 slentidades6;
	private static EntRel7 entrel7;
	private static Grafo8 grafo8;
	private static SLPerfiles9 slperfiles9;
	private static Plantilla11 plantilla11;
	private static AfegirCamp12 afegircamp12;
	private static ConsPerf15 consperf15;
	private static SLPlantilla16 slplantilla16;
	private static ConsPlant17 consplant17;
	private static ModPlantilla18 modplantilla18;
	private static ModCampPlantilla18b modcampplantilla18b;
	private static ElegirPlantilla20 elegirplantilla20;
	private static ModificarPerfil23 modificarperfil23;
	private static ConsultarEntidad consultarentidad;


	/*ScrollLists entidades*/

	private static ArrayList<Pair<Integer,String>> autores = new ArrayList<Pair<Integer,String>>();
	private static ArrayList<Pair<Integer,String>> conferencies = new ArrayList<Pair<Integer,String>>();
	private static ArrayList<Pair<Integer,String>> papers = new ArrayList<Pair<Integer,String>>();
	private static ArrayList<Pair<Integer,String>> termes = new ArrayList<Pair<Integer,String>>();
	
	private static HashMap<Integer,Float> Mapa = new HashMap<Integer,Float>();
	
	private static ArrayList<Integer> autoresID = new ArrayList<Integer>();
	private static ArrayList<Integer> conferenciesID = new ArrayList<Integer>();
	private static ArrayList<Integer> termesID = new ArrayList<Integer>();

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ControladorInterficie() {
		CtrlD = new CtrlDominio();
	}
	
	public void run() {
		VistaPrincipal1();
	}
	
	public static void cargarArrays() {
		autores = CtrlD.arrayAutores();
		conferencies = CtrlD.arrayConferencies(); 
		papers = CtrlD.arrayPapers();
		termes = CtrlD.arrayTermes();
	}
	
	public static ArrayList<Pair<Integer,String>> getAutors() {
		return autores;
	}
	
	public static ArrayList<Pair<Integer,String>> getConferencies() {
		return conferencies;
	}
	
	public static ArrayList<Pair<Integer,String>> getPapers() {
		return papers;
	}
	
	public static ArrayList<Pair<Integer,String>> getTermes() {
		return termes;
	}
	
	public static void setMenu2(String s){Menu2 = s;}
	public static String getMenu2(){return Menu2;}

	public static void setElement3(String s) {Element3 = s;}
	public static String getElement3(){return Element3;}
	
	public static void setEntidades4(String s) {Entidades4 = s;}
	public static String getEntidades4(){return Entidades4;}
	 
	public static void setNom5(String s) {Nom5 = s;}
	public static String getNom5(){return Nom5;}
	
	public static String getNombreEntidad() {return nombreEntidad;}
	public static void setNombreEntidad(String n) {nombreEntidad = n;}

	
	public static String getSLEntidades6() {return Slentidades6;}
	
	public static void setSLEntidades6(String entidad) {Slentidades6 = entidad;}
	
	public static void setEntRel7(String s) {EntRel7 = s;}
	public static String getEntRel7(){return EntRel7;}
	
	public static void setNomPlant11(String s){NomPlant11 = s;}
	public static String getNomPlant(){return NomPlant11;}
	
	public static void setTipusPlant11(String s){TipusPlant11 = s;}
	public static String getTipusPlant(){return TipusPlant11;}
	
	public static void setCamp(ArrayList<String> s){Camp12.add(s);}
	public static ArrayList<ArrayList<String>> getCamp12(){return Camp12;}
	
	public static void setNumCamp(int n){numCamp = n;}
	public static int getNumCamp(){return numCamp;}
	
	public static void setconsplant17(String s){consPlant17 = s;}
	public static String getconsplant17(){return consPlant17;}
	
	public static void setIdPaper(Integer Id){IdPaper = Id;}
	public static Integer getIdPaper(){return IdPaper;}
	
	public static void setIdNodo(Integer Id){IdNodo = Id;}
	public static Integer getIdNodo(){return IdNodo;}
	
	public static void borrarCamp12(){Camp12.clear();}
	
	public static void setNomG(String nomG) {CtrlD.setNomActual(nomG);}
	
	public static String getNomGraf() {return CtrlD.nomGraf();}
	
	public static void setSLPerfiles(String directorio) {SLPerfiles9 = directorio;}
	
	public static String getSLPerfiles() {return SLPerfiles9;}
	
	public static void addNode(String tipus, String nom) throws IOException { CtrlD.guardarNode(tipus, nom);}
	
	public static void saveGraph(String path) throws FileNotFoundException, IOException { CtrlD.guardarGraph(path);}
	
	public static void importaGraph(String path) throws FileNotFoundException, IOException { CtrlD.getCurrentGraph(path);}
	
	public static void carregaGraph(String path) throws FileNotFoundException,  IOException { CtrlD.carregaGraph(path);}
	
	public static void deleteGraph(String path) throws FileNotFoundException, IOException { CtrlD.esborraGraph(path);}
	
	public static void savePP() throws IOException, FicheroNoExiste, FicheroYaExistente{CtrlD.guardarPlantilla(NomPlant11, TipusPlant11, Camp12);}
	
	public static void loadPP(String ruta) throws FicheroNoExiste, IOException{CtrlD.cargarPlantilla(ruta);}
	public static void saveP() throws IOException, FicheroYaExistente, FicheroNoExiste{CtrlD.guardarPerfil();}
	
	public static void loadP(String ruta) throws FicheroNoExiste, IOException{CtrlD.cargarPerfil(ruta);}

	
	public static void VistaPrincipal1() {
		prin1 = new Principal1();
		prin1.setLocationRelativeTo(null);
		prin1.setVisible(true);
		prin1.setResizable(false);
	}
	
	public static void VistaMenu2() {
		menu2 = new Menu2();
		menu2.setLocationRelativeTo(null);
		menu2.setVisible(true);
		menu2.setResizable(false);
	}
	
	public static void VistaElementos3() {
		elements3 = new Elements3();
		elements3.setLocationRelativeTo(null);
		elements3.setVisible(true);
		elements3.setResizable(false);
	}
	
	public static void VistaEntidades4() {
		entidades4 = new Entidades4();
		entidades4.setLocationRelativeTo(null);
		entidades4.setVisible(true);
		entidades4.setResizable(false);
	}
	
	public static void VistaIntroduirNom5() {
		introduirnom5 = new IntroduirNom5();
		introduirnom5.setLocationRelativeTo(null);
		introduirnom5.setVisible(true);
		introduirnom5.setResizable(false);
	}

	public static void VistaSLEntidades6() {
		slentidades6 = new SLEntidades6();
		slentidades6.setLocationRelativeTo(null);
		slentidades6.setVisible(true);
		slentidades6.setResizable(false);
	}
 
	public static void VistaEntRel7() {
		entrel7 = new EntRel7();
		entrel7.setLocationRelativeTo(null);
		entrel7.setVisible(true);
		entrel7.setResizable(false);
	}
	
	public static void VistaGrafo8() {
		grafo8 = new Grafo8();
		grafo8.setLocationRelativeTo(null);
		grafo8.setVisible(true);
		grafo8.setResizable(false);
	}

	public static void VistaSLPerfiles9() {
		try {
			slperfiles9 = new SLPerfiles9();
		} catch (FicheroNoExiste | IOException e) {
			e.printStackTrace();
		}
		slperfiles9.setLocationRelativeTo(null);
		slperfiles9.setVisible(true);
		slperfiles9.setResizable(false);
	}
	
	public static void VistaPlantilla11() {
		plantilla11 = new Plantilla11();
		plantilla11.setLocationRelativeTo(null);
		plantilla11.setVisible(true);
		plantilla11.setResizable(false);
	}
	
	public static void VistaAfegirCamp12() {
		afegircamp12 = new AfegirCamp12();
		afegircamp12.setLocationRelativeTo(null);
		afegircamp12.setVisible(true);
		afegircamp12.setResizable(false);
	}
	
	public static void VistaConsPerf15() {
		consperf15 = new ConsPerf15();
		consperf15.setLocationRelativeTo(null);
		consperf15.setVisible(true);
		consperf15.setResizable(false);
	}

	public static void VistaSLPlantilla16() throws Exception, IOException {
		slplantilla16 = new SLPlantilla16();
		slplantilla16.setLocationRelativeTo(null);
		slplantilla16.setVisible(true);
		slplantilla16.setResizable(false);
	}
	
	public static void VistaConsPlant17() {
		consplant17 = new ConsPlant17();
		consplant17.setLocationRelativeTo(null);
		consplant17.setVisible(true);
		consplant17.setResizable(false);
	}

	public static void VistaModPlantilla18() {
		modplantilla18 = new ModPlantilla18();
		modplantilla18.setLocationRelativeTo(null);
		modplantilla18.setVisible(true);
		modplantilla18.setResizable(false);
	}
	
	public static void VistaModCampPlantilla18b() {
		modcampplantilla18b = new ModCampPlantilla18b();
		modcampplantilla18b.setLocationRelativeTo(null);
		modcampplantilla18b.setVisible(true);
		modcampplantilla18b.setResizable(false);
	}

	public static void VistaElegirPlantilla20() {
		elegirplantilla20 = new ElegirPlantilla20();
		elegirplantilla20.setLocationRelativeTo(null);
		elegirplantilla20.setVisible(true);
		elegirplantilla20.setResizable(false);
	}
	
	public static void VistaModificarPerfil23() {
		modificarperfil23 = new ModificarPerfil23();
		modificarperfil23.setLocationRelativeTo(null);
		modificarperfil23.setVisible(true);
		modificarperfil23.setResizable(false);
	}
	
	public static void VistaConsultar() {
		consultarentidad = new ConsultarEntidad();
		consultarentidad.setLocationRelativeTo(null);
		consultarentidad.setVisible(true);
		consultarentidad.setResizable(false);
	}
	
	public static void ordenarVector() {
		Collections.sort(autores,new CompararArrays());
		Collections.sort(conferencies,new CompararArrays());
		Collections.sort(papers,new CompararArrays());
		Collections.sort(termes,new CompararArrays());
	}
	
	public static void cargarMapAutores(Integer index) {
		Mapa = CtrlD.getRelacionsAutor(index);
	}
	
	public static void cargarMapConferencias(Integer index) {
		Mapa = CtrlD.getRelacionsConferencies(index);
	}
	
	public static void cargarMapTermes(Integer index) {
		Mapa = CtrlD.getRelacionsTermes(index);
	}
	
	public static HashMap<Integer,Float> getMapa() {
		return Mapa;
	}
	
	public static Integer getEntidades6Int() {
		return entidades6;
	}
	
	public static void setEntidades6Int(int entero) {
		entidades6 = entero;
	}
	
	public static ArrayList<String> getNomPath() {
		return CtrlD.getNomPath();
	}
	public static ArrayList<ArrayList<String>> getCampPle() {
		return CtrlD.getCampPle();
	}
	public static String getNomPlantilla() {
		return CtrlD.getNomPlantilla();
	}
	public static String getTipusPlantilla() {
		return CtrlD.getTipusPlantilla();
	}
	public static int getSise() {
		return CtrlD.getSise();
	}
	public static String getNomPerfil() {
		return CtrlD.getNomPerfil();
	}
	/*public static ArrayList<ArrayList<String>> getTodaPlantilla() {
		return CtrlD.getTodaPlantilla();
	}*/
	public static void deleteP(String ruta) throws FicheroNoExiste, IOException {CtrlD.deleteP(ruta);}
	
	public static void deletePP(String ruta) throws FicheroNoExiste, IOException {CtrlD.deletePP(ruta);}

	
	public static boolean pathValid(String path) {
		boolean yep = false;
		
		if (TipusPlant11.equals("Autor") && path.charAt(0) != 'A') return false;
		if (TipusPlant11.equals("Conferencia") && path.charAt(0) != 'C') return false;
		if (TipusPlant11.equals("Terme") && path.charAt(0) != 'T') return false;
		if (TipusPlant11.equals("Paper") && path.charAt(0) != 'P') return false;
		
        int n = path.length();
        int i; // Para el resto (A,C,T);
        int j; // Para las P;
        if(path.charAt(0) == 'P') { // Primera posicion es la P;
            yep = true;
            i = 1;
            j = 2;
            while (j < n && yep == true) {
                if (path.charAt(j) != 'P') yep = false;
                j = j + 2;
            }
            while (i < n && yep == true) {
                if (path.charAt(i) != 'C' && path.charAt(i) != 'T' && path.charAt(i) != 'A') yep = false;
                i = i + 2;
            }
        }
        else if (path.charAt(0) == 'A' || path.charAt(0) == 'C' || path.charAt(0) == 'T') {
            yep = true;
            i = 2;
            j = 1;
            while (j < n && yep == true) {
                if (path.charAt(j) != 'P') yep = false;
                j = j + 2;
            }
            while (i < n && yep == true) {
                if (path.charAt(i) != 'C' && path.charAt(i) != 'T' && path.charAt(i) != 'A') yep = false;
                i = i + 2;
            }
        }
        return yep;
    }
	
	public static boolean quantValid(String s) {
		if(s.charAt(0) == '-'){
			if (s.charAt(1) == '1' && s.length() == 2) return true;
			else return false;
		}
		if(s.charAt(0) == '0'){
			if(s.length() == 1) return true;
			else if(s.length() == 2) return false;
			else{
				for(int i=3; i<s.length(); i++){
					if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;
				}
				double d = Double.valueOf(s);
				if(d >= 0 && d <= 1) return true;
			}
		}
		return false;
	}
	
	public static void borrarNode(String nom,Integer index,int tipus) {
		CtrlD.borrarNodo(nom,index,tipus);
	}

	public static boolean minValid(String s) {
		if(s.charAt(0) == '-'){
			if (s.charAt(1) == '1' && s.length() == 2) return true;
			else return false;
		}
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;
		}
		return true;
	}
	public static void cargarPlantilla(){CtrlD.crearPlantilla(NomPlant11, TipusPlant11, Camp12);}
	
	public static void modificarNode() {
		CtrlD.modificarNode(getNombreEntidad(),getEntidades4(),getNom5(),getEntidades6Int());
	}
	
	public static void relacionesPapers(Integer paper) {
		autoresID = CtrlD.relacionesPapers("Autor", paper);
		conferenciesID = CtrlD.relacionesPapers("Conferencia", paper);
		termesID = CtrlD.relacionesPapers("Terme", paper);
	}
	
	public static ArrayList<Integer> getRelacionesAP() {
		return autoresID;
	}
	
	public static ArrayList<Integer> getRelacionesCP() {
		return conferenciesID;
	}
	
	public static ArrayList<Integer> getRelacionesTP() {
		return termesID;
	}
	
	public static String getLabel(String tipus, Integer Id) {
		return CtrlD.getLabel(tipus,Id);
	}
	
	public static void setCamp(String nom,String descripcio,String path,int quant,int minim) {
		
	}
	
	public static void newRelacion() {
		CtrlD.newRelacion(Entidades4,IdNodo,IdPaper);
	}
	
	public static void deleteRelacion() {
		CtrlD.deleteRelacion(Entidades4,IdNodo,IdPaper);
	}
	
	public static boolean consRelacion() {
		return CtrlD.consRelacion(Entidades4,IdNodo,IdPaper);
	}
	
	public static void modRelacion() {
		CtrlD.modRelacion(Entidades4,IdNodo,IdPaper);
	}
	public static void afegirCamp() throws NumberFormatException, FicheroNoExiste, IOException {
		CtrlD.cargarPlantilla(rutaPlant);
		ArrayList<ArrayList<String>> camp = new ArrayList<ArrayList<String>>();
		camp = CtrlD.getCampPlant();
		Camp12.clear();
		for(int i=0; i<camp.size(); i++){
			setCamp(camp.get(i));
		}
	}

	public static void setRutaPlant(String ruta) {rutaPlant = ruta;}
	public static String getRutaPlant() {return rutaPlant;}

}
