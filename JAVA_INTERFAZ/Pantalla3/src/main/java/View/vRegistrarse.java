
package View;

//Bibliotecas
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Ventana para el registro de un nuevo usuario tipo cliente 
public class vRegistrarse extends JFrame implements ActionListener{
    //ATRIBUTOS 
    public JPanel panel;
    public JLabel jbl_fondo, jbl_dialogo;
    public JLabel jbl_apellidos, jbl_nombre,jbl_email,usr,psw,jbl_im1,jbl_im2;
    public JButton btn_finalizar;
    public JButton btn_regresar;
    public JTextField jtf_apellidos;
    public JTextField jtf_nombres;
    public JTextField jtf_email;
    public JTextField jtf_usr;
    public JPasswordField jtf_psw;
    //METODOS
    
    public vRegistrarse(){
        setSize(800, 550);
        setTitle("Mi Cuenta");
        setLocationRelativeTo(null);
        setResizable(false);        
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    public void iniciaComponentes(){
        colocaPanel();
        colocaBotones();
        colocaCajasTexto();
        colocaDialogo();
        colocaEtiquetas();
        colocaFondo();
    }
    //Cajas de Texto
    private void colocaCajasTexto(){
        //Caja de apellidos
        jtf_apellidos = new JTextField();
        jtf_apellidos.setBounds(50,50,200,40);
        jtf_apellidos.setFont(new Font("arial", 1, 18));
        //jtf_apellidos.setText("Ramirez Galindo");
        jtf_apellidos.setBackground(new Color(180, 210, 240));
        jtf_apellidos.setEditable(true);
        panel.add(jtf_apellidos);
        
        //Caja de nombres
        jtf_nombres = new JTextField();
        jtf_nombres.setBounds(50,170,200,40);
        jtf_nombres.setFont(new Font("arial", 1, 18));
        jtf_nombres.setBackground(new Color(180, 210, 240));
        jtf_nombres.setEditable(true);
        panel.add(jtf_nombres);
        
        //Caja de email
        jtf_email = new JTextField();
        jtf_email.setBounds(50,290,200,40);
        jtf_email.setFont(new Font("arial", 1, 18));
        jtf_email.setBackground(new Color(180, 210, 240));
        jtf_email.setEditable(true);
        panel.add(jtf_email);
        
        //Caja de usr
        jtf_usr = new JTextField();
        jtf_usr.setBounds(300,50,200,40);
        jtf_usr.setFont(new Font("arial", 1, 18));
        jtf_usr.setBackground(new Color(180, 210, 240));
        jtf_usr.setEditable(true);
        panel.add(jtf_usr);
        
        //Caja psw
        jtf_psw = new JPasswordField();
        jtf_psw.setBounds(300,170,200,40);
        jtf_psw.setFont(new Font("arial", 1, 18));
        jtf_psw.setBackground(new Color(180, 210, 240));
        jtf_psw.setEditable(true);
        panel.add(jtf_psw);
    }
    
    private void colocaDialogo(){
        jbl_dialogo = new JLabel();
        jbl_dialogo.setBounds(408,225,200,100);
        jbl_dialogo.setText("¿Quién es el nuevo?");
        jbl_dialogo.setForeground(Color.BLACK);
        jbl_dialogo.setFont(new Font("arial",1,18));
        panel.add(jbl_dialogo);
    }
    //ETIQUETAS
     private void colocaEtiquetas() {
        //Etiqueta de apellidos  
        jbl_apellidos = new JLabel();
        jbl_apellidos.setBounds(50, 30, 110, 15);
        jbl_apellidos.setText("Apellidos");
        jbl_apellidos.setForeground(Color.WHITE);
        jbl_apellidos.setFont(new Font("arial", 1, 18));
        panel.add(jbl_apellidos);

        //Etiqueta de nombre
        jbl_nombre = new JLabel();
        jbl_nombre.setBounds(50, 150, 110, 15);
        jbl_nombre.setText("Nombre(s)");
        jbl_nombre.setForeground(Color.WHITE);
        jbl_nombre.setFont(new Font("arial", 1, 18));
        panel.add(jbl_nombre);
        
        //Etiqueta de email
        jbl_email = new JLabel();
        jbl_email.setBounds(50, 270, 110, 15);
        jbl_email.setText("email");
        jbl_email.setForeground(Color.WHITE);
        jbl_email.setFont(new Font("arial", 1, 18));
        panel.add(jbl_email);
        
        //Etiqueta de usuario
        usr = new JLabel();
        usr.setBounds(300, 30, 200, 15);
        usr.setText("Nombre de Usuario");
        usr.setForeground(Color.WHITE);
        usr.setFont(new Font("arial", 1, 18));
        panel.add(usr);
        
        //Etiqueta de psw
        psw = new JLabel();
        psw.setBounds(300, 150, 110, 15);
        psw.setText("Contraseña");
        psw.setForeground(Color.WHITE);
        psw.setFont(new Font("arial", 1, 18));
        panel.add(psw);
        
        //Etiqueta del perrito
        jbl_im1 = new JLabel();
        ImageIcon meme = new ImageIcon("./img/Administrador/perrito2.png");
        jbl_im1.setBounds(580,300,200,150);
        jbl_im1.setIcon(new ImageIcon(meme.getImage().getScaledInstance(jbl_im1.getWidth(),
                jbl_im1.getHeight(),Image.SCALE_SMOOTH )));
        panel.add(jbl_im1);
        
        //Etiqueta de viñeta
        jbl_im2 = new JLabel();
        ImageIcon meme2 = new ImageIcon("./img/Administrador/viñeta3.png");
        jbl_im2.setBounds(400,230,200,100);
        jbl_im2.setIcon(new ImageIcon(meme2.getImage().getScaledInstance(jbl_im2.getWidth(),
                jbl_im2.getHeight(),Image.SCALE_SMOOTH )));
        panel.add(jbl_im2);
    }
     
    //BOTONES
    private void colocaBotones(){
        //Boton "regresar"
        btn_regresar = new JButton("Regresar");
        btn_regresar.setBounds(345,450, 180, 40);
        btn_regresar.setFont(new Font("arial", 1, 20));
        btn_regresar.setBackground(new Color(185, 170, 220));
        panel.add(btn_regresar);
        btn_regresar.addActionListener(this);
       
       //Boton "cerrar sesion"
        btn_finalizar = new JButton("Finalizar");
        btn_finalizar.setBounds(550,450, 180, 40);
        btn_finalizar.setFont(new Font("arial", 1, 20));
        btn_finalizar.setBackground(new Color(185, 170, 220));
        panel.add(btn_finalizar);
        btn_finalizar.addActionListener(this);
       
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
    //EVENTOS 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Evento para el boton regresar
        if(e.getSource() == btn_regresar){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?\nNo se guardarán los cambios", "Confirmar salida",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == 0) {
                //JOptionPane.showMessageDialog(null, "Hasta Pronto :)");                
                vLogin va_de_nuez = new vLogin();
                va_de_nuez.setVisible(true);
                this.dispose();
            }
            if (respuesta == 1) {
                //JOptionPane.showMessageDialog(null, "Sigueme Usando UwU");
            }
        }
        //Evento para el boton finalizar
        if(e.getSource() == btn_finalizar){
            //ESPACIO PARA HACER LA CONEXION A LA BASE DE DATOS 
            
            //CAMBIO DE VENTANA 
            vLogin va_de_nuez = new vLogin();
            va_de_nuez.setVisible(true);
            this.dispose();
        }
    }
    
}
