import lombok.Data;

@Data
public class jefe extends trabajadores{

    public boolean accion = true;

    public jefe(boolean accion) {
        this.accion = accion;
    }

    public jefe(String nombre, String apellido, String dni, double salario, boolean accion) {
        super(nombre, apellido, dni, salario);
        this.accion = accion;
    }
}
