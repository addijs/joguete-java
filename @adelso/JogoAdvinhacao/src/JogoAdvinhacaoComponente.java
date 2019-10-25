/**
 * IFPB - TSI/POO
 * Prof. Fausto Ayres
 * 
 * Jogo de advinhacao - componente swing
 *  
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JogoAdvinhacaoComponente extends JPanel{
	private JLabel labelTentativas;			
	private JLabel labelResultado;			
	private JButton button;
	private JLabel label;
	private JTextField textField;
	private JButton button_1;
	private JogoAdvinhacao jogo;
	private JButton button_2;

	public JogoAdvinhacaoComponente() {
		this.setLayout(null);
		this.setSize(429, 120 );		

		button = new JButton("Iniciar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				textField.setEnabled(true);
				textField.requestFocus();
				labelTentativas.setText("tentativas=0");
				labelResultado.setText("resultado=");

				jogo = new JogoAdvinhacao(99);
				textField.setToolTipText("digite um numero entre 0 e "+jogo.getLimiteMaximo());
			}
		});
		button.setBounds(10, 11, 75, 23);
		add(button);

		label = new JLabel("Numero");
		label.setBounds(95, 15, 60, 14);
		add(label);

		labelTentativas = new JLabel();
		labelTentativas.setSize(409, 30);
		labelTentativas.setLocation(10, 45);
		this.add(labelTentativas);

		labelResultado = new JLabel();
		labelResultado.setSize(409, 30);
		labelResultado.setLocation(10,80);
		this.add(labelResultado);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setToolTipText("");
		textField.setBounds(148, 12, 86, 20);
		add(textField);
		textField.setColumns(10);

		button_1 = new JButton("Jogar");
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//validar campo vazio
				if(textField.getText().isEmpty()) {
					labelResultado.setText("campo vazio");
					return;
				}
				
				try {
					int numero = Integer.parseInt(textField.getText());
					String resultado = jogo.advinhar(numero);
					labelResultado.setText("resultado="+resultado);
					labelTentativas.setText("tentativas="+jogo.getTentativas());
				}
				catch(NumberFormatException erro) {
					labelResultado.setText("digite somente numeros");
					return;
				}
				catch(Exception erro) {
					labelResultado.setText(erro.getMessage());
					return;
				}
				
				if(jogo.terminou()) {
					labelResultado.setText("resultado="+jogo.getResultadoFinal());
					button_1.setEnabled(false);
					textField.setEnabled(false);
				}
				else
					textField.requestFocus();		//cursor dentro da caixa

			}
		});
		button_1.setBounds(238, 11, 75, 23);
		add(button_1);

		button_2 = new JButton("Historico");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] numeros = jogo.getHistorico();
				String texto="";
				for(int i=0; i<jogo.getTentativas(); i++)
					texto+=numeros[i] + "   ";

				JOptionPane.showMessageDialog(null, "Historico:\n"+texto  );
			}
		});
		button_2.setEnabled(false);
		button_2.setBounds(323, 11, 96, 23);
		add(button_2);

		this.repaint();		//desenhar todos os componentes

	}










}
