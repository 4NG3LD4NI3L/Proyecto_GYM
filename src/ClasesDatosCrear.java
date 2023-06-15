import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClasesDatosCrear extends JPanel {
	
	private JFrame frame;
	private Clases clase;
	private BaseDatos bd;
	
	public ClasesDatosCrear(JFrame ventana) {
		this.frame=ventana;
		try {
			bd = new BaseDatos();
		} catch (SQLException e) {
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
        
        JButton datos = new JButton("Crear Una Clase");
        datos.setSize(150, 23);
        datos.setBackground(new Color(61,61,61));
        datos.setLocation(175, 60);
        datos.setForeground(Color.yellow);
        datos.setBorderPainted(false);
        arriba.add(datos);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(593, 323);
        panel.setLocation(49, 127);
        panel.setBackground(new Color(0,0,0,100));
        this.add(panel);
        
        JLabel etiqueNuevaClase = new JLabel("Nombre de la nueva clase");
        etiqueNuevaClase.setSize(200, 16);
        etiqueNuevaClase.setLocation(15, 15);
        etiqueNuevaClase.setFont(new Font("Arial",Font.BOLD,16));
        etiqueNuevaClase.setForeground(Color.white);
        panel.add(etiqueNuevaClase);
        
        JTextField ingreNuevaClase = new JTextField();
        ingreNuevaClase.setSize(250, 25);
        ingreNuevaClase.setLocation(15, 35);
        ingreNuevaClase.setFont(new Font("Arial",Font.PLAIN,17));
        ingreNuevaClase.setBorder(null);
        panel.add(ingreNuevaClase);
        
        JLabel etiqueInstructor = new JLabel("Instructor");
        etiqueInstructor.setSize(200, 16);
        etiqueInstructor.setLocation(15, 72);
        etiqueInstructor.setFont(new Font("Arial",Font.BOLD,16));
        etiqueInstructor.setForeground(Color.white);
        panel.add(etiqueInstructor);
        
        
        
        JComboBox<String> instructoresDisponible_comboBox = new JComboBox<>();
        instructoresDisponible_comboBox.setSize(250, 30);
        instructoresDisponible_comboBox.setLocation(15, 90);
        instructoresDisponible_comboBox.setOpaque(true);
        instructoresDisponible_comboBox.setFocusable(false);
        try {
        	ArrayList<String> nombres = bd.obtenerInstructor();
        	
        	if (!nombres.isEmpty()) {
        		for (int i=0;i<nombres.size();i++) {
        			instructoresDisponible_comboBox.addItem(nombres.get(i));
        		}
        	}else {
        		instructoresDisponible_comboBox.addItem("No hay instructores en la base de datos");
        	}
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        	
        panel.add(instructoresDisponible_comboBox);
        
        JLabel etiqueHorario = new JLabel("Horario");
        etiqueHorario.setSize(200, 16);
        etiqueHorario.setLocation(16, 127);
        etiqueHorario.setFont(new Font("Arial",Font.BOLD,16));
        etiqueHorario.setForeground(Color.white);
        panel.add(etiqueHorario);
        
        JComboBox<String> horarios_comboBox = new JComboBox<>();
        horarios_comboBox.setSize(250, 30);
        horarios_comboBox.setLocation(15, 144);
        horarios_comboBox.setOpaque(true);
        horarios_comboBox.setFocusable(false);
        for (int i=5;i<=20;i++) {
        	horarios_comboBox.addItem(Integer.toString(i));
        }
        panel.add(horarios_comboBox);
        
        JComboBox<String> horarios_2_comboBox = new JComboBox<>();
        horarios_2_comboBox.setSize(250, 30);
        horarios_2_comboBox.setLocation(15, 174);
        horarios_2_comboBox.setOpaque(true);
        horarios_2_comboBox.setFocusable(false);
        for (int i=6;i<=20;i++) {
        	horarios_2_comboBox.addItem(Integer.toString(i));
        }
        panel.add(horarios_2_comboBox);
        
        JLabel etiqueDias = new JLabel("Días de clase");
        etiqueDias.setSize(200, 16);
        etiqueDias.setLocation(316, 13);
        etiqueDias.setFont(new Font("Arial",Font.BOLD,16));
        etiqueDias.setForeground(Color.white);
        panel.add(etiqueDias);
        
        JCheckBox checkLunes = new JCheckBox("Lunes");
        checkLunes.setSize(250, 25);
        checkLunes.setLocation(316, 30);
        checkLunes.setOpaque(true);
        panel.add(checkLunes);
        
        JCheckBox checkMartes = new JCheckBox("Martes");
        checkMartes.setSize(250, 25);
        checkMartes.setLocation(316, 55);
        checkMartes.setOpaque(true);
        panel.add(checkMartes);
        
        JCheckBox checkMiercoles = new JCheckBox("Miercoles");
        checkMiercoles.setSize(250, 25);
        checkMiercoles.setLocation(316, 80);
        checkMiercoles.setOpaque(true);
        panel.add(checkMiercoles);
        
        JCheckBox checkJueves = new JCheckBox("Jueves");
        checkJueves.setSize(250, 25);
        checkJueves.setLocation(316, 105);
        checkJueves.setOpaque(true);
        panel.add(checkJueves);
        
        JCheckBox checkViernes = new JCheckBox("Viernes");
        checkViernes.setSize(250, 25);
        checkViernes.setLocation(316, 130);
        checkViernes.setOpaque(true);
        panel.add(checkViernes);
        
        JCheckBox checkSabado = new JCheckBox("Sábado");
        checkSabado.setSize(250, 25);
        checkSabado.setLocation(316, 155);
        checkSabado.setOpaque(true);
        panel.add(checkSabado);
        
        JCheckBox checkDomingo = new JCheckBox("Domingo");
        checkDomingo.setSize(250, 25);
        checkDomingo.setLocation(316, 180);
        checkDomingo.setOpaque(true);
        panel.add(checkDomingo);
        
        JButton regresar = new JButton("Regresar");
        regresar.setBackground(Color.decode("#ff4343"));
        regresar.setFocusPainted(false);
        regresar.setFont(new Font("Arial",Font.BOLD,12));
        regresar.setSize(123, 34);
        regresar.setLocation(169, 250);
        regresar.setPreferredSize(new Dimension(87,34));
        panel.add(regresar);

        JButton nuevoClase = new JButton("Crear");
        nuevoClase.setBackground(Color.decode("#01ff57"));
        nuevoClase.setSize(123, 34);
        nuevoClase.setLocation(300, 250);
        nuevoClase.setPreferredSize(new Dimension(123,34));
        nuevoClase.setFocusPainted(false);
        panel.add(nuevoClase);

        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
               cerrarEstaVentana();

                mostrarMenu();

                
                frame.repaint();
                frame.revalidate();
            }
        });

        clases.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
               cerrarEstaVentana();

               mostrarPanelClases();

                
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
        
        nuevoClase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (ingreNuevaClase.getText().length()>0 && bd.existeNombreClase(ingreNuevaClase.getText())) {
					if (bd.instructorDesocupado(instructoresDisponible_comboBox.getSelectedItem().toString())) {
						if (Integer.parseInt(horarios_comboBox.getSelectedItem().toString())<Integer.parseInt(horarios_2_comboBox.getSelectedItem().toString())) {
							if (checkLunes.isSelected() ||
								checkMartes.isSelected() ||
								checkMiercoles.isSelected() ||
								checkJueves.isSelected() ||
								checkViernes.isSelected() ||
								checkSabado.isSelected() ||
								checkDomingo.isSelected()) {
								
								String dias = "";
								if (checkLunes.isSelected()) {
									dias+=checkLunes.getText()+",";
								}
								if (checkMartes.isSelected()) {
									dias+=checkMartes.getText()+",";
								}
								if (checkMiercoles.isSelected()) {
									dias+=checkMiercoles.getText()+",";
								}
								if (checkJueves.isSelected()) {
									dias+=checkJueves.getText()+",";
								}
								if (checkViernes.isSelected()) {
									dias+=checkViernes.getText()+",";
								}
								if (checkSabado.isSelected()) {
									dias+=checkSabado.getText()+",";
								}
								if (checkDomingo.isSelected()) {
									dias+=checkDomingo.getText();
								}
								
								try {
									bd.crearNuevaClase(ingreNuevaClase.getText(), instructoresDisponible_comboBox.getSelectedItem().toString(), horarios_comboBox.getSelectedItem().toString(), horarios_2_comboBox.getSelectedItem().toString(), dias);
									JOptionPane.showMessageDialog(null,"Se creo la clase con exito","Proceso completado",JOptionPane.INFORMATION_MESSAGE);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								clase = new Clases(frame);
								cerrarEstaVentana();
								frame.add(clase);
								
								frame.requestFocus();
								frame.repaint();
								frame.revalidate();
								
							}else {
								JOptionPane.showMessageDialog(null,"Debes seleccionar al menos un dia de la semana","Proceso no completado",JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null,"El horario no esta bien seleccionado","Proceso no completado",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null,"El instructor seleccionado ya esta asignado a otra clase","Proceso no completado",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"El nombre de la nueva clase no fue llenado o el nombre ingresado ya existe","Proceso no completado",JOptionPane.ERROR_MESSAGE);
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