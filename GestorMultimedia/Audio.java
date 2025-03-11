import lombok.Data;

@Data
public class Audio extends Multimedia{

    public double duracion;
    public String soporte;

    public Audio() {
    }

    public Audio(String formato, double tamaño, String autor, String titulo, int identificador, double duracion, String soporte) {
        super(formato, tamaño, autor, titulo, identificador);
        this.duracion = duracion;
        this.soporte = soporte;
    }

    public Audio(double duracion, String soporte) {
        this.duracion = duracion;
        this.soporte = soporte;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Duracion=" + duracion +
                ", Soporte=" + soporte;
    }
}
