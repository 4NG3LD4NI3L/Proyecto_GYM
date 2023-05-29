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

public class Clases extends JPanel {
	
	private JFrame frame;
	
	public Clases(JFrame ventana) {
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
        panel.setSize(493, 133);
        panel.setLocation(99, 227);
        panel.setBackground(new Color(0,0,0,85));
        this.add(panel);

        JLabel nombreClase = new JLabel("Clase:");
        nombreClase.setSize(145, 20);
        nombreClase.setLocation(42, 34);
        nombreClase.setFont(new Font("Arial",Font.BOLD,20));
        nombreClase.setForeground(Color.white);
        panel.add(nombreClase);
        
        JComboBox<String> clasesDisponible_comboBox = new JComboBox<>();
        clasesDisponible_comboBox.setSize(250, 30);
        clasesDisponible_comboBox.setLocation(110, 30);
        clasesDisponible_comboBox.setOpaque(true);
        clasesDisponible_comboBox.setBackground(Color.BLACK);
        clasesDisponible_comboBox.setForeground(Color.white);
        clasesDisponible_comboBox.setFocusable(false);
        clasesDisponible_comboBox.addItem("Seleccionar una clase");
        clasesDisponible_comboBox.addItem("Yoga");
        clasesDisponible_comboBox.addItem("xCombat");
        panel.add(clasesDisponible_comboBox);

        JButton regresar = new JButton("Regresar");
        ShapedButtonUI roundUI_3 = new ShapedButtonUI();
        roundUI_3.setShape(ButtonShape.ROUND, regresar,Color.decode("#ff4343"));
        regresar.setUI(roundUI_3);
        regresar.setFocusPainted(false);
        regresar.setFont(new Font("Arial",Font.BOLD,12));
        regresar.setSize(87, 34);
        regresar.setLocation(100+50, 90);
        regresar.setPreferredSize(new Dimension(87,34));
        panel.add(regresar);

        JButton buscar = new JButton("Buscar");
        ShapedButtonUI roundUI = new ShapedButtonUI();
        buscar.setSize(87, 32);
        buscar.setLocation(380, 30);
        roundUI.setShape(ButtonShape.ROUND, buscar,new Color(255,144,21));
        buscar.setUI(roundUI);
        buscar.setPreferredSize(new Dimension(87,34));
        buscar.setFocusPainted(false);
        panel.add(buscar);	

        JButton nuevoCliente = new JButton("Nuevo Cliente");
        ShapedButtonUI roundUI_2 = new ShapedButtonUI();
        roundUI_2.setShape(ButtonShape.ROUND, nuevoCliente,Color.decode("#01ff57"));
        nuevoCliente.setSize(123, 34);
        nuevoCliente.setLocation(300-50, 90);
        nuevoCliente.setUI(roundUI_2);
        nuevoCliente.setPreferredSize(new Dimension(123,34));
        nuevoCliente.setFocusPainted(false);
        panel.add(nuevoCliente);
        
        buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
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
        
        repaint();
		revalidate();
	    this.add(fondo1);
	}

    public void mostrar(){
        //frame.add(panel); ESTE PANEL NO ESTA INICIALIZADO Y MANDA NULL
        frame.add(frame);
		frame.repaint();
		frame.revalidate();
    }
}