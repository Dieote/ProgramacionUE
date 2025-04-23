import Enums.Genero;
import Enums.TipoHumor;
import lombok.Data;

@Data
public class LibroComedia extends Libro{

    private TipoHumor tipoHumor;

    public LibroComedia(String nombre, String autor, int paginas, String isbn, TipoHumor tipoHumor) {
        super(nombre, autor, paginas, isbn, Genero.COMEDIA);
        this.tipoHumor = tipoHumor;    }

    @Override
    public String toString() {
        return super.mostrarDatos() + "Género: "+ Genero.COMEDIA + " | Tipo de humor: " + tipoHumor;
    }
}
