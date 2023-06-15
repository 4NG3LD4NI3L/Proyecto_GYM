import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NuevoInstructor {

	private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;
    private BaseDatos bd;
    
	public NuevoInstructor(JFrame frame){
        this.frame = frame;
        try {
        	bd = new BaseDatos();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BASE DE DATOS NO FUNCIONA");
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

        JButton instr = new JButton("Instructores");
        instr.setSize(130, 23);
        instr.setLocation(110, 60);
        instr.setBackground(new Color(61,61,61));
        instr.setFont(new Font("", Font.BOLD, 15));
        instr.setForeground(Color.white);
        instr.setBorderPainted(false);
        arriba.add(instr);

        JLabel separador2 = new JLabel("/");
        separador2.setLocation(245, 67);
        separador2.setSize(10, 10);
        separador2.setFont(new Font("", Font.BOLD, 15));
        separador2.setForeground(Color.white);
        arriba.add(separador2);
        
        JButton datos = new JButton("Nuevo Instructor");
        datos.setSize(190, 23);
        datos.setLocation(250, 60);
        datos.setBackground(new Color(61,61,61));
        datos.setFont(new Font("", Font.BOLD, 15));
        datos.setForeground(Color.yellow);
        datos.setBorderPainted(false);
        arriba.add(datos);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(614, 340);
        panel.setLocation(35, 113);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);

        ///////////////////
        //////////////////

        JLabel nombrenuevo = new JLabel("Nombre");
        nombrenuevo.setSize(79, 9);
        nombrenuevo.setLocation(30, 16);
        nombrenuevo.setForeground(Color.black);
        panel.add(nombrenuevo);
        
        JTextField nombreN = new JTextField();
        nombreN.setSize(300, 27);
        nombreN.setLocation(30, 30);
        nombreN.setBorder(null);
        nombreN.setForeground(Color.black);
        panel.add(nombreN);
        
        JLabel apellidoNuevo = new JLabel("Apellido");
        apellidoNuevo.setSize(83, 22);
        apellidoNuevo.setLocation(30, 55);
        apellidoNuevo.setForeground(Color.black);
        panel.add(apellidoNuevo);

        JTextField Apellido = new JTextField();
        Apellido.setSize(300, 27);
        Apellido.setLocation(30, 75);
        Apellido.setBorder(null);
        panel.add(Apellido);
        
        JLabel edadNuevo = new JLabel("Edad");
        edadNuevo.setSize(83, 22);
        edadNuevo.setLocation(30, 100);
        edadNuevo.setForeground(Color.black);
        panel.add(edadNuevo);

        JTextField edad = new JTextField();
        edad.setSize(300, 27);
        edad.setLocation(30, 120);
        edad.setBorder(null);
        panel.add(edad);
        
        JLabel correoNuevo = new JLabel("Correo");
        correoNuevo.setSize(83, 22);
        correoNuevo.setLocation(30, 145);
        correoNuevo.setForeground(Color.black);
        panel.add(correoNuevo);
        
        JTextField CorreoN = new JTextField();
        CorreoN.setSize(300, 27);
        CorreoN.setLocation(30, 165);
        CorreoN.setBorder(null);
        panel.add(CorreoN);

        JLabel telefonoNuevo = new JLabel("Telefono");
        telefonoNuevo.setSize(83, 22);
        telefonoNuevo.setLocation(30, 190);
        telefonoNuevo.setForeground(Color.black);
        panel.add(telefonoNuevo);

        JTextField telefonoN = new JTextField();
        telefonoN.setSize(300, 27);
        telefonoN.setLocation(30, 210);
        telefonoN.setBorder(null);
        panel.add(telefonoN);

        JLabel telefonoNuevoEme = new JLabel("Telefono en caso de emergencia");
        telefonoNuevoEme.setSize(260, 22);
        telefonoNuevoEme.setLocation(30, 235);
        telefonoNuevoEme.setForeground(Color.black);
        panel.add(telefonoNuevoEme);

        JTextField telefonoNewEme = new JTextField();
        telefonoNewEme.setSize(300, 27);
        telefonoNewEme.setLocation(30, 255);
        telefonoNewEme.setBorder(null);
        panel.add(telefonoNewEme);
        
        JLabel sueldoInstructor = new JLabel("Sueldo del instructor");
        sueldoInstructor.setSize(260, 22);
        sueldoInstructor.setLocation(30, 280);//25
        sueldoInstructor.setForeground(Color.black);
        panel.add(sueldoInstructor);

        JTextField sueldoInstructorT = new JTextField();
        sueldoInstructorT.setSize(300, 27);
        sueldoInstructorT.setLocation(30, 300);
        sueldoInstructorT.setBorder(null);
        panel.add(sueldoInstructorT);

        ///////////////////
        //////////////////

        JButton confirmarN = new JButton("Confirmar");
        confirmarN.setSize(127, 37);
        confirmarN.setLocation(440, 213);
        confirmarN.setBackground(Color.decode("#292929"));
        confirmarN.setForeground(Color.decode("#14fc0e"));
        confirmarN.setBorderPainted(false);
        panel.add(confirmarN);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(127, 37);
        cancelar.setLocation(440, 260);
        cancelar.setBackground(Color.decode("#292929"));
        cancelar.setForeground(Color.decode("#ff0000"));
        cancelar.setBorderPainted(false);
        panel.add(cancelar);

        JButton ingresarFoto = new JButton("Ingresa una foto");
        ingresarFoto.setSize(126, 16);
        ingresarFoto.setLocation(440, 180);
        ingresarFoto.setBackground(Color.decode("#797979"));
        ingresarFoto.setForeground(Color.black);
        ingresarFoto.setBorderPainted(false);
        panel.add(ingresarFoto);
        
        JLabel fotoN = new JLabel(new ImageIcon("Resources/Fondopantallas.png"));
        fotoN.setSize(124, 135);
        fotoN.setLocation(440, 40);//25
        fotoN.setForeground(Color.black);
        fotoN.setBackground(Color.white);
        panel.add(fotoN);

        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarMenu();

                frame.repaint();
                frame.revalidate();
            }
        });

        instr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarPanelInstructor();

                frame.repaint();
                frame.revalidate();
            }
        });

        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarPanelInstructor();

                frame.repaint();
                frame.revalidate();
            }
        });
        
confirmarN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (nombreN.getText().length()>0 && Apellido.getText().length()>0 &&
					edad.getText().length()>0    && CorreoN.getText().length()>0 &&
				telefonoN.getText().length()>=10 && telefonoNewEme.getText().length()>=10) {
					
					if (nombreN.getText().matches("[a-zA-Z ]+") && Apellido.getText().matches("[a-zA-Z ]+") && CorreoN.getText().matches("^[a-zA-Z0-9._%+-]+@(gmail\\.com|hotmail\\.com)$")) {
						
						if (edad.getText().matches("[0-9]+") && telefonoN.getText().matches("[0-9]+") && telefonoNewEme.getText().matches("[0-9]+")) {
							
							if(sueldoInstructorT.getText().matches("[0-9]+")) {
								
								try {
									bd.crearNuevoInstructor(nombreN.getText(), Apellido.getText(), CorreoN.getText(), telefonoN.getText(), telefonoNewEme.getText(),Integer.parseInt(sueldoInstructorT.getText()), "07-06-2023", 0, Integer.parseInt(edad.getText()),fotoN.getText());
								} catch (NumberFormatException e1) {
									e1.printStackTrace();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null,"Instructor inscrito correctamente","Proceso finalizado",JOptionPane.INFORMATION_MESSAGE);
								
								frame.remove(fondo);
								
								mostrarPanelInstructor();
								
								frame.repaint();
								frame.revalidate();
							}else
								JOptionPane.showMessageDialog(null,"Caracteres no permitidos en el sueldo del instructor","Error al crear cliente",JOptionPane.WARNING_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"Solo puedes ingresar numeros en: Edad, Telefono y Telefono de emergencia","Error al crear cliente",JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null,"Solo puedes ingresar letras en: Nombre y Apellidos","Error al crear cliente",JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Todos los elementos deben ser llenados\n[nota: lo numeros telefonicos deben tener mas de 10 digitos]","Error al crear cliente",JOptionPane.WARNING_MESSAGE);
				}
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

    //Instructor
    public void mostrarPanelInstructor(){
    	Instructor instructor = new Instructor(frame);
    	instructor.mostrar();
        frame.repaint();
        frame.revalidate();
    }
    

}