import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultarCliente {

    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;

    public ConsultarCliente(JFrame frame){
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
        datos.setForeground(Color.yellow);
        datos.setBorderPainted(false);
        arriba.add(datos);
        
        RoundedPanel panel = new RoundedPanel(15);///////
        panel.setLayout(null);
        panel.setSize(614, 340);
        panel.setLocation(35, 113);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);

        JLabel nCliente = new JLabel("Cliente");
        nCliente.setSize(370, 40);
        nCliente.setLocation(20, 10);
        nCliente.setFont(new Font("",Font.BOLD,15));
        nCliente.setForeground(Color.black);
        panel.add(nCliente);

        JLabel nId = new JLabel("ID");
        nId.setSize(370, 40);
        nId.setLocation(238, 10);
        nId.setFont(new Font("",Font.BOLD,15));
        nId.setForeground(Color.black);
        panel.add(nId);

        JLabel nameCliente = new JLabel("Lalo suares");
        nameCliente.setSize(150, 15);
        nameCliente.setLocation(20, 40);
        nameCliente.setFont(new Font("",Font.BOLD,13));
        nameCliente.setOpaque(true);
        nameCliente.setBackground(Color.white);
        nameCliente.setForeground(Color.black);
        panel.add(nameCliente);

        JLabel idCliente = new JLabel("106015");
        idCliente.setSize(150, 15);
        idCliente.setLocation(238, 40);
        idCliente.setFont(new Font("",Font.BOLD,13));
        idCliente.setOpaque(true);
        idCliente.setBackground(Color.white);
        idCliente.setForeground(Color.black);
        panel.add(idCliente);

        JButton botonEditarC = new JButton("Editar Cliente");
        botonEditarC.setSize(160, 40);
        botonEditarC.setLocation(420, 60);
        botonEditarC.setBackground(Color.decode("#55A763"));
        panel.add(botonEditarC);

        JButton botonEliminarC = new JButton("Eliminar Cliente");
        botonEliminarC.setSize(160, 40);
        botonEliminarC.setLocation(420, 120);
        botonEliminarC.setBackground(Color.decode("#FF4343"));
        panel.add(botonEliminarC);

        JButton botonDescargarC = new JButton("Descagar Historial");
        botonDescargarC.setSize(160, 40);
        botonDescargarC.setLocation(420, 180);
        botonDescargarC.setBackground(Color.decode("#FFFFFF"));
        panel.add(botonDescargarC);

        JButton botonCredencialC = new JButton("Descagar Credencial");
        botonCredencialC.setSize(160, 40);
        botonCredencialC.setLocation(420, 240);
        botonCredencialC.setBackground(Color.decode("#FFFFFF"));
        panel.add(botonCredencialC);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setSize(370, 250);
        panel2.setLocation(20, 65);
        panel2.setBackground(new Color(255,255,255));
        panel.add(panel2);

        
        String[]columnas = {"Mes","Asistencia","Monto"};
        String[][]datosT ={
            {"Enero","15","$300.00"}
        };
        DefaultTableModel modelo = new DefaultTableModel(datosT,columnas);
    
        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 40, 330, 200);
        panel2.add(scroll);

        RoundedPanel up = new RoundedPanel(15);
        up.setSize(370, 30);
        up.setLayout(null);
        up.setBackground(Color.yellow);
        panel2.add(up);

        JLabel historialC = new JLabel("Historial del cliente");
        historialC.setFont(new Font("",Font.BOLD,20));
        historialC.setSize(200, 30);
        historialC.setLocation(95, 0);
        up.add(historialC);

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