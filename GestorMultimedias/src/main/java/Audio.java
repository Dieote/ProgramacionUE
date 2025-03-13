import lombok.Data;

@Data
public class Audio extends Multimedia{

    private double duracion;
    private String soporte;

    public Audio() {
    }

    public Audio(int id, String titulo, String autor, double tamanio, String formato, double duracion, String soporte) {
        super(id, titulo, autor, tamanio, formato);
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
