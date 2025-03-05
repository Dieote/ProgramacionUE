import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Trabajador> empleados = new ArrayList<>();
        int option;

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


                    break;
                case 2:
                    System.out.println("** Buscar empleado por NOMBRE. **");


                    break;
                case 3:
                    System.out.println("** ABuscar empleado por DNI. **");


                    break;
                case 4:
                    System.out.println("** Listar empleados. **");


                    break;
                case 5:
                    System.out.println("** Eliminar empleado **");


                    break;
                case 6:
                    System.out.println("Saliendo del programa--->");
                    break;
            }
        } while (option != 6);
            input.close();
    }
}
