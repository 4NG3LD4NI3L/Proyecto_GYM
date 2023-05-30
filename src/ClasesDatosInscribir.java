import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClasesDatosInscribir extends JPanel {
	
	private JFrame frame;
	
	public ClasesDatosInscribir(JFrame ventana) {
		this.frame=ventana;
		
		JLabel fondo1 = new JLabel(new ImageIcon("Resources/Fondopantallas.png"));
        fondo1.setSize(691, 487);
		
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setSize(691, 487);
        frame.add(this);
        
        JPanel arriba = new JPanel();
        arriba.setSize(691, 83);
        arriba.setLayout(null);
        arriba.setBackground(new Color(61,61,61));
        this.add(arriba);
        
        JLabel lofomini = new JLabel(new ImageIcon("Resources/logoMini.png"));
        lofomini.setLocation(550, 0);
        lofomini.setSize(102, 83);
        arriba.add(lofomini);
        
        JButton menu = new JButton("Menú");
        menu.setSize(65, 23);
        menu.setBackground(new Color(61,61,61));
        menu.setLocation(20, 60);
        menu.setForeground(Color.white);
        menu.setBorderPainted(false);
        arriba.add(menu);

        JLabel separador = new JLabel("/");
        separador.setLocation(85, 67);
        separador.setSize(10, 10);
        separador.setForeground(Color.white);
        arriba.add(separador);

        JButton clientes = new JButton("Clases");
        clientes.setSize(80, 23);
        clientes.setBackground(new Color(61,61,61));
        clientes.setLocation(90, 60);
        clientes.setForeground(Color.yellow);
        clientes.setBorderPainted(false);
        arriba.add(clientes);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(393, 183);
        panel.setLocation(149, 197);
        panel.setBackground(new Color(0,0,0,100));
        this.add(panel);

        JLabel titulo = new JLabel("Inscribir un nuevo cliente a la clase: Zumba");
        titulo.setSize(400, 20);
        titulo.setLocation(28, 20);
        titulo.setFont(new Font("Arial",Font.BOLD,17));
        titulo.setForeground(Color.white);
        panel.add(titulo);
        
        JLabel etiqueID = new JLabel("ID del usuario");
        etiqueID.setSize(200, 20);
        etiqueID.setLocation(28, 60);
        etiqueID.setFont(new Font("Arial",Font.BOLD,17));
        etiqueID.setForeground(Color.white);
        panel.add(etiqueID);
        
        JTextField ingreID = new JTextField();
        ingreID.setSize(338, 25);
        ingreID.setLocation(28, 80);
        ingreID.setFont(new Font("Arial",Font.PLAIN,17));
        ingreID.setForeground(Color.white);
        ingreID.setBackground(new Color(0,0,0,100));
        ingreID.setBorder(null);
        panel.add(ingreID);

        JButton regresar = new JButton("Regresar");
        ShapedButtonUI roundUI_3 = new ShapedButtonUI();
        roundUI_3.setShape(ButtonShape.ROUND, regresar,Color.decode("#ff4343"));
        regresar.setUI(roundUI_3);
        regresar.setFocusPainted(false);
        regresar.setFont(new Font("Arial",Font.BOLD,12));
        regresar.setSize(123, 34);
        regresar.setLocation(69, 130);
        regresar.setPreferredSize(new Dimension(87,34));
        panel.add(regresar);


        JButton nuevoCliente = new JButton("Nuevo Cliente");
        ShapedButtonUI roundUI_2 = new ShapedButtonUI();
        roundUI_2.setShape(ButtonShape.ROUND, nuevoCliente,Color.decode("#01ff57"));
        nuevoCliente.setSize(123, 34);
        nuevoCliente.setLocation(200, 130);
        nuevoCliente.setUI(roundUI_2);
        nuevoCliente.setPreferredSize(new Dimension(123,34));
        nuevoCliente.setFocusPainted(false);
        panel.add(nuevoCliente);
        
        regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
        nuevoCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        this.add(fondo1);
        
        repaint();
		revalidate();
	}

}