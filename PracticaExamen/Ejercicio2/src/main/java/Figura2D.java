import lombok.Data;

@Data
abstract public  class Figura2D implements FiguraGeometrica{

    private String nombre;

    public Figura2D() {
    }

    public Figura2D(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Figura2D: Nombre= " + nombre ;
    }

    @Override
    public abstract double calcularPerimetro();

}
