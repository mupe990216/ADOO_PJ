package View;

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

public class vMenuClient extends JFrame implements ActionListener{
    
    public JPanel panel;
    public JLabel fondo;
    public JButton btn_cerrar_Sesion,btn_mi_cuenta;
    
    public Usuario uvmc;
    
    public vMenuClient(Usuario usr){
        setSize(950, 600);
        setTitle("Menu Cliente");
        setLocationRelativeTo(null);
        setResizable(false);        
        uvmc = usr;
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }        
    
    private void iniciaComponentes(){
        colocaPanel();
        colocaBoton();
        colocaFondo();
    }
    
    private void colocaPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(160, 215, 240));
        this.getContentPane().add(panel);
    }
    
    private void colocaBoton() {
        //BOTON CERRAR SESION
        btn_cerrar_Sesion = new JButton("Cerrar Sesion");
        btn_cerrar_Sesion.setBounds(700, 480, 200, 50);
        btn_cerrar_Sesion.setFont(new Font("arial", 1, 22));
        btn_cerrar_Sesion.setBackground(new Color(185, 170, 220));
        panel.add(btn_cerrar_Sesion);
        btn_cerrar_Sesion.addActionListener(this);
        
        //BOTON MI CUENTA
        btn_mi_cuenta = new JButton("Mi Cuenta");
        btn_mi_cuenta.setBounds(500,480,180,50);
        btn_mi_cuenta.setFont(new Font("arial",1,22));
        btn_mi_cuenta.setBackground(new Color(185, 170, 220));
        panel.add(btn_mi_cuenta);
        btn_mi_cuenta.addActionListener(this);
    }
   
    private void colocaFondo() {
        ImageIcon logo_icono = new ImageIcon("./img/Fondo.png");
        fondo = new JLabel();
        fondo.setBounds(0, 0, this.getWidth(), this.getHeight());        
        fondo.setIcon(new ImageIcon(logo_icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(fondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //EVENTO PARA CERRAR SESION
        if (e.getSource() == btn_cerrar_Sesion) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
        
        //EVENTO PARA IR A VENTANA MI CUENTA
        if(e.getSource() == btn_mi_cuenta){
            vMiCuenta vmC = new vMiCuenta(uvmc);
            vmC.setVisible(true);
            this.dispose();
        }
    }
}
