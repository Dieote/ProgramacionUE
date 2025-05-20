import lombok.Data;

import java.util.Objects;

@Data
public class Circulo extends Figura2D{

    private double radio;

    public Circulo() {
    }

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public String toString() {
        return super.toString() + " Circulo: " +
                "| Radio= " + radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * radio * Math.PI ;
    }
}
