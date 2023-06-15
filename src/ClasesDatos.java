import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClasesDatos extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private Clases clase;
	private ClasesDatosEditar clase_editar;
	private ClasesDatosInscribir clase_inscribir;
	private String nombre_clase;
	private BaseDatos bd;
	
	private String[] columnas =  new String[1];
	private String[] horario = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
	private String[] clientes = {"Clientes"};
	private String[] clientes_datos = {"ID","Nombre"};
	private DefaultTableModel dtm_datosClientes;
	private DefaultTableModel dtm_horario;
	private DefaultTableModel dtm_tituloCliente;
	private DefaultTableModel dtm;
	private JTable datos;
	private JScrollPane panelScroll;
	private JTable datos_horario;
	private JScrollPane panelScroll_horario;
	private JTable datos_cliente;
	private JScrollPane panelScroll_tituloCliente;
	private JTable datos_DatosCliente;
	private JScrollPane panelScroll_clientes;
	
	public ClasesDatos(JFrame ventana,String nombre_Clase) {
		this.frame=ventana;
		this.nombre_clase=nombre_Clase;
		try {
			bd = new BaseDatos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		columnas[0] = "Instructor: "+bd.regresarInstructorDeLaClase(nombre_Clase);
		dtm_datosClientes = new DefaultTableModel(clientes_datos,0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		dtm_horario = new DefaultTableModel(horario,0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		dtm_tituloCliente = new DefaultTableModel(clientes,0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		dtm = new DefaultTableModel(columnas,0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		datos = new JTable(dtm);
		try {
			datos_horario = new JTable(bd.buscarClasesDatos(nombre_Clase));
			datos_DatosCliente = new JTable(bd.buscarClasesClientes(nombre_Clase));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		datos_cliente = new JTable(dtm_tituloCliente);
		
		panelScroll = new JScrollPane(datos);
		panelScroll_horario = new JScrollPane(datos_horario);
		panelScroll_tituloCliente = new JScrollPane(datos_cliente);
		panelScroll_clientes = new JScrollPane(datos_DatosCliente);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
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

        JLabel separador_uno = new JLabel("/");
        separador_uno.setLocation(85, 67);
        separador_uno.setSize(10, 10);
        separador_uno.setForeground(Color.white);
        arriba.add(separador_uno);

        JButton clases = new JButton("Clases");
        clases.setSize(80, 23);
        clases.setBackground(new Color(61,61,61));
        clases.setLocation(90, 60);
        clases.setForeground(Color.white);
        clases.setBorderPainted(false);
        arriba.add(clases);
        
        JLabel separador_dos = new JLabel("/");
        separador_dos.setLocation(170, 67);
        separador_dos.setSize(10, 10);
        separador_dos.setForeground(Color.white);
        arriba.add(separador_dos);
        
        JButton Datos = new JButton("Datos");
        Datos.setSize(70, 23);
        Datos.setBackground(new Color(61,61,61));
        Datos.setLocation(180, 60);
        Datos.setForeground(Color.yellow);
        Datos.setBorderPainted(false);
        arriba.add(Datos);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(540, 333);
        panel.setLocation(77, 117);
        panel.setBackground(new Color(0,0,0,85));
        this.add(panel);
        
        JLabel etiqueClase = new JLabel("Clase: "+nombre_clase);
        etiqueClase.setSize(520, 20);
        etiqueClase.setLocation(11, 10);
        etiqueClase.setForeground(Color.black);
        etiqueClase.setBackground(Color.yellow);
        etiqueClase.setOpaque(true);
        panel.add(etiqueClase);
        
        try {
			tabladeDatos();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        JScrollPane tabla_dosPrimerasLienas;
		tabla_dosPrimerasLienas = panelScroll;
		
		JScrollPane horario;
		horario = panelScroll_horario;
		
		JScrollPane clientes_titu;
		clientes_titu = panelScroll_tituloCliente;
		
		JScrollPane clientes_datos;
		clientes_datos = panelScroll_clientes;
		
		panel.add(tabla_dosPrimerasLienas);
		panel.add(horario);
		panel.add(clientes_titu);
		panel.add(clientes_datos);

        JButton regresar = new JButton("Regresar");
        regresar.setBackground(Color.decode("#ff4343"));
        regresar.setFocusPainted(false);
        regresar.setFont(new Font("Arial",Font.BOLD,12));
        regresar.setSize(87, 34);
        regresar.setLocation(15, 290);
        regresar.setPreferredSize(new Dimension(87,34));
        panel.add(regresar);

        JButton buscar = new JButton("Editar");
        buscar.setSize(123, 34);
        buscar.setLocation(250, 290);
        buscar.setBackground(new Color(255,144,21));
        buscar.setPreferredSize(new Dimension(123,34));
        buscar.setFocusPainted(false);
        panel.add(buscar);	

        JButton nuevoCliente = new JButton("Inscribir cliente");
        nuevoCliente.setBackground(Color.decode("#01ff57"));
        nuevoCliente.setSize(123, 34);
        nuevoCliente.setLocation(400, 290);
        nuevoCliente.setPreferredSize(new Dimension(123,34));
        nuevoCliente.setFocusPainted(false);
        panel.add(nuevoCliente);
        
        buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clase_editar = new ClasesDatosEditar(frame,nombre_clase);
				cerrarEstaVentana();
				frame.add(clase_editar);
				
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});

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
				clase = new Clases(frame);
				cerrarEstaVentana();
				frame.add(clase);
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});

		regresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				clase = new Clases(frame);
				cerrarEstaVentana();
				frame.add(clase);
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
        nuevoCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				clase_inscribir = new ClasesDatosInscribir(frame,nombre_clase);
				cerrarEstaVentana();
				frame.add(clase_inscribir);
				
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

	//Menu
    public void mostrarMenu(){
        Menu menu = new Menu(frame);
        menu.mostrar();
        frame.repaint();
        frame.revalidate();
    }
	
	public void tabladeDatos() throws IOException {
		panelScroll.setSize(520,39);
		panelScroll.setLocation(10,30);
		panelScroll_horario.setSize(520,40);
		panelScroll_horario.setLocation(10,66);
		panelScroll_tituloCliente.setSize(520,20);
		panelScroll_tituloCliente.setLocation(10,100);
		panelScroll_clientes.setSize(520,160);
		panelScroll_clientes.setLocation(10,120);
		
		String[] datosNew = {"Horario"};
		String[] datos_horas = {"7-9 PM","5-9 PM","7-9 PM","7-9 PM","8-10 PM","9-11 PM","9-11 PM",};
		String[] datos_clientes = {"90465","Guillermo Guadalupe Estrada Nicolas"};
		
		dtm.addRow(datosNew);
		dtm_horario.addRow(datos_horas);
		dtm_datosClientes.addRow(datos_clientes);
		
		this.repaint();
		this.revalidate();
	}
}