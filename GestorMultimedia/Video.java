import lombok.Data;
@Data
public class Video extends Multimedia{

    public String director;
    public String actores;

    public Video() {
    }

    public Video(int identificador, String titulo, String autor, String formato, double tamanio, String director, String actores) {
        super(identificador, titulo, autor, formato, tamanio);
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
