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

    public Libro(int id, String titulo, String autor, String formato, double tamanio, String ISBN, int numeroPaginas) {
        super(id, titulo, autor, formato, tamanio);
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", ISBN=" + ISBN +
                ", Numero de Paginas=" + numeroPaginas;
    }
}
