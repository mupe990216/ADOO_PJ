//BOTONES DE LA LISTA DESPLEGABLE
package Login;

import javax.swing.JButton;


public class Botones extends JButton {
    //Atributo
    private String texto;
    
    public void crearBoton(String a){
        texto = a;
        this.setText(a);
    }
    @Override
    public String toString(){
        return texto;
    }
}
