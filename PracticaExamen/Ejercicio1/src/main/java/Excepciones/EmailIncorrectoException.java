package Excepciones;

public class EmailIncorrectoException extends RuntimeException {
    public EmailIncorrectoException(String message) {
                super(message);
    }
}
