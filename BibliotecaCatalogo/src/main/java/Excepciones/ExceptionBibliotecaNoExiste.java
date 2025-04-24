package Excepciones;

public class ExceptionBibliotecaNoExiste extends RuntimeException{

    public ExceptionBibliotecaNoExiste(String message) {
        super(message);
    }
}
