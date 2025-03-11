import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Entrada {

    private List<Multimedia> coleccionMultimedia = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

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
                        añadirElemento();
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

    private void añadirElemento(){

        System.out.println("Que tipo de elemento multimedia quieres agregar?");
        System.out.println("1. Libro");
        System.out.println("2. Video");
        System.out.println("3. Audio");
        input.nextInt();
        input.nextLine();

        System.out.println("Indique el ID; ");
        int id = input.nextInt();

        if (coleccionMultimedia.stream().anyMatch(multi -> Objects.equals(multi.getIdentificador(), id))){
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

        switch (input){
            case 1:
                System.out.print("ISBN: ");
                String ISBN = input.nextLine();
                System.out.print("NUmero de Paginas: ");
                int paginas = input.nextInt();
                input.nextLine();
                coleccionMultimedia.add(new Libro(id, titulo, autor, formato, tamanio, ISBN, paginas));
                break;
            case 2:
                System.out.println("Nombre del Director: ");
                String nombreDirector = input.nextLine();
                System.out.print("DNI del director: ");
                String directorDni = input.nextLine();
                //CONTINUAR CREANDO CLASE DIRECTOR Y ACTOR - nombre ,DNI


        }

    }
}
