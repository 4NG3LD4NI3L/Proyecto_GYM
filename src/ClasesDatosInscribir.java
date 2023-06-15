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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClasesDatosInscribir extends JPanel {
	
	private JFrame frame;
	private ClasesDatos clase_datos;
	private String nombre_clase;
	private BaseDatos bd;
	
	public ClasesDatosInscribir(JFrame ventana,String nombre) {
		this.frame=ventana;
		this.nombre_clase=nombre;
		try {
			bd = new BaseDatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

        JButton clases = new JButton("Clases");
        clases.setSize(80, 23);
        clases.setBackground(new Color(61,61,61));
        clases.setLocation(90, 60);
        clases.setForeground(Color.white);
        clases.setBorderPainted(false);
        arriba.add(clases);
        
        JLabel separador_2 = new JLabel("/");
        separador_2.setLocation(170, 67);
        separador_2.setSize(10, 10);
        separador_2.setForeground(Color.white);
        arriba.add(separador_2);
        
        JButton datos = new JButton("Datos");
        datos.setSize(80, 23);
        datos.setBackground(new Color(61,61,61));
        datos.setLocation(175, 60);
        datos.setForeground(Color.white);
        datos.setBorderPainted(false);
        arriba.add(datos);
        
        JLabel separador_3 = new JLabel("/");
        separador_3.setLocation(255, 67);
        separador_3.setSize(10, 10);
        separador_3.setForeground(Color.white);
        arriba.add(separador_3);
        
        JButton crear_Clase = new JButton("Inscribir Un Cliente");
        crear_Clase.setSize(150, 23);
        crear_Clase.setBackground(new Color(61,61,61));
        crear_Clase.setLocation(260, 60);
        crear_Clase.setForeground(Color.yellow);
        crear_Clase.setBorderPainted(false);
        arriba.add(crear_Clase);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(393, 183);
        panel.setLocation(149, 197);
        panel.setBackground(new Color(0,0,0,100));
        this.add(panel);

        JLabel titulo = new JLabel("Inscribir un cliente a la clase: "+nombre_clase);
        titulo.setSize(400, 20);
        titulo.setLocation(28, 20);
        titulo.setFont(new Font("Arial",Font.BOLD,16));
        titulo.setForeground(Color.white);
        panel.add(titulo);
        
        JLabel etiqueID = new JLabel("ID del usuario");
        etiqueID.setSize(200, 20);
        etiqueID.setLocation(28, 60);
        etiqueID.setFont(new Font("Arial",Font.BOLD,17));
        etiqueID.setForeground(Color.white);
        panel.add(etiqueID);
        
        ArrayList<String> clientesBD = new ArrayList<>();
        try {
			clientesBD = bd.obtenerNombresClientesParaClases();
		} catch (SQLException e) {
			System.err.println("Error al capturar los clientes: "+e.getMessage());
		}
        JComboBox<String> clasesDisponible_comboBox = new JComboBox<>();
        clasesDisponible_comboBox.setSize(338, 25);
        clasesDisponible_comboBox.setLocation(28, 80);
        clasesDisponible_comboBox.setOpaque(true);
        clasesDisponible_comboBox.setBackground(Color.white);
        clasesDisponible_comboBox.setForeground(Color.black);
        clasesDisponible_comboBox.setFocusable(false);
        if (!clientesBD.isEmpty()) {
        	for (int i=0;i<clientesBD.size();i++) {
        		clasesDisponible_comboBox.addItem(clientesBD.get(i));
        	}
        }else {
        	clasesDisponible_comboBox.addItem("-1 <No hay clientes registrados>");
        }
        panel.add(clasesDisponible_comboBox);

        JButton regresar = new JButton("Regresar");
        regresar.setBackground(Color.decode("#ff4343"));
        regresar.setFocusPainted(false);
        regresar.setFont(new Font("Arial",Font.BOLD,12));
        regresar.setSize(123, 34);
        regresar.setLocation(69, 130);
        panel.add(regresar);

        JButton inscribirCliente = new JButton("Inscribir");
        inscribirCliente.setBackground(Color.decode("#01ff57"));
        inscribirCliente.setSize(123, 34);
        inscribirCliente.setLocation(200, 130);
        inscribirCliente.setFocusPainted(false);
        panel.add(inscribirCliente);

        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
               cerrarEstaVentana();

                mostrarMenu();

                
                frame.repaint();
                frame.revalidate();
            }
        });

        clases.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				cerrarEstaVentana();
                
				mostrarPanelClases();
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
        datos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				clase_datos = new ClasesDatos(frame,nombre_clase);
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
				clase_datos = new ClasesDatos(frame,nombre_clase);
				cerrarEstaVentana();
				frame.add(clase_datos);
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
        inscribirCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				
				String opcionSeleccionada = (String) clasesDisponible_comboBox.getSelectedItem();
            	String[] datos = opcionSeleccionada.split(" ");
            	
            	if (bd.inscribirCliente(nombre_clase,datos[0],datos[1])) {
            		JOptionPane.showMessageDialog(null,"Cliente registrado con exito","Proceso completado",JOptionPane.INFORMATION_MESSAGE);
            	}else {
            		JOptionPane.showMessageDialog(null,"El cliente ya esta inscrito a la clase de "+nombre_clase,"Proceso no completado",JOptionPane.ERROR_MESSAGE);
            	}
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        this.add(fondo1);
        
        repaint();
		revalidate();
	}
	
	public void cerrarEstaVentana() {
		frame.remove(this);
	}

    //Menu
    public void mostrarMenu(){
        Menu menu = new Menu(frame);
        menu.mostrar();
        frame.repaint();
        frame.revalidate();
    }

    //Clases panel
    public void mostrarPanelClases(){
        Clases clases = new Clases(frame);
        clases.mostrar();
        frame.repaint();
        frame.revalidate();
    }

}