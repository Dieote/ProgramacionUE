import lombok.Data;
import java.util.ArrayList;

@Data
public class Empresa {

    private ArrayList<Trabajador> empleados;

    public Empresa(ArrayList<Trabajador> empleados) {
        this.empleados = empleados;
    }

    public void RegistrarTrabajador(Trabajador empleado){
        System.out.println("** Agregando empleado... **");
        if (empleado instanceof Jefe){
            if (hayJefe()){
                System.out.println("Ya existe un jefe en la empresa.");
            } else {
                empleados.add(empleado);
            }
        } else {
            empleados.add(empleado);
        }
    }

    private boolean hayJefe(){
        for( Trabajador empleado : empleados){
            if (empleado instanceof Jefe){
                return true;
            }
        }
        return false;
    }

    public void DespedirTrabajador(String dni){
        empleados.removeIf(trabajador -> trabajador.getDni().equals(dni));
        System.out.println("** Eliminando empleado... **");
    }

    public void ListarEmpleados() {
        System.out.println("** Listado de empleados **");
        for (Trabajador empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }
    public Trabajador buscarDni(String dni){
            for (Trabajador empleado : empleados){
                if (empleado.getDni() == dni){
                    return empleado;
                }
            }
            return null;
        }

    public Trabajador buscarNombre(String nombre){
        for (Trabajador empleado : empleados){
            if (empleado.getNombre() == nombre){
                return empleado;
            }
        }
        return null;
    }

    }
