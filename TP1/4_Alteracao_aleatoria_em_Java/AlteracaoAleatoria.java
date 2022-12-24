
/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 10/08/2022
 */

import java.util.Random;

class AlteracaoAleatoria {

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
     * Metodo que recebe uma String e troca um caractere por outro
     * exemplo:
     * String = teste, caractere1 = e, caractere2 = b
     * saida = tbstb
     * 
     * @param s          String a ser modificada
     * @param caractere1 Caractere de origem a ser substituido
     * @param caractere2 Caractere alvo a substituir
     * @return
     */
    public static String troca(String s, char caractere1, char caractere2) {
        String nova = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == caractere1) {
                nova += caractere2;
            } else {
                nova += s.charAt(i);
            }
        }
        return nova;
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

        Random gerador = new Random();
        gerador.setSeed(4);

        // Para cada linha de entrada, gerando uma de saida contendo a palavra
        // embaralhada
        for (int i = 0; i < numEntrada; i++) {
            char sorteio1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char sorteio2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            MyIO.println(troca(entrada[i], sorteio1, sorteio2));
        }

    }
}