import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TarifasEditar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public TarifasEditar(JFrame ventana) {
		this.frame=ventana;
		
		JLabel fondo1 = new JLabel(new ImageIcon("Resources/Fondopantallas.png"));
        fondo1.setSize(691, 487);
		
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setSize(691, 487);
        frame.add(this);
        
        JPanel arriba = new JPanel();
        arriba.setSize(691, 83);
        arriba.setLayout(null);
        arriba.setBackground(new Color(61,61,61));
        this.add(arriba);
        
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

        JButton tarifas = new JButton("Tarifas");
        tarifas.setSize(80, 23);
        tarifas.setBackground(new Color(61,61,61));
        tarifas.setLocation(90, 60);
        tarifas.setForeground(Color.white);
        tarifas.setBorderPainted(false);
        arriba.add(tarifas);
        
        JLabel separador_2 = new JLabel("/");
        separador_2.setLocation(170, 67);
        separador_2.setSize(10, 10);
        separador_2.setForeground(Color.white);
        arriba.add(separador_2);

        JButton editarTarifa = new JButton("Editar Tarifa");
        editarTarifa.setSize(130, 23);
        editarTarifa.setBackground(new Color(61,61,61));
        editarTarifa.setLocation(179, 60);
        editarTarifa.setForeground(Color.yellow);
        editarTarifa.setBorderPainted(false);
        arriba.add(editarTarifa);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(293, 333);
        panel.setLocation(199, 122);
        panel.setBackground(new Color(0,0,0,100));
        this.add(panel);

        JLabel etiqueDuracion = new JLabel("Duración");
        etiqueDuracion.setSize(145, 16);
        etiqueDuracion.setLocation(15, 15);
        etiqueDuracion.setFont(new Font("Arial",Font.BOLD,16));
        etiqueDuracion.setForeground(Color.BLACK);
        panel.add(etiqueDuracion);
        
        JTextField ingreDuracion = new JTextField("1 mes");
        ingreDuracion.setSize(250, 25);
        ingreDuracion.setLocation(15, 33);
        ingreDuracion.setFont(new Font("Arial",Font.PLAIN,17));
        ingreDuracion.setForeground(Color.black);
        ingreDuracion.setBackground(Color.white);
        ingreDuracion.setBorder(null);
        panel.add(ingreDuracion);
        
        JLabel etiquePrecio = new JLabel("Precio");
        etiquePrecio.setSize(145, 16);
        etiquePrecio.setLocation(15, 70);
        etiquePrecio.setFont(new Font("Arial",Font.BOLD,16));
        etiquePrecio.setForeground(Color.BLACK);
        panel.add(etiquePrecio);
        
        JTextField ingrePrecio = new JTextField("300");
        ingrePrecio.setSize(250, 25);
        ingrePrecio.setLocation(15, 89);
        ingrePrecio.setFont(new Font("Arial",Font.PLAIN,17));
        ingrePrecio.setForeground(Color.black);
        ingrePrecio.setBackground(Color.white);
        ingrePrecio.setBorder(null);
        panel.add(ingrePrecio);
        
        JButton cambiar_foto = new JButton("Cambiar foto");
        ShapedButtonUI roundUI_4 = new ShapedButtonUI();
        roundUI_4.setShape(ButtonShape.ROUND, cambiar_foto,Color.white);
        cambiar_foto.setUI(roundUI_4);
        cambiar_foto.setFocusPainted(false);
        cambiar_foto.setFont(new Font("Arial",Font.BOLD,12));
        cambiar_foto.setSize(123, 34);
        cambiar_foto.setLocation(83, 140);
        cambiar_foto.setPreferredSize(new Dimension(87,34));
        panel.add(cambiar_foto);
        
        JButton cancelar = new JButton("Cancelar");
        ShapedButtonUI roundUI_3 = new ShapedButtonUI();
        roundUI_3.setShape(ButtonShape.ROUND, cancelar,Color.decode("#ff4343"));
        cancelar.setUI(roundUI_3);
        cancelar.setFocusPainted(false);
        cancelar.setFont(new Font("Arial",Font.BOLD,12));
        cancelar.setSize(123, 34);
        cancelar.setLocation(17, 285);
        cancelar.setPreferredSize(new Dimension(87,34));
        panel.add(cancelar);	

        JButton confirmar = new JButton("Confirmar");
        ShapedButtonUI roundUI_2 = new ShapedButtonUI();
        roundUI_2.setShape(ButtonShape.ROUND, confirmar,Color.decode("#01ff57"));
        confirmar.setSize(123, 34);
        confirmar.setLocation(153, 285);
        confirmar.setUI(roundUI_2);
        confirmar.setPreferredSize(new Dimension(123,34));
        confirmar.setFocusPainted(false);
        panel.add(confirmar);
        
        cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Aqui debe mandar al menu
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
        confirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.requestFocus();
				frame.repaint();
				frame.revalidate();
			}
		});
        
        repaint();
		revalidate();
	    this.add(fondo1);
	}
	
	public void cerrarEstaVentana() {
		frame.remove(this);
	}

    public void mostrar(){
        //frame.add(panel); ESTE PANEL NO ESTA INICIALIZADO Y MANDA NULL
        frame.add(this);
		frame.repaint();
		frame.revalidate();
    }
}