import java.awt.Color;

import javax.swing.*;

public class Login {
    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    
    public Login(JFrame frame) {
        this.frame = frame;
        
       fondo = new JPanel();
       fondo.setLayout(null);
       fondo.setSize(691, 487);
       fondo.setBackground(Color.blue);//agregar imagen
       frame.add(fondo);
       
       JButton inicio = new JButton("INICIO");
       inicio.setSize(75, 34);
       inicio.setLocation(305, 417);
       frame.add(inicio);

       panel = new JPanel();
       panel.setLayout(null);
       panel.setSize(358, 209);
       panel.setLocation(167, 198);
       panel.setBackground(Color.green);
       fondo.add(panel);
       
       JTextField usuario = new JTextField("ADMIN");
       usuario.setLocation(76, 67);
       usuario.setSize(206, 25);
       panel.add(usuario);
       
       JPasswordField contraseña = new JPasswordField();
        contraseña.setSize(206,25);
        contraseña.setLocation(76, 120);
        panel.add(contraseña);


    }    

    public void agregar(){
        frame.add(panel);
		frame.add(fondo);
		frame.repaint();
		frame.revalidate();
    }
}
