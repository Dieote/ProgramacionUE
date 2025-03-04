import lombok.Data;

@Data
abstract public class Trabajador {

    public String nombre;
    public String apellido;
    public String dni;
    public double salario;

    public Trabajador() {}

    public Trabajador(String nombre, String apellido, String dni, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.salario = salario;
    }

    public String ListarTrabajador(){
        return toString();
    }

    @Override
    public String toString() {
        return "** Trabajador:" + "Nombre='" + nombre + " " + apellido + '\'' +
                ", DNI= Nº " + dni  + ", Salario=" + salario + ".";
    }
}
