/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_4 {
    /*
     * Faca um metodo recursivo que receba dois numeros inteiros e retorne a
     * multiplicacao do primeiro pelo segundo fazendo somas
     * 
     * metodo copiado a partir do slide do exercicio
     */
    public static int multiplicacao(int a, int b, int i) {
        int resp = 0;
        if (i < b) {
            resp = a + multiplicacao(a, b, i + 1);
        }
        return resp;
    }

    public static int multiplicacao(int a, int b) {
        return multiplicacao(a, b, 0);
    }

    public static void main(String[] args) {
        MyIO.print(multiplicacao(4, 3));
    }
}
