
package View;
//BIBLIOTECAS
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//VENTANA PARA CONSULTAR CLIENTES
public class vConsultarC extends JFrame implements ActionListener{

    //ATRIBUTOS 
    public Usuario uvcc;
    public JPanel panel;
    public JLabel jbl_fondo;
    public JButton btn_regresar, btn_cerrar_sesion;
    //METODOS
    public vConsultarC(Usuario u){
        setSize(750, 400);
        setTitle("Consulta de Clientes");
        setLocationRelativeTo(null);
        setResizable(false);
        uvcc = u;
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void iniciaComponentes(){
        colocaPanel();
        colocaBotones();
        colocaFondo();
    }
    
    //COLOCA BOTONES
     public void colocaBotones(){
        //Boton regresar
        btn_regresar = new JButton("Regresar");
        btn_regresar.setBounds(320,300, 180, 40);
        btn_regresar.setFont(new Font("arial", 1, 20));
        btn_regresar.setBackground(new Color(185, 170, 220));
        panel.add(btn_regresar);
        btn_regresar.addActionListener(this);
       
        //Boton "cerrar sesion"
        btn_cerrar_sesion = new JButton("Cerrar Sesion");
        btn_cerrar_sesion.setBounds(520,300, 180, 40);
        btn_cerrar_sesion.setFont(new Font("arial", 1, 20));
        btn_cerrar_sesion.setBackground(new Color(185, 170, 220));
        panel.add(btn_cerrar_sesion);
        btn_cerrar_sesion.addActionListener(this);
     }
    //COLOCA PANEL
     private void colocaPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(160, 215, 240));
        this.getContentPane().add(panel);
    }
     
     //COLOCA FONDO
    private void colocaFondo() {
        ImageIcon logo_icono = new ImageIcon("./img/Fondo.png");
        jbl_fondo = new JLabel();
        jbl_fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        jbl_fondo.setIcon(new ImageIcon(logo_icono.getImage().getScaledInstance(jbl_fondo.getWidth(), jbl_fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(jbl_fondo);
    }
    


    //EVENTOS
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btn_cerrar_sesion){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?", "Confirmar salida",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                JOptionPane.showMessageDialog(null, "Hasta Pronto :)");                
                vLogin va_de_nuez = new vLogin();
                va_de_nuez.setVisible(true);
                this.dispose();
            }
            if (respuesta == 1) {
                JOptionPane.showMessageDialog(null, "Sigueme Usando UwU");
            }
        }
        
        if(e.getSource() == btn_regresar){
            if(e.getSource() == btn_regresar){
            vGestcliente vGC = new vGestcliente(uvcc);
            vGC.setVisible(true);
            this.dispose();
            }
        }
    }
    
}
