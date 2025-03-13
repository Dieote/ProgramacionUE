import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Libro extends Multimedia{

    private String ISBN;
    private int numeroPaginas;

    //Lista de libros
    public static List<Libro> librosEnBiblioteca = new ArrayList<>();

                        //MODIFICAR ID A STRING "L001"
    static {
        librosEnBiblioteca.add(new Libro(0001, "1984", "George Orwell", 1.5, "PDF", "978-0451524935", 328));
        librosEnBiblioteca.add(new Libro(0002, "Cien años de soledad", "Gabriel García Márquez", 2.0, "EPUB", "978-0307474728", 471));
        librosEnBiblioteca.add(new Libro(0003, "El Hobbit", "J.R.R. Tolkien", 1.8, "MOBI", "978-0261102217", 310));
    }

    public Libro() {
    }

    public Libro(String ISBN, int numeroPaginas) {
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    public Libro(int id, String titulo, String autor, double tamanio, String formato, String ISBN, int numeroPaginas) {
        super(id, titulo, autor, tamanio, formato);
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "\n** ISBN= " + ISBN +
                ", Numero de Paginas= " + numeroPaginas;
    }
}
