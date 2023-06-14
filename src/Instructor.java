import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Instructor {

	private JFrame frame;
    private JPanel fondo;
    private JPanel arriba;
    private BaseDatos bd;
    
	public Instructor(JFrame frame) {
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

        JButton clientes = new JButton("Instructor");
        clientes.setSize(110, 23);
        clientes.setBackground(new Color(61,61,61));
        clientes.setLocation(110, 60);
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

        JLabel nombreClase = new JLabel("Instructor:");
        nombreClase.setSize(145, 20);
        nombreClase.setLocation(15, 34);
        nombreClase.setFont(new Font("Arial",Font.BOLD,20));
        nombreClase.setForeground(Color.white);
       panel.add(nombreClase);
        
        ArrayList<String> instructorBD = new ArrayList<>();
        try {
			instructorBD = bd.obtenerNombresinstructor();
		} catch (SQLException e) {
			System.err.println("Error al capturar los instructores: "+e.getMessage());
		}
       
        JComboBox<String> clasesDisponible_comboBox = new JComboBox<>();
        clasesDisponible_comboBox.setSize(250, 30);
        clasesDisponible_comboBox.setLocation(120, 30);
        clasesDisponible_comboBox.setOpaque(true);
        clasesDisponible_comboBox.setBackground(Color.white);
        clasesDisponible_comboBox.setForeground(Color.black);
        clasesDisponible_comboBox.setFocusable(false);
       if (!instructorBD.isEmpty()) {
        	for (int i=0;i<instructorBD.size();i++) {
        		clasesDisponible_comboBox.addItem(instructorBD.get(i));
        	}
        }else {
        	clasesDisponible_comboBox.addItem("-1 <No hay clientes registrados>");
        }
        panel.add(clasesDisponible_comboBox);

        JButton regresar = new JButton("Regresar");
        regresar.setSize(87, 34);
        regresar.setLocation(121, 90);
        regresar.setBackground(Color.decode("#ff4343"));
        regresar.setBorderPainted(false);
       
        regresar.setOpaque(true);
        panel.add(regresar);

        JButton buscar = new JButton("Buscar");
        ShapedButtonUI roundUI = new ShapedButtonUI();//CLASE PARA REDONDEAR BOTONES
        buscar.setSize(87, 34);
        buscar.setLocation(380, 30);
        roundUI.setShape(ButtonShape.ROUND, buscar,new Color(255,144,21));//AQUI SE AGREGA: (LA FORMA DESEADA, EL NOMBRE DEL BOTON, EL COLOR)
        buscar.setUI(roundUI);//
        buscar.setPreferredSize(new Dimension(87,34));//
        panel.add(buscar);

        JButton nuevoCliente = new JButton("Nuevo Instructor");
        nuevoCliente.setSize(150, 34);
        nuevoCliente.setLocation(221, 90);
        nuevoCliente.setBackground(Color.decode("#01ff57"));
        nuevoCliente.setPreferredSize(new Dimension(87,34));
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

                NuevoInstructor();

                frame.repaint();
                frame.revalidate();
            }
        });

        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);
                
                String opcionSeleccionada = (String) clasesDisponible_comboBox.getSelectedItem();
            	String[] datos = opcionSeleccionada.split(" ");

                mostrarConsultarInstructor(datos[1], datos[0]);

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

    //NuevoInstructor
    public void NuevoInstructor(){
        NuevoInstructor newInstructor = new NuevoInstructor(frame);
        newInstructor.mostrar();
        
    }

    //Consultar
    public void mostrarConsultarInstructor(String nombre,String id){
    	ConsultarInstructor consultarInstructor = new ConsultarInstructor(frame,nombre,id);
    	consultarInstructor.mostrar();
    }
}
