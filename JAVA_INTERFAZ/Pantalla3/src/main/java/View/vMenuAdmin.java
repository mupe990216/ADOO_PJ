package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class vMenuAdmin extends JFrame implements ActionListener { //implements ActionListener

    public JPanel panel;
    public JLabel fondo;
    //Botones
    public JButton btn_cerrar_Sesion;
    public JButton btn_mi_cuenta;
    public JButton btn_gestAdmin;
    public JButton btn_gestClien;
    public JButton btn_gestPublic;
    public JButton btn_gestForo;
    //etiquetas
    public JLabel jbl_admin;
    public JLabel jbl_clie;
    public JLabel jbl_publ;
    public JLabel jbl_foro;
    
    public vMenuAdmin() {
        setSize(950, 600);
        setTitle("Menu Administrador");
        setLocationRelativeTo(null);
        setResizable(false);
        //cambioIcono();
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //METODO DE INICIAR COMPONENTES
    private void iniciaComponentes() {
        colocaPanel();
        colocaBotonCerrarSesion();
        colocaBotonMiCuenta();
        colocaBoton_gestAdmin();
        colocaBoton_gestClien();
        colocaBoton_gestPublic();
        colocaBoton_gestForo();
        colocaEtiquetas();
        colocaFondo();
    }
    //CAMBIO DE ICONO
    private void cambioIcono(){
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("./img/LOBO.png");
        setIconImage(miIcono);
    } 

    //PANEL
    private void colocaPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(160, 215, 240));
        this.getContentPane().add(panel);
    }

    //BOTON CERRAR SESION
    private void colocaBotonCerrarSesion() {
        btn_cerrar_Sesion = new JButton("Cerrar Sesion");
        btn_cerrar_Sesion.setBounds(700, 480, 180, 50);
        btn_cerrar_Sesion.setFont(new Font("arial", 1, 22));
        btn_cerrar_Sesion.setBackground(new Color(185, 170, 220));
        panel.add(btn_cerrar_Sesion);
        btn_cerrar_Sesion.addActionListener(this);
    }
    
    //BOTON MI CUENTA
    private void colocaBotonMiCuenta(){
        btn_mi_cuenta = new JButton("Mi Cuenta");
        btn_mi_cuenta.setBounds(500,480,180,50);
        btn_mi_cuenta.setFont(new Font("arial",1,22));
        btn_mi_cuenta.setBackground(new Color(185, 170, 220));
        panel.add(btn_mi_cuenta);
        btn_mi_cuenta.addActionListener(this);
        
    }
    //BOTON GESTADMIN
    private void colocaBoton_gestAdmin(){
        btn_gestAdmin = new JButton();
        btn_gestAdmin.setBounds(100, 100, 160, 100);
        ImageIcon i1 = new ImageIcon("./img/Administrador/Admin.png");
        btn_gestAdmin.setIcon(new ImageIcon(i1.getImage().getScaledInstance(btn_gestAdmin.getWidth(), btn_gestAdmin.getHeight(), Image.SCALE_SMOOTH)));
       // btn_gestAdmin.setFont(new Font("arial", 1, 22));
        btn_gestAdmin.setBackground(new Color(185, 170, 220));
        panel.add(btn_gestAdmin);
        btn_gestAdmin.addActionListener(this);
    }
    //BOTON GESTCLIEN
    private void colocaBoton_gestClien(){
        btn_gestClien = new JButton();
        btn_gestClien.setBounds(400, 100, 160, 100);
        ImageIcon i1 = new ImageIcon("./img/Cliente/Usuario_icono.png");
        btn_gestClien.setIcon(new ImageIcon(i1.getImage().getScaledInstance(btn_gestClien.getWidth(), btn_gestClien.getHeight(), Image.SCALE_SMOOTH)));
       // btn_gestAdmin.setFont(new Font("arial", 1, 22));
        btn_gestClien.setBackground(new Color(185, 170, 220));
        panel.add(btn_gestClien);
        btn_gestClien.addActionListener(this);
    }
    //BOTON GESTPUBLIC
    private void colocaBoton_gestPublic(){
        btn_gestPublic = new JButton();
        btn_gestPublic.setBounds(100, 280, 160, 100);
        ImageIcon i1 = new ImageIcon("./img/publicacion.png");
        btn_gestPublic.setIcon(new ImageIcon(i1.getImage().getScaledInstance(btn_gestPublic.getWidth(), btn_gestPublic.getHeight(), Image.SCALE_SMOOTH)));
       // btn_gestAdmin.setFont(new Font("arial", 1, 22));
        btn_gestPublic.setBackground(new Color(185, 170, 220));
        panel.add(btn_gestPublic);
        btn_gestPublic.addActionListener(this);
    }
    //BOTON GESTFORO
    private void colocaBoton_gestForo(){
        btn_gestForo = new JButton();
        btn_gestForo.setBounds(400, 280, 160, 100);
        ImageIcon i1 = new ImageIcon("./img/foro.png");
        btn_gestForo.setIcon(new ImageIcon(i1.getImage().getScaledInstance(btn_gestForo.getWidth(), btn_gestForo.getHeight(), Image.SCALE_SMOOTH)));
       // btn_gestAdmin.setFont(new Font("arial", 1, 22));
        btn_gestForo.setBackground(new Color(185, 170, 220));
        panel.add(btn_gestForo);
        btn_gestForo.addActionListener(this);
   }
   
    //ETIQUETA ADMIN
    private void colocaEtiquetas(){
        //Etiquta de gestion de administradores
        jbl_admin = new JLabel();
        jbl_admin.setText("Gestionar Administradores");
        jbl_admin.setFont(new Font("arial",1,16));
        jbl_admin.setForeground(Color.WHITE);
        jbl_admin.setBounds(90, 200, 210, 30);
        panel.add(jbl_admin);
        
        //Etiquta de gestion de clientes
        jbl_clie = new JLabel();
        jbl_clie.setText("Gestionar Clientes");
        jbl_clie.setFont(new Font("arial",1,16));
        jbl_clie.setForeground(Color.WHITE);
        jbl_clie.setBounds(415, 200, 210, 30);
        panel.add(jbl_clie);
        
        //Etiqueta de gestion de publicaciones
        jbl_publ = new JLabel();
        jbl_publ.setText("Gestionar Publicaciones");
        jbl_publ.setFont(new Font("arial",1,16));
        jbl_publ.setForeground(Color.WHITE);
        jbl_publ.setBounds(100, 380, 210, 30);
        panel.add(jbl_publ);
        
        //Etiqueta de gestion de Foros
        jbl_foro = new JLabel();
        jbl_foro.setText("Gestionar Foros");
        jbl_foro.setFont(new Font("arial",1,16));
        jbl_foro.setForeground(Color.WHITE);
        jbl_foro.setBounds(420, 380, 210, 30);
        panel.add(jbl_foro);
    }

    //COLOCAR FONDO 
    private void colocaFondo() {
        ImageIcon logo_icono = new ImageIcon("./img/Fondo.png");
        fondo = new JLabel();
        fondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        fondo.setIcon(new ImageIcon(logo_icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(fondo);
    }
    
    //EVENTOS 
    @Override
    //Aqui va el codigo que quite XD
    
        public void actionPerformed(ActionEvent e) {
        //getSource significa al apretar el boton XD
        //evento para el boton de Cerrar Sesion
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
        
        //Evento para el boton de gest Admin
        if(e.getSource() == btn_gestAdmin){
            vGestAdmin GA = new vGestAdmin();
            GA.setVisible(true);
            this.dispose();
        }
        
        //Evento para el boton gest Clien
        if(e.getSource() == btn_gestClien){
            vGestcliente GC = new vGestcliente();
            GC.setVisible(true);
            this.dispose();
        }
        //Evento para el boton Gest Public
        if(e.getSource() == btn_gestPublic){
            vGestPublic GP = new vGestPublic();
            GP.setVisible(true);
            this.dispose();
        }
        //Evento para el boton gest Foro
        if(e.getSource() == btn_gestForo){
            vGestForo GF = new vGestForo();
            GF.setVisible(true);
            this.dispose();
        }
        //Evento para el boton de Mi cuenta
            if(e.getSource() == btn_mi_cuenta){
            vMiCuenta cuenta = new vMiCuenta();
            cuenta.setVisible(true);
            this.dispose();
        }
    }
    
}
