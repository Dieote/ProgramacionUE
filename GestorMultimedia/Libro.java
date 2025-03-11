import lombok.Data;
@Data
public class Libro extends Multimedia{

    public int ISBN;
    public int numeroPaginas;

    public Libro() {
    }

    public Libro(int ISBN, int numeroPaginas) {
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    public Libro(String formato, double tamaño, String autor, String titulo, int identificador, int ISBN, int numeroPaginas) {
        super(formato, tamaño, autor, titulo, identificador);
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", ISBN=" + ISBN +
                ", Numero de Paginas=" + numeroPaginas;
    }
}
