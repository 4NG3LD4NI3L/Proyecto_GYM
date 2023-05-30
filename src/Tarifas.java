import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tarifas {

    private JFrame frame;
    private JPanel fondo;
    private JPanel panel;
    private JPanel arriba;
    JButton mes;

    public Tarifas(JFrame frame){
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

        JButton clientes = new JButton("Tarifas");
        clientes.setSize(100, 23);
        clientes.setBackground(new Color(61,61,61));
        clientes.setLocation(105, 60);
        clientes.setFont(new Font("", Font.BOLD, 15));
        clientes.setForeground(Color.yellow);
        clientes.setBorderPainted(false);
        arriba.add(clientes);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(580, 270);
        panel.setLocation(50, 155);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);

        mes = new JButton("1 Mes");
        mes.setSize(160, 220);
        mes.setLayout(null);
        mes.setLocation(30, 25);
        mes.setBackground(Color.yellow);
        panel.add(mes);

        JButton sixmes = new JButton("6 Meses");
        sixmes.setSize(160, 220);
        sixmes.setLayout(null);
        sixmes.setLocation(210, 25);
        sixmes.setBackground(Color.yellow);
        panel.add(sixmes);

        JButton año = new JButton("1 Año");
        año.setSize(160, 220);
        año.setLayout(null);
        año.setLocation(390, 25);
        año.setBackground(Color.yellow);
        panel.add(año);

        JButton CrearTarifa = new JButton("Crear tarifa");
        CrearTarifa.setSize(100, 20);
        CrearTarifa.setLayout(null);
        CrearTarifa.setLocation(520, 125);
        CrearTarifa.setBackground(Color.GREEN);
        fondo.add(CrearTarifa);

        JButton pq1 = new JButton();
        pq1.setSize(20, 20);
        pq1.setLocation(135,5);
        mes.add(pq1);

        JButton pq2 = new JButton();
        pq2.setSize(20, 20);
        pq2.setLocation(135,5);
        sixmes.add(pq2);

        JButton pq3 = new JButton();
        pq3.setSize(20, 20);
        pq3.setLocation(135,5);
        año.add(pq3);

        pq1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq1.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(120, 30);
                editTarifa.setLocation(20, 40);
                mes.add(editTarifa);

                JButton eliTarifa = new JButton("Eliminar Tarifa");
                eliTarifa.setSize(120, 30);
                eliTarifa.setLocation(20, 100);
                mes.add(eliTarifa);

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(120, 30);
                cancelTarifa.setLocation(20, 160);
                mes.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq1.setSize(20, 20);

                    }
                });

                mes.repaint();
                mes.revalidate();
			}
        });

        pq2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq2.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(120, 30);
                editTarifa.setLocation(20, 40);
                sixmes.add(editTarifa);

                JButton eliTarifa = new JButton("Eliminar Tarifa");
                eliTarifa.setSize(120, 30);
                eliTarifa.setLocation(20, 100);
                sixmes.add(eliTarifa);

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(120, 30);
                cancelTarifa.setLocation(20, 160);
                sixmes.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq2.setSize(20, 20);

                    }
                });

                sixmes.repaint();
                sixmes.revalidate();
			}
        });

        pq3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq3.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(120, 30);
                editTarifa.setLocation(20, 40);
                año.add(editTarifa);

                JButton eliTarifa = new JButton("Eliminar Tarifa");
                eliTarifa.setSize(120, 30);
                eliTarifa.setLocation(20, 100);
                año.add(eliTarifa);

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(120, 30);
                cancelTarifa.setLocation(20, 160);
                año.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq3.setSize(20, 20);

                    }
                });

                año.repaint();
                año.revalidate();
			}
        });



        

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