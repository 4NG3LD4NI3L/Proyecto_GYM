import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class EditarCliente {

    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;
    private String nombre_cliente;
    private String id_cliente;
    private BaseDatos bd;

    public EditarCliente(JFrame frame, String nombre, String id){
        this.frame = frame;
        this.nombre_cliente=nombre;
    	this.id_cliente=id;
    	
    	try {
			bd = new BaseDatos();
		} catch (SQLException e) {
			System.err.println("BaseDatos fallo en la clase EditarCliente, ERROR: "+e.getMessage());
		}
    	String[] datosCli = bd.obtenerTodoDelCliente(Integer.parseInt(id_cliente));
        
    	
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
        datos.setForeground(Color.white);
        datos.setBorderPainted(false);
        arriba.add(datos);

        JLabel separador3 = new JLabel("/");
        separador3.setLocation(354, 67);
        separador3.setSize(10, 10);
        separador3.setForeground(Color.white);
        separador3.setFont(new Font("", Font.BOLD, 15));
        arriba.add(separador3);

        JButton crd = new JButton("Editar Cliente");
        crd.setSize(150, 23);
        crd.setBackground(new Color(61,61,61));
        crd.setLocation(360, 60);
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
        
        JTextField nombreN = new JTextField(datosCli[0]);
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

        JTextField apellido = new JTextField(datosCli[1]);
        apellido.setSize(300, 27);
        apellido.setLocation(30, 90);
        apellido.setBorder(null);
        panel.add(apellido);
        
        JLabel edadNuevo = new JLabel("Edad");
        edadNuevo.setSize(83, 22);
        edadNuevo.setLocation(30, 115);
        edadNuevo.setForeground(Color.black);
        panel.add(edadNuevo);

        JTextField edad = new JTextField(datosCli[7]);
        edad.setSize(300, 27);
        edad.setLocation(30, 135);
        edad.setBorder(null);
        panel.add(edad);
        
        JLabel correoNuevo = new JLabel("Correo");
        correoNuevo.setSize(83, 22);
        correoNuevo.setLocation(30, 160);
        correoNuevo.setForeground(Color.black);
        panel.add(correoNuevo);
        
        JTextField correoN = new JTextField(datosCli[2]);
        correoN.setSize(300, 27);
        correoN.setLocation(30, 180);
        correoN.setBorder(null);
        panel.add(correoN);

        JLabel telefonoNuevo = new JLabel("Telefono");
        telefonoNuevo.setSize(83, 22);
        telefonoNuevo.setLocation(30, 205);//25
        telefonoNuevo.setForeground(Color.black);
        panel.add(telefonoNuevo);

        JTextField telefonoN = new JTextField(datosCli[3]);
        telefonoN.setSize(300, 27);
        telefonoN.setLocation(30, 225);
        telefonoN.setBorder(null);
        panel.add(telefonoN);

        JLabel telefonoNuevoEme = new JLabel("Telefono en caso de emergencia");
        telefonoNuevoEme.setSize(260, 22);
        telefonoNuevoEme.setLocation(30, 250);//25
        telefonoNuevoEme.setForeground(Color.black);
        panel.add(telefonoNuevoEme);

        JTextField telefonoNewEme = new JTextField(datosCli[4]);
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

        clientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarPanelCliente();

                frame.repaint();
                frame.revalidate();
            }
        });

        datos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarConsultaCliente();

                frame.repaint();
                frame.revalidate();
            }
        });

        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarConsultaCliente();

                frame.repaint();
                frame.revalidate();
            }
        });
        
        confirmarN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (nombreN.getText().length()>0 &&
					apellido.getText().length()>0 &&
					edad.getText().length()>0 &&
					correoN.getText().length()>0 &&
					telefonoN.getText().length()>=10 &&
					telefonoNewEme.getText().length()>=10) {
					
					if (verifNombreApellidos(nombreN.getText(), apellido.getText())) {
						
						if (verifEdad_Telefonos(telefonoN.getText(), edad.getText(), telefonoNewEme.getText())) {
							
							if (verifCorreo(correoN.getText())) {
								try {
									bd.actualizarCliente(Integer.parseInt(id_cliente), nombreN.getText(), apellido.getText(), correoN.getText(), telefonoN.getText(), telefonoNewEme.getText(), edad.getText(), "Aqui va la foto");
								} catch (NumberFormatException e1) {
									e1.printStackTrace();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null,"Los datos se actualizaron correctamete","Completado",JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null,"No es un correo valido","Error al actualizar la informacion",JOptionPane.ERROR_MESSAGE);
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
    
    public boolean verifCorreo(String correo) {
		boolean resultado = false;
		
		if (correo.contains("@gmail.com") || correo.contains("@hotmail.com") || correo.contains("outlook.com") || correo.contains("outlook.com.es")) {
			resultado = true;
		}
		
		return resultado;
	}
    
    public boolean verifEdad_Telefonos(String edad,String telefonos,String telefonosEmer) {
		boolean resultado = true;
		Set<Character> caracteresProhibidos = new HashSet<>(Arrays.asList('|','°','¬','!','"','#','$','%','&','/','(',')','=','?','¡','¿','+','*','~','´','¨',
																		'{','}','[',']','^','`','<','>',',',';','.',':','-','_','q','Q','w','W','e','E','r','R'
																		,'t','T','y','Y','u','U','i','I','o','O','p','P','a','A','s','S','d','D','f','F','g','G',
																		'h','H','j','J','k','K','l','L','ñ','Ñ','z','Z','x','X','c','C','v','V','b','B','n','N',
																		'm','M',' '));
		
		int contador=0;
		
		for (int i=0;i<edad.length();i++) {
			char caracterActual = edad.charAt(i);
			if (caracteresProhibidos.contains(caracterActual)) {
				contador++;
			}
		}
		
		for (int i=0;i<telefonos.length();i++) {
			char caracterActual = telefonos.charAt(i);
			if (caracteresProhibidos.contains(caracterActual)) {
				contador++;
			}
		}
		
		for (int i=0;i<telefonosEmer.length();i++) {
			char caracterActual = telefonosEmer.charAt(i);
			if (caracteresProhibidos.contains(caracterActual)) {
				contador++;
			}
		}
		
		if (contador>0) {
			resultado=false;
		}
		
		return resultado;
	}
    
    public boolean verifNombreApellidos(String nombre,String ApellidoPat) {
		boolean resultado = true;
		Set<Character> caracteresProhibidos = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9','|','°','¬','!','"','#','$','%','&','/',
																		'(',')','=','?','¡','¿','+','*','~','´','¨','{','}','[',']','^','`','<','>',',',';',
																		'.',':','-','_','@'));
		int contador=0;
		
		for (int i=0;i<nombre.length();i++) {
			char caracterActual = nombre.charAt(i);
			if (caracteresProhibidos.contains(caracterActual)) {
				contador++;
			}
		}
		
		for (int i=0;i<ApellidoPat.length();i++) {
			char caracterActual = ApellidoPat.charAt(i);
			if (caracteresProhibidos.contains(caracterActual)) {
				contador++;
			}
		}
		
		if (contador>0) {
			resultado=false;
		}
		
		return resultado;
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

    //Cliente
    public void mostrarPanelCliente(){
        Clientes clientes = new Clientes(frame); 
        clientes.mostrar();
        frame.repaint();
        frame.revalidate();
    }

    //Consultar
    public void mostrarConsultaCliente(){
        ConsultarCliente consultaCliente = new ConsultarCliente(frame,nombre_cliente,id_cliente);
        consultaCliente.mostrar();
        frame.repaint();
        frame.revalidate();
    }
}