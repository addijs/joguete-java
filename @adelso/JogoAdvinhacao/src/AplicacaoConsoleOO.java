/**
 * IFPB - TSI/POO
 * Prof. Fausto Ayres
 * 
 * Jogo de advinhacao - aplicação console
 * 
 */

import java.util.Scanner;

public class AplicacaoConsoleOO {

	public static void main(String[] args) {
		System.out.println("JOGO DE ADVINHACAO - CONSOLE");
		Scanner teclado = new Scanner(System.in);
		JogoAdvinhacao jogo = new JogoAdvinhacao(99);	//99 é o limite

		int numero;
		String resultado;
		do{
			System.out.println("\nDigite um numero entre 0 e 99:");
			numero = teclado.nextInt();
			
			try {
				resultado = jogo.advinhar(numero);
				System.out.println(resultado);
			}
			catch(Exception erro) {
				System.out.println(erro.getMessage());
			}

		}while(!jogo.terminou());


		System.out.println("\nGAME OVER !!");
		System.out.println(jogo.getResultadoFinal());

		//imprimir historico
		int[] numeros = jogo.getHistorico();
		String texto="";
		for(int i=0; i<jogo.getTentativas(); i++)	
			texto+=numeros[i] + "   ";
		System.out.println("\nHistorico:"+texto);
	}

}
