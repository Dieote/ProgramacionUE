import Excepciones.*;
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

    public String mostrarDatosBiblioteca(){
        return toString();
    }

    @Override
    public String toString() {
        return "Biblioteca " + nombre + '\'' +
                ", director='" + director + '\'' +
                ", catalogo=" + catalogo +
                '}';
    }

    public Catalogo construirCatalogo(int capacidad){
            this.catalogo = new Catalogo(capacidad);
            return this.catalogo;
    }

    public void buscarLibroEnBiblioteca(String isbn){
        if (this.catalogo == null){
            throw new ExceptionCatalogoNoExiste("❌ No se puede buscar o el catalogo no existe.");
        }
        try {
        Libro libro = this.catalogo.buscarLibroEnCatalogo(isbn);
            System.out.println("✅Libro encontrado: " + libro.mostrarDatos());
            } catch (ExceptionLibroNoEncontrado e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public void agregarLibroEnBiblioteca(Libro libro){
        if (this.catalogo == null){
            throw new ExceptionCatalogoNoExiste("No se puede agregar o el catalogo no existe.");
        }
        try {
            this.catalogo.agregarLibroEnCatalogo(libro);
            System.out.println("✅ Libro agregado correctamente.");
        } catch (ExceptionEspacioInsuficiente e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public void eliminarLibroEnBiblioteca(String isbn){
        if (this.catalogo == null){
            throw new ExceptionCatalogoNoExiste("❌ No se puede eliminar o el catalogo no existe.");
        }
        boolean eliminado = this.catalogo.eliminarLibroEnCatalogo(isbn);
        if (eliminado) {
            System.out.println("✅ Libro eliminado correctamente.");
        } else {
            System.out.println("❌ No se encontró un libro con ese ISBN.");
        }
    }

    public void mostrarTodosLosLibrosEnBiblioteca(){
        if (this.catalogo == null){
            throw new ExceptionCatalogoNoExiste("❌ No se puede mostrar o el catalogo no existe.");
        }
        this.catalogo.listarLibrosEnCatalogo();
    }

    public void consultarNumeroLibrosEnBiblioteca(){
        if (this.catalogo == null) {
            throw new ExceptionCatalogoNoExiste("No se puede consultar el número de libros porque el catálogo no existe.");
        }
        System.out.println("La biblioteca tiene " + this.catalogo.getLibros().size() + " libro(s) en el catálogo.");
    }

}

