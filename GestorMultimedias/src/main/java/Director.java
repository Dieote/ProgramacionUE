import lombok.Data;

@Data
public class Director {

    public String nombreDirector;
    public String directorDni;

    public Director() {
    }

    public Director(String nombreDirector, String directorDni) {
        this.nombreDirector = nombreDirector;
        this.directorDni = directorDni;
    }

    public String mostrarDatosDirector(){
        return "Nombre Director: " + nombreDirector + "DNI: " + directorDni;
    }
}
