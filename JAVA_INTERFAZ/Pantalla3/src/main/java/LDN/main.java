package LDN;

import View.Usuario;
import View.vConsultarA;
import View.vGestAdmin;
import View.vGestcliente;
import View.vLogin;
import View.vMiCuenta;
import View.vRegAdmin;
import View.vRegistrarse;

public class main {
    public static Usuario u = new Usuario();
    public static void main(String args[]){
       //vLogin Proyecto = new vLogin();
       //Proyecto.setVisible(true);        
       
        //vMiCuenta cuenta = new vMiCuenta();
        //cuenta.setVisible(true);       
        
        //vGestAdmin v2 = new vGestAdmin();
        //v2.setVisible(true);
        
        //vGestcliente v3 = new vGestcliente();
        //v3.setVisible(true);
        
        //vRegistrarse reg = new vRegistrarse();
        //reg.setVisible(true);
       
       //vRegAdmin vRA = new vRegAdmin();
       //vRA.setVisible(true);
       
       vConsultarA hola = new vConsultarA(u);
       hola.setVisible(true);
    }
}
