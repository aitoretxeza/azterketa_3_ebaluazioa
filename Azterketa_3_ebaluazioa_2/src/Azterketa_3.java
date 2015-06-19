import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class Azterketa_3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Azterketa_3 frame = new Azterketa_3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Azterketa_3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JRadioButton radioButtonEguna = new JRadioButton("Eguna");
		contentPane.add(radioButtonEguna, BorderLayout.WEST);
		
		JRadioButton radioButtonGaua = new JRadioButton("Gaua");
		contentPane.add(radioButtonGaua, BorderLayout.CENTER);
		
		JButton btnAceptar = new JButton("Aceptar");
		contentPane.add(btnAceptar, BorderLayout.NORTH);   
		
		JButton btnCancelar = new JButton("Cancelar");
		contentPane.add(btnCancelar, BorderLayout.SOUTH);
	}

}
