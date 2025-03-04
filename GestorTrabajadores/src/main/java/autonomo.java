import lombok.Data;
@Data
abstract public class autonomo extends trabajadores{

    public boolean contratado = true;

    public autonomo(boolean contratado) {
        this.contratado = contratado;
    }

    public autonomo(String nombre, String apellido, String dni, double salario, boolean contratado) {
        super(nombre, apellido, dni, salario);
        this.contratado = contratado;
    }
}
