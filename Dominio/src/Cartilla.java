import java.time.LocalDateTime;

public class Cartilla {
    private Long idCartilla;
    private LocalDateTime fechaCreacion;
    private Mascota mascota;

    public Cartilla() {
    }

    public Cartilla(Long idCartilla, LocalDateTime fechaCreacion, Mascota mascota) {
        this.idCartilla = idCartilla;
        this.fechaCreacion = fechaCreacion;
        this.mascota = mascota;
    }

    public Long getIdCartilla() { return idCartilla; }
    public void setIdCartilla(Long idCartilla) { this.idCartilla = idCartilla; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
}
