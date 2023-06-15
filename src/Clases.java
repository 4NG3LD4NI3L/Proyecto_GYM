import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clases extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private ClasesDatos clase_datos;
	private ClasesDatosCrear clase_crear;
	private String nombre_clase;
	private BaseDatos bd;
	
	public Clases(JFrame ventana) {
		this.frame=ventana;
		try {
			bd = new BaseDatos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
        panel.setBackground(new Color(0,0,0,100));
        this.add(panel);

        JLabel nombreClase = new JLabel("Clase:");
        nombreClase.setSize(145, 20);
        nombreClase.setLocation(42, 34);
        nombreClase.setFont(new Font("Arial",Font.BOLD,20));
        nombreClase.setForeground(Color.white);
        panel.add(nombreClase);
        
        ArrayList<String> clases_nombreBD = new ArrayList<>();
        try {
			clases_nombreBD = bd.obtenerNombreClases();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        JComboBox<String> clasesDisponible_comboBox = new JComboBox<>();
        clasesDisponible_comboBox.setSize(250, 30);
        clasesDisponible_comboBox.setLocation(110, 30);
        clasesDisponible_comboBox.setOpaque(true);
        clasesDisponible_comboBox.setFocusable(false);
        if (!clases_nombreBD.isEmpty()) {
        	for (int i=0;i<clases_nombreBD.size();i++) {
        		clasesDisponible_comboBox.addItem(clases_nombreBD.get(i));
        	}
        }else {
        	clasesDisponible_comboBox.addItem("-1 <No hay clases registradas>");
        }
        panel.add(clasesDisponible_comboBox);

        JButton regresar = new JButton("Regresar");
        regresar.setBackground(Color.decode("#ff4343"));
        regresar.setFocusPainted(false);
        regresar.setFont(new Font("Arial",Font.BOLD,12));
        regresar.setSize(87, 34);
        regresar.setLocation(150, 90);
        regresar.setPreferredSize(new Dimension(87,34));
        panel.add(regresar);

        JButton buscar = new JButton("Buscar");
        buscar.setBackground(new Color(255,144,21));
        buscar.setSize(87, 32);
        buscar.setLocation(380, 30);
        buscar.setPreferredSize(new Dimension(87,34));
        buscar.setFocusPainted(false);
        panel.add(buscar);	

        JButton nuevoCliente = new JButton("Nueva Clase");
        nuevoCliente.setBackground(Color.decode("#01ff57"));
        nuevoCliente.setSize(123, 34);
        nuevoCliente.setLocation(250, 90);
        nuevoCliente.setPreferredSize(new Dimension(123,34));
        nuevoCliente.setFocusPainted(false);
        panel.add(nuevoCliente);

        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
               cerrarEstaVentana();

                mostrarMenu();

                
                frame.repaint();
                frame.revalidate();
            }
        });
        
        buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clase_datos = new ClasesDatos(frame,clasesDisponible_comboBox.getSelectedItem().toString());
				cerrarEstaVentana();
				frame.add(clase_datos);
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
        regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                cerrarEstaVentana();

                mostrarMenu();

                
                frame.repaint();
                frame.revalidate();
			}
		});
        
        nuevoCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clase_crear = new ClasesDatosCrear(frame);
				cerrarEstaVentana();
				frame.add(clase_crear);
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
        repaint();
		revalidate();
	    this.add(fondo1);
	}
	
	public void cerrarEstaVentana() {
		frame.remove(this);
	}

    public void mostrar(){
        frame.add(this);
		frame.repaint();
		frame.revalidate();
    }

     //Menu
     public void mostrarMenu(){
        Menu menu = new Menu(frame);
        menu.mostrar();
        frame.repaint();
        frame.revalidate();
    }
}