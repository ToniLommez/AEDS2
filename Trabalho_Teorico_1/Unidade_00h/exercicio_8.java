/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_8 {
    /*
     * Faca um metodo recursivo que receba um string e retorne um numero
     * inteiro indicando a quantidade de caracteres
     * (NOT vogal) AND (NOT consoante maiuscula) da string
     * recebida como parametro
     */

    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? (char) (c - 32) : c;
    }

    public static boolean isUpper(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    public static boolean isConsoante(char c) {
        c = toUpper(c);
        return (c >= 'A' && c <= 'Z');
    }

    public static boolean isVogal(char c) {
        c = toUpper(c);
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static int contConsoanteMinuscula(String s) {
        return contConsoanteMinuscula(s, 0);
    }

    public static int contConsoanteMinuscula(String s, int i) {
        int cont = 0;
        if (i < s.length()) {
            if (isConsoante(s.charAt(i)) && !isUpper(s.charAt(i)) && !isVogal(s.charAt(i))) {
                cont++;
            }
            cont += contConsoanteMinuscula(s, i + 1);
        }
        return cont;
    }

    public static void main(String[] args) {
        String s1 = "testeTESTE123";
        MyIO.print(contConsoanteMinuscula(s1));
    }
}
