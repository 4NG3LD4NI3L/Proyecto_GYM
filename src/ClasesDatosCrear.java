import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClasesDatosCrear extends JPanel {
	
	private JFrame frame;
	private Clases clase;
	
	public ClasesDatosCrear(JFrame ventana) {
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
        ingreNuevaClase.setForeground(Color.white);
        ingreNuevaClase.setBackground(new Color(0,0,0));
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
        instructoresDisponible_comboBox.setBackground(new Color(0,0,0));
        instructoresDisponible_comboBox.setForeground(Color.white);
        instructoresDisponible_comboBox.setFocusable(false);
        instructoresDisponible_comboBox.addItem("Seleccionar un Instructor");
        instructoresDisponible_comboBox.addItem("Yahir Hernandez");
        instructoresDisponible_comboBox.addItem("Alberto Cota");
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
        horarios_comboBox.setBackground(new Color(0,0,0));
        horarios_comboBox.setForeground(Color.white);
        horarios_comboBox.setFocusable(false);
        horarios_comboBox.addItem("Seleccionar un horario");
        horarios_comboBox.addItem("9:00 AM");
        horarios_comboBox.addItem("10:00 AM");
        horarios_comboBox.addItem("11:00 AM");
        panel.add(horarios_comboBox);
        
        JComboBox<String> horarios_2_comboBox = new JComboBox<>();
        horarios_2_comboBox.setSize(250, 30);
        horarios_2_comboBox.setLocation(15, 174);
        horarios_2_comboBox.setOpaque(true);
        horarios_2_comboBox.setBackground(new Color(0,0,0));
        horarios_2_comboBox.setForeground(Color.white);
        horarios_2_comboBox.setFocusable(false);
        horarios_2_comboBox.addItem("Seleccionar un horario");
        horarios_2_comboBox.addItem("9:00 PM");
        horarios_2_comboBox.addItem("10:00 PM");
        horarios_2_comboBox.addItem("11:00 PM");
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
        checkLunes.setBackground(Color.black);
        checkLunes.setForeground(Color.white);
        panel.add(checkLunes);
        
        JCheckBox checkMartes = new JCheckBox("Martes");
        checkMartes.setSize(250, 25);
        checkMartes.setLocation(316, 55);
        checkMartes.setOpaque(true);
        checkMartes.setBackground(Color.black);
        checkMartes.setForeground(Color.white);
        panel.add(checkMartes);
        
        JCheckBox checkMiercoles = new JCheckBox("Miercoles");
        checkMiercoles.setSize(250, 25);
        checkMiercoles.setLocation(316, 80);
        checkMiercoles.setOpaque(true);
        checkMiercoles.setBackground(Color.black);
        checkMiercoles.setForeground(Color.white);
        panel.add(checkMiercoles);
        
        JCheckBox checkJueves = new JCheckBox("Jueves");
        checkJueves.setSize(250, 25);
        checkJueves.setLocation(316, 105);
        checkJueves.setOpaque(true);
        checkJueves.setBackground(Color.black);
        checkJueves.setForeground(Color.white);
        panel.add(checkJueves);
        
        JCheckBox checkViernes = new JCheckBox("Viernes");
        checkViernes.setSize(250, 25);
        checkViernes.setLocation(316, 130);
        checkViernes.setOpaque(true);
        checkViernes.setBackground(Color.black);
        checkViernes.setForeground(Color.white);
        panel.add(checkViernes);
        
        JCheckBox checkSabado = new JCheckBox("Sábado");
        checkSabado.setSize(250, 25);
        checkSabado.setLocation(316, 155);
        checkSabado.setOpaque(true);
        checkSabado.setBackground(Color.black);
        checkSabado.setForeground(Color.white);
        panel.add(checkSabado);
        
        JCheckBox checkDomingo = new JCheckBox("Domingo");
        checkDomingo.setSize(250, 25);
        checkDomingo.setLocation(316, 180);
        checkDomingo.setOpaque(true);
        checkDomingo.setBackground(Color.black);
        checkDomingo.setForeground(Color.white);
        panel.add(checkDomingo);
        
        JButton regresar = new JButton("Regresar");
        ShapedButtonUI roundUI_3 = new ShapedButtonUI();
        roundUI_3.setShape(ButtonShape.ROUND, regresar,Color.decode("#ff4343"));
        regresar.setUI(roundUI_3);
        regresar.setFocusPainted(false);
        regresar.setFont(new Font("Arial",Font.BOLD,12));
        regresar.setSize(123, 34);
        regresar.setLocation(169, 250);
        regresar.setPreferredSize(new Dimension(87,34));
        panel.add(regresar);

        JButton nuevoCliente = new JButton("Crear");
        ShapedButtonUI roundUI_2 = new ShapedButtonUI();
        roundUI_2.setShape(ButtonShape.ROUND, nuevoCliente,Color.decode("#01ff57"));
        nuevoCliente.setSize(123, 34);
        nuevoCliente.setLocation(300, 250);
        nuevoCliente.setUI(roundUI_2);
        nuevoCliente.setPreferredSize(new Dimension(123,34));
        nuevoCliente.setFocusPainted(false);
        panel.add(nuevoCliente);

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
        
        nuevoCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
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