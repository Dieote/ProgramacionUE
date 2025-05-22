import java.io.Console;
import java.util.ArrayList;

public class Prueba {

    public static void main(String[] args) {

        Figura2D[] figuras = new Figura2D[3];

        figuras[0] = new Circulo("Circulo",1.9);
        figuras[1] = new Rectangulo("Rectangulo",1.5,2);
        figuras[2] = new Triangulo("Triangulo",4,5.5,4);

        for (Figura2D item : figuras){
            System.out.print("Las figuras dentro del array unidimensional son: " + item.getNombre());
            System.out.println(" Con perimetro " + item.calcularPerimetro());
        }


    ArrayList<Figura2D> figurasList = new ArrayList<>();

    Circulo circulo1 = new Circulo("Circulo1", 2.5);
    Rectangulo rectangulo1 = new Rectangulo("Rectangulo1", 2.2, 4);
    Triangulo triangulo1 = new Triangulo("Triangulo1", 2, 2, 2);

        figurasList.add(circulo1);
        figurasList.add(rectangulo1);
        figurasList.add(triangulo1);

    for (Figura2D item : figurasList){
        System.out.print("Las figuras dentro del arraylist son: " + item.getNombre());
        System.out.println(" Con perimetro " + item.calcularPerimetro());
    }

    }
}
