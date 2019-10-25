/**
 * IFPB - TSI/POO
 * Prof. Fausto Ayres
 * 
 * Jogo de advinhacao - aplicação swing
 * 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;

public class AplicacaoSwing {

	private JFrame frame;
	private JogoAdvinhacaoComponente jogoAdvinhacaoComponente;
	private JogoAdvinhacaoComponente jogoAdvinhacaoComponente_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacaoSwing window = new AplicacaoSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacaoSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Jogo de advinhacao");
		frame.setBounds(100, 100, 456, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		jogoAdvinhacaoComponente = new JogoAdvinhacaoComponente();
		jogoAdvinhacaoComponente.setBounds(10, 21, 420, 111);
		frame.getContentPane().add(jogoAdvinhacaoComponente);
		
		jogoAdvinhacaoComponente_1 = new JogoAdvinhacaoComponente();
		jogoAdvinhacaoComponente_1.setBounds(10, 136, 420, 111);
		frame.getContentPane().add(jogoAdvinhacaoComponente_1);
	}
}
