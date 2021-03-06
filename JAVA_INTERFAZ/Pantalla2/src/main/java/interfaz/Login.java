/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author erick
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setSize(400,550);
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
        this.setResizable(false);
        
        //ETIQUETA DE IMAGEN (FONDO AZUL)
        //ImageIcon fondo = new ImageIcon("Fondo_azul.jpg");
       // Fondo_azul.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(400, 275,
              //  Image.SCALE_SMOOTH)));
        //this.repaint();
        
    }
    
    //CAMBIO DEL ICONO DE LA VENTANA 
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/LOGO.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        Usuario = new javax.swing.JLabel();
        Caja_usuario = new javax.swing.JTextField();
        Boton_iniciarS = new javax.swing.JButton();
        Candado = new javax.swing.JLabel();
        Caja_psw = new javax.swing.JPasswordField();
        Logo = new javax.swing.JLabel();
        Say_woof = new javax.swing.JLabel();
        Fondo_azul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(400, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 550));

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Usuario.setForeground(new java.awt.Color(102, 51, 0));
        Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario3.png"))); // NOI18N
        Panel.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 41, 40));

        Caja_usuario.setBackground(new java.awt.Color(255, 255, 255));
        Caja_usuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Caja_usuario.setForeground(new java.awt.Color(0, 0, 0));
        Caja_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Caja_usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Caja_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caja_usuarioActionPerformed(evt);
            }
        });
        Panel.add(Caja_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 270, 30));

        Boton_iniciarS.setBackground(new java.awt.Color(0, 204, 255));
        Boton_iniciarS.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Boton_iniciarS.setForeground(new java.awt.Color(255, 255, 255));
        Boton_iniciarS.setText("Iniciar Sesi??n");
        Boton_iniciarS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 204), null, null));
        Boton_iniciarS.setBorderPainted(false);
        Panel.add(Boton_iniciarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 150, 40));

        Candado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/candado2.png"))); // NOI18N
        Candado.setText("jLabel2");
        Panel.add(Candado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 40, 41));
        Candado.getAccessibleContext().setAccessibleDescription("");

        Caja_psw.setBackground(new java.awt.Color(255, 255, 255));
        Caja_psw.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Caja_psw.setForeground(new java.awt.Color(0, 0, 0));
        Caja_psw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Caja_psw.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel.add(Caja_psw, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 270, 30));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGO.png"))); // NOI18N
        Panel.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 17, -1, -1));

        Say_woof.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        Say_woof.setForeground(new java.awt.Color(0, 102, 204));
        Say_woof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Say_woof.setText("Say Woof!");
        Panel.add(Say_woof, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 280, 70));

        Fondo_azul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo_azul.jpg"))); // NOI18N
        Panel.add(Fondo_azul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 281, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Caja_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caja_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caja_usuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_iniciarS;
    private javax.swing.JPasswordField Caja_psw;
    private javax.swing.JTextField Caja_usuario;
    private javax.swing.JLabel Candado;
    private javax.swing.JLabel Fondo_azul;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel Say_woof;
    private javax.swing.JLabel Usuario;
    // End of variables declaration//GEN-END:variables
}
