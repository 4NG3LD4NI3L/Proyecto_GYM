import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tarifas {
	private JFrame frame;
	private JPanel fondo;
	private JPanel panel;
	private JPanel arriba;
	
	CrearTarifa cTarifa;
	public Tarifas(JFrame frame) {
		this.frame = frame;
		JLabel fondoI = new JLabel(new ImageIcon("Resources/Fondopantallas.png"));
        fondoI.setSize(691, 487);
		
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
        
        JLabel logomini = new JLabel(new ImageIcon("Resources/logoMini.png"));
        logomini.setLocation(560, 0);
        logomini.setSize(102, 83);
        arriba.add(logomini);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(600, 280);
        panel.setLocation(45, 150);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);
        
        JButton CreaTarifa = new JButton("Crear tarifa");
        CreaTarifa.setSize(100, 30);
        CreaTarifa.setLocation(540, 110);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ButtonShape.ROUND, CreaTarifa,Color.decode("#01FF57"));
        CreaTarifa.setUI(roundUI);
        fondo.add(CreaTarifa);
        
        JButton op1 = new JButton(new ImageIcon("Resources/1 Mes.png"));
        op1.setSize(150, 220);
        op1.setLocation(25, 30);
        ShapedButtonUI roundUI_dos = new ShapedButtonUI();
        roundUI_dos.setShape(ButtonShape.ROUND, op1,Color.decode("#FAFF00"));
        op1.setUI(roundUI_dos);
        op1.setPreferredSize(new Dimension(87,34));
        panel.add(op1);
        
       ImageIcon foto1 = new ImageIcon("Resources/1 Mes.png");
        JLabel fill = new JLabel();
        fill.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH)));
        fill.setLocation(0, 0);
        fill.setSize(150, 220);
        op1.add(fill);
        
        JButton op2 = new JButton("3 meses");
        op2.setSize(150, 220);
        op2.setLocation(225, 30);
        ShapedButtonUI roundUI_tres = new ShapedButtonUI();
        roundUI_tres.setShape(ButtonShape.ROUND, op2,Color.decode("#FAFF00"));
        op2.setUI(roundUI_tres);
        op2.setPreferredSize(new Dimension(87,34));
        panel.add(op2);
        
        ImageIcon foto2 = new ImageIcon("Resources/3 Meses.png");
        JLabel fill1 = new JLabel();
        fill1.setIcon(new ImageIcon(foto2.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH)));
        fill1.setLocation(0,0);
        fill1.setSize(150, 220);
        op2.add(fill1);
        
        JButton op3 = new JButton("1 Año");
        op3.setSize(150, 220);
        op3.setLocation(425, 30);
        ShapedButtonUI roundUI_cuatro = new ShapedButtonUI();
        roundUI_cuatro.setShape(ButtonShape.ROUND, op3,Color.decode("#FAFF00"));
        op3.setUI(roundUI_cuatro);
        op3.setPreferredSize(new Dimension(87,34));
        panel.add(op3);
        
        ImageIcon foto3 = new ImageIcon("Resources/1 Año.png");
        JLabel fill2 = new JLabel();
        fill2.setIcon(new ImageIcon(foto3.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH)));
        fill2.setLocation(0,0);
        fill2.setSize(150, 220);
        op3.add(fill2);
        
        JButton pq1 = new JButton();
        pq1.setSize(20, 20);
        pq1.setLocation(95,5);
        fill.add(pq1);

        JButton pq2 = new JButton();
        pq2.setSize(20, 20);
        pq2.setLocation(95,5);
        fill1.add(pq2);

        JButton pq3 = new JButton();
        pq3.setSize(20, 20);
        pq3.setLocation(95,5);
        fill2.add(pq3);

        pq1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq1.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(80, 30);
                editTarifa.setLocation(20, 40);
                fill.add(editTarifa);

                editTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEditar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton eliTarifa = new JButton("Eliminar Tarifa");
                eliTarifa.setSize(80, 30);
                eliTarifa.setLocation(20, 100);
                fill.add(eliTarifa);

                eliTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEliminar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(80, 30);
                cancelTarifa.setLocation(20, 160);
                fill.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq1.setSize(20, 20);

                    }
                });

                fill.repaint();
                fill.revalidate();
			}
        });

        pq2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq2.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(80, 30);
                editTarifa.setLocation(20, 40);
                fill1.add(editTarifa);

                editTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEditar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton eliTarifa = new JButton("Eliminar Tarifa");
                eliTarifa.setSize(80, 30);
                eliTarifa.setLocation(20, 100);
                fill1.add(eliTarifa);

                eliTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEliminar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(80, 30);
                cancelTarifa.setLocation(20, 160);
                fill1.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq2.setSize(20, 20);

                    }
                });

                fill1.repaint();
                fill1.revalidate();
			}
        });

        pq3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq3.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(80, 30);
                editTarifa.setLocation(20, 40);
                fill2.add(editTarifa);

                editTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEditar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton eliTarifa = new JButton("Eliminar Tarifa");
                eliTarifa.setSize(80, 30);
                eliTarifa.setLocation(20, 100);
                fill2.add(eliTarifa);

                eliTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEliminar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(80,30);
                cancelTarifa.setLocation(20, 160);
                fill2.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq3.setSize(20, 20);

                    }
                });

                fill2.repaint();
                fill2.revalidate();
			}
        });
        
		menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarMenu();

                frame.repaint();
                frame.revalidate();
            }
        });

        CreaTarifa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                CrearTarifas();

                frame.repaint();
                frame.revalidate();
            }
        });
        
        
        
        
        
        
        
        
        
        frame.repaint();
		frame.revalidate();
		fondo.add(fondoI);
	}
	public void mostrar(){
        frame.add(fondo);
		frame.repaint();
		frame.revalidate();
    }

	public void CrearTarifas(){
        cTarifa = new CrearTarifa(frame);
        cTarifa.mostrar();
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

    //Tarifas
    public void mostrarPanelTarifas(){
        Tarifas tarifa = new Tarifas(frame);
         tarifa.mostrar();
         frame.repaint();
         frame.revalidate();
    }

    public void mostrarTarifasEditar() {
    	EditarTarifa tarifas_editar = new EditarTarifa(frame);
    	tarifas_editar.mostrar();
    }

    public void mostrarTarifasEliminar() {
    	EliminarTarifa tarifas_eliminar = new EliminarTarifa(frame);
    	tarifas_eliminar.mostrar();
    	
    }
}
