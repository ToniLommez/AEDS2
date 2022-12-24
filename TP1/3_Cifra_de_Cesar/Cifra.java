/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 10/08/2022
 */

class Cifra {
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
     * Metodo que retorna se um caractere e maiusculo
     * 
     * @param c Caractere a testar
     * @return True se for uma letra maiuscula
     */
    public static boolean eMaiuscula(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    /**
     * Metodo que retorna se um caractere e minusculo
     * 
     * @param c Caractere a testar
     * @return True se for uma letra minuscula
     */
    public static boolean eMinuscula(char c) {
        return (c >= 'a' && c <= 'z');
    }

    /**
     * Metodo que retorna se um caractere e um digito
     * 
     * @param c Caractere a testar
     * @return True se for uma digito
     */
    public static boolean eDigito(char c) {
        return (c >= '0' && c <= '9');
    }

    /**
     * Metodo que recebe uma String e a criptografa
     * a partir do metodo da Cifra de Cesar com chave k=3
     * Este metodo desloca todos os caracteres em +3 na tabela ASCII
     * exemplo: abc >> def
     * 
     * @param s String a ser criptografada
     * @return String com criptografia de chave k=3
     */
    public static String encrypt(String s) {
        int x;
        int chave = 3;
        String criptografia = "";
        if (s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i) + chave;
            criptografia += (char) x;
        }
        return criptografia;
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