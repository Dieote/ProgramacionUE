import lombok.Data;
@Data
public class Libro extends Multimedia{

    private String ISBN;
    private int numeroPaginas;

    public Libro() {
    }

    public Libro(String ISBN, int numeroPaginas) {
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    public Libro(int id, String titulo, String autor, double tamanio, String formato, String ISBN, int numeroPaginas) {
        super(id, titulo, autor, tamanio, formato);
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", ISBN=" + ISBN +
                ", Numero de Paginas=" + numeroPaginas;
    }
}
