/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_6 {
    /*
     * Faça um método recursivo que receba um array de caracteres e
     * retorne um valor booleano indicando se esse é um palíndromo
     * 
     * metodo copiado a partir do slide do exercicio
     */
    public static boolean isPalindromo(String s) {
        return isPalindromo(s, 0);
    }

    public static boolean isPalindromo(String s, int i) {
        boolean resp;
        if (i >= s.length() / 2) {
            resp = true;
        } else if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            resp = false;
        } else {
            resp = isPalindromo(s, i + 1);
        }
        return resp;
    }

    public static void main(String[] args) {
        String s1 = "teste";
        String s2 = "testetset";
        MyIO.print(s1);
        MyIO.print(" = ");
        MyIO.print(isPalindromo(s1) ? "E palindromo" : "Nao e palindromo");
        MyIO.print("\n");
        MyIO.print(s2);
        MyIO.print(" = ");
        MyIO.print(isPalindromo(s2) ? "E palindromo" : "Nao e palindromo");
    }
}
