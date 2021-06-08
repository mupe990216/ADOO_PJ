package View;

import DB.cDatos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vLogin extends JFrame implements ActionListener {

    public JPanel panel;
    public JTextField jtf_usuario, jtf_contrasenia;
    public JButton btn_Ingresa,btn_registrarse;
    public JLabel fondo, usr, psw;
    public JPasswordField contra;
    //public static String usuario,tipo_usr;


    public vLogin() {
        setSize(405, 600);
        setTitle("Inicio de Sesión");
        setLocationRelativeTo(null);
        setResizable(false);
        //cambioIcono();
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciaComponentes() {
        colocaPanel();
        colocaTextFiled();
        colocaPasswordField();
        colocaEtiquetas();
        colocaBoton();
        colocaFondo();
    }
    
    private void cambioIcono(){
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("./img/LOBO.png");
        setIconImage(miIcono);
    } 

    private void colocaPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(160, 215, 240));
        this.getContentPane().add(panel);
    }

    public void colocaTextFiled() {
        jtf_usuario = new JTextField();
        jtf_usuario.setBounds(100, 75, 200, 50);
        jtf_usuario.setFont(new Font("arial", 1, 22));
        jtf_usuario.setBackground(new Color(180, 210, 240));
        panel.add(jtf_usuario);
    }
    
    public void colocaPasswordField(){
         contra = new JPasswordField();
         contra.setBounds(100,175,200,50);
         contra.setFont(new Font("arial", 1, 22));
         contra.setBackground(new Color(180, 210, 240));
         panel.add(contra);
     }

    private void colocaEtiquetas() {
        usr = new JLabel();
        usr.setBounds(100, 50, 200, 15);
        usr.setText("Nombre de usuario");
        usr.setForeground(Color.WHITE);
        usr.setFont(new Font("arial", 1, 18));
        panel.add(usr);

        psw = new JLabel();
        psw.setBounds(100, 150, 110, 15);
        psw.setText("Contraseña");
        psw.setForeground(Color.WHITE);
        psw.setFont(new Font("arial", 1, 18));
        panel.add(psw);
    }

    private void colocaBoton() {
        //Boton de ingresar al sistema 
        btn_Ingresa = new JButton("Ingresa");
        btn_Ingresa.setBounds(120, 290, 160, 50);
        btn_Ingresa.setFont(new Font("arial", 1, 22));
        btn_Ingresa.setBackground(new Color(185, 170, 220));
        panel.add(btn_Ingresa);
        btn_Ingresa.addActionListener(this);
        
        //boton de registrarse
        btn_registrarse = new JButton("Registrarse");
        btn_registrarse.setBounds(120, 360, 160, 50);
        btn_registrarse.setFont(new Font("arial", 1, 22));
        btn_registrarse.setBackground(new Color(185, 170, 220));
        panel.add(btn_registrarse);
        btn_registrarse.addActionListener(this);
    }

    private void colocaFondo() {
        ImageIcon logo_icono = new ImageIcon("./img/Logo01.png");
        fondo = new JLabel();
        fondo.setBounds(0, 0, this.getWidth(), this.getHeight());        
        fondo.setIcon(new ImageIcon(logo_icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(fondo);
    }
    
    //EVENTOS
    @Override
    public void actionPerformed(ActionEvent e) {
        //Evento para el boton de ingresar al sistema
        if (e.getSource() == btn_Ingresa) {
            String usuario = jtf_usuario.getText();
            //String contras = jtf_contrasenia.getText();
            String contras = "";
            for(int i = 0; i< contra.getPassword().length;i++ ){
                contras += contra.getPassword()[i];
            }
            cDatos datitos = new cDatos(); //Creo un objeto de la clase para conectar a MySQL
            try {
                Connection conn = datitos.conecta(); //Conecta Java con MySQL y regresa un objeto del tipo connection
                //RESULSET = conjunto de resultados de una sentencia SQL
                ResultSet rs = datitos.consulta("call sp_Login('" + usuario + "','" + contras + "');", conn); // Ejecuta sentencia SQL y regresa las coincidencias
                while (rs.next()) { //next() => mientras haya algo que leer en de la consulta
                    //JOptionPane.showMessageDialog(null, rs.getString("Respuesta")); //Columna Respuesta
                    //JOptionPane.showMessageDialog(null, rs.getString("tipoUSR")); //Columna tipo usr
                    if(rs.getString("tipoUSR").equalsIgnoreCase("Administrador")){
                        //Creamos el objeto USUARIO
                        Usuario u1 = new Usuario();
                        u1.setTipo_usr("Administrador");
                        u1.setNombre_usr(usuario);
                        u1.set_psw(contras);
                        //Abrimos una nueva ventana
                        vMenuAdmin mAdmin = new vMenuAdmin(u1);                  
                        mAdmin.setVisible(true);
                        this.dispose();
                    }
                    if(rs.getString("tipoUSR").equalsIgnoreCase("Cliente")){
                         //Creamos el objeto USUARIO
                        Usuario u2 = new Usuario();
                        u2.setTipo_usr("Cliente");
                        u2.setNombre_usr(usuario);
                        u2.set_psw(contras);
                         //Abrimos una nueva ventana
                        usuario = rs.getString("tipoUSR");
                        vMenuClient mClien = new vMenuClient(u2);                        
                        mClien.setVisible(true);
                        this.dispose();
                    }
                }
                rs.close();
                conn.close();
            } catch (SQLException ex) { //SQLException ex 
                System.out.println("Error al iniciar Sesion: " + ex.getMessage());
            }
        }
        
        //Evento para el boton Registrarse
        if(e.getSource() == btn_registrarse){
            vRegistrarse v2 = new vRegistrarse();
            v2.setVisible(true);
            this.dispose();
        }
    }
    /*
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("./img/LOGO2.png"));
        this.setIconImage(retValue);
        return retValue;
    }*/
}

