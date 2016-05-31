//@Author Albert Ripol

package domini;

import java.util.ArrayList;


public class PlantillaPerfil{
	
	//Dades
	private String nomPlantilla;
	private Node.Type tipus;
	private ArrayList<Camp> info;
	
////////////////////////////////////////////////////////////
///////////		  PLANTILLAS PREDEFINIDAS		 ///////////
////////////////////////////////////////////////////////////

	Camp c = new Camp();
	
	//AUTOR  ///////////////////////////////////////////////////
	public void ppAutorDet (){
		nomPlantilla = "Autor detallada";
		tipus = Node.Type.Autor;
		
		c = new Camp();
		//Publicacions
		c.setPath("Publicacions d'un autor", "Publicacions", "AP");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
			
		c = new Camp();
		//Co-autors.
		c.setPath("Co-autors d'un autor", "Co-autors", "APA");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
		
		c = new Camp();
		//Conferencies
		c.setPath("Conferencies en les que ha assistit un autor", "Conferencies", "APC");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
	}
	public void ppAutorBreu (){
		nomPlantilla = "Autor breu";
		tipus = Node.Type.Autor;
		
		c = new Camp();
		//Publicacions
		c.getPath().setNom("Publicacions");
		c.getPath().setContingut("AP");
		c.getPath().setDescripcio("Publicacions d'un autor");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
		
		c = new Camp();
		//Co-autors.
		c.getPath().setNom("Co-autors");
		c.getPath().setContingut("APA");
		c.getPath().setDescripcio("Co-autors d'un autor");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
		
		c = new Camp();
		//Conferencies
		c.getPath().setNom("Conferencies");
		c.getPath().setContingut("APC");
		c.getPath().setDescripcio("Conferencies en les que ha assistit un autor");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
	}
	//CONFERENCIA      //////////////////////////////////////////////////////
	public void ppConfDet (){
		
		nomPlantilla = "Conferencies detallat";
		tipus = Node.Type.Conferencia;
		
		c = new Camp();
		//Conferencies
		c.getPath().setNom("Conferencies");
		c.getPath().setContingut("CP");
		c.getPath().setDescripcio("Publicacions de les Conferencies");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
		
		c = new Camp();
		//Autors
		c.getPath().setNom("Autors");
		c.getPath().setContingut("CPA");
		c.getPath().setDescripcio("Autors de les conferencies");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
		
		c = new Camp();
		//Paraules claus (Termes)
		c.getPath().setNom("Terme");
		c.getPath().setContingut("CPT");
		c.getPath().setDescripcio("Termes de les conferencies");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
	}
	public void ppConfBreu (){
		
		nomPlantilla = "Conferencies breu";
		tipus = Node.Type.Conferencia;
		
		c = new Camp();
		//Conferencies
		c.getPath().setNom("Conferencies");
		c.getPath().setContingut("CP");
		c.getPath().setDescripcio("Publicacions de les Conferencies");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
		
		c = new Camp();
		//Autors
		c.getPath().setNom("Autors");
		c.getPath().setContingut("CPA");
		c.getPath().setDescripcio("Autors de les conferencies");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
		
		c = new Camp();
		//Paraules claus (Termes)
		c.getPath().setNom("Terme");
		c.getPath().setContingut("CPT");
		c.getPath().setDescripcio("Termes de les conferencies");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
	}
	// TERME         //////////////////////////////////
	public void ppTermeDet (){
		nomPlantilla = "Terme detallat";
		tipus = Node.Type.Terme;
		
		c = new Camp();
		//Termes d'una publicacio
		c.getPath().setNom("Termes");
		c.getPath().setContingut("TP");
		c.getPath().setDescripcio("Termes de la publicacio");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
		
		c = new Camp();
		//Autors
		c.getPath().setNom("Autors");
		c.getPath().setContingut("TPA");
		c.getPath().setDescripcio("Autors que usen el Terme");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
		
		c = new Camp();
		//Paraules claus (Termes)
		c.getPath().setNom("Terme");
		c.getPath().setContingut("TPC");
		c.getPath().setDescripcio("Termes de les conferencies");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
	}
	public void ppTermeBreu (){
		nomPlantilla = "Terme Breu";
		tipus = Node.Type.Terme;
		
		c = new Camp();
		//Termes d'una publicacio
		c.getPath().setNom("Termes");
		c.getPath().setContingut("TP");
		c.getPath().setDescripcio("Termes de la publicacio");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
		
		c = new Camp();
		//Autors
		c.getPath().setNom("Autors");
		c.getPath().setContingut("TPA");
		c.getPath().setDescripcio("Autors que usen el Terme");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
		
		c = new Camp();
		//Paraules claus (Termes)
		c.getPath().setNom("Terme");
		c.getPath().setContingut("TPC");
		c.getPath().setDescripcio("Termes de les conferencies");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
	}
	//ARTICLE (PAPER)         //////////////////////////////////
	public void ppArticleDet(){
		nomPlantilla = "Article Detallat";
		tipus = Node.Type.Paper;
		
		c = new Camp();
		//Autors que han fet l'article
		c.getPath().setNom("Autors");
		c.getPath().setContingut("PA");
		c.getPath().setDescripcio("Autors que han participat en l'article");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
		
		c = new Camp();
		//Termes (Paraules claus) en l'article
		c.getPath().setNom("Termes");
		c.getPath().setContingut("PT");
		c.getPath().setDescripcio("Termes (Paraules clau) que apareixen en l'article");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
		
		c = new Camp();
		//altres articles que han escrit els mateixos autors d'aquest article
		c.getPath().setNom("Altres Articles Relacionats");
		c.getPath().setContingut("PAP");
		c.getPath().setDescripcio("Altres articles que han escrit els mateixos autors d'aquest article");
		c.quant = (float) 0.8;
		c.minim = -1;
		info.add(c);
	}
	public void ppArticleBreu(){
		nomPlantilla = "Article Breu";
		tipus = Node.Type.Paper;
		
		c = new Camp();
		//Autors que han fet l'article
		c.getPath().setNom("Autors");
		c.getPath().setContingut("PA");
		c.getPath().setDescripcio("Autors que han participat en l'article");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
		
		c = new Camp();
		//Termes (Paraules claus) en l'article
		c.getPath().setNom("Termes");
		c.getPath().setContingut("PT");
		c.getPath().setDescripcio("Termes (Paraules clau) que apareixen en l'article");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
		
		
		//altres articles que han escrit els mateixos autors d'aquest article
		c.getPath().setNom("Altres Articles Relacionats");
		c.getPath().setContingut("PAP");
		c.getPath().setDescripcio("Altres articles que han escrit els mateixos autors d'aquest article");
		c.quant = (float) -1;
		c.minim = 3;
		info.add(c);
	}
	////////////////////////////////////////////////////////////
	///////////			   	     FIN				 ///////////
	////////////////////////////////////////////////////////////
	public PlantillaPerfil(String nomPlantilla2, Node.Type tipus2, ArrayList<Camp> info2){
		nomPlantilla = nomPlantilla2;
		tipus = tipus2;
		info = info2;
	}
	public PlantillaPerfil(){
		info = new ArrayList<Camp>();
	}

	public String getNom(){
		return nomPlantilla;
	}

	public Node.Type getTipus(){
		return tipus;
	}

	public ArrayList<Camp> getInfo(){
		return info;
	}
	
	public int getTam (){
		return info.size();
	}

	public void setNom(String nom){
		nomPlantilla = nom;
	}

	public void setTipus(Node.Type tipus2){
		tipus = tipus2;
	}

	public void setInfo(Camp info2){
		info.add(info2);
	}

	public void modificarPlant(String accio, String element, String nou){
		ArrayList<String> Plant = new ArrayList<String>();
		if(accio.equals("eliminar")){
			Plant.remove(element);
		}
		else if(accio.equals("afegir")){
			Plant.add(element);
		}
		else if(accio.equals("modificar")){
			if(element.equals("nom")){
				c.getPath().setNom(nou);
			}
			else if(element.equals("path")){
				c.getPath().setContingut(nou);
			}
			else if(element.equals("descripcio")){
				c.getPath().setDescripcio(nou);
			}
			else if(element.equals("quant")){
				float n = Float.parseFloat(nou);
				c.setQuant(n);
			}
			else if(element.equals("minim")){
				int n = Integer.parseInt(nou);
				c.setMinim(n);
			}
		}
	}
	
	public ArrayList<String> getNomPath () {
		ArrayList<String> t = new ArrayList<>();
		int n = info.size();
		for (int i = 0; i < n; ++i) {
			t.add(this.info.get(i).getNomPath());
		}
		return t;
	}
	
	public void borrarCamps(){info.clear();}
	
	public void actualizaNombre(Integer i, String nomNou) {
		Camp c;
		c = info.get(i);
		c.getPath().setNom(nomNou);
	}
}