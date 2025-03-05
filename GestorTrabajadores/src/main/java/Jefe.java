import lombok.Data;

@Data
public class Jefe extends Trabajador {

    public String rol = "JEFE";
    public boolean accion = true;

    public Jefe(boolean accion) {
        this.accion = accion;
    }

    public Jefe(String nombre, String apellido, String dni, double salario, boolean accion) {
        super(nombre, apellido, dni, salario);
        this.accion = accion;
    }

    @Override
    public String toString(){
        return super.toString() + " | Acciones: " + accion + " | Rol: " + rol;
    }
}
