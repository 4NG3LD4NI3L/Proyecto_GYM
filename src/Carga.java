import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carga extends JPanel {
	
	public Carga() {
		setBounds(0, 0, 700, 522);
		setLayout(null);
		
		JLabel f1 = new JLabel(new ImageIcon("Resources/FondoGym.png"));
		f1.setSize(700,522);
		this.add(f1);
		
		JLabel titulo = new JLabel("Loading", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 26));
		titulo.setForeground(Color.decode("#905453"));
		titulo.setBounds(265,170, 150, 50);
		this.add(titulo);
		
		JLabel f2 = new JLabel(new ImageIcon("Resources/splash.gif"));
		f2.setSize(50,50);
		f2.setLocation(313, 220);
		this.add(f2);
	
		repaint();
		revalidate();
	}
}