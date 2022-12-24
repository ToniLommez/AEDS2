/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_4 {
    /*
     * Faca o quadro de memoria e mostre a saida na tela
     */
    public static void passagemDeArray(int[] b) {
        for (int i = 0; i < 5; i++) {
            b[i] *= 5;
            System.out.printf("b[" + i + "]: " + b[i] + "\n");
        }
        b = new int[5];
        for (int i = 0; i < 5; i++) {
            b[i] = i;
            System.out.printf("b[" + i + "]: " + b[i] + "\n");
        }
    }

    public static void main(String[] args) {
        int[] y = new int[5];
        for (int i = 0; i < 5; i++) {
            y[i] = i;
            System.out.printf("y[" + i + "]: " + y[i] + "\n");
        }
        passagemDeArray(y);
        for (int i = 0; i < 5; i++) {
            System.out.printf("y[" + i + "]: " + y[i] + "\n");
        }
    }

}