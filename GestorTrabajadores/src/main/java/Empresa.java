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
        System.out.println("** Agregando empleado... **");
    }

    public void DespedirTrabajador(String dni){
        empleados.removeIf(trabajador -> trabajador.getDni().equals(dni));
        System.out.println("** Eliminando empleado... **");
    }

    public void ListarEmpleados(){
        System.out.println("** Listado de empleados **");
        for (Trabajador empleado : empleados) {
            System.out.println(empleado.ListarTrabajador());
        }
    }
}
