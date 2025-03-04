import lombok.Data;
@Data
abstract public class Autonomo extends Trabajador {

    public boolean contratado = true;

    public Autonomo(boolean contratado) {
        this.contratado = contratado;
    }

    public Autonomo(String nombre, String apellido, String dni, double salario, boolean contratado) {
        super(nombre, apellido, dni, salario);
        this.contratado = contratado;
    }
}
