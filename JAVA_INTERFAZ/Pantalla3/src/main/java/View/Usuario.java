
package View;

//Clase que me representa al usuario que inicia sesion en SAY WOOF!
public class Usuario {
    //ATRIBUTOS
    private String ApellidoP;
    private String ApellidoM;
    private String nombres;
    private String email;
    private String nombre_usr;
    private String tipo_usr;
    private String psw;
    //METODOS

    //GETTERS
    public String getApellidoP() {
        return ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public String getNombres() {
        return nombres;
    }

    public String getEmail() {
        return email;
    }
    
    public String getNoombre_usr(){
        return nombre_usr;
    }

    public String getTipo_usr() {
        return tipo_usr;
    }
    
    public String getPSW(){
        return psw;
    }
    //SETTERS
    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setNombre_usr(String nombre_usr){
        this.nombre_usr = nombre_usr;
    }

    public void setTipo_usr(String tipo_usr) {
        this.tipo_usr = tipo_usr;
    }
    
    public void set_psw(String psw){
        this.psw = psw;
    }
}
