package Excepciones;

// Excepción: Último dígito del DNI no es una letra
public class UltimoDigitoNoLetraException extends RuntimeException {
    public UltimoDigitoNoLetraException(String mensaje) {
        super(mensaje);
    }
}
