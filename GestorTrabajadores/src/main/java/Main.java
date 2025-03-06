import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Empresa empresa = new Empresa();
        int option, tipo;

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

            switch (option) {
                case 1:
                    System.out.println("Seleccione el tipo de trabajador a registrar:");
                    System.out.println("1. Asalariado");
                    System.out.println("2. Autónomo");
                    System.out.println("3. Jefe");
                    System.out.print("Opción: ");
                    tipo = input.nextInt();
                    input.nextLine();
                    System.out.println("Ingrese los datos del trabajador::");
                    System.out.print("Ingrese nombre: ");
                    String nombre = input.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellido = input.nextLine();
                    System.out.print("Ingrese DNI: ");
                    String dni = input.nextLine();
                    System.out.print("Ingrese salario: ");
                    double salario = input.nextDouble();
                    input.nextLine();

                    Trabajador trabajadorNuevo = null;

                    if (tipo == 1) {
                        System.out.print("Ingrese número de pagas: ");
                        int numeroPagas = input.nextInt();
                        input.nextLine();
                        trabajadorNuevo = new Asalariado(nombre, apellido, dni, salario, true, numeroPagas);
                    } else if (tipo == 2) {
                        trabajadorNuevo = new Autonomo(nombre, apellido, dni, salario, true);
                    } else if (tipo == 3) {
                        System.out.print("Ingrese el porcentaje de acciones: ");
                        double acciones = input.nextDouble();
                        input.nextLine();
                        trabajadorNuevo = new Jefe(nombre, apellido, dni, salario, acciones);
                    } else {
                        System.out.println("Opción no válida.");
                        break;
                    }
                    empresa.RegistrarTrabajador(trabajadorNuevo);
                    break;

                case 2:
                    System.out.println("** Buscar empleado por NOMBRE. **");
                    System.out.println("Ingrese nombre a buscar:.");
                    String nombreABuscar = input.nextLine();
                    Trabajador empleadoPorNombre = empresa.buscarNombre(nombreABuscar);

                    if (empleadoPorNombre != null) {
                        System.out.println("La busqueda coincide con # ");
                        empleadoPorNombre.mostrarInfo();
                    } else {
                        System.out.println("No hay coincidencias en la busqueda por nombre.");
                     }
                    break;
                case 3:
                    System.out.println("** Buscar empleado por DNI. **");
                    System.out.println("Ingrese nombre a buscar:.");
                    String dniABuscar = input.nextLine();
                    Trabajador empleadoPorDni = empresa.buscarDni(dniABuscar);

                    if (empleadoPorDni != null) {
                        System.out.println("La busqueda coincide con # ");
                        empleadoPorDni.mostrarInfo();
                    } else {
                     System.out.println("No hay coincidencias en la busqueda por DNI.");
                    }
                    break;
                case 4:
                    System.out.println("¿Qué tipo de empleados desea listar?");
                    System.out.println("1. Todos");
                    System.out.println("2. Asalariados");
                    System.out.println("3. Autónomos");
                    System.out.print("Seleccione una opción: ");

                    tipo = input.nextInt();
                    input.nextLine();
                    seleccionarTipoEmpleado(empresa, tipo);
                    break;
                case 5:
                    System.out.println("** Eliminar empleado **");
                    System.out.println("Ingrese un DNI para eliminar el empleado: ");
                    String dniAEliminar = input.nextLine();
                    empresa.DespedirTrabajador(dniAEliminar);
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    break;
            }
        } while (option != 6);
        input.close();
    }

public static void seleccionarTipoEmpleado(Empresa empresa, int tipo) {
     if (tipo == 1) {
        empresa.ListarEmpleados();
    }else if (tipo == 2) {
        for (Trabajador trabajador : empresa.getEmpleados()) {
            if (trabajador instanceof Asalariado) {
                trabajador.mostrarInfo();
            }
        }
    } else if (tipo == 3) {
        for (Trabajador trabajador : empresa.getEmpleados()) {
            if (trabajador instanceof Autonomo) {
                trabajador.mostrarInfo();
            }
        }
    }else {
        System.out.println("Opcion no valida.");
    }
}
    }
