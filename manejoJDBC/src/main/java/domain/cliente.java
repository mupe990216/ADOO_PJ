package domain;

/**
 *
 * @author Karina
 */
public class cliente {
    private String correoCliente;//lave primaria en BD
    private String nombre;
    private String contraseña;
//sobrecarga de constructores
    
    //CONTRUCTOR PRINCIPAL
    public cliente() {
    }
    
    //CONTRUCTOR PARA ELIMINAR REGISTROS DE LA TABLA cliente 
    public cliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
    
    //CONTRUCTOR PARA INSERTAR REGISTROS EN LA TABLA cliente
    public cliente(String correoCliente, String nombre, String contraseña) {
        this.correoCliente = correoCliente;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    
    //CONSTRUCTOR PARA MODIFICAR REGISTROS DE LA TABLA cliente
    //mismo que el anterior
    
    
    //GETTERS Y SETTERS

    public String getCorreoCliente() {
        return correoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    //MANDAR A IMPRIMIR EL ESTADO DE CUALQUIER OBJETO CUANDO SE NECESITE
    @Override
    public String toString() {
        return "cliente{" + "correoCliente=" + correoCliente + ", nombre=" + nombre + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
    
    
}
