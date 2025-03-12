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

    public Multimedia(int id, String titulo, String autor, String formato, double tamanio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.tamanio = tamanio;
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