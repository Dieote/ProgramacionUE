import lombok.Data;

import java.util.ArrayList;

@Data
public class Libro {

    private int id;
    private String nombre;
    private String autor;
    private int paginas;
    private String seccion;
    private String isbn;
    //private boolean disponibilidad;

    public Libro(){}

    public Libro( int id, String nombre, String autor, int paginas, String seccion, String isbn) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.paginas = paginas;
        this.seccion = seccion;
        this.isbn = isbn;
    }

    public Libro(String nombre, String autor, int paginas, String seccion, String isbn) {
        id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.paginas = paginas;
        this.seccion = seccion;
        this.isbn = isbn;
    }

    public String mostrarDatos(){
        return toString();
    }

    @Override
    public String toString() {
        return "Libro *{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas=" + paginas +
                ", seccion='" + seccion + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

/*
    Letra Estante       NumeroEstante           ISBN
        A                   1 - 8                AAA0000
 */