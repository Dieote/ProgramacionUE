import lombok.Data;

@Data
abstract public class Multimedia {

    public int identificador;
    public String titulo;
    public String autor;
    public double tamaño;
    public String formato;


    public Multimedia() {
    }

    public Multimedia(String formato, double tamaño, String autor, String titulo, int identificador) {
        this.formato = formato;
        this.tamaño = tamaño;
        this.autor = autor;
        this.titulo = titulo;
        this.identificador = identificador;
    }

    public String mostrarInfo() {
        return "Multimedia: " +
                "ID - " + identificador +
                ", Titulo='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", Tamaño=" + tamaño +
                ", Formato='" + formato;
    }
}
