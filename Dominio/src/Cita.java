import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private Long idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private Estado estado;
    private Veterinario veterinario;
    private Cliente cliente;
    private Mascota mascota;

    public Cita() {
    }

    public Cita(Long idCita, LocalDate fecha, LocalTime hora, String motivo,
                Estado estado, Veterinario veterinario, Cliente cliente, Mascota mascota) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
        this.veterinario = veterinario;
        this.cliente = cliente;
        this.mascota = mascota;
    }

    public Long getIdCita() { return idCita; }
    public void setIdCita(Long idCita) { this.idCita = idCita; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }

    public enum Estado { PENDIENTE, CONFIRMADA, ATENDIDA, CANCELADA }
}
