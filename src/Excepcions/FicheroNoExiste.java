package Excepcions;

public class FicheroNoExiste extends Exception {

    public FicheroNoExiste() {
        super();
    }

    public FicheroNoExiste(String s) {
        super(s);
    }
}
