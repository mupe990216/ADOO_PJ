package View;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class vMenuAdmin extends JFrame{
    
    public JPanel panel;
    public JLabel Titulo, img01;    
    
    public vMenuAdmin(){
        setSize(600,600);
        setTitle(" Menu Admin");
        setLocationRelativeTo(null);
        
        iniciarCompotentes();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    private void iniciarCompotentes(){
        colocaPanel();
        colocaEtiquetas();
    }
    
    private void colocaPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);
    }
    
    private void colocaEtiquetas(){
        Titulo = new JLabel();
        Titulo.setBounds(50, 50, 200, 50);
        Titulo.setOpaque(true);
        Titulo.setText("Menu Admin xd");
        panel.add(Titulo);
        
        
        ImageIcon prueba = new ImageIcon("./src/main/java/imagenes/foro.png");
        img01 = new JLabel();
        img01.setBounds(150, 150, 280, 150);
        img01.setOpaque(true);        
        img01.setIcon(new ImageIcon(prueba.getImage().getScaledInstance(img01.getWidth(), img01.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(img01);
    }
}
