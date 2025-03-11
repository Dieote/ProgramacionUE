import lombok.Data;

@Data
abstract public class Multimedia {

    public int identificador;
    public String titulo;
    public String autor;
    public double tamanio;
    public String formato;


    public Multimedia() {
    }

    public Multimedia(int identificador, String titulo, String autor, String formato, double tamanio) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.autor = autor;
        this.formato = formato;
        this.tamanio = tamanio;
    }

        public String mostrarInfo() {
        return "Multimedia: " +
                "ID - " + identificador +
                ", Titulo='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", Tamaño=" + tamanio +
                ", Formato='" + formato;
    }
}
