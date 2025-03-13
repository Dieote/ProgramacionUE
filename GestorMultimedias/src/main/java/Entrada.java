import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrada {

    private static ArrayList<Multimedia> coleccionMultimedia = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    static {
        coleccionMultimedia.addAll(Libro.librosEnBiblioteca);
        coleccionMultimedia.addAll(Audio.audiosEnAudioteca);
        coleccionMultimedia.addAll(Video.videosEnVideoteca);
    }


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
                        eliminarElemento();
                        break;
                    case 3:
                        listarElemento();
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
        System.out.print("Seleccione una opción: ");
        int tipo = input.nextInt();
        input.nextLine();

        System.out.println("Indique el ID; ");
        int identificador = input.nextInt();
        input.nextLine();

       if (coleccionMultimedia.stream().anyMatch(m -> m.equals(identificador))){ //no utilizo equals porque es int id , no string
            System.out.println("Ya existe un elemento multimedia con ese ID. Intente nuevamente.");
            return;
        }

        System.out.print("Título: ");
        String titulo = input.nextLine();
        System.out.print("Autor: ");
        String autor = input.nextLine();
        System.out.print("Tamaño en MB/GB: ");
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
                coleccionMultimedia.add(new Libro(identificador, titulo, autor, tamanio, formato, ISBN, paginas));
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
                coleccionMultimedia.add(new Video(identificador, titulo, autor, tamanio, formato,  director,   actores));
                break;
            case 3:
                System.out.println("Cuanto dura el audio?: ");
                double duracionAudio = input.nextDouble();
                System.out.print("En que soporte esta subido? : ");
                String soporteAudio = input.nextLine();
                input.nextLine();
                coleccionMultimedia.add(new Audio(identificador, titulo, autor, tamanio, formato, duracionAudio, soporteAudio));
                break;
            default:
                System.out.println("Opcion no valida.");
                return;
        }
        System.out.println("Elemento agregado correctamente.");
    }

    private static void  eliminarElemento(){
        System.out.println("Ingrese el identificador del elemento a eliminar.");
        int idEliminar = input.nextInt();

        if (!coleccionMultimedia.removeIf(elemento -> elemento.equals(idEliminar))) {
            System.out.println("Error al eliminar elemento.");
        } else {
            System.out.println("Elemento eliminado correctamente.");
        }
    }

    //Revisar metodo
    private static void listarElemento(){
        System.out.println("Que elementos quieres listar 1. Libros | 2- Videos | 3. Audios | 4. Todos");
        int tipo = input.nextInt();
        input.nextLine();

        List<Multimedia> buscados = new ArrayList<>();
        switch (tipo){
            case 1:
                System.out.println("** Mostrando BIBLIOTECA..");
               // buscados = coleccionMultimedia.stream().filter(cinta -> cinta instanceof Libro).collect(Collectors.toList());
                break;
            case 2:
                System.out.println("** Mostrando VIDEOTECA..");
               // buscados = coleccionMultimedia.stream().filter(cinta -> cinta instanceof Video).collect(Collectors.toList());
                break;
            case 3:
                System.out.println("** Mostrando AUDIOTECA..");
              //  buscados = coleccionMultimedia.stream().filter(cinta -> cinta instanceof Audio).collect(Collectors.toList());
                break;
            case 4:
                if (!coleccionMultimedia.isEmpty()) {
                    System.out.println("** Mostrando TODOS los elementos existentes..");
                    buscados.addAll(coleccionMultimedia);
            } else {
                    System.out.println("La colección multimedia está vacía.");
                }
                break;
            default:
                System.out.println("Opcion no valida. Intente nuevamente.");
                return;
        }
        if (buscados.isEmpty()) {
            System.out.println("No hay elementos para mostrar.");
        } else {
            buscados.forEach(multimedia -> System.out.println(multimedia.mostrarInfo()));
        }
    }

  }
