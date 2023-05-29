import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Menu{
	 private JFrame frame;
	 private JPanel fondo;
	 private JPanel panel;
	 private JPanel arriba;
	    
	public Menu(JFrame frame) {
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
        
        JLabel logomini = new JLabel(new ImageIcon("Resources/logoMini.png"));
        logomini.setLocation(10, 0);
        logomini.setSize(102, 83);
        arriba.add(logomini);
        
        RoundedPanel panel = new RoundedPanel(15);
        panel.setLayout(null);
        panel.setSize(400, 330);
        panel.setLocation(150, 120);
        panel.setBackground(new Color(0,0,0,85));
        fondo.add(panel);
        
        JLabel nomPantalla = new JLabel("Menu");
        nomPantalla.setSize(145, 32);
        nomPantalla.setLocation(320, 25);
        nomPantalla.setForeground(Color.white);
        nomPantalla.setFont(new Font("",Font.BOLD,40));
        arriba.add(nomPantalla);
        
        JLabel sombraNomPantalla = new JLabel("Menu");
        sombraNomPantalla.setSize(145, 32);
        sombraNomPantalla.setLocation(327, 30);
        sombraNomPantalla.setForeground(Color.decode("#323232"));
        sombraNomPantalla.setFont(new Font("",Font.BOLD,40));
        arriba.add(sombraNomPantalla);
        
        JButton cerrarSesion = new JButton("Cerrar sesion");
        cerrarSesion.setSize(120, 30);
        cerrarSesion.setLocation(530, 30);
        ShapedButtonUI roundUI = new ShapedButtonUI();
        roundUI.setShape(ButtonShape.ROUND, cerrarSesion,Color.decode("#FF9015"));
        cerrarSesion.setUI(roundUI);
        arriba.add(cerrarSesion);
        
        JButton op1 = new JButton("Clientes");
        op1.setSize(120, 120);
        op1.setLocation(65, 30);
        ShapedButtonUI roundUI_dos = new ShapedButtonUI();
        roundUI_dos.setShape(ButtonShape.ROUND, op1,Color.decode("#FAFF00"));
        op1.setUI(roundUI_dos);
        op1.setPreferredSize(new Dimension(87,34));
        panel.add(op1);
        
        JButton op2 = new JButton("Tarifas");
        op2.setSize(120, 120);
        op2.setLocation(215, 30);
        ShapedButtonUI roundUI_tres = new ShapedButtonUI();
        roundUI_tres.setShape(ButtonShape.ROUND, op1,Color.decode("#FAFF00"));
        op2.setUI(roundUI_tres);
        op2.setPreferredSize(new Dimension(87,34));
        panel.add(op2);
        
        JButton op3 = new JButton("Clases");
        op3.setSize(120, 120);
        op3.setLocation(65, 180);
        ShapedButtonUI roundUI_cuatro = new ShapedButtonUI();
        roundUI_cuatro.setShape(ButtonShape.ROUND, op1,Color.decode("#FAFF00"));
        op3.setUI(roundUI_cuatro);
        op3.setPreferredSize(new Dimension(87,34));
        panel.add(op3);
        
        JButton op4 = new JButton("Instructores");
        op4.setSize(120, 120);
        op4.setLocation(215, 180);
        ShapedButtonUI roundUI_cinco = new ShapedButtonUI();
        roundUI_cinco.setShape(ButtonShape.ROUND, op1,Color.decode("#FAFF00"));
        op4.setUI(roundUI_cinco);
        op4.setPreferredSize(new Dimension(87,34));
        panel.add(op4);
		
        frame.repaint();
	    frame.revalidate();
        fondo.add(fondoI);
	}
	
	public void mostrar(){
        frame.add(fondo);
		frame.repaint();
		frame.revalidate();
    }

}
