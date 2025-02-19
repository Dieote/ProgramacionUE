package EjercicioCoche;

import java.util.ArrayList;
import java.util.Scanner;

public class Carrera {
    Scanner input = new Scanner(System.in);

    private ArrayList<Coche> corredores;
    private Coche ganador;
    private int kmTotales, numVueltas;

    public Carrera (){
    }
    public Carrera ( int kmTotales, int numVueltas){
        this.kmTotales = kmTotales;
        this.numVueltas = numVueltas;
    }
    public Carrera(ArrayList<Coche> corredores) {
        this.corredores = corredores;
    }

    private Coche seleccionarCoche(ArrayList<Coche> cochesDisponibles){
        System.out.println("**Listado de coches disponibles**");


        for (int i = 0; i < cochesDisponibles.size(); i++) { //Maximo 2 coches
            System.out.println("Coche " + (i + 1) + ": " + cochesDisponibles.get(i).listarCoches());
        }
        System.out.println();
        System.out.println("Que coche deseas escoger.");
        int numElegido = input.nextInt()-1;

        while(numElegido < 0 || numElegido >= cochesDisponibles.size() ){
            System.out.println("Indice no valido. Escoge nuevamente.");
            numElegido = input.nextInt()-1;
        }
        return cochesDisponibles.get(numElegido);
        }

        public void seleccionarCorredor(ArrayList<Coche> cochesDisponibles){
            if (cochesDisponibles.size() < 2){
                System.out.println("No hay suficientes coches para ccomenzar la carrera.");
                return;
            }
            corredores = new ArrayList<>(); //se inicializa la lista

            System.out.println("Seleccion coche 1: ");
            Coche coche1 = seleccionarCoche(cochesDisponibles);
            cochesDisponibles.remove(coche1);

            System.out.println("Seleccion coche 2: ");
            Coche coche2 = seleccionarCoche(cochesDisponibles);

            corredores.add(coche1);
            corredores.add(coche2);

            System.out.println("¡! Participantes seleccionados ¡!");
            System.out.println("* 1. " + coche1.listarCoches());
            System.out.println("* 2. " + coche2.listarCoches());

        }

        public Coche iniciarCarrera(){
            if (corredores.size() < 2){
                System.out.println("No hay suficientes coches para comenzar la carrera.");
                return null;
            }
            System.out.println("¡¡ Comienza la carrera !!");
            for (Coche coche : corredores) {
            System.out.println(coche.listarCoches());
            System.out.printf(" - Velocidad: %s - Kilometros: %s %n", coche.getVelocidad(),coche.getKmRecorridos());
            }

            //Vueltas
            for(int vuelta = 1; vuelta <= numVueltas; vuelta++){
                System.out.printf("%nVuelta Numero: %d de %d%n",vuelta, numVueltas);
                
                for (Coche coche : corredores) {
                    System.out.printf("%nIngrese la velocidad del coche %s - Matricula %s:", coche.getMarca(),coche.getMatricula());
                    int aceleracion = input.nextInt();
                    coche.acelerar(aceleracion);
                }
            }

            //distancia
               ganador = corredores.get(0);
               for (Coche coche : corredores) {
                    if (coche.getKmRecorridos() >= kmTotales) {
                        this.ganador = coche;
                        System.out.printf("%n ¡¡ El ganador por llegar primero a los kilometros !!%n");
                        System.out.printf("%n ## Matricula: %s - Coche: %s !!" + ganador.getMatricula(), ganador.getMarca());
                        return ganador;
               }
               // Si ninguna condición de victoria se cumple, gana el coche con más km recorridos
               if (coche.getKmRecorridos() > ganador.getKmRecorridos()) {
                   ganador = coche;
                }
            }
            System.out.printf("%n !!! CARRERA FINALIZADA ¡¡¡ %n");
            return ganador;

    }
}