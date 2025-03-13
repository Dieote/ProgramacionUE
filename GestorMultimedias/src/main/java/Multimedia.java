import lombok.Data;

@Data
abstract public class Multimedia {

    private int id;
    private String titulo;
    private String autor;
    private double tamanio;
    private String formato;

    public Multimedia() {
    }

    public Multimedia(int id, String titulo, String autor, double tamanio, String formato) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.tamanio = tamanio;
        this.formato = formato;
    }

    public String mostrarInfo() {
        return "Multimedia: " +
                "ID - " + id +
                ", Titulo='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", Tamaño=" + tamanio +
                ", Formato='" + formato;
    }

}