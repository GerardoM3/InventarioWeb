
package Model;


public class UserM {
    
    int id;
    String nombre_u;
    String apellido_u;
    String correo_u;
    String usuario;
    String clave;
    int tipo;
    int estado;
    String fecha;

    public UserM() {
    }

    public UserM(int id, String nombre_u, String apellido_u, String correo_u, String usuario, String clave, int tipo, int estado, String fecha) {
        this.id = id;
        this.nombre_u = nombre_u;
        this.apellido_u = apellido_u;
        this.correo_u = correo_u;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_u() {
        return nombre_u;
    }

    public void setNombre_u(String nombre_u) {
        this.nombre_u = nombre_u;
    }

    public String getApellido_u() {
        return apellido_u;
    }

    public void setApellido_u(String apellido_u) {
        this.apellido_u = apellido_u;
    }

    public String getCorreo_u() {
        return correo_u;
    }

    public void setCorreo_u(String correo_u) {
        this.correo_u = correo_u;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
