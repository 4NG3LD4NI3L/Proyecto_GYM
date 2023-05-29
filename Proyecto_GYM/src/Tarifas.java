import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tarifas extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	public Tarifas() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel fondo1 = new JLabel(new ImageIcon("Resources/Fondopantallas.png"));
        fondo1.setSize(691, 487);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(76, 101, 489, 218);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(110, 11, 49, 23);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(285, 11, 33, 23);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(446, 11, 33, 23);
		panel_1.add(btnNewButton_5);

		JButton btnNewButton = new JButton("1 mes");
		btnNewButton.setBounds(10, 11, 149, 196);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("6 mes");
		btnNewButton_1.setBounds(169, 11, 149, 196);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("1 ano");
		btnNewButton_2.setBounds(328, 11, 149, 196);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_6 = new JButton("Menu");
		btnNewButton_6.setBounds(10, 11, 80, 23);
		panel.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Tarifas");
		btnNewButton_7.setBounds(89, 11, 88, 23);
		panel.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Crear Tarifas");
		btnNewButton_8.setBounds(445, 67, 120, 23);
		panel.add(btnNewButton_8);
		panel.add(fondo1);
		
		
		
		
		
		panel.repaint();
		panel.revalidate();
	}

}
