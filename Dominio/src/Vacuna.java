public class Vacuna {
    private Long idVacuna;
    private String nombre;

    public Vacuna() {
    }

    public Vacuna(Long idVacuna, String nombre) {
        this.idVacuna = idVacuna;
        this.nombre = nombre;
    }

    public Long getIdVacuna() { return idVacuna; }
    public void setIdVacuna(Long idVacuna) { this.idVacuna = idVacuna; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
