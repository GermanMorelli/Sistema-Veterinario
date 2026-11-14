import java.time.LocalDate;

public class Aplicacion {
    private Long idAplicacion;
    private LocalDate fechaAplicacion;
    private String lote;
    private Estado estado;
    private Cartilla cartilla;
    private Vacuna vacuna;
    private Veterinario veterinario;

    public Aplicacion() {
    }

    public Aplicacion(Long idAplicacion, LocalDate fechaAplicacion, String lote,
                      Estado estado, Cartilla cartilla, Vacuna vacuna,
                      Veterinario veterinario) {
        this.idAplicacion = idAplicacion;
        this.fechaAplicacion = fechaAplicacion;
        this.lote = lote;
        this.estado = estado;
        this.cartilla = cartilla;
        this.vacuna = vacuna;
        this.veterinario = veterinario;
    }

    public Long getIdAplicacion() { return idAplicacion; }
    public void setIdAplicacion(Long idAplicacion) { this.idAplicacion = idAplicacion; }
    public LocalDate getFechaAplicacion() { return fechaAplicacion; }
    public void setFechaAplicacion(LocalDate fechaAplicacion) { this.fechaAplicacion = fechaAplicacion; }
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public Cartilla getCartilla() { return cartilla; }
    public void setCartilla(Cartilla cartilla) { this.cartilla = cartilla; }
    public Vacuna getVacuna() { return vacuna; }
    public void setVacuna(Vacuna vacuna) { this.vacuna = vacuna; }
    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }

    public enum Estado { PENDIENTE, APLICADA, CANCELADA }
}
