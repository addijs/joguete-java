import java.util.Random;

public class JogoBatalhaTerrestre {
	private String[][] tabuleiro = new String[10][10];
	private int contadorTiros; 
	private int contadorAcertos;
	private int aux = 0;
	
	public JogoBatalhaTerrestre() {
		contadorTiros = 0;
		contadorAcertos = 0;
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				tabuleiro[x][y] = " . ";
			}
		}
		
		while(aux < 5) {
			int px, py;	
			Random random = new Random();
			px = random.nextInt(10);
			py = random.nextInt(10);
			if(tabuleiro[px][py] == " O ") continue;
			tabuleiro[px][py] = " O ";
			aux++;
		}
	}
	
	private boolean checarProximo(int linha, int coluna) {		
		for(int x = -1; x < 2; x++) {
			for(int y = -1; y < 2; y++) {
				try {
					if(this.tabuleiro[linha+x][coluna+y] == " O ") {
						return true;
					}	
				} catch(Exception err) {
					
				}
			}
		}
		
		return false;
	}
	
	public String getResultadoFinal() {
		String res = "";
		res = res + "Acertos: " + this.contadorAcertos + "\n";
		res = res + "Nº de tiros: " + this.contadorTiros + "\n";
		
		return res;
	}
	
	public boolean terminou() {
		if(this.contadorTiros == 5) return true;
		return false;
	}
	
	
	public String toString() {
		String stringTabuleiro = "";
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				stringTabuleiro+=tabuleiro[x][y];
			}
			stringTabuleiro+="\n";
		}
		
		return stringTabuleiro;
	}
	
	
	public String atirar(int linha, int coluna) {
		linha--;
		coluna--;
		
		if(this.tabuleiro[linha][coluna] == " O ") {
			this.contadorAcertos++;
			this.contadorTiros++;
			return "alvo";
		}
		
		if(this.checarProximo(linha, coluna) == true) {
			this.contadorTiros++;
			return "proximo";
		}
		
		this.contadorTiros++;
		return "distante";
		
	}
	
	public int getAcertos() {
		return this.contadorAcertos;
	}
	
	public int getTiros() {
		return this.contadorTiros;
	}
	
}