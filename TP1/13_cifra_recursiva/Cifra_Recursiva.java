/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 21/08/2022
 */

class Cifra_Recursiva {
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
     * Metodo Driver para o metodo recursivo de criptografia
     * utilizando chave k=3
     * 
     * @param s
     * @return
     */
    public static String encrypt(String s) {
        return encrypt(s, 0, "");
    }

    /**
     * Metodo que recebe uma String e a criptografa
     * a partir do metodo da Cifra de Cesar com chave k=3
     * Este metodo desloca todos os caracteres em +3 na tabela ASCII
     * exemplo: abc >> def
     * 
     * @param s    String a ser criptografada
     * @param i    charAt a ser criptografado
     * @param resp String criptografada recursivamente
     * @return String com criptografia de chave k=3
     */
    public static String encrypt(String s, int i, String resp) {
        if (i < s.length()) {
            int x = s.charAt(i) + 3;
            resp += (char) x;
            resp = encrypt(s, i + 1, resp);
        }
        return resp;
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

        // Para cada linha de entrada, gerando uma de saida contendo o a palavra cifrada
        // em chave 3
        for (int i = 0; i < numEntrada; i++) {
            MyIO.println(encrypt(entrada[i]));
        }
    }
}