import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class Clientes {

    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;
    private BaseDatos bd;

    public Clientes(JFrame frame){
        this.frame = frame;
        try {
			bd = new BaseDatos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
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

        JButton clientes = new JButton("Clientes");
        clientes.setSize(100, 23);
        clientes.setBackground(new Color(61,61,61));
        clientes.setLocation(105, 60);
        clientes.setFont(new Font("", Font.BOLD, 15));
        clientes.setForeground(Color.yellow);
        clientes.setBorderPainted(false);
        arriba.add(clientes);

        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(493, 133);
        panel.setLocation(99, 227);
        panel.setBackground(new Color(0,0,0,100));
        fondo.add(panel);

        JLabel nombreClase = new JLabel("Cliente:");
        nombreClase.setSize(145, 20);
        nombreClase.setLocation(42, 34);
        nombreClase.setFont(new Font("Arial",Font.BOLD,20));
        nombreClase.setForeground(Color.white);
        panel.add(nombreClase);
        
        ArrayList<String> clientesBD = new ArrayList<>();
        try {
			clientesBD = bd.obtenerNombresClientes();
		} catch (SQLException e) {
			System.err.println("Error al capturar los clientes: "+e.getMessage());
		}
        JComboBox<String> clasesDisponible_comboBox = new JComboBox<>();
        clasesDisponible_comboBox.setSize(250, 30);
        clasesDisponible_comboBox.setLocation(120, 30);
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
        regresar.setSize(87, 34);
        regresar.setLocation(150, 80);
        regresar.setBackground(Color.decode("#ff4343"));
        regresar.setBorderPainted(false);
       
        regresar.setOpaque(true);
        panel.add(regresar);

        JButton buscar = new JButton("Buscar");
        buscar.setSize(87, 34);
        buscar.setLocation(380, 30);
        buscar.setBackground(new Color(255,144,21));
        panel.add(buscar);

        JButton nuevoCliente = new JButton("Nuevo Cliente");
        nuevoCliente.setSize(123, 34);
        nuevoCliente.setLocation(250, 80);
        nuevoCliente.setBackground(Color.decode("#01ff57"));
        panel.add(nuevoCliente);

        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarMenu();

                frame.repaint();
                frame.revalidate();
            }
        });

        regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
                frame.remove(fondo);

                mostrarMenu();

                frame.repaint();
                frame.revalidate();
            }
        });

        nuevoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                NuevoCliente();

                frame.repaint();
                frame.revalidate();
            }
        });

        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String opcionSeleccionada = (String) clasesDisponible_comboBox.getSelectedItem();
            	String[] datos = opcionSeleccionada.split(" ");
            	
            	mostrarConsultaCliente(datos[1], datos[0]);
            	
            	frame.remove(fondo);
                frame.repaint();
                frame.revalidate();
            }
        });




        
        frame.repaint();
	    frame.revalidate();
        fondo.add(fondo1);
    }
    
    public boolean buscarBD(String nombre,int id) throws SQLException {
    	bd = new BaseDatos();
    	boolean resultado = false;
    	
    	if ( bd.buscarNombreClienteIdCliente(nombre,id)) {
    		System.out.println("LO ENCONTRO");
    		resultado=true;
    	}else {
    		System.out.println("no lo encontro");
    	}
    	
    	return resultado;
    }
    
    public boolean verifID(String id) {
		boolean resultado = false;
		Set<Character> caracteresProhibidos = new HashSet<>(Arrays.asList('|','°','¬','!','"','#','$','%','&','/','(',')','=','?','¡','¿','+','*','~','´','¨',
																		'{','}','[',']','^','`','<','>',',',';','.',':','-','_','q','Q','w','W','e','E','r','R'
																		,'t','T','y','Y','u','U','i','I','o','O','p','P','a','A','s','S','d','D','f','F','g','G',
																		'h','H','j','J','k','K','l','L','ñ','Ñ','z','Z','x','X','c','C','v','V','b','B','n','N',
																		'm','M',' '));
		for (int i=0;i<id.length();i++) {
			char caracterActual = id.charAt(i);
			if (caracteresProhibidos.contains(caracterActual)) {
				resultado = true;
			}
		}
		
		return resultado;
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

    //NuevoCiente
    public void NuevoCliente(){
        NuevoCliente newcliente = new NuevoCliente(frame);
        newcliente.mostrar();
        frame.repaint();
        frame.revalidate();
    }

    //Consultar
    public void mostrarConsultaCliente(String nombre,String id){// EDITADO PARA PASAR LOS DATOS DEL CLIENTE
        ConsultarCliente consultaCliente = new ConsultarCliente(frame,nombre,id);
        consultaCliente.mostrar();
        frame.repaint();
        frame.revalidate();
    }
}