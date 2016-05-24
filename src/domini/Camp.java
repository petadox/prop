package domini;
/**
 *
 * @author chus
 */
public class Camp {
    Path p = new Path();
    Float quant;
    int minim;
   
    
    public void setPath(String descripcio, String nom, String path) {
        p = new Path(descripcio,nom,path);
    }
    
    public void setQuant(Float quant) {
        this.quant = quant;
    }
    
    public void setMinim(int minim) {
        this.minim = minim;
    }
    
    public Path getPath() {
        return p;
    }
    
    public String getNomPath() {
    	return p.getNom();
    }
    
    public Float getQuant() {
        return quant;
    }
    
    public int getMinim() {
        return minim;
    }

	public String getStringPath() {
		return p.getStringPath();
	}

	public String getDescripcioPath() {
		return p.getDescripcio();
	}
}
