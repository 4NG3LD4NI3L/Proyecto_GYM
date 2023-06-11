import java.awt.Color;
import java.awt.Font;
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

public class EditarInstructor {
	private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;
    
    private String nombre_instructor;
    private String id_instructor;
    private BaseDatos bd;


	public EditarInstructor(JFrame frame, String nombre, String id){
		 this.frame = frame;
	        this.nombre_instructor=nombre;
	    	this.id_instructor=id;
	    	
	    	try {
				bd = new BaseDatos();
			} catch (SQLException e) {
				System.err.println("BaseDatos fallo en la clase EditarCliente, ERROR: "+e.getMessage());
			}
	    	String[] datosInstructor = bd.obtenerTodoDelinstructor(Integer.parseInt(id_instructor));
	    	
        
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

        menu.setLocation(0, 60);

        menu.setFont(new Font("", Font.BOLD, 15));
        menu.setForeground(Color.white);
        menu.setBorderPainted(false);
        arriba.add(menu);

        JLabel separador = new JLabel("/");

        separador.setLocation(100, 67);

        separador.setLocation(80, 67);

        separador.setFont(new Font("", Font.BOLD, 15));
        separador.setSize(10, 10);
        separador.setForeground(Color.white);
        arriba.add(separador);

        JButton instr = new JButton("Instructor");

        instr.setSize(103, 23);
        instr.setBackground(new Color(61,61,61));
        instr.setLocation(105, 60);

        instr.setSize(120, 23);
        instr.setBackground(new Color(61,61,61));
        instr.setLocation(85, 60);

        instr.setFont(new Font("", Font.BOLD, 15));
        instr.setForeground(Color.white);
        instr.setBorderPainted(false);
        arriba.add(instr);

        JLabel separador2 = new JLabel("/");
        separador2.setLocation(205, 67);
        separador2.setSize(10, 10);
        separador2.setFont(new Font("", Font.BOLD, 15));
        separador2.setForeground(Color.white);
        arriba.add(separador2);
        
        JButton datos = new JButton("Datos Instructor");
        datos.setSize(150, 23);
        datos.setBackground(new Color(61,61,61));

        datos.setLocation(212, 60);

        datos.setLocation(210, 60);

        datos.setFont(new Font("", Font.BOLD, 15));
        datos.setForeground(Color.white);
        datos.setBorderPainted(false);
        arriba.add(datos);

        JLabel separador3 = new JLabel("/");
        separador3.setLocation(364, 67);
        separador3.setLocation(360, 67);
        separador3.setSize(10, 10);
        separador3.setForeground(Color.white);
        separador3.setFont(new Font("", Font.BOLD, 15));
        arriba.add(separador3);

        JButton crd = new JButton("Editar Instructor");
        crd.setSize(180, 23);
        crd.setBackground(new Color(61,61,61));
        crd.setLocation(370, 60);
        crd.setLocation(365, 60);
        crd.setForeground(Color.yellow);
        crd.setBorderPainted(false);
        crd.setFont(new Font("", Font.BOLD, 15));
        arriba.add(crd);
        
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
        nombrenuevo.setLocation(30, 33);
        nombrenuevo.setForeground(Color.black);
        panel.add(nombrenuevo);
        
        JTextField nombreN = new JTextField(datosInstructor[0]);
        nombreN.setSize(300, 27);
        nombreN.setLocation(30, 45);
        nombreN.setBorder(null);
        nombreN.setForeground(Color.black);
        panel.add(nombreN);
        
        JLabel apellidoNuevo = new JLabel("Apellido");
        apellidoNuevo.setSize(83, 22);
        apellidoNuevo.setLocation(30, 70);
        apellidoNuevo.setForeground(Color.black);
        panel.add(apellidoNuevo);

        JTextField Apellido = new JTextField(datosInstructor[1]);
        Apellido.setSize(300, 27);
        Apellido.setLocation(30, 90);
        Apellido.setBorder(null);
        panel.add(Apellido);
        
        JLabel edadNuevo = new JLabel("Edad");
        edadNuevo.setSize(83, 22);
        edadNuevo.setLocation(30, 115);
        edadNuevo.setForeground(Color.black);
        panel.add(edadNuevo);

        JTextField edad = new JTextField(datosInstructor[2]);
        edad.setSize(300, 27);
        edad.setLocation(30, 135);
        edad.setBorder(null);
        panel.add(edad);
        
        JLabel correoNuevo = new JLabel("Correo");
        correoNuevo.setSize(83, 22);
        correoNuevo.setLocation(30, 160);
        correoNuevo.setForeground(Color.black);
        panel.add(correoNuevo);
        
        JTextField CorreoN = new JTextField(datosInstructor[3]);
        CorreoN.setSize(300, 27);
        CorreoN.setLocation(30, 180);
        CorreoN.setBorder(null);
        panel.add(CorreoN);

        JLabel telefonoNuevo = new JLabel("Telefono");
        telefonoNuevo.setSize(83, 22);
        telefonoNuevo.setLocation(30, 205);//25
        telefonoNuevo.setForeground(Color.black);
        panel.add(telefonoNuevo);

        JTextField telefonoN = new JTextField(datosInstructor[4]);
        telefonoN.setSize(300, 27);
        telefonoN.setLocation(30, 225);
        telefonoN.setBorder(null);
        panel.add(telefonoN);

        JLabel telefonoNuevoEme = new JLabel("Telefono en caso de emergencia");
        telefonoNuevoEme.setSize(260, 22);
        telefonoNuevoEme.setLocation(30, 250);//25
        telefonoNuevoEme.setForeground(Color.black);
        panel.add(telefonoNuevoEme);

        JTextField telefonoNewEme = new JTextField(datosInstructor[5]);
        telefonoNewEme.setSize(300, 27);
        telefonoNewEme.setLocation(30, 270);
        telefonoNewEme.setBorder(null);
        panel.add(telefonoNewEme);

        ///////////////////
        //////////////////

        JButton confirmarN = new JButton("Confirmar");
        confirmarN.setSize(127, 37);
        confirmarN.setLocation(440, 233);
        confirmarN.setBackground(Color.decode("#292929"));
        confirmarN.setForeground(Color.decode("#14fc0e"));
        confirmarN.setBorderPainted(false);
        panel.add(confirmarN);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(127, 37);
        cancelar.setLocation(440, 280);
        cancelar.setBackground(Color.decode("#292929"));
        cancelar.setForeground(Color.decode("#ff0000"));
        cancelar.setBorderPainted(false);
        panel.add(cancelar);

        
        JButton ingresarFoto = new JButton("Cambiar la foto");
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

        datos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarConsultarInstructor();

                frame.repaint();
                frame.revalidate();
            }
        });

        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarConsultarInstructor();

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
					
					if (nombreN.getText().matches("[a-zA-Z ]+") && Apellido.getText().matches("[a-zA-Z ]+")) {
						
						if (edad.getText().matches("[0-9]+") && telefonoN.getText().matches("[0-9]+") && telefonoNewEme.getText().matches("[0-9]+") && CorreoN.getText().matches("^[a-zA-Z0-9._%+-]+@(gmail\\.com|hotmail\\.com)$")) {
								try {
									bd.actualizarInstructor(Integer.parseInt(id_instructor), nombreN.getText(), Apellido.getText(),edad.getText(),CorreoN.getText(), telefonoN.getText(), telefonoNewEme.getText(), "Aqui va la foto");
									bd.cerrarCONEXION();
									JOptionPane.showMessageDialog(null,"Los datos se actualizaron correctamete","Completado",JOptionPane.INFORMATION_MESSAGE);
									
									frame.remove(fondo);
									mostrarConsultarInstructor();

					                frame.repaint();
					                frame.revalidate();
								} catch (NumberFormatException e1) {
									e1.printStackTrace();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
						}else {
							JOptionPane.showMessageDialog(null,"Solo puedes ingresar numeros en: Edad, Telefono y Telefono de emergencia","Error al actualizar la informacion",JOptionPane.WARNING_MESSAGE);
						}
						
					}else {
						JOptionPane.showMessageDialog(null,"Solo puedes ingresar letras en: Nombre y Apellidos","Error al actualizar la informacion",JOptionPane.WARNING_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"Todos los elementos deben ser llenados\n[nota: lo numeros telefonicos deben tener mas de 10 digitos]","Error al actualizar la informacion",JOptionPane.WARNING_MESSAGE);
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

    //Consultar
    public void mostrarConsultarInstructor(){
    	ConsultarInstructor consultarInstructor = new ConsultarInstructor(frame,nombre_instructor,id_instructor);
    	consultarInstructor.mostrar();
    }

}
