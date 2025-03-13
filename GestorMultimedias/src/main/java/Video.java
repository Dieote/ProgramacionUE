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

    public Video(int id, String titulo, String autor, double tamanio, String formato, Director director, List<Actor> actores) {
        super(id, titulo, autor, tamanio, formato);
        this.director = director;
        this.actores = actores;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Director=" + director +
                ", Artistas=" + actores;
    }
}
