
package View;

//Bibliotecas
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Ventana para el registro de un nuevo usuario tipo cliente 
public class vRegistrarse extends JFrame implements ActionListener{
    //ATRIBUTOS 
    public JPanel panel;
    public JLabel jbl_fondo, jbl_dialogo;
    public JLabel jbl_apellidoP,jbl_apellidoM, jbl_nombre,jbl_email,usr,psw,jbl_im1,jbl_im2;
    public JButton btn_finalizar,btn_regresar;
    public JTextField jtf_apellidoP,jtf_apellidoM,jtf_nombres,jtf_email,jtf_usr;
    public JPasswordField jtf_psw;
    public String ApellidoP, ApellidoM, Nombre,Email,n_usr,spsw;
    
    //METODOS
    
    public vRegistrarse(){
        setSize(800, 550);
        setTitle("Registro");
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
       //Caja de apellido Paterno
        jtf_apellidoP = new JTextField();
        jtf_apellidoP.setBounds(50,50,200,40);
        jtf_apellidoP.setFont(new Font("arial", 1, 18));
        //jtf_apellidoP.setText("Ramirez Galindo");
        jtf_apellidoP.setBackground(new Color(180, 210, 240));
        jtf_apellidoP.setEditable(true);
        panel.add(jtf_apellidoP);
        
        //Caja de apellido Materno
        jtf_apellidoM = new JTextField();
        jtf_apellidoM.setBounds(50,150,200,40);
        jtf_apellidoM.setFont(new Font("arial", 1, 18));
        jtf_apellidoM.setBackground(new Color(180, 210, 240));
        jtf_apellidoM.setEditable(true);
        panel.add(jtf_apellidoM);
        
        //Caja de Nombre
        jtf_nombres = new JTextField();
        jtf_nombres.setBounds(50,250,200,40);
        jtf_nombres.setFont(new Font("arial", 1, 18));
        jtf_nombres.setBackground(new Color(180, 210, 240));
        jtf_nombres.setEditable(true);
        panel.add(jtf_nombres);
        
        //Caja de email
        jtf_email = new JTextField();
        jtf_email.setBounds(50,350,200,40);
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
    //ETIQUETAS
    private void colocaDialogo(){
        jbl_dialogo = new JLabel();
        jbl_dialogo.setBounds(408,225,200,100);
        jbl_dialogo.setText("??Qui??n es el nuevo?");
        jbl_dialogo.setForeground(Color.BLACK);
        jbl_dialogo.setFont(new Font("arial",1,18));
        panel.add(jbl_dialogo);
    }
    
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
        psw.setText("Contrase??a");
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
        
        //Etiqueta de vi??eta
        jbl_im2 = new JLabel();
        ImageIcon meme2 = new ImageIcon("./img/Administrador/vi??eta3.png");
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
     
     //Verificar si los jtf estan vacios
    private int jtfVacio(){
         //String ApellidoP,ApellidoM,Nombre,email,usr,psw;
         ApellidoP = jtf_apellidoP.getText();
         ApellidoM = jtf_apellidoM.getText();
         Nombre = jtf_nombres.getText();
         Email = jtf_email.getText();
         n_usr = jtf_usr.getText();
         spsw = "";
         for(int i = 0;i < jtf_psw.getPassword().length;i++){
             spsw += jtf_psw.getPassword()[i];
         }
         if(ApellidoP.equals("") || ApellidoM.equals("") || Nombre.equals("") || Email.equals("") || n_usr.equals("") || spsw.equals("")){
             return 1;
         }
         else{
             return 0;
         }
     }
    //EVENTOS 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Evento para el boton regresar
        if(e.getSource() == btn_regresar){
            int respuesta = JOptionPane.showConfirmDialog(null, "??Desea salir del sistema?\nNo se guardar??n los cambios", "Confirmar salida",
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
            int vacio = jtfVacio();
            int respuesta = JOptionPane.showConfirmDialog(null, "??Desea finalizar el registro?", "Confirmar registro",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //SI LA RESPUESTA FUE QUE SI 
            if (respuesta == 0) {
               //VERIFICAMOS SI NO ESTAN VACIOS 
                if(vacio == 0){
                    cDatos datitos = new cDatos(); //Creo un objeto de la clase para conectar a MySQL
                    try{
                        Connection conn = datitos.conecta(); 
                        ResultSet rs = datitos.consulta("call sp_AltaUsuario('"+Email+"','"+Nombre+"','"+ApellidoP+"','"+ApellidoM+"','"+n_usr+"','"+spsw+"');",
                                conn); // Ejecuta sentencia SQL y regresa las coincidencias
                        while(rs.next()){
                            JOptionPane.showMessageDialog(null, rs.getString("Respuesta")); //Columna Respuesta
                        }
                        rs.close();
                        conn.close();
                    } catch(SQLException ex){
                        System.out.println("Error al registrarse en SAY WOOF!: " + ex.getMessage());
                    }
                    //Una vez agregado el usr cliente  regresamos a la ventana anterior
                    //CAMBIO DE VENTANA 
                    vLogin va_de_nuez = new vLogin();
                    va_de_nuez.setVisible(true);
                    this.dispose();
               }
                //SI ESTAN VACIOS
                else{
                   JOptionPane.showMessageDialog(null, "Complete todos los campos");
                }
            }
        }
    }
    
}
