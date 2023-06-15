import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultarInstructor {

		private JFrame frame;
	    private JPanel fondo;
	    private JPanel panel;
	    private JPanel arriba;
	    
	    private BaseDatos bd;
	    private String nombre_instructor;
	    private String id_instructor;
	    
	public ConsultarInstructor(JFrame frame, String nombre, String id) {
		this.frame = frame;
        this.nombre_instructor=nombre;
    	this.id_instructor=id;
    	
    	try {
			bd = new BaseDatos();
		} catch (SQLException e) {
			System.err.println("BaseDatos fallo en la clase EditarCliente, ERROR: "+e.getMessage());
		}
    	String[] datosInstructor = bd.obtenerTodoDelinstructor(Integer.parseInt(id_instructor));
	        
	        JLabel fondo1 = new JLabel(new ImageIcon("Resources/Fondopantallas.png"));
	        fondo1.setSize(691, 487);

	        fondo = new JPanel();
	        fondo.setLayout(null);
	        fondo.setOpaque(true);
	        fondo.setBackground(Color.BLACK);
	        fondo.setSize(691, 487);
	        frame.add(fondo);
	        
	        arriba = new JPanel();
	        arriba.setSize(691, 83);
	        arriba.setLayout(null);
	        arriba.setBackground(new Color(61,61,61));
	        fondo.add(arriba);

	        JLabel lofomini = new JLabel(new ImageIcon("Resources/logoMini.png"));
	        lofomini.setLocation(550, 0);
	        lofomini.setSize(102, 83);
	        arriba.add(lofomini);

	        JButton menu = new JButton("Menú");
	        menu.setSize(80, 23);
	        menu.setBackground(new Color(61,61,61));
	        menu.setLocation(20, 60);
	        menu.setFont(new Font("", Font.BOLD, 15));
	        menu.setForeground(Color.white);
	        menu.setBorderPainted(false);
	        arriba.add(menu);

	        JLabel separador = new JLabel("/");
	        separador.setLocation(100, 67);
	        separador.setFont(new Font("", Font.BOLD, 15));
	        separador.setSize(10, 10);
	        separador.setForeground(Color.white);
	        arriba.add(separador);

	        JButton instr = new JButton("Instructores");
	        instr.setSize(130, 23);
	        instr.setLocation(110, 60);
	        instr.setBackground(new Color(61,61,61));
	        instr.setFont(new Font("", Font.BOLD, 15));
	        instr.setForeground(Color.white);
	        instr.setBorderPainted(false);
	        arriba.add(instr);

	        JLabel separador2 = new JLabel("/");
	        separador2.setLocation(245, 67);
	        separador2.setSize(10, 10);
	        separador2.setFont(new Font("", Font.BOLD, 15));
	        separador2.setForeground(Color.white);
	        arriba.add(separador2);
	        
	        JButton datos = new JButton("Datos Instructor");
	        datos.setSize(190, 23);
	        datos.setLocation(250, 60);
	        datos.setBackground(new Color(61,61,61));
	        datos.setFont(new Font("", Font.BOLD, 15));
	        datos.setForeground(Color.yellow);
	        datos.setBorderPainted(false);
	        arriba.add(datos);
	        
	        RoundedPanel panel = new RoundedPanel(15);///////
	        panel.setLayout(null);
	        panel.setSize(614, 340);
	        panel.setLocation(35, 113);
	        panel.setBackground(new Color(0,0,0,85));
	        fondo.add(panel);

	        JLabel nCliente = new JLabel("Instructores");
	        nCliente.setSize(370, 40);
	        nCliente.setLocation(20, 10);
	        nCliente.setFont(new Font("",Font.BOLD,15));
	        nCliente.setForeground(Color.black);
	        panel.add(nCliente);

	        JLabel nId = new JLabel("ID");
	        nId.setSize(370, 40);
	        nId.setLocation(238, 10);
	        nId.setFont(new Font("",Font.BOLD,15));
	        nId.setForeground(Color.black);
	        panel.add(nId);

	        JLabel nameCliente = new JLabel(nombre_instructor);
	        nameCliente.setSize(150, 15);
	        nameCliente.setLocation(20, 40);
	        nameCliente.setFont(new Font("",Font.BOLD,13));
	        nameCliente.setOpaque(true);
	        nameCliente.setBackground(Color.white);
	        nameCliente.setForeground(Color.black);
	        panel.add(nameCliente);

	        JLabel idCliente = new JLabel(id_instructor);
	        idCliente.setSize(150, 15);
	        idCliente.setLocation(238, 40);
	        idCliente.setFont(new Font("",Font.BOLD,13));
	        idCliente.setOpaque(true);
	        idCliente.setBackground(Color.white);
	        idCliente.setForeground(Color.black);
	        panel.add(idCliente);

	        JButton botonEditarC = new JButton("Editar Instructor");
	        botonEditarC.setSize(160, 40);
	        botonEditarC.setLocation(420, 60);
	        botonEditarC.setBackground(Color.decode("#55A763"));
	        panel.add(botonEditarC);

	        JButton botonEliminarC = new JButton("Eliminar Instructor");
	        botonEliminarC.setSize(160, 40);
	        botonEliminarC.setLocation(420, 120);
	        botonEliminarC.setBackground(Color.decode("#FF4343"));
	        panel.add(botonEliminarC);

	        JButton botonDescargarC = new JButton("Descagar Historial");
	        botonDescargarC.setSize(160, 40);
	        botonDescargarC.setLocation(420, 180);
	        botonDescargarC.setBackground(Color.decode("#FFFFFF"));
	        panel.add(botonDescargarC);

	        JButton botonCredencialC = new JButton("Descagar Credencial");
	        botonCredencialC.setSize(160, 40);
	        botonCredencialC.setLocation(420, 240);
	        botonCredencialC.setBackground(Color.decode("#FFFFFF"));
	        panel.add(botonCredencialC);

	        JPanel panel2 = new JPanel();
	        panel2.setLayout(null);
	        panel2.setSize(370, 250);
	        panel2.setLocation(20, 65);
	        panel2.setBackground(new Color(255,255,255));
	        panel.add(panel2);
	    
	        try {
				JTable tabla;
				tabla = new JTable(bd.buscarIns(Integer.parseInt(id_instructor)));
				JScrollPane scroll = new JScrollPane(tabla);
				scroll.setBounds(20, 40, 330, 200);
				panel2.add(scroll);
			} catch (SQLException e) {
				System.err.println("Error al mostrar la tabla: "+e);
			}

	        JPanel up = new JPanel();
	        up.setSize(370, 30);
	        up.setLayout(null);
	        up.setBackground(Color.yellow);
	        panel2.add(up);

	        JLabel historialC = new JLabel("Historial del Instructor");
	        historialC.setFont(new Font("",Font.BOLD,20));
	        historialC.setSize(250, 30);
	        historialC.setLocation(65, 0);
	        up.add(historialC);

			menu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					frame.remove(fondo);
	
					mostrarMenu();
	
					frame.repaint();
					frame.revalidate();
				}
			});
	
			instr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					frame.remove(fondo);
	
					mostrarPanelInstructor();
	
					frame.repaint();
					frame.revalidate();
				}
			});

			botonEditarC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					frame.remove(fondo);
	
					EditarInstructor();
	
					frame.repaint();
					frame.revalidate();
				}
			});

			botonEliminarC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					frame.remove(fondo);
	
					mostarEliminarInstructor();
	
					frame.repaint();
					frame.revalidate();
				}
			});



			botonCredencialC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					
					JOptionPane.showMessageDialog(null,"Se descargo Correctamente la credencial");
					frame.repaint();
					frame.revalidate();
				}
			});
	
			botonDescargarC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					
					JOptionPane.showMessageDialog(null,"Se descargo Correctamente el documento");
					frame.repaint();
					frame.revalidate();
				}
			});
			
	        frame.repaint();
		    frame.revalidate();
	        fondo.add(fondo1);
	    }

	    public void mostrar(){
	        frame.add(fondo);
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
	
		//Instructor
		public void mostrarPanelInstructor(){
			Instructor instructor = new Instructor(frame);
			instructor.mostrar();
			frame.repaint();
			frame.revalidate();
		}

		//EditarInstructor
		public void EditarInstructor(){
			EditarInstructor editInstructor = new EditarInstructor(frame,nombre_instructor,id_instructor);
			editInstructor.mostrar();
			
		}

		//EliminarInstructor
		public void mostarEliminarInstructor(){
			EliminarInstructor eliminarInstructor = new EliminarInstructor(frame,nombre_instructor,id_instructor);
			eliminarInstructor.mostrar();
			
		}


}