package CastleVania;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario {

    String User, Contra;
    int PartidasHeroe, PartidasVillano;
    boolean Activo = true;
    double Puntos;

    // Constructor
    public Usuario(String atributoUser, String atributoContra) {
        User = atributoUser;
        Contra = atributoContra;
        Puntos = 0;
        PartidasHeroe = 0;
        PartidasVillano = 0;
    }

    // GETTERS
    public String getUser() {
        return User;
    }

    public String getContra() {
        return Contra;
    }

    public double getPuntos() {
        return Puntos;
    }

    public int getPartidasHeroe() {
        return PartidasHeroe;
    }

    public int getPartidasVillano() {
        return PartidasVillano;
    }

    public boolean isActivo() {
        return Activo;
    }

    // SETTERS
    public void setUser(String User) {
        this.User = User;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public void setPuntos(Double Puntos) {
        this.Puntos = Puntos;
    }

    public void setPartidasHeroe(int PartidasHeroe) {
        this.PartidasHeroe = PartidasHeroe;
    }

    public void setPartidasVillano(int PartidasVillano) {
        this.PartidasVillano = PartidasVillano;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    // Other methods


    public String fecha() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
