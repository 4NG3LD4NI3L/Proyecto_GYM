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
import javax.swing.JTextField;

public class EditarTarifa {

	private JFrame frame;
	private JPanel fondo;
	private JPanel panel;
	private JPanel arriba;
	 private String duracion;
	 private String id;

	public EditarTarifa(JFrame frame) {
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

        JButton tari = new JButton("Tarifas");
        tari.setSize(100, 23);
        tari.setBackground(new Color(61,61,61));
        tari.setLocation(105, 60);
        tari.setFont(new Font("", Font.BOLD, 15));
        tari.setForeground(Color.white);
        tari.setBorderPainted(false);
        arriba.add(tari);

        JLabel separador2 = new JLabel("/");
        separador2.setLocation(207, 67);
        separador2.setSize(10, 10);
        separador2.setFont(new Font("", Font.BOLD, 15));
        separador2.setForeground(Color.white);
        arriba.add(separador2);
        
        JButton datos = new JButton("Editar tarifa");
        datos.setSize(140, 23);
        datos.setBackground(new Color(61,61,61));
        datos.setLocation(212, 60);
        datos.setFont(new Font("", Font.BOLD, 15));
        datos.setForeground(Color.yellow);
        datos.setBorderPainted(false);
        arriba.add(datos);
        
        JLabel logomini = new JLabel(new ImageIcon("Resources/logoMini.png"));
        logomini.setLocation(560, 0);
        logomini.setSize(102, 83);
        arriba.add(logomini);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(280, 320);
        panel.setLocation(205, 120);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);
        
        JLabel duracion = new JLabel("Duración");
        duracion.setSize(100, 20);
        duracion.setLocation(15, 10);
        duracion.setFont(new Font("",Font.BOLD,18));
        panel.add(duracion);
        
        JTextField duraciont = new JTextField("  1 Mes");
        duraciont.setSize(250, 25);
        duraciont.setLocation(15, 40);
        duraciont.setBorder(null);
        duraciont.setBackground(Color.LIGHT_GRAY);
        panel.add(duraciont);
        
        JLabel precio = new JLabel("Precio");
        precio.setSize(100, 20);
        precio.setLocation(15, 75);
        precio.setFont(new Font("",Font.BOLD,18));
        panel.add(precio);
        
        JTextField preciot = new JTextField("  300");
        preciot.setSize(250, 25);
        preciot.setLocation(15, 105);
        preciot.setBorder(null);
        preciot.setBackground(Color.LIGHT_GRAY);
        panel.add(preciot);
        
        ImageIcon foto = new ImageIcon("Resources/editPlan.png");
        JLabel fill = new JLabel();
        fill.setIcon(new ImageIcon(foto.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
        fill.setLocation(85, 135);
        fill.setSize(110, 110);
        panel.add(fill);
        
        JButton cambiar_foto = new JButton("Cambiar foto");
        ShapedButtonUI roundUI_4 = new ShapedButtonUI();
        roundUI_4.setShape(ButtonShape.ROUND, cambiar_foto,Color.white);
        cambiar_foto.setUI(roundUI_4);
        cambiar_foto.setFocusPainted(false);
        cambiar_foto.setFont(new Font("Arial",Font.BOLD,12));
        cambiar_foto.setSize(110, 20);
        cambiar_foto.setLocation(90,250);
        cambiar_foto.setPreferredSize(new Dimension(87,34));
        panel.add(cambiar_foto);
        
        JButton confirmar = new JButton("Confirmar");
        confirmar.setSize(120, 30);
        confirmar.setLocation(145, 275);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ButtonShape.ROUND, confirmar,new Color(0,0,0,170));
        confirmar.setUI(roundUI);
        confirmar.setPreferredSize(new Dimension(87,34));
        confirmar.setForeground(Color.decode("#01ff57"));
        panel.add(confirmar);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(120, 30);
        cancelar.setLocation(15, 275);
        ShapedButtonUI roundUI_dos = new ShapedButtonUI();
        roundUI_dos.setShape(ButtonShape.ROUND, cancelar,new Color(0,0,0,170));
        cancelar.setUI(roundUI_dos);
        cancelar.setPreferredSize(new Dimension(87,34));
        cancelar.setForeground(Color.decode("#ff4343"));
        panel.add(cancelar);
        
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarMenu();

                frame.repaint();
                frame.revalidate();
            }
        });

        tari.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarPanelTarifas();

                frame.repaint();
                frame.revalidate();
            }
        });

        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                frame.remove(fondo);

                mostrarPanelTarifas();

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

    //Menu
    public void mostrarMenu(){
        Menu menu = new Menu(frame);
        menu.mostrar();
        frame.repaint();
        frame.revalidate();
    }

    //Tarifas
    public void mostrarPanelTarifas(){
        Tarifas tarifa = new Tarifas(frame,duracion,id);
         tarifa.mostrar();
         frame.repaint();
         frame.revalidate();
     }

}
