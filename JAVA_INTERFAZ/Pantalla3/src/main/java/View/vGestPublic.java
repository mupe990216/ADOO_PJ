
package View;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;



//Ventana para gestionar las publicaciones
public class vGestPublic extends JFrame implements ActionListener{

    //ATRIBUTOS
    
    //METODOS
    public vGestPublic(){
        setSize(950, 600);
        setTitle("Gestión de Publicaciones");
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
