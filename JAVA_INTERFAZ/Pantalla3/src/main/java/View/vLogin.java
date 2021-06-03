package View;

import DB.cDatos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JTextField;

public class vLogin extends JFrame implements ActionListener {

    public JPanel panel;
    public JTextField jtf_usuario, jtf_contrasenia;
    public JButton btn_Ingresa;
    public JLabel fondo, usr, psw;

    public vLogin() {
        setSize(405, 600);
        setTitle("Inicio de Sesión");
        setLocationRelativeTo(null);
        setResizable(false);        
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciaComponentes() {
        colocaPanel();
        colocaTextFiled();
        colocaEtiquetas();
        colocaBoton();
        colocaFondo();
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

        jtf_contrasenia = new JTextField();
        jtf_contrasenia.setBounds(100, 175, 200, 50);
        jtf_contrasenia.setFont(new Font("arial", 1, 22));
        jtf_contrasenia.setBackground(new Color(180, 210, 240));
        panel.add(jtf_contrasenia);
    }

    private void colocaEtiquetas() {
        usr = new JLabel();
        usr.setBounds(100, 50, 110, 15);
        usr.setText("Usuario");
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
        btn_Ingresa = new JButton("Ingresa");
        btn_Ingresa.setBounds(120, 300, 160, 50);
        btn_Ingresa.setFont(new Font("arial", 1, 22));
        btn_Ingresa.setBackground(new Color(185, 170, 220));
        panel.add(btn_Ingresa);
        btn_Ingresa.addActionListener(this);
    }

    private void colocaFondo() {
        ImageIcon logo_icono = new ImageIcon("./img/Logo01.png");
        fondo = new JLabel();
        fondo.setBounds(0, 0, this.getWidth(), this.getHeight());        
        fondo.setIcon(new ImageIcon(logo_icono.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(fondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Ingresa) {
            String usuario = jtf_usuario.getText();
            String contras = jtf_contrasenia.getText();            
            cDatos datitos = new cDatos();
            try {
                Connection conn = datitos.conecta(); //Conecta Java con MySQL y regresa un objeto del tipo connection
                ResultSet rs = datitos.consulta("call sp_Login('" + usuario + "','" + contras + "');", conn); // Ejecuta sentencia SQL y regresa las coincidencias
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, rs.getString("Respuesta"));
                    //JOptionPane.showMessageDialog(null, rs.getString("tipoUSR"));
                    if(rs.getString("tipoUSR").equalsIgnoreCase("Administrador")){
                        vMenuAdmin mAdmin = new vMenuAdmin();                  
                        mAdmin.setVisible(true);
                        this.dispose();
                    }
                    if(rs.getString("tipoUSR").equalsIgnoreCase("Cliente")){
                        vMenuClient mClien = new vMenuClient();                        
                        mClien.setVisible(true);
                        this.dispose();
                    }
                }
                rs.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al iniciar Sesion: " + ex.getMessage());
            }
        }
    }

}
