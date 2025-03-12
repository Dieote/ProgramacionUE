import lombok.Data;

import java.util.List;

@Data
public class Video extends Multimedia{

    private Director director;
    private List<Actor> actores;

    public Video() {
    }

    public Video(Director director, List<Actor> actores) {
        this.director = director;
        this.actores = actores;
    }

    public Video(int id, String titulo, String autor, String formato, double tamanio, Director director, List<Actor> actores) {
        super(id, titulo, autor, formato, tamanio);
        this.director = director;
        this.actores = actores;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Director=" + director +
                ", Artistas=" + actores;
    }
}
