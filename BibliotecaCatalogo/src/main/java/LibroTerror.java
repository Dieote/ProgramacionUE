import Enums.Genero;
import lombok.Data;

@Data
public class LibroTerror extends Libro{

    private double calificacion;

    public LibroTerror(String nombre, String autor, int paginas, String isbn, double calificacion) {
        super(nombre, autor, paginas, isbn, Genero.TERROR);
                this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return super.mostrarDatos() + "Genero "+ Genero.TERROR + " | Calificación: " + calificacion;
    }
}
