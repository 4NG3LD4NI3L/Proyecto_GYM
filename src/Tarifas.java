
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


        JButton datos = new JButton("Tarifas");
        datos.setSize(100, 23);
        datos.setBackground(new Color(61,61,61));
        datos.setLocation(105, 60);
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
        
        JButton botonCrearT = new JButton("Crear Tarifa");
        botonCrearT.setSize(165, 40);
        botonCrearT.setLocation(420, 100);
        botonCrearT.setBackground(Color.decode("#55A763"));
        panel.add(botonCrearT);
        
        JButton botonEditarT = new JButton("Editar Tarifa");
        botonEditarT.setSize(165, 40);
        botonEditarT.setLocation(420,170);
        botonEditarT.setBackground(Color.decode("#55A763"));
        panel.add(botonEditarT);

        JButton botonEliminarT = new JButton("Eliminar Tarifa");
        botonEliminarT.setSize(165, 40);
        botonEliminarT.setLocation(420, 240);
        botonEliminarT.setBackground(Color.decode("#FF4343"));
        panel.add(botonEliminarT);
        
        
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
		
        JPanel up = new JPanel();
        up.setSize(370, 30);
        up.setLayout(null);
        up.setBackground(Color.yellow);
        panel2.add(up);

        JLabel historialC = new JLabel("Lista de tarifas");
        historialC.setFont(new Font("",Font.BOLD,20));
        historialC.setSize(200, 30);
        historialC.setLocation(115, 0);
        up.add(historialC);


        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarMenu();

                frame.repaint();
                frame.revalidate();
            }
        });
        
        botonCrearT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	frame.remove(fondo);

            	mostrarPanelCrearTarifas();
                
                frame.repaint();
                frame.revalidate();
            }
        });


        botonEliminarT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	String opcionSeleccionada = (String) tarifas_comboBox.getSelectedItem();
                String[] datos = opcionSeleccionada.split(" ");
                bd.eliminarTarifa(Integer.parseInt(datos[1]));
                frame.remove(fondo);
                mostrarPanelTarifas();
                JOptionPane.showMessageDialog(null,"Tarifa eliminada correctamente","Operación exitosa",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        botonEditarT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);
                
                String opcionSeleccionada = (String) tarifas_comboBox.getSelectedItem();
                String[] datos = opcionSeleccionada.split(" ");
                
                editarTarifa(datos[1]);
                
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

    //MENU
    public void mostrarMenu(){
        Menu menu = new Menu(frame);
        menu.mostrar();
        frame.repaint();
        frame.revalidate();
    }
    
    public void mostrarPanelTarifas(){
        Tarifas tarifa = new Tarifas(frame);
         tarifa.mostrar();
         frame.repaint();
         frame.revalidate();
     }

    //TARIFA
    public void mostrarPanelCrearTarifas(){
        CrearTarifa cTarifas = new CrearTarifa(frame); 
        cTarifas.mostrar();
        frame.repaint();
        frame.revalidate();
    }

    //ELIMINAR TARIFA
    public void mostarEliminarTarifa(){// AGREGAR PARAMETROS LUEGO
        EliminarTarifa eliminarTarifa = new EliminarTarifa(frame);
        eliminarTarifa.mostrar();
    }

    //EDITAR TARIFA
    public void editarTarifa(String id){// AGREGAR PARAMETROS LUEGO
        EditarTarifa editarTarifa = new EditarTarifa(frame, id);
        editarTarifa.mostrar();
    }
 }