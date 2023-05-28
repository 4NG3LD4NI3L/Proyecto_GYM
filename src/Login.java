import java.awt.Color;

import javax.swing.*;
import javax.swing.ImageIcon;

public class Login {
    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    public JButton inicio;
    
    public Login(JFrame frame) {
        this.frame = frame;

       JLabel fondo1 = new JLabel(new ImageIcon("Resources/FondoGym.png"));
       fondo1.setSize(691, 487);
       
       fondo = new JPanel();
       fondo.setLayout(null);
       fondo.setOpaque(true);
       fondo.setBackground(Color.black);
       fondo.setSize(691, 487);
       frame.add(fondo);
       fondo.add(fondo1);

       
       inicio = new JButton("LOGIN");
       inicio.setSize(75, 34);
       inicio.setLocation(305, 417);
       inicio.setBackground(new Color(255,144,21));
       inicio.setBorderPainted(false);
       frame.add(inicio);

       
       JLabel logo = new JLabel(new ImageIcon("Resources/logoGrande.png"));
       logo.setSize(241, 189);
       logo.setLocation(229, 2);
       frame.add(logo);
       
       RoundedPanel panel = new RoundedPanel(15);
       panel.setLayout(null);
       panel.setSize(358, 209);
       panel.setLocation(167, 198);
       panel.setBackground(new Color(255,255,255,40));
       fondo.add(panel);

       JLabel textoUsu = new JLabel("Usuario");
       textoUsu.setSize(59, 14);
       textoUsu.setLocation(241, 249);
       textoUsu.setForeground(Color.white);
       frame.add(textoUsu);

       JTextField usuario = new JTextField("ADMIN");
       usuario.setLocation(76, 67);
       usuario.setSize(206, 25);
       usuario.setBorder(null);
       panel.add(usuario);

       JLabel textoContra = new JLabel("Contraseña");
       textoContra.setSize(89, 14);
       textoContra.setLocation(242, 302);
       textoContra.setForeground(new Color(255,255,255));
       frame.add(textoContra);
       
       JPasswordField contraseña = new JPasswordField();
        contraseña.setSize(206,25);
        contraseña.setLocation(76, 120);
        contraseña.setBorder(null);
        panel.add(contraseña);

        frame.repaint();
		frame.revalidate();
    }    

    public void agregar(){
        frame.add(fondo);
        frame.add(panel);
		frame.repaint();
		frame.revalidate();
        
    }
}
