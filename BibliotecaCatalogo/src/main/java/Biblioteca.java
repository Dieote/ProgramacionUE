import lombok.Data;

@Data
public class Biblioteca {

    private String nombre;
    private String director;
    private Catalogo catalogo;

    public Biblioteca(){}

    public Biblioteca(String nombre, String director, Catalogo catalogo) {
        this.nombre = nombre;
        this.director = director;
        this.catalogo = catalogo;
    }

    public String mostrarDatos(){
       return "* Biblioteca " + nombre + " - Director: " + director + " - Categoria: " + catalogo;
    }

    public Catalogo construirCatalogo(int capacidad){
            this.catalogo = new Catalogo(capacidad);
            return this.catalogo;
    }

    public void buscarLibro(String isbn){}

    public void agregarLibro(Libro libro){}

    public void eliminarLibro(String isbn){}

    public void mostrarTodosLosLibros(){}

    public void consultarNumeroLibros(){}

}

