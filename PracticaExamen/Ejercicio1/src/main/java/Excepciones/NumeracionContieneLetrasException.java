package Excepciones;

// Excepción: Los primeros 8 dígitos del DNI contienen letras
public class NumeracionContieneLetrasException extends RuntimeException {
    public NumeracionContieneLetrasException(String mensaje) {
        super(mensaje);
    }
}
