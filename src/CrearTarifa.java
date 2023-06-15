import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrearTarifa {

	private JFrame frame;
	private JPanel fondo;
	private JPanel panel;
	private JPanel arriba;
	private String duracion;
	private String id;
	private BaseDatos bd;

	public CrearTarifa(JFrame frame) {
		this.frame = frame;
		JLabel fondoI = new JLabel(new ImageIcon("Resources/Fondopantallas.png"));
        fondoI.setSize(691, 487);
        try {
			bd = new BaseDatos();
		} catch (SQLException e) {
			System.err.println("BaseDatos fallo en la clase EditarTarifa, ERROR: "+e.getMessage());
		}
		
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

        JButton tari = new JButton("Tarifas");
        tari.setSize(100, 23);
        tari.setBackground(new Color(61,61,61));
        tari.setLocation(105, 60);
        tari.setFont(new Font("", Font.BOLD, 15));
        tari.setForeground(Color.white);
        tari.setBorderPainted(false);
        arriba.add(tari);

        JLabel separador2 = new JLabel("/");
        separador2.setLocation(207, 67);
        separador2.setSize(10, 10);
        separador2.setFont(new Font("", Font.BOLD, 15));
        separador2.setForeground(Color.white);
        arriba.add(separador2);
        
        JButton datos = new JButton("Crear tarifa");
        datos.setSize(140, 23);
        datos.setBackground(new Color(61,61,61));
        datos.setLocation(212, 60);
        datos.setFont(new Font("", Font.BOLD, 15));
        datos.setForeground(Color.yellow);
        datos.setBorderPainted(false);
        arriba.add(datos);
        
        JLabel logomini = new JLabel(new ImageIcon("Resources/logoMini.png"));
        logomini.setLocation(560, 0);
        logomini.setSize(102, 83);
        arriba.add(logomini);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(400, 220);
        panel.setLocation(145, 200);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);
        
        JLabel duracion = new JLabel("Ingrese la duración");
        duracion.setSize(240, 25);
        duracion.setLocation(75, 10);
        duracion.setFont(new Font("",Font.BOLD,18));
        panel.add(duracion);
        
        JTextField duraciont = new JTextField("");
        duraciont.setSize(250, 25);
        duraciont.setLocation(75, 40);
        duraciont.setBorder(null);
        duraciont.setBackground(Color.LIGHT_GRAY);
        panel.add(duraciont);
        
        JLabel precio = new JLabel("Ingrese el precio");
        precio.setSize(240, 25);
        precio.setLocation(75, 75);
        precio.setFont(new Font("",Font.BOLD,18));
        panel.add(precio);
        
        JTextField preciot = new JTextField("");
        preciot.setSize(250, 25);
        preciot.setLocation(75, 105);
        preciot.setBorder(null);
        preciot.setBackground(Color.LIGHT_GRAY);
        panel.add(preciot);
        
        JButton confirmar = new JButton("Confirmar");
        confirmar.setSize(120, 30);
        confirmar.setLocation(205, 170);
        confirmar.setBackground(new Color(0,0,0));
        confirmar.setOpaque(true);
        confirmar.setForeground(Color.decode("#01ff57"));
        panel.add(confirmar);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(120, 30);
        cancelar.setLocation(75, 170);
        cancelar.setBackground(new Color(0,0,0));
        cancelar.setForeground(Color.decode("#ff4343"));
        panel.add(cancelar);
        
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarMenu();

                frame.repaint();
                frame.revalidate();
            }
        });

        tari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarPanelTarifas();

                frame.repaint();
                frame.revalidate();
            }
        });

        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarPanelTarifas();

                frame.repaint();
                frame.revalidate();
            }
        });
        
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                if(duraciont.getText().length()>0) {
                	if(preciot.getText().length()>0) {
                		if(preciot.getText().matches("[0-9]+")) {
                			if(duraciont.getText().matches("^[a-zA-ZñÑ0-9 ]*$")) {
                				try {
            						bd.crearNuevaTarifa(duraciont.getText(), preciot.getText());
            					} catch (SQLException e1) {
            						e1.printStackTrace();
            					}
                				JOptionPane.showMessageDialog(null,"Tarifa ingresada correctamente","Operación exitosa",JOptionPane.INFORMATION_MESSAGE);
                				frame.remove(fondo);
                                mostrarPanelTarifas();
                                frame.repaint();
                                frame.revalidate();
                        	}
                			else
                				JOptionPane.showMessageDialog(null,"Valores distintos a los permitidos en la duración","ERROR",JOptionPane.ERROR_MESSAGE);
                    	}
                		else
            				JOptionPane.showMessageDialog(null,"Valores distintos a los permitidos en el precio de la tarifa","ERROR",JOptionPane.ERROR_MESSAGE);
                	}
                	else
        				JOptionPane.showMessageDialog(null,"Texto inexistente en el precio de la tarifa","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
    				JOptionPane.showMessageDialog(null,"Texto inexistente en la duración","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        
        frame.repaint();
		frame.revalidate();
		fondo.add(fondoI);
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

    //Tarifas
    public void mostrarPanelTarifas(){
        Tarifas tarifa = new Tarifas(frame);
         tarifa.mostrar();
         frame.repaint();
         frame.revalidate();
     }

}