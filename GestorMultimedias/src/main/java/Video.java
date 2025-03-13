import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Video extends Multimedia{

    private Director director;
    private List<Actor> actores;

    //Lista de Videos
    public static List<Video> videosEnVideoteca = new ArrayList<>();

    static {
        List<Actor> grupo1 = new ArrayList<>();
        grupo1.add(new Actor("Keanu Reeves", "12345678A"));
        grupo1.add(new Actor("Laurence Fishburne", "87654321B"));

        List<Actor> grupo2 = new ArrayList<>();
        grupo2.add(new Actor("Robert Downey Jr.", "56781234C"));
        grupo2.add(new Actor("Chris Evans", "43218765D"));

        List<Actor> grupo3 = new ArrayList<>();
        grupo3.add(new Actor("Leonardo DiCaprio", "78965412E"));
        grupo3.add(new Actor("Joseph Gordon-Levitt", "32147896F"));
                //MODIFICAR ID A STRING "V001"
        videosEnVideoteca.add(new Video(001, "The Matrix", "Hermanas Wachowski", 1500, "MP4",
                new Director("Lana Wachowski", "111222333"), grupo1));
        videosEnVideoteca.add(new Video(002, "Avengers: Endgame", "Anthony Russo", 2200, "MKV",
                new Director("Joe Russo", "444555666"), grupo2));
        videosEnVideoteca.add(new Video(003, "Inception", "Christopher Nolan", 1800, "AVI",
                new Director("Christopher Nolan", "777888999"), grupo3));
    }

    public Video() {
    }

    public Video(Director director, List<Actor> actores) {
        this.director = director;
        this.actores = new ArrayList<>(actores);
    }

    public Video(int id, String titulo, String autor, double tamanio, String formato, Director director, List<Actor> actores) {
        super(id, titulo, autor, tamanio, formato);
        this.director = director;
        this.actores = new ArrayList<>(actores);
        }

        @Override
        public String mostrarInfo() {
        return super.mostrarInfo() + "\nDirector:\n " + director.mostrarDatosDirector() +
            "\nArtistas:\n" + mostrarDatosActores();
        }

        public String mostrarDatosActores(){
        StringBuilder datosActores = new StringBuilder();
        for (Actor actor : actores) {
            datosActores.append(actor.mostrarDatosActor()).append("\n");
        }
        return datosActores.toString();
        }
       }
