package Excepciones;

// Excepción: Longitud del DNI incorrecta
public class LongitudDNINoValidaException extends RuntimeException {
    public LongitudDNINoValidaException(String mensaje) {
        super(mensaje);
    }
}
