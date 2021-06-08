
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class vMiCuenta extends JFrame implements ActionListener{
    //ATRIBUTOS
    public JPanel panel;
    public JLabel jbl_fondo;
    public JLabel jbl_apellidoP,jbl_apellidoM, jbl_nombre,jbl_email,usr,psw;
    public JButton btn_cerrar_sesion;
    public JButton btn_regresar;
    public JButton btn_actualiza_info, btn_save;
    public JTextField jtf_apellidoP,jtf_apellidoM;
    public JTextField jtf_nombres;
    public JTextField jtf_email;
    public JTextField jtf_usr;
    public JPasswordField jtf_psw;
    
    public Usuario uvMiCuenta;
    
    //CONTRUCTOR DE VENTANA
    public vMiCuenta(Usuario u){
        setSize(800, 550);
        setTitle("Mi Cuenta");
        setLocationRelativeTo(null);
        setResizable(false);   
        uvMiCuenta = u;
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    //METODO DE LOS COMPONENTES
    public void iniciaComponentes(){
        //AQUI LLAMAMOS TODOS LOS METODOS DE CADA COMPONENTE DE LA VENTANA
        colocaPanel();
        colocaBotones();
        colocaCajasTexto();
        colocaEtiquetas();
        colocaFondo();
    }
    //Cajas de Texto
    private void colocaCajasTexto(){
        //Caja de apellido Paterno
        jtf_apellidoP = new JTextField();
        jtf_apellidoP.setBounds(50,50,200,40);
        jtf_apellidoP.setFont(new Font("arial", 1, 18));
        //jtf_apellidoP.setText("Ramirez Galindo");
        jtf_apellidoP.setBackground(new Color(180, 210, 240));
        jtf_apellidoP.setEditable(false);
        panel.add(jtf_apellidoP);
        
        //Caja de apellido Materno
        jtf_apellidoM = new JTextField();
        jtf_apellidoM.setBounds(50,150,200,40);
        jtf_apellidoM.setFont(new Font("arial", 1, 18));
        jtf_apellidoM.setBackground(new Color(180, 210, 240));
        jtf_apellidoM.setEditable(false);
        panel.add(jtf_apellidoM);
        
        //Caja de Nombre
        jtf_nombres = new JTextField();
        jtf_nombres.setBounds(50,250,200,40);
        jtf_nombres.setFont(new Font("arial", 1, 18));
        jtf_nombres.setBackground(new Color(180, 210, 240));
        jtf_nombres.setEditable(false);
        panel.add(jtf_nombres);
        
        //Caja de email
        jtf_email = new JTextField();
        jtf_email.setBounds(50,350,200,40);
        jtf_email.setFont(new Font("arial", 1, 18));
        jtf_email.setBackground(new Color(180, 210, 240));
        jtf_email.setEditable(false);
        panel.add(jtf_email);
        
        //Caja de usr
        jtf_usr = new JTextField();
        jtf_usr.setBounds(300,50,200,40);
        jtf_usr.setFont(new Font("arial", 1, 18));
        jtf_usr.setBackground(new Color(180, 210, 240));
        jtf_usr.setEditable(false);
        panel.add(jtf_usr);
        
        //Caja psw
        jtf_psw = new JPasswordField();
        jtf_psw.setBounds(300,170,200,40);
        jtf_psw.setFont(new Font("arial", 1, 18));
        jtf_psw.setBackground(new Color(180, 210, 240));
        jtf_psw.setEditable(false);
        panel.add(jtf_psw);
    }
    
    //ETIQUETAS
     private void colocaEtiquetas() {
        //Etiqueta de apellido Paterno  
        jbl_apellidoP = new JLabel();
        jbl_apellidoP.setBounds(50, 30, 160, 15);
        jbl_apellidoP.setText("Apellido Paterno");
        jbl_apellidoP.setForeground(Color.WHITE);
        jbl_apellidoP.setFont(new Font("arial", 1, 18));
        panel.add(jbl_apellidoP);

        //Etiqueta de apellido Materno
        jbl_apellidoM = new JLabel();
        jbl_apellidoM.setBounds(50, 130, 160, 15);
        jbl_apellidoM.setText("Apellido Materno");
        jbl_apellidoM.setForeground(Color.WHITE);
        jbl_apellidoM.setFont(new Font("arial", 1, 18));
        panel.add(jbl_apellidoM);
        
        //Etiqueta de nombre
        jbl_nombre = new JLabel();
        jbl_nombre.setBounds(50, 230, 110, 15);
        jbl_nombre.setText("Nombre(s)");
        jbl_nombre.setForeground(Color.WHITE);
        jbl_nombre.setFont(new Font("arial", 1, 18));
        panel.add(jbl_nombre);
        
        //Etiqueta de email
        jbl_email = new JLabel();
        jbl_email.setBounds(50, 330, 110, 15);
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
        btn_cerrar_sesion = new JButton("Cerrar Sesion");
        btn_cerrar_sesion.setBounds(550,450, 180, 40);
        btn_cerrar_sesion.setFont(new Font("arial", 1, 20));
        btn_cerrar_sesion.setBackground(new Color(185, 170, 220));
        panel.add(btn_cerrar_sesion);
        btn_cerrar_sesion.addActionListener(this);
       
       //Boton actualizar informacion
        btn_actualiza_info = new JButton("Actualizar Informacion");
        btn_actualiza_info.setBounds(300,250, 230, 40);
        btn_actualiza_info.setFont(new Font("arial", 1, 18));
        btn_actualiza_info.setBackground(new Color(185, 170, 220));
        panel.add(btn_actualiza_info);
        btn_actualiza_info.addActionListener(this);
       
       //Boton guardar cambios 
        btn_save = new JButton("Guardar cambios");
        btn_save.setBounds(320,300, 200, 40);
        btn_save.setFont(new Font("arial", 1, 18));
        btn_save.setBackground(new Color(185, 170, 220));
        panel.add(btn_save);
        btn_save.addActionListener(this);
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
    //evento del boton actualizar info
        if(e.getSource() == btn_actualiza_info){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea actualizar sus datos?", "Actualizar Datos", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta == 0){
                //jtf_apellidos.setEditable(true);
                jtf_apellidoP.setEditable(true);
                jtf_apellidoM.setEditable(true);
                jtf_nombres.setEditable(true);
                jtf_email.setEditable(true);        
                jtf_usr.setEditable(true);
                jtf_psw.setEditable(true);     
            }
        }
        
    //Evento para el boton guardar cambios 
        if(e.getSource() == btn_save){
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar cambios?", "Guardar cambios", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(respuesta == 0){
                jtf_apellidoP.setEditable(false);
                jtf_apellidoM.setEditable(false);
                jtf_nombres.setEditable(false);
                jtf_email.setEditable(false);        
                jtf_usr.setEditable(false);
                jtf_psw.setEditable(false);     
            }
        }
    //Evento para el boton de cerrar sesion
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
    //Evento para el boton regresar
        if(e.getSource() == btn_regresar){
            if(uvMiCuenta.getTipo_usr().equalsIgnoreCase("Administrador")){
                vMenuAdmin vma = new vMenuAdmin(uvMiCuenta);
                vma.setVisible(true);
                this.dispose();
            }
            if(uvMiCuenta.getTipo_usr().equalsIgnoreCase("Cliente")){
                vMenuClient vmc = new vMenuClient(uvMiCuenta);
                vmc.setVisible(true);
                this.dispose();
            }
        }
    }//FIN DEL METODO DE LOS EVENTOS  
}//FIN DE LA CLASE
