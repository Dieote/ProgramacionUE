import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Trabajador> empleados = new ArrayList<>();
        int option;
        boolean hayJefe = false; // Controla si ya hay un jefe en la empresa
        boolean coincide;


//        Trabajador asalariado = new Asalariado("Diego","Lopez","xxx0001",998.32,true,12);
//        Trabajador autonomo = new Autonomo("Elena","Gomez","xxx0011",1129.23,true);
//        Trabajador jefe = new Jefe("Laura", "Woolfi","xxx0111",1310.12,4.5);

        do {
            System.out.println();
            System.out.println("<----- MENÚ  App de Gestion de Empleados----->");
            System.out.println("1. Agregar empleado.");
            System.out.println("2. Buscar empleado por NOMBRE.");
            System.out.println("3. Buscar empleado por DNI.");
            System.out.println("4. Listar empleados.");
            System.out.println("5. Eliminar empleados.");
            System.out.println("6. Salir");
            System.out.printf("%nSeleccione una opción: ");
            option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1:
                    System.out.println("** Agregar empleado nuevo **");
                    System.out.println("Seleccione el tipo de empleado: ");
                    System.out.println("1. Jefe");
                    System.out.println("2. Asalariado");
                    System.out.println("3. Autónomo");
                    int tipo = input.nextInt();
                    input.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = input.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = input.nextLine();
                    System.out.print("DNI: ");
                    String dni = input.nextLine();

                    break;
                case 2:
                    System.out.println("** Buscar empleado por NOMBRE. **");
                        String buscarNombre = input.nextLine();
                        coincide = false;

                        for (Trabajador trabajador : empleados){
                            if (trabajador.getNombre().equalsIgnoreCase(buscarNombre)){
                                coincide = true;
                                System.out.println("La busqueda coincide con # " + trabajador.toString());
                            }
                        } if (!coincide){
                            System.out.println("No hay coincidencias en la busqueda.");
                         }
                    break;
                case 3:
                    System.out.println("** Buscar empleado por DNI. **");
                    String buscarDni = input.nextLine();
                    coincide = false;

                    for (Trabajador trabajador : empleados){
                        if (trabajador.getDni().equalsIgnoreCase(buscarDni)){
                            coincide = true;
                            System.out.println("La busqueda coincide con # " + trabajador.toString());
                        }
                    } if (!coincide){
                    System.out.println("No hay coincidencias en la busqueda.");
                        }
                    break;
                case 4:
                    System.out.println("** Listar empleados. **");
                    for (Trabajador trabajador : empleados){
                        System.out.println(trabajador.toString());
                        }
                    break;
                case 5:
                    System.out.println("** Eliminar empleado **");


                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    break;
            }
        } while (option != 6);
            input.close();
    }
}
