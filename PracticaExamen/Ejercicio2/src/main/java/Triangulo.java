import lombok.Data;

import java.util.Objects;

@Data
public class Triangulo extends Figura2D{

    private double ladoUno;
    private double ladoDos;
    private double ladoTres;


    public Triangulo() {
    }

       public Triangulo(String nombre, double ladoUno, double ladoDos, double ladoTres) {
        super(nombre);
        this.ladoUno = ladoUno;
        this.ladoDos = ladoDos;
        this.ladoTres = ladoTres;

    }

    @Override
    public String toString() {
        return " Triangulo: " +
                "| LadoUno= " + ladoUno +
                " - LadoDos= " + ladoDos +
                " - LadoTres= " + ladoTres;
    }

    @Override
    public double calcularPerimetro() {
        return ladoUno + ladoDos + ladoTres;
    }
}
