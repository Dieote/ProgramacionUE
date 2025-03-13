import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Audio extends Multimedia{

    private double duracion;
    private String soporte;

    public static List<Audio> audiosEnAudioteca = new ArrayList<>();
                                //Cambiar id a String A001
    static {
        audiosEnAudioteca.add(new Audio(001, "Bohemian Rhapsody", "Queen", 5.3, "MP3", 5.55, "Digital"));
        audiosEnAudioteca.add(new Audio(002, "Imagine", "John Lennon", 4.1, "WAV", 3.03, "Vinilo"));
        audiosEnAudioteca.add(new Audio(003, "Thriller", "Michael Jackson", 6.5, "FLAC", 5.58, "CD"));
    }

    public Audio() {
    }

    public Audio(int id, String titulo, String autor, double tamanio, String formato, double duracion, String soporte) {
        super(id, titulo, autor, tamanio, formato);
        this.duracion = duracion;
        this.soporte = soporte;
    }

    public Audio(double duracion, String soporte) {
        this.duracion = duracion;
        this.soporte = soporte;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "\n** Duracion= " + duracion +
                ", Soporte= " + soporte;
    }
}
