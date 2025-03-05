import lombok.Data;

@Data
public class Asalariado extends Trabajador {

    private int numeroDePagas;
    private boolean contratado;
    private double retenciones;

    public Asalariado(boolean contratado, int numeroDePagas) {
        this.contratado = contratado;
        this.numeroDePagas = numeroDePagas;
    }

    public Asalariado(String nombre, String apellido, String dni, double salario, boolean contratado, int numeroDePagas) {
        super(nombre, apellido, dni, salario);
        this.contratado = contratado;
        this.numeroDePagas = numeroDePagas;
    }

    public boolean estaContratado(){
        return contratado;
    }

    @Override
    public void calcularSalarioMensual() {
        double salarioMes = (getSalario()-(getSalario()*retenciones))/ numeroDePagas;
        System.out.println("El salario mensual es: "+salarioMes);
    }
    @Override
    public String toString(){
       return super.toString() + " | Numero de Pagas: " + numeroDePagas + " | Retenciones: " + retenciones;
    }
}
