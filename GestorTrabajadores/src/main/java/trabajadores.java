import lombok.Data;

@Data
abstract public class trabajadores {

    public String nombre;
    public String apellido;
    public String dni;
    public double salario;

    public trabajadores() {}

    public trabajadores(String nombre, String apellido, String dni, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.salario = salario;
    }
}
