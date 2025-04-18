import java.util.ArrayList;
import java.util.Scanner;

public class Catalogo {

    private ArrayList<Libro> libros;
    private int capacidad;
    private static Scanner input = new Scanner(System.in);


    public Catalogo(int capacidad) {
        this.capacidad = capacidad;
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro){
        System.out.println("Ingrese los datos del libro...");
        System.out.println("Ingrese nombre: ");
            String nombre = input.nextLine();
        System.out.println("Ingrese Autor: ");
            String autor = input.nextLine();
        System.out.println("Ingrese numero de paginas: ");
            int paginas = input.nextInt();
        System.out.println("Ingrese la seccion a la que pertenece: ");
            String seccion = input.nextLine();
        System.out.println("Ingrese la seccion a la que pertenece: ");
            String isbn = input.nextLine();
        libros.add(new Libro(nombre, autor, paginas, seccion, isbn));
    }

    public void eliminarLibro(String isbn){
            System.out.println("Ingrese el ISBN para eliminar un libro.");
                String isbnElimanar = input.nextLine();

        if (libros.removeIf(libro -> libro.equals(isbnElimanar))) {
            System.out.println("Elemento eliminado correctamente.");
        } else {
            System.out.println("Error al intentar eliminar.");
        }
    }

    public void buscarLibro(String isbn){}

    public void listarLibros(){}

}
