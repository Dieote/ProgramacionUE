import lombok.Data;

@Data
abstract public class asalariado extends trabajadores{

    public int numeroDePagas;
    public boolean contratado = true;

    public asalariado(boolean contratado, int numeroDePagas) {
        this.contratado = contratado;
        this.numeroDePagas = numeroDePagas;
    }

    public asalariado(String nombre, String apellido, String dni, double salario, boolean contratado, int numeroDePagas) {
        super(nombre, apellido, dni, salario);
        this.contratado = contratado;
        this.numeroDePagas = numeroDePagas;
    }
}
