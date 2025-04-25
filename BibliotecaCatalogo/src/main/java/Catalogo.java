import Excepciones.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;

@Data
public class Catalogo {

    @Getter
    private ArrayList<Libro> libros;
    private int capacidad;

    public Catalogo(int capacidad) {
        this.capacidad = capacidad;
        this.libros = new ArrayList<>();
    }

    public void agregarLibroEnCatalogo(Libro libro) throws ExceptionEspacioInsuficiente {
        if (libros.size() >= capacidad){
            throw new ExceptionEspacioInsuficiente("❌ No hay espacion el catalogo.");
        }
        if (libros.stream().anyMatch(l -> l.getIsbn().equalsIgnoreCase(libro.getIsbn()))){
            System.out.println("❌ Este libro existe en el catalogo actual.");
            return;
        }
        libros.add(libro);
    }

    public boolean eliminarLibroEnCatalogo(String isbn){
        return libros.removeIf(libro -> libro.getIsbn().equalsIgnoreCase(isbn));
    }

    public Libro buscarLibroEnCatalogo(String isbn) throws ExceptionLibroNoEncontrado {
               return libros.stream()
                .filter(libro -> libro.getIsbn().equalsIgnoreCase(isbn))
                .findFirst()
                .orElseThrow(() -> new ExceptionLibroNoEncontrado("❌ Libro no encontrado con ISBN: " + isbn));
        }

    public void listarLibrosEnCatalogo(){
        if (libros.isEmpty()){
            System.out.println("❌ No hay libros en el catalogo actual.");
            return;
        }
        for (Libro libro : libros) {
            System.out.println(libro.mostrarDatos());
        }
    }

}
