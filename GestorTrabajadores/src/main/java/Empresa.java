import lombok.Data;
import java.util.ArrayList;

@Data
public class Empresa {

    private ArrayList<Trabajador> empleados;

    public Empresa(ArrayList<Trabajador> empleados) {
        this.empleados = empleados;
    }

    public void RegistrarTrabajador(Trabajador empleado){
        empleados.add(empleado);
    }

    public void DespedirTrabajador(Trabajador empleado){
        empleados.remove(empleado);
    }

    public void ListarEmpleados(Trabajador empleado){
        System.out.println("** Listado de empleados **");
        for (Trabajador empleado : empleados) {
            System.out.println(empleado.ListarTrabajador());
        }
    }
}
