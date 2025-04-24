import Enums.Genero;
import Enums.TramaPoliciaca;

public class LibroPoliciaco extends Libro {

    private TramaPoliciaca trama;
    private String personajes;

    public LibroPoliciaco(String nombre, String autor, int paginas, String isbn, TramaPoliciaca trama, String personajes) {
        super(nombre, autor, paginas, isbn, Genero.POLICIACA);
        this.trama = trama;
        this.personajes = personajes;
    }

    @Override
    public String toString() {
        return super.mostrarDatos() + "Género: "+ Genero.POLICIACA + " Trama: " + trama + " | Personajes: " + personajes;
    }
}
