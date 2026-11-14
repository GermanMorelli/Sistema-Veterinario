public class Mascota {
    private Long idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private Sexo sexo;
    private float peso;
    private String senas;
    private byte[] imagen;
    private Cliente cliente;

    public Mascota() {
    }

    public Mascota(Long idMascota, String nombre, String especie, String raza, Sexo sexo, float peso, String senas, byte[] imagen, Cliente cliente) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.peso = peso;
        this.senas = senas;
        this.imagen = imagen;
        this.cliente = cliente;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getSenas() {
        return senas;
    }

    public void setSenas(String senas) {
        this.senas = senas;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public enum Sexo {
        MACHO,
        HEMBRA
    }
}
