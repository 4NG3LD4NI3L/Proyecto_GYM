import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Instructor {

	private JFrame frame;
    private JPanel fondo;
    private JPanel arriba;
	public Instructor(JFrame frame) {
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

        JButton clientes = new JButton("Instructor");
        clientes.setSize(150, 23);
        clientes.setBackground(new Color(61,61,61));
        clientes.setLocation(90, 60);
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

        JLabel nombreCliente = new JLabel("Nombre del instructor");
        nombreCliente.setSize(145, 15);
        nombreCliente.setLocation(42, 36);
        nombreCliente.setForeground(Color.white);
        panel.add(nombreCliente);

        JLabel idCliente = new JLabel("ID instructor");
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

        JButton nuevoCliente = new JButton("Nuevo Instructor");
        nuevoCliente.setSize(145, 27);
        nuevoCliente.setLocation(75, 214);
        ShapedButtonUI roundUI_dos = new ShapedButtonUI();
        roundUI_dos.setShape(ButtonShape.ROUND, nuevoCliente,Color.decode("#01ff57"));
        nuevoCliente.setUI(roundUI_dos);
        nuevoCliente.setPreferredSize(new Dimension(87,34));
        panel.add(nuevoCliente);
        
        frame.repaint();
	    frame.revalidate();
        fondo.add(fondo1);
    }

    public void mostrar(){
    	
        //frame.add(panel); ESTE PANEL NO ESTA INICIALIZADO Y MANDA NULL
        frame.add(fondo);
		frame.repaint();
		frame.revalidate();
    }
}