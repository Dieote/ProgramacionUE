import lombok.Data;

import java.util.ArrayList;

@Data
abstract public class Trabajador {

    private String nombre;
    private String apellido;
    private String dni;
    private double salario;

    public Trabajador() {}

    public Trabajador(String nombre, String apellido, String dni, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.salario = salario;
    }

    public abstract void calcularSalarioMensual();

    @Override
    public String toString() {
        return "** Trabajador:" + "Nombre='" + nombre + " " + apellido + '\'' +
                ", DNI= Nº " + dni  + ", Salario=" + salario + ".";
    }

    private static boolean existeDni(ArrayList<Trabajador> empleados, String dni){
        return empleados.stream().anyMatch(trabajador -> trabajador.getDni().equals(dni));
    }

}
