//Paquetes 
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

//Ventana del menu para gestionar administradores
public class vGestAdmin extends JFrame implements ActionListener{
    //Atributos
    public JPanel panel;
    public JLabel jbl_fondo,jbl_nAdmin,jbl_cAdmin;
    public JButton btn_cerrar_sesion,btn_regresar,btn_agregarAdmin,btn_consultar,btn_eliminar;
    public Usuario uvga;
    
    //Metodos
    public vGestAdmin(Usuario u){
        setSize(750, 400);
        setTitle("Gestión de Administradores");
        setLocationRelativeTo(null);
        setResizable(false);
        uvga = u;
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void iniciaComponentes(){
        colocaPanel();
        colocaBotones();
        colocaEtiqueta();
        colocaFondo();
    }
    
    //Metodo de colocaBotones
    public void colocaBotones(){
        //Boton agregar nuevo administrador
        btn_agregarAdmin = new JButton();
        btn_agregarAdmin.setBounds(100, 100, 160, 100);
        ImageIcon i1 = new ImageIcon("./img/Administrador/Agregar_Admin.png");
        btn_agregarAdmin.setIcon(new ImageIcon(i1.getImage().getScaledInstance(btn_agregarAdmin.getWidth(), btn_agregarAdmin.getHeight(), Image.SCALE_SMOOTH)));
       // btn_gestAdmin.setFont(new Font("arial", 1, 22));
        btn_agregarAdmin.setBackground(new Color(185, 170, 220));
        panel.add(btn_agregarAdmin);
        btn_agregarAdmin.addActionListener(this);
        
        //Boton consultar Administradores
        btn_consultar = new JButton();
        btn_consultar.setBounds(400, 100, 160, 100);
        ImageIcon i2 = new ImageIcon("./img/Administrador/Credencial.png");
        btn_consultar.setIcon(new ImageIcon(i2.getImage().getScaledInstance(btn_consultar.getWidth(), btn_consultar.getHeight(), Image.SCALE_SMOOTH)));
       // btn_consultar.setFont(new Font("arial", 1, 22));
        btn_consultar.setBackground(new Color(185, 170, 220));
        panel.add(btn_consultar);
        btn_consultar.addActionListener(this);
        //Boton eliminar administrador
        
        //Boton "regresar"
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
    
    //Metodo para colocar etiquetas
    public void colocaEtiqueta(){
        //Etiqueta para agregar nuevo administrador
        jbl_nAdmin = new JLabel();
        jbl_nAdmin.setText("Nuevo Administrador");
        jbl_nAdmin.setFont(new Font("arial",1,18));
        jbl_nAdmin.setForeground(Color.WHITE);
        jbl_nAdmin.setBounds(90, 200, 210, 30);
        panel.add(jbl_nAdmin);   
        
        //Etiqueta para consultar administradores
        jbl_cAdmin = new JLabel();
        jbl_cAdmin.setText("Consultar Administradores");
        jbl_cAdmin.setFont(new Font("arial",1,18));
        jbl_cAdmin.setForeground(Color.WHITE);
        jbl_cAdmin.setBounds(370, 200, 240, 30);
        panel.add(jbl_cAdmin);   
    }
    
    //Metodo de colocaPanel
    private void colocaPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(160, 215, 240));
        this.getContentPane().add(panel);
    }
    
    //Metodo de colocar fondo
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
        //EVENTO PARA CERRAR SESION
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
        //EVENTO PARA REGRESAR
        if(e.getSource() == btn_regresar){
            vMenuAdmin vMA = new vMenuAdmin(uvga);
            vMA.setVisible(true);
            this.dispose();
        }
        
        //EVENTO PARA REGISTRAR NUEVO ADMINISTRADOR
        if(e.getSource() == btn_agregarAdmin){
            vRegAdmin v4 = new vRegAdmin(uvga);
            v4.setVisible(true);
            this.dispose();
        }
        
        //EVENTO PARA CONSULTAR ADMINISTRADORES
        if(e.getSource() == btn_consultar){
            
        }
    }//FIN DEL METODO DE EVENTOS
    
}
