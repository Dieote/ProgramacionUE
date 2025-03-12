import lombok.Data;

@Data
public class Actor {

    public String nombreActor;
    public String actorDni;

    public Actor() {
    }

    public Actor(String nombreActor, String actorDni) {
        this.nombreActor = nombreActor;
        this.actorDni = actorDni;
    }

    public String mostrarDatosActor(){
        return "Nombre Actor: " + nombreActor + "DNI: " + actorDni;
    }
}
