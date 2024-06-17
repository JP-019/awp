package Clases;

import java.time.LocalDate;

public class Usuarios {
    private String Nombre;
    private String Contra;
    private int Puntos;
    private boolean Activa;
    private LocalDate FechaCreacion;

    public Usuarios(String Nombre, String Contra) {
        this.Nombre = Nombre;
        this.Contra = Contra;
        this.Puntos = 0;
        this.Activa = true;
        this.FechaCreacion = LocalDate.now();
    }

    // Constructor que inicializa solo con el nombre
    public Usuarios(String Nombre) {
        this.Nombre = Nombre;
        this.Contra = ""; // Asignación de valor por defecto para evitar NullPointerException
        this.Puntos = 0;
        this.Activa = true;
        this.FechaCreacion = LocalDate.now();
    }

    // Getters y setters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public boolean isActiva() {
        return Activa;
    }

    public void setActiva(boolean Activa) {
        this.Activa = Activa;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(LocalDate FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    // Métodos adicionales
    public void DeactivateAccount() {
        Activa = false;
    }

    public void addPuntos() {
        Puntos += 3;
    }

    public String getFechaDeCreacion() {
        return FechaCreacion.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
