import lombok.Data;
@Data
public class Autonomo extends Trabajador {

    private boolean contratado;
    private double comision = 0.50;

    public Autonomo(boolean contratado) {
        this.contratado = contratado;
    }

    public Autonomo(String nombre, String apellido, String dni, double salario, boolean contratado) {
        super(nombre, apellido, dni, salario);
        this.contratado = contratado;
    }

    @Override
    public void mostrarInfo(){
        System.out.println(super.toString() + " | Tipo: Autónomo");
    }

    public boolean estaContratado(){
        return contratado;
    }

    @Override
    public void calcularSalarioMensual(){
        double salarioMes = getSalario() * comision;
        System.out.println("El salario mensual de autonomo es -€ " + salarioMes);
    }
}
