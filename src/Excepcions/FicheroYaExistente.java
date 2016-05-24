package Excepcions;



public class FicheroYaExistente extends Exception {

    public FicheroYaExistente() {
        super();
    }

    public FicheroYaExistente(String s) {
        super(s);
    }
}
