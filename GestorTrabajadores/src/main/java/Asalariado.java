import lombok.Data;

@Data
abstract public class Asalariado extends Trabajador {

    public int numeroDePagas;
    public boolean contratado = true;

    public Asalariado(boolean contratado, int numeroDePagas) {
        this.contratado = contratado;
        this.numeroDePagas = numeroDePagas;
    }

    public Asalariado(String nombre, String apellido, String dni, double salario, boolean contratado, int numeroDePagas) {
        super(nombre, apellido, dni, salario);
        this.contratado = contratado;
        this.numeroDePagas = numeroDePagas;
    }
}
