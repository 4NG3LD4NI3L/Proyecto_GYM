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
        CreaTarifa.setSize(105, 20);
        CreaTarifa.setLocation(540, 110);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ButtonShape.ROUND, CreaTarifa,Color.decode("#01FF57"));
        CreaTarifa.setUI(roundUI);
        fondo.add(CreaTarifa);
        
        RoundedPanel plan1 = new RoundedPanel(15);
        plan1.setLayout(null);
        plan1.setSize(150, 220);
        plan1.setLocation(25, 30);
        panel.add(plan1);

        ImageIcon foto1 = new ImageIcon("Resources/1 Mes.png");
        JLabel fondo1 = new JLabel(new ImageIcon(foto1.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH)));
        fondo1.setSize(150, 220);
        plan1.add(fondo1);

        RoundedPanel plan2 = new RoundedPanel(15);
        plan2.setLayout(null);
        plan2.setSize(150, 220);
        plan2.setLocation(225, 30);
        panel.add(plan2);

        ImageIcon foto2 = new ImageIcon("Resources/3 Meses.png");
        JLabel fondo2 = new JLabel(new ImageIcon(foto2.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH)));
        fondo2.setSize(150, 220);
        plan2.add(fondo2);

        RoundedPanel plan3 = new RoundedPanel(15);
        plan3.setLayout(null);
        plan3.setSize(150, 220);
        plan3.setLocation(425, 30);
        panel.add(plan3);

        ImageIcon foto3 = new ImageIcon("Resources/1 Año.png");
        JLabel fondo3 = new JLabel(new ImageIcon(foto3.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH)));
        fondo3.setSize(150, 220);
        plan3.add(fondo3);
        
        JButton pq1 = new JButton();
        pq1.setSize(20, 20);
        pq1.setLocation(120,5);
        fondo1.add(pq1);

        JButton pq2 = new JButton();
        pq2.setSize(20, 20);
        pq2.setLocation(120,5);
        fondo2.add(pq2);

        JButton pq3 = new JButton();
        pq3.setSize(20, 20);
        pq3.setLocation(120,5);
        fondo3.add(pq3);

        pq1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq1.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(105, 30);
                editTarifa.setLocation(20, 40);
                fondo1.add(editTarifa);

                editTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEditar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton eliTarifa = new JButton("Eliminar");
                eliTarifa.setSize(105, 30);
                eliTarifa.setLocation(20, 100);
                fondo1.add(eliTarifa);

                eliTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEliminar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(105, 30);
                cancelTarifa.setLocation(20, 160);
                fondo1.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq1.setSize(20, 20);

                    }
                });

                fondo1.repaint();
                fondo1.revalidate();
			}
        });

        pq2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq2.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(105, 30);
                editTarifa.setLocation(20, 40);
                fondo2.add(editTarifa);

                editTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEditar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton eliTarifa = new JButton("Eliminar");
                eliTarifa.setSize(105, 30);
                eliTarifa.setLocation(20, 100);
                fondo2.add(eliTarifa);

                eliTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEliminar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(105, 30);
                cancelTarifa.setLocation(20, 160);
                fondo2.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq2.setSize(20, 20);

                    }
                });

                fondo2.repaint();
                fondo2.revalidate();
			}
        });

        pq3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
				pq3.setSize(0, 0);

                JButton editTarifa = new JButton("Editar Tarifa");
                editTarifa.setSize(105, 30);
                editTarifa.setLocation(20, 40);
                fondo3.add(editTarifa);

                editTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEditar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton eliTarifa = new JButton("Eliminar");
                eliTarifa.setSize(105, 30);
                eliTarifa.setLocation(20, 100);
                fondo3.add(eliTarifa);

                eliTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        frame.remove(fondo);
        
                        mostrarTarifasEliminar();
        
                        frame.repaint();
                        frame.revalidate();
                    }
                });

                JButton cancelTarifa = new JButton("Cancelar");
                cancelTarifa.setSize(105,30);
                cancelTarifa.setLocation(20, 160);
                fondo3.add(cancelTarifa);

                cancelTarifa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) { 
                        editTarifa.setSize(0, 0);
                        eliTarifa.setSize(0, 0);
                        cancelTarifa.setSize(0, 0);

                        pq3.setSize(20, 20);

                    }
                });

                fondo3.repaint();
                fondo3.revalidate();
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
