import Enums.Genero;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
abstract public class Libro  implements Serializable {

    private String nombre;
    private String autor;
    private int paginas;
    private String isbn;
    private Genero genero;

    public Libro(){}

    public Libro( String nombre, String autor, int paginas, String isbn, Genero genero) {
        this.nombre = nombre;
        this.autor = autor;
        this.paginas = paginas;
        this.isbn = isbn;
        this.genero = genero;
    }

    public String mostrarDatos(){
             return "Libro *{" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas=" + paginas +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

/*
    Letra Estante       NumeroEstante           ISBN
        A                   1 - 8                AAA0000
 */