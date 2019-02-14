package entity;

/**
 *
 * @author carlosalberto
 */
public class Usuario {

    private int Id;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Codigo;
    private String Cedula;
    private Departamento objDepartamento;

    public Usuario() {

    }

    public Usuario(int Id, String Nombre, String Apellido, String Email, String Codigo, String Cedula, Departamento objDepartamento) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Email = Email;
        this.Codigo = Codigo;
        this.Cedula = Cedula;
        this.objDepartamento = objDepartamento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido.toUpperCase();
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEmail() {
        return Email.toLowerCase();
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public Departamento getObjDepartamento() {
        return objDepartamento;
    }

    public void setObjDepartamento(Departamento objDepartamento) {
        this.objDepartamento = objDepartamento;
    }

}
