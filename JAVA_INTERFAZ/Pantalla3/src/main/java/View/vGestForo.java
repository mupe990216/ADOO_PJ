
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

//Ventana de gestion de foros
public class vGestForo extends JFrame implements ActionListener {
    //ATRIBUTOS
    //METODOS
    public vGestForo(){
        setSize(950, 600);
        setTitle("Gestión de Foros");
        setLocationRelativeTo(null);
        setResizable(false);
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void iniciaComponentes(){
        
    }
    //EVENTOS
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
}
