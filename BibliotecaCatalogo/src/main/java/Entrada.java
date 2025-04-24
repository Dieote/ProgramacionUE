import Enums.*;
import Excepciones.*;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Biblioteca biblioteca = null;
        Biblioteca bibliotecaEspania = new Biblioteca("Biblioteca España", "Borja Martin",null);
        System.out.println("Biblioteca Creada: " + bibliotecaEspania.getNombre());

        bibliotecaEspania.construirCatalogo(4);
        System.out.println("Catalago creado con capacidad de 4 libros.");

        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroTerror("It", "Stephen King", 1000, "111", 4.5));
        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroComedia("Don Quijote", "Cervantes", 900, "222", TipoHumor.SATIRICO));
        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroPoliciaco("Sherlock Holmes", "Conan Doyle", 300, "333", TramaPoliciaca.MISTERIO, "Sherlock, Watson"));
        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroTerror("El Resplandor", "Stephen King", 500, "444", 4.8));
        bibliotecaEspania.agregarLibroEnBiblioteca(new LibroComedia("Los Simpsons", "Matt Groening", 250, "555", TipoHumor.ABSURDO)); // aquí se debe lanzar excepción

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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;

            }
        } while (opcion != 9);



    }
}
