import lombok.Data;

@Data
public class Audio extends Multimedia{

    public double duracion;
    public String soporte;

    public Audio() {
    }

    public Audio(int identificador, String titulo, String autor, String formato, double tamanio, double duracion, String soporte) {
        super(identificador, titulo, autor, formato, tamanio);
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
