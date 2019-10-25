/**
 * IFPB - TSI/POO
 * Prof. Fausto Ayres
 * 
 * Jogo de advinhacao - regras do jogo
 * 
 */

import java.util.Random;

public class JogoAdvinhacao {
	private int tentativas;
	private int sorteio;
	private final int LIMITE_MAXIMO;
	private int[] historico ;

	public JogoAdvinhacao(int max){
		LIMITE_MAXIMO=max;
		tentativas=0;	
		Random random = new Random();
		sorteio = random.nextInt(LIMITE_MAXIMO+1);
		historico = new int[6];
		
		System.out.println("numero sorteado (teste):"+sorteio);
	}

	public String advinhar(int numero)  throws Exception {
		//validar numero fora da faixa
		if(numero<0 || numero>LIMITE_MAXIMO) 
			throw new Exception("o numero esta fora da faixa permitida= 0 e " +LIMITE_MAXIMO);

		//validar numero repetido
		if(ehRepetido(numero))
			throw new Exception("o numero ja foi tentado antes, tente outro");

		//obter resultado da jogada
		historico[tentativas]=numero;
		tentativas++;
		if(numero==sorteio)
			return "acertou";
		else {
			String dica="";
			if(numero < sorteio)
				dica+="tente um numero MAIOR";
			else
				dica+="tente um numero MENOR";
			if(Math.abs(numero - sorteio) <=5)
				dica+=", esta QUENTE";
			else
				dica+=", esta FRIO";

			return dica;
		}
	}

	public boolean terminou() {
		if(tentativas >0) {
			int ultimaTentativa = historico[tentativas-1];

			if(ultimaTentativa==sorteio)
				return true;
			else
				if(tentativas==6)
					return true;
				else
					return false;
		}
		else
			return false;
	}

	public String getResultadoFinal() {
		if(terminou()) {
			int ultimaTentativa = historico[tentativas-1];
			if(ultimaTentativa==sorteio) 
				return "Voce ganhou com " + tentativas + " tentativa(s)";
			else
				return "Voce perdeu, terminaram as 6 tentativas !!";
		}
		else
			return "jogo ainda em execucao";
	}

	private boolean ehRepetido(int numero) {
		//verificar se o numero encontra-se no historico
		for(int n : historico) {
			if(numero == n)
				return true;
		}
		return false;
	}


	public int getTentativas() {
		return tentativas;
	}

	public int getLimiteMaximo() {
		return LIMITE_MAXIMO;
	}

	public int[] getHistorico() {
		return historico;
	}
}

