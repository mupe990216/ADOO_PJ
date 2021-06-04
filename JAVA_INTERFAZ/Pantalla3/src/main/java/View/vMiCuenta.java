
package View;

//VENTANA MI CUENTA 

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class vMiCuenta extends JFrame implements ActionListener{
    //ATRIBUTOS
    public JPanel panel;
    public JLabel jbl_fondo,usr,psw;
    public JButton btn_cerrar_sesion;
    
    //CONTRUCTOR DE VENTANA
    public vMiCuenta(){
        setSize(950, 600);
        setTitle("Mi Cuenta");
        setLocationRelativeTo(null);
        setResizable(false);        
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    //METODO DE LOS COMPONENTES
    public void iniciaComponentes(){
        //AQUI LLAMAMOS TODOS LOS METODOS DE CADA COMPONENTE DE LA VENTANA
        colocaPanel();
        colocaFondo();
        colocaEtiquetas();
        
        
        
    }
    //ETIQUETAS
    private void colocaEtiquetas() {
        usr = new JLabel();
        usr.setBounds(0, 0, 110, 15);
        usr.setText("Usuario");
        usr.setForeground(Color.WHITE);
        usr.setFont(new Font("arial", 1, 18));
        panel.add(usr);

        psw = new JLabel();
        psw.setBounds(20, 20, 110, 15);
        psw.setText("Contraseña");
        psw.setForeground(Color.WHITE);
        psw.setFont(new Font("arial", 1, 18));
        panel.add(psw);
    }
    //PANEL
    private void colocaPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(160, 215, 240));
        this.getContentPane().add(panel);
    }
    
    //FONDO
     private void colocaFondo() {
        ImageIcon logo_icono = new ImageIcon("./img/Fondo.png");
        jbl_fondo = new JLabel();
        jbl_fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        jbl_fondo.setIcon(new ImageIcon(logo_icono.getImage().getScaledInstance(jbl_fondo.getWidth(), jbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(jbl_fondo);
    }
    
    
    
    
    
    //METODO DE EVENTO
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
}
