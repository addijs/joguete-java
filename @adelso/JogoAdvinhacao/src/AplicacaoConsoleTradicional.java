/**
 * IFPB - TSI/POO
 * Prof. Fausto Ayres
 * 
 * Jogo de advinhacao - aplicação tradicional
 * 
 */
import java.util.Random;
/**
 * IFPB - TSI/POO
 * Prof. Fausto Ayres
 * 
 * AplicacaoConsoleTradicional de advinhacao
 * 
 */
import java.util.Scanner;

public class AplicacaoConsoleTradicional {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//sortear o numero
		int sorteio = new Random().nextInt(100);
		System.out.println("numero sorteado (teste):"+sorteio);

		
		System.out.println("digite um numero");
		int numero = teclado.nextInt();
		int tentativas=1;

		int[] historico = new int[6];
		historico[0] = numero;
		
		while (sorteio != numero && tentativas < 6) {
			if(sorteio > numero)
				System.out.println("tente novamente um numero maior");
			else
				System.out.println("tente novamente um numero menor");

			numero = teclado.nextInt();		
			historico[tentativas] = numero;
			tentativas++;
		}

		if(sorteio==numero) 
			System.out.println("Parabens, vc acertou com "+ tentativas +" tentativas");
		else
			System.out.println("Perdeu, terminaram as 6 tentativas !!");

		
		System.out.println("historico dos numeros");
		for(int i=0; i<tentativas; i++)
			System.out.println(historico[i]);

	}

}
