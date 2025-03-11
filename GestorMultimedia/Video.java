import lombok.Data;
@Data
public class Video extends Multimedia{

    public String director;
    public String actores;

    public Video() {
    }

    public Video(String formato, double tamaño, String autor, String titulo, int identificador, String director, String actores) {
        super(formato, tamaño, autor, titulo, identificador);
        this.director = director;
        this.actores = actores;
    }

    public Video(String director, String actores) {
        this.director = director;
        this.actores = actores;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Director=" + director +
                ", Actores=" + actores;
    }
}
