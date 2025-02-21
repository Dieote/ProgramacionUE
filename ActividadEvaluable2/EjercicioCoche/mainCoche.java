package EjercicioCoche;

import java.util.ArrayList;
import java.util.Scanner;

public class mainCoche {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Coche> cocheStock = new ArrayList<>();
        int option;


        cocheStock.add(new Coche("Honda", "Civic",158, 1996 , "ABC000"));
        cocheStock.add(new Coche("Ford", "Focus",120, 1496 , "ABC001"));
        cocheStock.add(new Coche("Toyota", "Corolla",132, 1798 ,"ABC002"));



        do {
            System.out.println();
            System.out.println("<----- MENÚ  App de Carreras----->");
            System.out.println("1. Agregar coches.");
            System.out.println("2. Buscar coche por marca.");
            System.out.println("3. Listar coches.");
            System.out.println("4. Iniciar carrera.");
            System.out.println("5. Salir");
            System.out.printf("%nSeleccione una opción: ");
            option = input.nextInt();
            input.nextLine();


            switch (option) {
                case 1:
                    System.out.println("** Agregar coche nuevo **");

                    for (int i = 0; i <= 0; i++) { 
                        System.out.println("Coche " + (i + 1) + ":");

                        System.out.println("Ingrese la Marca: ");
                        String marca = input.nextLine();
                        System.out.println("Ingrese modelo: ");
                        String modelo = input.nextLine();
                        System.out.println("Ingrese caballos de potencia: ");
                        int cv = input.nextInt();
                        input.nextLine();
                        System.out.println("Ingrese cilindradas: ");
                        int cc = input.nextInt();
                        input.nextLine();
                        System.out.println("Ingrese matricula: ");
                        String matricula = input.nextLine();

                        Coche cocheNew = new Coche(marca, modelo, cv, cc, matricula);
                        cocheStock.add(cocheNew);
                    }
                    break;
                case 2:
                     System.out.println("Que marca de coche quiere buscar.??");
                    String buscarMarca = input.nextLine();

                    boolean coincide = false;

                    for (Coche coche : cocheStock) {
                        if (coche.getMarca().equalsIgnoreCase(buscarMarca)) {
                            coincide = true;
                            System.out.println("Coincide la busqueda - " + coche);
                        }
                    }
                    if (!coincide) {
                        System.out.println("No hay coincidencias en la busqueda.");
                    }
                    break;
                case 3:
                    System.out.println("** Listado de coches **");
                    for (Coche coche : cocheStock) {
                        System.out.println(coche.listarCoches());
                    }
                    break;
                case 4:
                        if (cocheStock.size() < 2) {
                            System.out.println("No hay coches disponibles.");
                            break;
                        }

                        System.out.println("** Iniciar carreras **");
                            
                //sobre la pista
                        System.out.println("Ingrese los kilometros que tiene la pista.");
                        int kmTotales = input.nextInt();
                        System.out.println("Ingrese la cantidad de vueltas de la carrera.");
                        int numVueltas = input.nextInt();

                        Carrera circuito = new Carrera(kmTotales, numVueltas);
                        
                       circuito.seleccionarCorredor(new ArrayList<>(cocheStock));
                       
                        Coche ganador = circuito.iniciarCarrera();
                       if (ganador != null) {
                           System.out.println();
                         System.out.println("!* !* !* DATOS DE LA CARRERA *¡ *¡ *¡");
                         System.out.printf("!* GANADOR %s %s - Matricula: %s *¡%n", ganador.getMarca(), ganador.getModelo() ,ganador.getMatricula()); 
                       }
                        break;                   
                case 5:
                    System.out.println("Saliendo del programa--->");
                    break;
            }
        } while (option != 5);
        input.close();
    }
}