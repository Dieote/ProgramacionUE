package modal;

import lombok.Data;

@Data
public class Jefe extends Trabajador {

    public String rol = "JEFE";
    public double acciones;

    public Jefe(){}

    public Jefe(double acciones) {
        this.acciones = acciones;
    }

    public Jefe(String nombre, String apellido, String dni, double salario, double acciones) {
        super(nombre, apellido, dni, salario);
        this.acciones = acciones;
    }

    @Override
    public void mostrarInfo(){
        System.out.println(super.toString() + " | Acciones: %" + acciones + " | Rol: " + rol);
    }

    @Override
    public void calcularSalarioMensual() {
        System.out.println("El salario mensual es :"+getSalario());
    }

    public void despedir(Trabajador trabajador){
        if (trabajador instanceof Asalariado){
            ((Asalariado)trabajador).setContratado(false);
        } else {
            ((Autonomo)trabajador).setContratado(false);
        }
    }
}
