import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.ImageIcon;

public class Login {
    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    public JButton inicio;

    Menu menu;
    
    public Login(JFrame frame) {
        this.frame = frame;

        
        fondo = new JPanel();
        fondo.setLayout(null);
        fondo.setOpaque(true);
        fondo.setBackground(Color.black);
        fondo.setSize(691, 487);
        frame.add(fondo);

        JLabel fondo1 = new JLabel(new ImageIcon("Resources/FondoGym.png"));
        fondo1.setSize(691, 487);
        fondo.add(fondo1);

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
       usuario.setLocation(241, 264);
       usuario.setSize(206, 25);
       usuario.setBorder(null);
       frame.add(usuario);
       
       usuario.addFocusListener(new FocusAdapter() {
           @Override
           public void focusGained(FocusEvent e) {
               if (usuario.getText().equals("ADMIN")) {
            	   usuario.setText("");
               }
           }

           @Override
           public void focusLost(FocusEvent e) {
               if (usuario.getText().isEmpty()) {
            	   usuario.setText("ADMIN");
               }
           }
       });

       JLabel textoContra = new JLabel("Contraseña");
       textoContra.setSize(89, 14);
       textoContra.setLocation(241, 302);
       textoContra.setForeground(new Color(255,255,255));
       frame.add(textoContra);
       
       JPasswordField contraseña = new JPasswordField("1234567890");
        contraseña.setSize(206,25);
        contraseña.setLocation(241, 317);
        contraseña.setBorder(null);
        frame.add(contraseña);
        
        contraseña.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                char[] password = contraseña.getPassword();
                if (password.length > 0 && new String(password).equals("1234567890")) {
                	contraseña.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                char[] password = contraseña.getPassword();
                if (password.length == 0) {
                	contraseña.setText("1234567890");
                }
            }
        });
    
        inicio = new JButton("LOGIN");
       inicio.setSize(75, 34);
       inicio.setLocation(305, 417);
       inicio.setOpaque(true);
       inicio.setBackground(new Color(255,144,21));
       inicio.setBorderPainted(false);
       frame.add(inicio);

       
        inicio.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);
                frame.remove(inicio);
                frame.remove(textoUsu);
                frame.remove(textoContra);
                frame.remove(logo);
                frame.remove(contraseña);
                frame.remove(usuario);
                
                String password = new String(contraseña.getPassword());

                fondo.repaint();
                fondo.revalidate();
                
               if(usuario.getText().equals("Admin") && password.equals("123")) {
            	   mostrarMenu();
               }
               else {
            	   JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrectos","ERROR",JOptionPane.ERROR_MESSAGE);
            	   mostrarLogin();
               }

                frame.repaint();
            }
       });

        frame.repaint();
		frame.revalidate();
    }    

    public void agregar(){
        frame.add(fondo);
		frame.repaint();
		frame.revalidate();
        
    }


    public void mostrarMenu(){
        Menu menu = new Menu(frame);
        menu.mostrar();
        frame.repaint();
        frame.revalidate();
    }
    
    public void mostrarLogin(){
        Login login = new Login(frame); 
        login.agregar();
        frame.repaint();
        frame.revalidate();
    }
    
}
