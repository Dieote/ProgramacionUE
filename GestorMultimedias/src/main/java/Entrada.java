import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrada {

    private static final List<Multimedia> coleccionMultimedia = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        do {
            System.out.println("\nGestión de colección multimedia");
            System.out.println("1. Añadir a la colección");
            System.out.println("2. Eliminar de la colección");
            System.out.println("3. Listar elementos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = input.nextInt();
            input.nextLine();
                switch (opcion){
                    case 1:
                        agregarElemento();
                        break;
                    case 2:
                        //eliminarElemento();
                        break;
                    case 3:
                        //listarElemento();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                }
        } while (opcion!=4);
    }

    //Funciones del switch

    private static void agregarElemento(){
        System.out.println("Que tipo de elemento multimedia quieres agregar?");
        System.out.println("1. Libro");
        System.out.println("2. Video");
        System.out.println("3. Audio");
        int tipo = input.nextInt();
        input.nextLine();

        System.out.println("Indique el ID; ");
        int identificador = input.nextInt();
        input.nextLine();

        //revisar porque no encuentra getId() de clase Multimedia
        if (coleccionMultimedia.stream().anyMatch((m -> m.getId() == identificador))){ //no utilizo equals porque es int id , no string
            System.out.println("Ya existe un elemento multimedia con ese ID. Intente nuevamente.");
            return;
        }

        System.out.print("Título: ");
        String titulo = input.nextLine();
        System.out.print("Autor: ");
        String autor = input.nextLine();
        System.out.print("Tamaño: ");
        double tamanio = input.nextDouble();
        input.nextLine();
        System.out.print("Formato: ");
        String formato = input.nextLine();

        switch (tipo){
            case 1:
                System.out.print("ISBN: ");
                String ISBN = input.nextLine();
                System.out.print("NUmero de Paginas: ");
                int paginas = input.nextInt();
                input.nextLine();
                coleccionMultimedia.add(new Libro(identificador, titulo, autor, formato, tamanio, ISBN, paginas));
                break;
            case 2:
                System.out.println("Nombre del Director: ");
                String nombreDirector = input.nextLine();
                System.out.print("DNI del director: ");
                String directorDni = input.nextLine();
                Director director = new Director(nombreDirector, directorDni);

                List<Actor> actores = new ArrayList<>();
                System.out.println("Cuantos actores participan?");
                int cantidadActores = input.nextInt();
                input.nextLine();
                for (int i = 0; i < cantidadActores; i++) {
                    System.out.print("Nombre del actor: ");
                    String actorNombre = input.nextLine();
                    System.out.print("DNI del actor: ");
                    String actorDni = input.nextLine();
                    actores.add(new Actor(actorNombre, actorDni));
                }
                coleccionMultimedia.add(new Video(identificador, titulo, autor, formato, tamanio,  director,   actores));
                break;
            case 3:
                System.out.println("Cuanto dura el audio?: ");
                double duracionAudio = input.nextDouble();
                System.out.print("En que soporte esta subido? : ");
                String soporteAudio = input.nextLine();
                coleccionMultimedia.add(new Audio(identificador, titulo, autor, formato, tamanio, duracionAudio, soporteAudio));
                break;
            default:
                System.out.println("Opcion no valida.");
                return;
        }
        System.out.println("Elemento agregado correctamente.");
    }
}
