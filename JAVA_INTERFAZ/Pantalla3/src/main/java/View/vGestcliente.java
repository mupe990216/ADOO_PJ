
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

//VENTANA DE GESTION DE CLIENTES
public class vGestcliente extends JFrame implements ActionListener{

    //ATRIBUTOS
    public JPanel panel;
    public JLabel jbl_fondo,jbl_ncliente,jbl_cCliente;
    public JButton btn_cerrar_sesion,btn_regresar,btn_nCliente,btn_cCliente;
    
    
    //METODOS
    public vGestcliente(){
        setSize(750, 400);
        setTitle("Gestionar Clientes");
        setLocationRelativeTo(null);
        setResizable(false);
        iniciaComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void iniciaComponentes(){
        colocaPanel();
        colocaBotones();
        colocaEtiqueta();
        colocaFondo();
    }
    
    //Metodo de colocar boton
    public void colocaBotones(){
        //Boton agregar nuevo administrador
        btn_nCliente = new JButton();
        btn_nCliente.setBounds(100, 100, 160, 100);
        ImageIcon i1 = new ImageIcon("./img/Cliente/agregar_usr.png");
        btn_nCliente.setIcon(new ImageIcon(i1.getImage().getScaledInstance(btn_nCliente.getWidth(), btn_nCliente.getHeight(), Image.SCALE_SMOOTH)));
       // btn_nCliente.setFont(new Font("arial", 1, 22));
        btn_nCliente.setBackground(new Color(185, 170, 220));
        panel.add(btn_nCliente);
        btn_nCliente.addActionListener(this);
        
        //Boton consultar Administradores
        btn_cCliente = new JButton();
        btn_cCliente.setBounds(400, 100, 160, 100);
        ImageIcon i2 = new ImageIcon("./img/Cliente/credencial2.png");
        btn_cCliente.setIcon(new ImageIcon(i2.getImage().getScaledInstance(btn_cCliente.getWidth(), btn_cCliente.getHeight(), Image.SCALE_SMOOTH)));
       // btn_cCliente.setFont(new Font("arial", 1, 22));
        btn_cCliente.setBackground(new Color(185, 170, 220));
        panel.add(btn_cCliente);
        btn_cCliente.addActionListener(this);
        
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
        jbl_ncliente = new JLabel();
        jbl_ncliente.setText("Nuevo Cliente");
        jbl_ncliente.setFont(new Font("arial",1,18));
        jbl_ncliente.setForeground(Color.WHITE);
        jbl_ncliente.setBounds(90, 200, 210, 30);
        panel.add(jbl_ncliente);   
        
        //Etiqueta para consultar administradores
        jbl_cCliente = new JLabel();
        jbl_cCliente.setText("Consultar Clientes");
        jbl_cCliente.setFont(new Font("arial",1,18));
        jbl_cCliente.setForeground(Color.WHITE);
        jbl_cCliente.setBounds(370, 200, 240, 30);
        panel.add(jbl_cCliente);   
    }
    //Metodo de colocar panel
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
    
    //Metodo 
    
    //EVENTOS 
    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTON PARA CERRAR SESION
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
        //BOTON PARA REGRESAR
        if(e.getSource() == btn_regresar){
            vMenuAdmin vMA = new vMenuAdmin();
            vMA.setVisible(true);
            this.dispose();
        }
    }
    
}
