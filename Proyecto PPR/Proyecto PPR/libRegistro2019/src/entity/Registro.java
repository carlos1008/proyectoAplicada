package entity;

/**
 *
 * @author carlosalberto
 */
public class Registro {

    private int Id;
    private Usuario objUsuario;
    private String Foto;
    private String Fecha;
    private String Hora;
    private String Tipo;

    public Registro() {

    }

    public Registro(int Id, Usuario objUsuario, String Foto, String Fecha, String Hora, String Tipo) {
        this.Id = Id;
        this.objUsuario = objUsuario;
        this.Foto = Foto;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Tipo = Tipo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

}
