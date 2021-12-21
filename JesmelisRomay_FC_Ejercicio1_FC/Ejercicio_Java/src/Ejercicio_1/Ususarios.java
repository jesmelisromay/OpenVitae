package Ejercicio_1;

public class Ususarios {
    private String correo;
    private String nombre;
    private String usuario;


    public Ususarios(){

    }
    public Ususarios(String correo, String nombre, String usuario) {
        this.correo = correo;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Ususarios: " +
                "CORREO='" + correo + '\'' +
                ", NOMBRE='" + nombre + '\'' +
                ", USUARIO='" + usuario + '\'';
    }
}
