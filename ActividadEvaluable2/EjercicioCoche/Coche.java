package EjercicioCoche;

public class Coche {

    private String marca, modelo, matricula;
    private int cv, cc;
    private double velocidad, kmRecorridos;

    public Coche(String marca, String modelo, int cv, int cc, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.cc = cc;
        this.matricula = matricula;
        velocidad = 0;
        kmRecorridos = 0;
    }

    public Coche(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        velocidad = 0;
        kmRecorridos = 0;
    }

    public Coche() {
    }

    public void acelerar(int numVel) {

        if (numVel < 10) {
            //velocidad += (int) (Math.random() * Math.max(numVel, 10));
            System.out.println("** Este coche acelera muy lento ** Acelerando al mínimo de 10 km/h.");
            numVel = 10;
        } else if (this.cv <= 100) {
            velocidad += (int) (Math.random() * numVel);
            System.out.printf("** La potencia del coche es MENOR a 100 caballos ** Acelerando a %d km/h.%n", numVel);
        } else {
            velocidad += (int) (Math.random() * (numVel - 10) + 10);
            System.out.printf("** La potencia del coche es MAYOR a 100 caballos ** Acelerando a %d km/h.%n", numVel);
        }

        double aumenta = velocidad * 0.5;
        kmRecorridos += aumenta;
        System.out.printf("La nueva velocidad es %.2f km/h y recorre %.2f km. %n", velocidad, kmRecorridos);
    }

    public String listarCoches() {
        return toString();
    }

    public String toString() {
        return "Marca: " + marca + " - Modelo: " + modelo + " - Potencia: " + cv + " - Cilindrada:  " + cc + " - Matricula: " + matricula +
                " - Velocidad: " + velocidad + " - Kilometros: " + kmRecorridos;
    }


    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }
}



