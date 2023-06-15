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

public class EliminarInstructor {

    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;
    private String nombre_instructor;
    private String id_instructor;
    private BaseDatos bd;

	public EliminarInstructor(JFrame frame, String nombre, String id){
		 this.frame = frame;
	     this.nombre_instructor = nombre;
	     this.id_instructor = id;
        
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
        menu.setSize(70, 23);
        menu.setBackground(new Color(61,61,61));
        menu.setLocation(20, 60);
        menu.setFont(new Font("", Font.BOLD, 13));
        menu.setForeground(Color.white);
        menu.setBorderPainted(false);
        arriba.add(menu);

        JLabel separador = new JLabel("/");
        separador.setLocation(95, 67);
        separador.setFont(new Font("", Font.BOLD, 15));
        separador.setSize(10, 10);
        separador.setForeground(Color.white);
        arriba.add(separador);

        JButton instr = new JButton("Instructores");
        instr.setSize(125, 23);
        instr.setLocation(105, 60);
        instr.setBackground(new Color(61,61,61));
        instr.setFont(new Font("", Font.BOLD, 13));
        instr.setForeground(Color.white);
        instr.setBorderPainted(false);
        arriba.add(instr);

        JLabel separador2 = new JLabel("/");
        separador2.setLocation(230, 67);
        separador2.setSize(10, 10);
        separador2.setFont(new Font("", Font.BOLD, 15));
        separador2.setForeground(Color.white);
        arriba.add(separador2);
        
        JButton datos = new JButton("Datos Instructor");
        datos.setSize(135, 23);
        datos.setLocation(245, 60);
        datos.setBackground(new Color(61,61,61));
        datos.setFont(new Font("", Font.BOLD, 13));
        datos.setForeground(Color.yellow);
        datos.setBorderPainted(false);
        arriba.add(datos);

        JLabel separador3 = new JLabel("/");
        separador3.setLocation(380, 67);
        separador3.setSize(10, 10);
        separador3.setForeground(Color.white);
        separador3.setFont(new Font("", Font.BOLD, 15));
        arriba.add(separador3);

        JButton crd = new JButton("Eliminar Instructor");
        crd.setSize(150, 23);
        crd.setBackground(new Color(61,61,61));
        crd.setLocation(385, 60);
        crd.setForeground(Color.yellow);
        crd.setBorderPainted(false);
        crd.setFont(new Font("", Font.BOLD, 13));
        arriba.add(crd);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(614, 240);
        panel.setLocation(35, 113);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);

        ///////////////////
        //////////////////

        JLabel pregunta = new JLabel("Desea eliminar al Instructor?");
        pregunta.setSize(390, 40);
        pregunta.setLocation(125, 20);
        pregunta.setOpaque(true);
        pregunta.setBackground(Color.decode("#a6a6a6"));
        pregunta.setFont(new Font("",Font.BOLD,25));
        pregunta.setForeground(Color.black);
        panel.add(pregunta);

        JLabel nCliente = new JLabel("Instructor");
        nCliente.setSize(370, 40);
        nCliente.setLocation(150, 70);
        nCliente.setFont(new Font("",Font.BOLD,15));
        nCliente.setForeground(Color.black);
        panel.add(nCliente);

        JLabel nId = new JLabel("ID");
        nId.setSize(370, 40);
        nId.setLocation(350, 70);
        nId.setFont(new Font("",Font.BOLD,15));
        nId.setForeground(Color.black);
        panel.add(nId);

        JLabel nameCliente = new JLabel(nombre_instructor);
        nameCliente.setSize(120, 15);
        nameCliente.setLocation(150, 100);
        nameCliente.setFont(new Font("",Font.BOLD,13));
        nameCliente.setOpaque(true);
        nameCliente.setBackground(Color.white);
        nameCliente.setForeground(Color.black);
        panel.add(nameCliente);

        JLabel idCliente = new JLabel(id_instructor);
        idCliente.setSize(120, 15);
        idCliente.setLocation(350, 100);
        idCliente.setFont(new Font("",Font.BOLD,13));
        idCliente.setOpaque(true);
        idCliente.setBackground(Color.white);
        idCliente.setForeground(Color.black);
        panel.add(idCliente);
        
        ///////////////////
        //////////////////

        JButton confirmarN = new JButton("Confirmar");
        confirmarN.setSize(127, 37);
        confirmarN.setLocation(370, 165);
        confirmarN.setBackground(Color.decode("#292929"));
        confirmarN.setForeground(Color.decode("#14fc0e"));
        confirmarN.setBorderPainted(false);
        panel.add(confirmarN);

        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(127, 37);
        cancelar.setLocation(115, 165);
        cancelar.setBackground(Color.decode("#292929"));
        cancelar.setForeground(Color.decode("#ff0000"));
        cancelar.setBorderPainted(false);
        panel.add(cancelar);

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
				eliminarIns(id_instructor);
				
				JOptionPane.showMessageDialog(null,"Se elimino exitosamente","Cliente eliminado",JOptionPane.INFORMATION_MESSAGE);
				
				frame.remove(fondo);
				mostrarPanelInstructor();
				
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
	
	//Instructor
	public void mostrarPanelInstructor(){
		Instructor instructor = new Instructor(frame);
		instructor.mostrar();
		frame.repaint();
		frame.revalidate();
	}
	
	public void eliminarIns(String id) {
    	try {
			bd = new BaseDatos();
			bd.eliminarInstructor(Integer.parseInt(id));
		} catch (SQLException e) {
			System.err.println("Base de datos fallo en la clase Eliminar instructor: "+e.getMessage());
		}
    }

    //Consultar
    public void mostrarConsultarInstructor(){
    	ConsultarInstructor consultarInstructor = new ConsultarInstructor(frame,nombre_instructor,id_instructor);
    	consultarInstructor.mostrar();
    }
}