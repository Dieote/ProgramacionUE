package controller;

import lombok.Data;
import modal.Jefe;
import modal.Trabajador;

import java.util.ArrayList;

@Data
public class Empresa {

    private ArrayList<Trabajador> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public void RegistrarTrabajador(Trabajador empleado) {
        System.out.println("** Agregando empleado... **");
        if (empleado instanceof Jefe) {
            if (hayJefe()) {
                System.out.println("Ya existe un jefe en la empresa.");
                return;
            }
        }
        empleados.add(empleado);
        System.out.println("Empleado registrado correctamente.");
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
        boolean eliminado = empleados.removeIf(trabajador -> trabajador.getDni().equals(dni));
        System.out.println("** Eliminando empleado... **");
        if (eliminado) {
            System.out.println("Empleado con DNI-" + dni + " eliminado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void ListarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("** Listado de empleados **");
        for (Trabajador empleado : empleados) {
            empleado.mostrarInfo();
        }
    }

    public Trabajador buscarDni(String dni){
            for (Trabajador empleado : empleados){
                if (empleado.getDni().equals(dni)){
                    return empleado;
                }
            }
            return null;
        }

    public Trabajador buscarNombre(String nombre){
        for (Trabajador empleado : empleados){
            if (empleado.getNombre().equalsIgnoreCase(nombre)){
                return empleado;
            }
        }
        return null;
    }

    }
