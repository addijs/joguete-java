import java.util.Random;

public class JogoBatalhaTerrestre {
	private String[][] tabuleiro_secreto = new String[10][10];
	private String[][] tabuleiro_publico = new String[10][10];
	private int contadorTiros; 
	private int contadorAcertos;
	private int aux = 0;
	
	//Construtor
	public JogoBatalhaTerrestre() {
		contadorTiros = 0;
		contadorAcertos = 0;
		
		//Matriz interna do jogo
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				tabuleiro_secreto[x][y] = " . ";
			}
		}
		
		//Matriz publica do jogador
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				tabuleiro_publico[x][y] = " . ";
			}
		}
		
		while(aux < 5) {
			int px, py;	
			Random random = new Random();
			px = random.nextInt(10);
			py = random.nextInt(10);
			if(tabuleiro_secreto[px][py] == " O " || tabuleiro_secreto[px][py] == " 1 ") continue;
			tabuleiro_secreto[px][py] = " O ";
			AddBorda(px,py);
			aux++;
		}
	}
	
	private void AddBorda(int linha, int coluna){
		for(int x = -1; x < 2; x++) {
			for(int y = -1; y < 2; y++) {
				try {
					if(this.tabuleiro_secreto[linha+x][coluna+y] == " . ") {
						this.tabuleiro_secreto[linha+x][coluna+y] = " 1 ";
					}	
				} catch(Exception err) {
					
				}
			}
		}
	}
	
	private boolean checarProximo(int linha, int coluna) {		
		if(this.tabuleiro_secreto[linha][coluna] == " 1 ")
			return true;
		return false;	
	}
	
	public boolean terminou() {
		if(this.getAcertos() == 5) return true;
		return false;
	}
	
	public String atirar(int linha, int coluna) {
		linha--;
		coluna--;
		
		if(this.tabuleiro_secreto[linha][coluna] == " O ") {
			this.contadorAcertos++;
			this.contadorTiros++;
			//Alvo marcado como acertado
			this.tabuleiro_secreto[linha][coluna] = " C ";
			this.tabuleiro_publico[linha][coluna] = " C ";
			return "alvo";
		}
		
		if(this.checarProximo(linha, coluna) == true) {
			this.contadorTiros++;
			this.tabuleiro_publico[linha][coluna] = " P ";
			return "proximo";
		}
		
		//Verifica se um alvo já foi acertado
		if(this.tabuleiro_secreto[linha][coluna] == " C ") {
			this.contadorTiros++;
			return "acertado";
		}
		
		this.contadorTiros++;
		this.tabuleiro_publico[linha][coluna] = " X ";
		return "distante";
		
	}
	public String getResultadoFinal() {
		String res = "";
		res = res + "Acertos: " + this.contadorAcertos + "\n";
		res = res + "Nº de tiros: " + this.contadorTiros + "\n";
		
		return res;
	}
	
	public int getAcertos() {
		return this.contadorAcertos;
	}
	
	public int getTiros() {
		return this.contadorTiros;
	}
	
	public String toString() {
		String stringTabuleiro = "\nLegenda:\nX - Tiro longe\nC - Tiro no alvo\nP - Tiro perto do alvo\n\n";
		stringTabuleiro+="       1  2  3  4  5  6  7  8  9  10\n";
		
		for(int x = 0; x < 10; x++) {
			if(x == 9) stringTabuleiro+=String.format(" %d : ", x+1);
			else stringTabuleiro+=String.format(" %d  : ", x+1);
			
			for(int y = 0; y < 10; y++) {
				
				stringTabuleiro+=tabuleiro_publico[x][y];
				
			}
			stringTabuleiro+="\n";
		}
		
		/*Matriz interna com os alvos visiveis
		*Comentar em produção!
		*/
		stringTabuleiro+="\n       1  2  3  4  5  6  7  8  9  10\n";
		for(int x = 0; x < 10; x++) {
			if(x == 9) stringTabuleiro+=String.format(" %d : ", x+1);
			else stringTabuleiro+=String.format(" %d  : ", x+1);
			
			for(int y = 0; y < 10; y++) {
				stringTabuleiro+=tabuleiro_secreto[x][y];
			}
			stringTabuleiro+="\n";
		}	
		//Retorno do ToString
		return stringTabuleiro;
	}
	
}
