import lombok.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

    @Data
    public class Estudiante {

        private String nombre;
        private int edad;
        private double nota1;
        private double nota2;
        private double nota3;

        public Estudiante() {
        }

        public Estudiante(String nombre, int edad, double nota1, double nota2, double nota3) {
            this.nombre = nombre;
            this.edad = edad;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.nota3 = nota3;
        }

        public double notaMedia() {
            return (nota1 + nota2 + nota3) / 3.0;
        }


        @Override
        public String toString() {
            return "Estudiante " +
                    " Nombre= " + nombre +
                    " - edad= " + edad +
                    "| nota1= " + nota1 +
                    "| nota2= " + nota2 +
                    "| nota3= " + nota3;
        }


        public static void main(String[] args) throws FileNotFoundException {

            Estudiante estudiante1 = new Estudiante("Juan", 27, 3.2, 5.6, 8.3);
            Estudiante estudiante2 = new Estudiante("Ana", 35, 7.4, 4.5, 9);

            ArrayList<Estudiante> estudiante = new ArrayList<>();

            estudiante.add(estudiante1);
            estudiante.add(estudiante2);

            System.out.println("<<<<<< Datos en ArrayList >>>>>>");
            for (Estudiante item : estudiante) {
                System.out.print("Datos del estudiante: " + item.getNombre() + " - " + item.getEdad() + " años | ");
                System.out.println("La nota media = " + item.notaMedia());

                Estudiante[] estudianteArray = new Estudiante[2];

                estudianteArray[0] = new Estudiante("Juan", 27, 3.2, 5.6, 8.3);
                estudianteArray[1] = new Estudiante("Ana", 35, 7.4, 6.5, 9);

                System.out.println("----------------------------------------------");

                System.out.println("<<<<< Datos en Array >>>>>>");
                for (Estudiante cosa : estudianteArray) {
                    System.out.println(cosa.getNombre() + " edad " + cosa.getEdad());
                    System.out.println("Nota Media= " + cosa.notaMedia());
                }
            }
        }


   public static ArrayList<Estudiante> leerEstudiantesList(String nombreFichero) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("estudiantes.txt"));
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        String linea;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");

            if (partes.length == 5) {
                String nombre = partes[0].trim();
                int edad = Integer.parseInt(partes[1].trim());
                double nota1 = Double.parseDouble(partes[2].trim());
                double nota2 = Double.parseDouble(partes[3].trim());
                double nota3 = Double.parseDouble(partes[4].trim());

                // Crear objeto estudiante y añadir a la lista
                estudiantes.add(new Estudiante(nombre, edad, nota1, nota2, nota3));
            }
        }
        br.close();
        return estudiantes;
    }

        public static Estudiante[] leerEstudiantesArray(String nombreFichero) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            ArrayList<Estudiante> tempList = new ArrayList<>();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String nombre = partes[0].trim();
                    int edad = Integer.parseInt(partes[1].trim());
                    double nota1 = Double.parseDouble(partes[2].trim());
                    double nota2 = Double.parseDouble(partes[3].trim());
                    double nota3 = Double.parseDouble(partes[4].trim());
                    tempList.add(new Estudiante(nombre, edad, nota1, nota2, nota3));
                }
            }
            br.close();

            // Convertir ArrayList a array fijo
            return tempList.toArray(new Estudiante[0]);
        }
    }
