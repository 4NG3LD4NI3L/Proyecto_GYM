import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClasesDatos extends JPanel {
	
	private JFrame frame;
	
	String[] columnas = {"Instructor: Yahir Hernandez Soto"};
	String[] horario = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
	String[] clientes = {"Clientes"};
	String[] clientes_datos = {"ID","Nombre"};
	DefaultTableModel dtm_datosClientes = new DefaultTableModel(clientes_datos,0) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) { 
			return false;
		}
	};
	DefaultTableModel dtm_horario = new DefaultTableModel(horario,0) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) { 
			return false;
		}
	};
	DefaultTableModel dtm_tituloCliente = new DefaultTableModel(clientes,0) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) { 
			return false;
		}
	};
	DefaultTableModel dtm = new DefaultTableModel(columnas,0) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) { 
			return false;
		}
	};
	JTable datos = new JTable(dtm);
	JScrollPane panelScroll = new JScrollPane(datos);
	JTable datos_horario = new JTable(dtm_horario);
	JScrollPane panelScroll_horario = new JScrollPane(datos_horario);
	JTable datos_cliente = new JTable(dtm_tituloCliente);
	JScrollPane panelScroll_tituloCliente = new JScrollPane(datos_cliente);
	JTable datos_DatosCliente = new JTable(dtm_datosClientes);
	JScrollPane panelScroll_clientes = new JScrollPane(datos_DatosCliente);
	
	public ClasesDatos(JFrame ventana) {
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

        JLabel separador_uno = new JLabel("/");
        separador_uno.setLocation(85, 67);
        separador_uno.setSize(10, 10);
        separador_uno.setForeground(Color.white);
        arriba.add(separador_uno);

        JButton clientes = new JButton("Clases");
        clientes.setSize(80, 23);
        clientes.setBackground(new Color(61,61,61));
        clientes.setLocation(90, 60);
        clientes.setForeground(Color.white);
        clientes.setBorderPainted(false);
        arriba.add(clientes);
        
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
        ShapedButtonUI roundUI_3 = new ShapedButtonUI();
        roundUI_3.setShape(ButtonShape.ROUND, regresar,Color.decode("#ff4343"));
        regresar.setUI(roundUI_3);
        regresar.setFocusPainted(false);
        regresar.setFont(new Font("Arial",Font.BOLD,12));
        regresar.setSize(87, 34);
        regresar.setLocation(230, 280);
        regresar.setPreferredSize(new Dimension(87,34));
        panel.add(regresar);

        JButton buscar = new JButton("Editar");
        ShapedButtonUI roundUI = new ShapedButtonUI();
        buscar.setSize(123, 32);
        buscar.setLocation(400, 30);
        roundUI.setShape(ButtonShape.ROUND, buscar,new Color(255,144,21));
        buscar.setUI(roundUI);
        buscar.setPreferredSize(new Dimension(123,34));
        buscar.setFocusPainted(false);
        panel.add(buscar);	

        JButton nuevoCliente = new JButton("Nuevo Cliente");
        ShapedButtonUI roundUI_2 = new ShapedButtonUI();
        roundUI_2.setShape(ButtonShape.ROUND, nuevoCliente,Color.decode("#01ff57"));
        nuevoCliente.setSize(123, 34);
        nuevoCliente.setLocation(400, 90);
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
	
	public void tabladeDatos() throws IOException {
		panelScroll.setSize(370,39);
		panelScroll.setLocation(10,10);
		panelScroll_horario.setSize(370,40);
		panelScroll_horario.setLocation(10,46);
		panelScroll_tituloCliente.setSize(370,20);
		panelScroll_tituloCliente.setLocation(10,80);
		panelScroll_clientes.setSize(370,160);
		panelScroll_clientes.setLocation(10,100);
		
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