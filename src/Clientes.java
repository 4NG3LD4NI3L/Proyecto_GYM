import java.awt.Color;

import javax.swing.*;

public class Clientes {

    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;

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

        JButton clientes = new JButton("Clientes");
        clientes.setSize(80, 23);
        clientes.setBackground(new Color(61,61,61));
        clientes.setLocation(90, 60);
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
        nombre.setBorder(null);
        fondo.add(nombre);

        JTextField iD = new JTextField();
        iD.setSize(208, 25);
        iD.setLocation(241, 245);
        iD.setBorder(null);
        iD.setBackground(Color.decode("#404040"));
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
        panel.add(regresar);

        JButton buscar = new JButton("Buscar");
        buscar.setSize(87, 34);
        buscar.setLocation(164, 151);
        buscar.setBackground(Color.decode("#ff9015"));
        buscar.setBorderPainted(false);
        panel.add(buscar);

        JButton nuevoCliente = new JButton("Nuevo Cliente");
        nuevoCliente.setSize(123, 27);
        nuevoCliente.setLocation(85, 214);
        nuevoCliente.setBackground(Color.decode("#01ff57"));
        nuevoCliente.setBorderPainted(false);
        panel.add(nuevoCliente);
        
        frame.repaint();
	    frame.revalidate();
        fondo.add(fondo1);
    }

    public void mostrar(){
        frame.add(panel);
        frame.add(fondo);
		frame.repaint();
		frame.revalidate();
    }
}