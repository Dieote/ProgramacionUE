import lombok.Data;

@Data
public class Jefe extends Trabajador {

    public boolean accion = true;

    public Jefe(boolean accion) {
        this.accion = accion;
    }

    public Jefe(String nombre, String apellido, String dni, double salario, boolean accion) {
        super(nombre, apellido, dni, salario);
        this.accion = accion;
    }
}
