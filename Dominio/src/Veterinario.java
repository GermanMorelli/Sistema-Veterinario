import java.util.Set;

public class Veterinario {
    private Long idVeterinario;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String correo;
    private String nombreUsuario;
    private String contrasenia;
    private String telefono;
    private String cedula;
    private Set<DiaSemana> diasDisponibles = Set.of();

    public Veterinario() {
    }

    public Veterinario(Long idVeterinario, String nombre, String apellidoMaterno, String apellidoPaterno,String correo, String nombreUsuario, String contrasenia, String telefono, String cedula) {
        this.idVeterinario = idVeterinario;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public Veterinario(Long idVeterinario, String nombre, String apellidoMaterno,
                       String apellidoPaterno, String correo, String nombreUsuario,
                       String contrasenia, String telefono, String cedula,
                       Set<DiaSemana> diasDisponibles) {
        this(idVeterinario, nombre, apellidoMaterno, apellidoPaterno, correo,
                nombreUsuario, contrasenia, telefono, cedula);
        setDiasDisponibles(diasDisponibles);
    }

    public Long getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Long idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Set<DiaSemana> getDiasDisponibles() {
        return diasDisponibles;
    }

    public void setDiasDisponibles(Set<DiaSemana> diasDisponibles) {
        this.diasDisponibles = Set.copyOf(diasDisponibles);
    }
}
