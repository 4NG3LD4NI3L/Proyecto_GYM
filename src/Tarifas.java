import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formattable;

public class Tarifas {

    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;
    private BaseDatos bd;
    private String duracion;
    private String id_tarifa;
    

    public Tarifas(JFrame frame){
        this.frame = frame;
        this.duracion=duracion;
    	//this.id_tarifa=id;
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
        clientes.setForeground(Color.white);
        clientes.setBorderPainted(false);
        arriba.add(clientes);

        JLabel separador2 = new JLabel("/");
        separador2.setLocation(207, 67);
        separador2.setSize(10, 10);
        separador2.setFont(new Font("", Font.BOLD, 15));
        separador2.setForeground(Color.white);
        arriba.add(separador2);
        
        JButton datos = new JButton("Datos Clientes");
        datos.setSize(140, 23);
        datos.setBackground(new Color(61,61,61));
        datos.setLocation(212, 60);
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
        
        ArrayList<String> tarifas = new ArrayList();
        try {
			tarifas=bd.obtenerNombresTarifas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        JComboBox<String> tarifas_comboBox = new JComboBox<>();
        tarifas_comboBox.setSize(250, 30);
        tarifas_comboBox.setLocation(85, 20);
        tarifas_comboBox.setOpaque(true);
        tarifas_comboBox.setBackground(Color.white);
        tarifas_comboBox.setForeground(Color.black);
        tarifas_comboBox.setFocusable(false);
        if (!tarifas.isEmpty()) {
            for (int i=0;i<tarifas.size();i++) {
            	tarifas_comboBox.addItem(tarifas.get(i));
            }
        }else {
        	tarifas_comboBox.addItem("-1 <No hay tarifas registradas>");
        }
        panel.add(tarifas_comboBox);
        
        JButton botonEditarC = new JButton("Editar Cliente");
        botonEditarC.setSize(160, 40);
        botonEditarC.setLocation(420, 60);
        botonEditarC.setBackground(Color.decode("#55A763"));
        panel.add(botonEditarC);

        JButton botonEliminarC = new JButton("Eliminar Cliente");
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
			tabla = new JTable(bd.buscarTarifa());
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(20, 40, 330, 200);
			panel2.add(scroll);
		} catch (SQLException e) {
			System.err.println("Error al mostrar la tabla: "+e);
		}
		
        RoundedPanel up = new RoundedPanel(15);
        up.setSize(370, 30);
        up.setLayout(null);
        up.setBackground(Color.yellow);
        panel2.add(up);

        JLabel historialC = new JLabel("Historial del cliente");
        historialC.setFont(new Font("",Font.BOLD,20));
        historialC.setSize(200, 30);
        historialC.setLocation(95, 0);
        up.add(historialC);


        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarMenu();

                frame.repaint();
                frame.revalidate();
            }
        });

        clientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarPanelCliente();

                frame.repaint();
                frame.revalidate();
            }
        });

        botonEliminarC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostarEliminarCliente();
                
                frame.repaint();
                frame.revalidate();
            }
        });

        botonEditarC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                EditarCliente();
                
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

    //Cliente
    public void mostrarPanelCliente(){
        Clientes clientes = new Clientes(frame); 
        clientes.mostrar();
        frame.repaint();
        frame.revalidate();
    }

    //ELIMINAR CLIENTE
    public void mostarEliminarCliente(){// AGREGAR PARAMETROS LUEGO
        EliminarCliente eliminarCliente = new EliminarCliente(frame,duracion,id_tarifa);
        eliminarCliente.mostrar();
    }

    //Editar cliente
    public void EditarCliente(){// AGREGAR PARAMETROS LUEGO
        EditarCliente editCliente = new EditarCliente(frame,duracion,id_tarifa);
        editCliente.mostrar();
    }
}