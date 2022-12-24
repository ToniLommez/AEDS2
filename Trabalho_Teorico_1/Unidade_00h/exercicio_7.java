/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_7 {
    /*
     * Faca um metodo recursivo que receba um array de caracteres e
     * retorne um numero inteiro indicando a quantidade de vogais do mesmo
     * 
     * metodo copiado a partir do slide do exercicio
     */
    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? (char) (c - 32) : c;
    }

    public static boolean isUpper(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    public static int contVogais(String s) {
        return contVogais(s, 0);
    }

    public static int contVogais(String s, int i) {
        int cont = 0;
        if (i < s.length()) {
            if (isUpper(toUpper(s.charAt(i))) == true) {
                cont++;
            }
            cont += contVogais(s, i + 1);
        }
        return cont;
    }

    public static void main(String[] args) {
        String s1 = "testeTESTE123";
        MyIO.print(contVogais(s1));
    }
}
