import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public Menu() {
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); 
		
		JLabel fondo1 = new JLabel(new ImageIcon("Resources/Fondopantallas.png"));
        fondo1.setSize(691, 487);
        
        
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setBounds(269, 11, 116, 44);
		panel_1.add(lblNewLabel);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(132, 109, 371, 292);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(47, 37, 96, 93);
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(207, 37, 96, 93);
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(47, 141, 96, 93);
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(207, 141, 96, 93);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Cerrar Sesion");
		btnNewButton_4.setBounds(525, 11, 105, 23);
		panel_1.add(btnNewButton_4);
		panel_1.add(fondo1);
		
		
		
		
		
		panel_1.repaint();
		panel_1.revalidate();
	}

}
