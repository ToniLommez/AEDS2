/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 10/08/2022
 */

public class Palindromo {

	/**
	 * Metodo para testar se a String contem a palavra 'FIM'
	 * 
	 * @param s String a testar
	 * @return True se for 'FIM'
	 */
	public static boolean isFim(String s) {
		return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}

	/**
	 * Metodo que recebe uma String e testa se
	 * a mesma e' um palindromo, exemplo:
	 * arara, reviver, ama, ovo
	 * 
	 * @param s String a ser testada
	 * @return True se for um palindromo
	 */
	public static boolean ePalindromo(String s) {
		for (int i = 0, j = (s.length() - 1); i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	// Driver
	public static void main(String[] args) {
		String[] entrada = new String[1000];
		int numEntrada = 0;

		// Leitura da entrada padrao
		do {
			entrada[numEntrada] = MyIO.readLine();
		} while (isFim(entrada[numEntrada++]) == false);
		numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

		for (int i = 0; i < numEntrada; i++) {
			System.out.println(ePalindromo(entrada[i]) ? "SIM" : "NAO");
		}
	}
}
