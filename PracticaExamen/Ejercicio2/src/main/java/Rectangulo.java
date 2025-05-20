import lombok.Data;

import java.util.Objects;

@Data
public class Rectangulo extends Figura2D{

    private double longitudBase;
    private double longitudAltura;

    public Rectangulo() {
    }

    public Rectangulo(String nombre, double longitudBase, double longitudAltura) {
        super(nombre);
        this.longitudBase = longitudBase;
        this.longitudAltura = longitudAltura;
    }

    @Override
    public String toString() {
        return super.toString() + " Rectangulo: " +
                " | LongitudBase= " + longitudBase +
                " - LongitudAltura= " + longitudAltura;
    }

    @Override
    public double calcularPerimetro() {
        return 2*longitudBase + 2*longitudAltura;
    }
}
