public class Cliente {
    private Long idCliente;
    private String nombre;
    private String correo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombre, String correo, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
    public Long getId() {
        return idCliente;
    }
    public void setId(Long idCliente) {
        this.idCliente = idCliente;
    }
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
