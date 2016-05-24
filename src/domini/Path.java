package domini;

import java.io.Serializable;
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
public class Path implements Serializable {
    private ArrayList<Node.Type> contingut;
    private String path;
    private String descripcioPath;
    private String nomPath;
    
    private static final long serialVersionUID = 1L;
    
    //Pre: Cert.
    //Post: Es crea un path buit.
    public Path() {
        nomPath = new String();
        descripcioPath = new String();
        contingut = new ArrayList<>();
        path = new String();
    }
    
    //Pre: Cert.
    //Post: Es crea un path amb totes les dades d'entrada.
    public Path(String descripcio, String nom, String path) {
        nomPath = new String();
        descripcioPath = new String();
        contingut = new ArrayList<>();
        this.path = new String();
        nomPath = nom;
        descripcioPath = descripcio;
        if (stringCorrecto(path)) {
            this.path = path;
            contingut = stringapath(path);
        }
    }
    
    
    
    //Pre: path nomes conte les lletres 'A', 'P', 'C', 'T';
    //Post: Retorna un arraylist amb les lletres canviades per Node.Type;
    private ArrayList<Node.Type> stringapath(String path) {
        if (stringCorrecto(path)) {
            ArrayList<Node.Type> noucontingut;
            noucontingut = new ArrayList<>();
            for (int i = 0; i < path.length(); ++i) {
               // Autor A, paper P, term T, conference C; Paper al medio;
               switch (path.charAt(i)) {
                   case 'A':
                       noucontingut.add(Node.Type.Autor);
                       break;
                   case 'C':
                       noucontingut.add(Node.Type.Conferencia);
                       break;
                   case 'P':
                       noucontingut.add(Node.Type.Paper);
                       break;
                   case 'T':
                       noucontingut.add(Node.Type.Terme);
                       break;
                   default:
                       break;
               }
           }
            return noucontingut;
        }
        else return contingut;
    }
    
    //Pre: path nomes conte les lletres 'A', 'P', 'C', 'T';
    //Post: Retorna un arraylist amb les lletres canviades per Node.Type;
    public Node.Type tipoUltimaLetra(String path) {
        if (stringCorrecto(path)) {
            Node.Type noutype;
            int i = path.length() - 1;
            // Autor A, paper P, term T, conference C; Paper al medio;
            switch (path.charAt(i)) {
                case 'A':
                    noutype = Node.Type.Autor;
                    break;
                case 'C':
                    noutype = Node.Type.Conferencia;
                    break;
                case 'P':
                    noutype = Node.Type.Paper;
                    break;
                case 'T':
                    noutype = Node.Type.Terme;
                    break;
                default:
                    noutype = Node.Type.MidElement;
                    break;
            }
            return noutype;
        }
        else return Node.Type.MidElement;
    }
    
    private boolean stringCorrecto(String path) {
        boolean yep = false;
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
    
    
    //Pre: Cert.
    //Post: Especifica el contingut del path.
    public void setContingut(String contingut) {
        this.contingut.clear(); // Vacio/limpio el arraylist;
        if (stringCorrecto(contingut)) {
            this.path = contingut;
            this.contingut = stringapath(contingut);
        }
    }
    
    public String getStringPath () {
        return this.path;
    }
    
    //Pre: Cert.
    //Post: Especifica la descripcio del path.
    public void setDescripcio(String contingut) {
        // Talvez deberia ser string descripció;
        this.descripcioPath = contingut;
    }
    
    //Pre: Cert.
    //Post: Especifica el nom del path.
    public void setNom(String nom){
        this.nomPath = nom;
    }
    
    //Pre: El contingut no pot estar buit.
    //Post: Retorna el contingut.
    public ArrayList<Node.Type> getContingut() {
        return this.contingut;
    }
    
    //Pre: Cert.
    //Post: Retorna el tamany del path(length).
    public Integer getLength() {
        return this.contingut.size();
    }
    
    //Pre: La descripcio no pot estar buit.
    //Post: Retorna la descripcio del path.
    public String getDescripcio() {
        return this.descripcioPath;
    }
    
    //Pre: El nom no pot estar buit.
    //Post: Retorna el nom del path.
    public String getNom() {
        return this.nomPath;
    }
    
    //Pre: Contingut no es buit.
    //Post: Retorna el contigut del path a l'inreves.
    public ArrayList<Node.Type> reversePath() {
        ArrayList<Node.Type> reversed = new ArrayList<>();
        int n;
        // Dudo de si hay que hacer new o no;
        n = this.contingut.size();
        for (int i = n-1; i >= 0 ; --i)
        {   // Si el vector tiene 4 valores, entonces n-1 =  3, que es la
            // cuarta posición del vector. cuando i = 0, entrará y hará
            // la cuarta iteración.
            reversed.add(this.contingut.get(i));
        }
        return reversed;
    }
    
    
    
    //Pre: Contingut no és buit.
    //Post: retorn la primera i la segona meitat del contigut del path.
    //Si lenght(contingut) par, afegeix al final de begin y al principi
    //de end un element = Node.Type.MidElemnt. En el cas de que sigui imparell,
    //l’ultim element de la primera meitat será el primer element de la segona meitat.
    //En qualsevol cas, la primera meitat tindrà el mateix tamany que la segona meitat.
    public Pair<ArrayList<Node.Type>, ArrayList<Node.Type>> getPath() {
        ArrayList<Node.Type> firstarray = new ArrayList<>();
        ArrayList<Node.Type> secondarray = new ArrayList<>();
        
        int n = this.contingut.size();
        // Comprobamos la paridad de this.contingut;
        
        if (this.contingut.size()%2 == 0) {
            // Si path tiene elementos pares, debemos añadir el elemento  neutro
            // tanto al final del primer minipath, como al principio del primero.
            for (int i = 0; i < n/2; ++i) {
                firstarray.add(this.contingut.get(i));
                // Llenamos el primer minipath;
            }
            firstarray.add(Node.Type.MidElement);
            secondarray.add(Node.Type.MidElement);
            // Añadimos el midelement al final del primer minipath
            // y al principio del segundo. Llenamos el segundo.
            for (int i = n/2; i < n; ++i) {
                secondarray.add(this.contingut.get(i));
            }
        }
        else {
            //El path tiene elementos impares, duplico el del medio;
            for (int i = 0; i <= n/2; ++i) {
                firstarray.add(this.contingut.get(i));
                // Llenamos el primer minipath;
            }
            // Llenamos el segundo.
            for (int i = n/2; i < n; ++i) {
                secondarray.add(this.contingut.get(i));
            }
            
        }
        Pair<ArrayList<Node.Type>, ArrayList<Node.Type>> doblepath;
        doblepath = new Pair<> (firstarray,secondarray);
        return doblepath;
    }
        
}
