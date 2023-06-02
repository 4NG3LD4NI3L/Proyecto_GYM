import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EliminarInstructor {

    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;

	public EliminarInstructor(JFrame frame){
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
        menu.setLocation(0, 60);
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

        JButton instr = new JButton("Instructor");
        instr.setSize(105, 23);
        instr.setBackground(new Color(61,61,61));
        instr.setLocation(105, 60);
        instr.setFont(new Font("", Font.BOLD, 15));
        instr.setForeground(Color.white);
        instr.setBorderPainted(false);
        arriba.add(instr);

        JLabel separador2 = new JLabel("/");
        separador2.setLocation(210, 67);
        separador2.setSize(10, 10);
        separador2.setFont(new Font("", Font.BOLD, 15));
        separador2.setForeground(Color.white);
        arriba.add(separador2);
        
        JButton datos = new JButton("Datos Instructor");
        datos.setSize(140, 23);
        datos.setBackground(new Color(61,61,61));
        datos.setLocation(212, 60);
        datos.setSize(150, 23);
        datos.setBackground(new Color(61,61,61));
        datos.setLocation(210, 60);
        datos.setFont(new Font("", Font.BOLD, 15));
        datos.setForeground(Color.white);
        datos.setBorderPainted(false);
        arriba.add(datos);

        JLabel separador3 = new JLabel("/");
        separador3.setLocation(360, 67);
        separador3.setSize(10, 10);
        separador3.setForeground(Color.white);
        separador3.setFont(new Font("", Font.BOLD, 15));
        arriba.add(separador3);

        JButton crd = new JButton("Eliminar Instructor");
        crd.setSize(150, 23);
        crd.setSize(180, 23);
        crd.setBackground(new Color(61,61,61));
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

        JLabel nameCliente = new JLabel("Ricardo Montana");
        nameCliente.setSize(120, 15);
        nameCliente.setLocation(150, 100);
        nameCliente.setFont(new Font("",Font.BOLD,13));
        nameCliente.setOpaque(true);
        nameCliente.setBackground(Color.white);
        nameCliente.setForeground(Color.black);
        panel.add(nameCliente);

        JLabel idCliente = new JLabel("254015");
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
    	ConsultarInstructor consultarInstructor = new ConsultarInstructor(frame);
    	consultarInstructor.mostrar();
    }
}