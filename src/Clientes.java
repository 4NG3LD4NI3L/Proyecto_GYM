import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
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
        panel.setSize(293, 283);
        panel.setLocation(199, 137);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);

        JTextField nombre = new JTextField();
        nombre.setSize(208, 25);
        nombre.setLocation(241, 190);
        nombre.setBackground(Color.decode("#404040"));
        nombre.setForeground(Color.white);
        nombre.setBorder(null);
        fondo.add(nombre);

        JTextField iD = new JTextField();
        iD.setSize(208, 25);
        iD.setLocation(241, 245);
        iD.setBorder(null);
        iD.setBackground(Color.decode("#404040"));
        iD.setForeground(Color.white);
        fondo.add(iD);

        JLabel nombreCliente = new JLabel("Nombre del cliente");
        nombreCliente.setSize(145, 15);
        nombreCliente.setLocation(42, 36);
        nombreCliente.setForeground(Color.white);
        panel.add(nombreCliente);

        JLabel idCliente = new JLabel("ID cliente");
        idCliente.setSize(145, 15);
        idCliente.setLocation(42, 91);
        idCliente.setForeground(Color.white);
        panel.add(idCliente);

        JButton regresar = new JButton("Regresar");
        regresar.setSize(87, 34);
        regresar.setLocation(42, 151);
        regresar.setBackground(Color.decode("#ff4343"));
        regresar.setBorderPainted(false);
       
        regresar.setOpaque(true);
        panel.add(regresar);

        JButton buscar = new JButton("Buscar");
        ShapedButtonUI roundUI = new ShapedButtonUI();//CLASE PARA REDONDEAR BOTONES
        buscar.setSize(87, 34);
        buscar.setLocation(164, 151);
        roundUI.setShape(ButtonShape.ROUND, buscar,new Color(255,144,21));//AQUI SE AGREGA: (LA FORMA DESEADA, EL NOMBRE DEL BOTON, EL COLOR)
        buscar.setUI(roundUI);//
        buscar.setPreferredSize(new Dimension(87,34));//
        panel.add(buscar);

        JButton nuevoCliente = new JButton("Nuevo Cliente");
        nuevoCliente.setSize(123, 27);
        nuevoCliente.setLocation(85, 214);
        ShapedButtonUI roundUI_dos = new ShapedButtonUI();
        roundUI_dos.setShape(ButtonShape.ROUND, nuevoCliente,Color.decode("#01ff57"));
        nuevoCliente.setUI(roundUI_dos);
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

                NuevoCliente();

                frame.repaint();
                frame.revalidate();
            }
        });

        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	
            	try {
            		
            		if (nombre.getText().length()>0 && iD.getText().length()>0) {
            			if (!verifID(iD.getText())) {
            				if (buscarId(Integer.parseInt(iD.getText()))) {
            					frame.remove(fondo);
            					mostrarConsultaCliente();
            				}else {
            					JOptionPane.showMessageDialog(null,"El nombre del usuario y/o ID son incorrectos o no coinciden","Error al buscar el usuario",JOptionPane.ERROR_MESSAGE);
            				}
            			}else {
            				JOptionPane.showMessageDialog(null,"Solo se pueden ingresar numeros en la casilla ID","Error al buscar el usuario",JOptionPane.INFORMATION_MESSAGE);
            			}
            		}else {
            			JOptionPane.showMessageDialog(null,"Todos los elementos deben ser llenados","Error al buscar el usuario",JOptionPane.ERROR_MESSAGE);            			
            		}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            	
                frame.repaint();
                frame.revalidate();
            }
        });




        
        frame.repaint();
	    frame.revalidate();
        fondo.add(fondo1);
    }
    
    public boolean buscarNombre(String nombre) throws SQLException {
    	bd = new BaseDatos();
    	boolean resultado = false;
    	
    	if (bd.buscarNombreCliente(nombre)) {
    		System.out.println("LO ENCONTRO");
    		resultado=true;
    	}else {
    		System.out.println("no lo encontro");
    	}
    	
    	return resultado;
    }
    
    public boolean buscarId(int id) throws SQLException {
    	bd = new BaseDatos();
    	boolean resultado = false;
    	
    	if (bd.buscarIdCliente(id)) {
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
																		'm','M'));
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
    public void mostrarConsultaCliente(){
        ConsultarCliente consultaCliente = new ConsultarCliente(frame);
        consultaCliente.mostrar();
        frame.repaint();
        frame.revalidate();
    }
}