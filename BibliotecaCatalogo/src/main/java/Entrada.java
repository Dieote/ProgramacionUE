import Enums.*;
import Excepciones.*;

import java.io.*;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) throws ExceptionEspacioInsuficiente {

        Scanner input = new Scanner(System.in);

        Biblioteca biblioteca = null;
        Biblioteca bibliotecaEspania = new Biblioteca("Biblioteca España", "Borja Martin",null);
        System.out.println("Biblioteca Creada: " + bibliotecaEspania.getNombre());

        bibliotecaEspania.construirCatalogo(4);
        System.out.println("Catalago creado con capacidad de 4 libros.");

        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroTerror("It", "Stephen King", 1000, "111AAA", 4.5));
        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroComedia("Don Quijote", "Cervantes", 900, "222AAA", TipoHumor.SATIRICO));
        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroPoliciaco("Sherlock Holmes", "Conan Doyle", 300, "333AAA", TramaPoliciaca.MISTERIO, "Sherlock, Watson"));
        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroTerror("El Resplandor", "Stephen King", 500, "444AAA", 4.8));
        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroComedia("Los Simpsons", "Matt Groening", 250, "555AAA", TipoHumor.ABSURDO)); // aquí se debe lanzar excepción

        int opcion;

        do {
            System.out.println("\n MENU DE BIBLIOTECA ");
            System.out.println("1. Crear biblioteca.");
            System.out.println("2. Construir catálogo.");
            System.out.println("3. Agregar libro.");
            System.out.println("4. Eliminar libro.");
            System.out.println("5. Buscar libro.");
            System.out.println("6. Mostrar todos los libros.");
            System.out.println("7. Consultar número de libros.");
            System.out.println("8. Exportar catálogo a archivo.");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = input.nextInt();
            input.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Nombre de la biblioteca: ");
                    String nombre = input.nextLine();
                    System.out.println("Nombre de su director: ");
                    String director = input.nextLine();
                    biblioteca = new Biblioteca(nombre,director,null);
                    System.out.println("Se creo la biblioteca correctamente.");
                    break;

                case 2:
                    if (biblioteca == null){
                        System.out.println("❌ Debes crear la biblioteca primero.");
                    } else {
                        System.out.println("Capacidad del catalogo: ");
                        int capacidad = input.nextInt();
                        input.nextLine();
                        biblioteca.construirCatalogo(capacidad);
                        System.out.printf("Se creo el catalogo con capacidad %d en Biblioteca %s ", capacidad ,biblioteca.getNombre());
                    }
                    break;
                case 3:
                    if (biblioteca == null || biblioteca.getCatalogo() == null){
                        System.out.println("❌ Biblioteca o catalogo no existen.");
                        break;
                    }
                    System.out.println("Selecciona el genero del libro: ");
                    for (Genero genre : Genero.values()){
                        System.out.printf(" - %s", genre);
                    }
                    System.out.println("\nEscriba el genero elegido: ");
                    Genero genero = Genero.valueOf(input.nextLine().toUpperCase());
                    System.out.println("Nombre del libro: ");
                    String nombreLibro = input.nextLine();
                    System.out.println("Nombre del autor: ");
                    String autorLibro = input.nextLine();
                    System.out.println("Numero de paginas: ");
                    int paginasLibro = input.nextInt();
                    input.nextLine();
                    System.out.println("ISBN: ");
                    String isbnLibro = input.nextLine();

                    Libro libro = null;

                    switch (genero) {
                        case TERROR:
                            System.out.print("Calificación: ");
                            double calificacion = input.nextDouble();
                            input.nextLine();
                            libro = new LibroTerror(nombreLibro, autorLibro, paginasLibro, isbnLibro, calificacion);
                            break;
                        case COMEDIA:
                            System.out.println("Tipo de humor (NEGRO, SATIRICO, ABSURDO, BLANCO): ");
                            TipoHumor humor = TipoHumor.valueOf(input.nextLine().toUpperCase());
                            libro = new LibroComedia(nombreLibro, autorLibro, paginasLibro, isbnLibro, humor);
                            break;
                        case POLICIACA:
                            System.out.println("Trama (MISTERIO o INTROGA): ");
                            TramaPoliciaca trama = TramaPoliciaca.valueOf(input.nextLine().toUpperCase());
                            System.out.print("Personajes principales: ");
                            String personajes = input.nextLine();
                            libro = new LibroPoliciaco(nombreLibro, autorLibro, paginasLibro, isbnLibro, trama, personajes);
                            break;
                    }

                    biblioteca.agregarLibroEnBiblioteca(libro);
                    break;
                case 4:
                    System.out.println("Indique el ISBN del libro a eliminar: ");
                    String isbnEliminar = input.nextLine();
                    if (biblioteca != null) {
                        biblioteca.eliminarLibroEnBiblioteca(isbnEliminar);
                    } else {
                        throw new ExceptionBibliotecaNoExiste("❌ No se puede eliminar o la biblioteca no existe.");
                    }
                    break;
                case 5:
                    System.out.print("ISBN a buscar: ");
                    String isbnBuscar = input.nextLine();
                    if (biblioteca != null) {
                        biblioteca.buscarLibroEnBiblioteca(isbnBuscar);
                    }else {
                        throw new ExceptionBibliotecaNoExiste("❌ No se puede buscar o la biblioteca no existe.");
                    }
                    break;
                case 6:
                    if (biblioteca != null) {
                        biblioteca.mostrarTodosLosLibrosEnBiblioteca();
                    } else {
                        throw new ExceptionBibliotecaNoExiste("❌ No se puede mostrar o la biblioteca no existe.");
                    }
                    break;
                case 7:
                    if (biblioteca != null) {
                        biblioteca.consultarNumeroLibrosEnBiblioteca();
                    } else {
                        throw new ExceptionBibliotecaNoExiste("❌ No se puede consultar o la biblioteca no existe.");
                    }
                    break;
                case 8:
                    if (biblioteca == null || biblioteca.getCatalogo() == null) {
                        System.out.println("❌ No existe biblioteca o catálogo.");
                        break;
                    }

                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("libros.obj"))) {
                        out.writeObject(biblioteca.getCatalogo().getLibros());
                        System.out.println("✅ Libros exportados a 'libros.obj'");
                    } catch (IOException e) {
                        System.out.println("❌ Error al exportar: " + e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("👋 Cerrando aplicación...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");

            }
        } while (opcion != 9);



    }
}
