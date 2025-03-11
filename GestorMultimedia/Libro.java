import lombok.Data;
@Data
public class Libro extends Multimedia{

    public String ISBN;
    public int numeroPaginas;

    public Libro() {
    }

    public Libro(String ISBN, int numeroPaginas) {
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    public Libro(int identificador, String titulo, String autor, String formato, double tamanio, String ISBN, int numeroPaginas) {
        super(identificador, titulo, autor, formato, tamanio);
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", ISBN=" + ISBN +
                ", Numero de Paginas=" + numeroPaginas;
    }
}
