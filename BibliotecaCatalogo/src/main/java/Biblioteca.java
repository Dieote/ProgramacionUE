import lombok.Data;

import java.util.ArrayList;

@Data
public class Biblioteca {

    private String nombre;
    private String director;
    private ArrayList<Biblioteca> generoLibro;

    public Biblioteca(){}

    public Biblioteca(String nombre, String director, ArrayList<Biblioteca> generoLibro) {
        this.nombre = nombre;
        this.director = director;
        this.generoLibro = generoLibro;
    }

    public String mostrarDatos(){
       return "* Biblioteca " + nombre + " - Director: " + director + " - Genero: " + generoLibro;
    }

}

/*
    Letra Estante       NumeroEstante
        A                   1 - 8
 */