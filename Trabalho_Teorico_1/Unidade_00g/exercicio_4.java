/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

class exercicio_4 {
    /*
     * Leia 10 numeros inteiros,
     * selecione o maior e imprima seu valor na tela.
     */
    public static void main(String[] args) {
        MyIO.print("Digite 10 numeros inteiros:\n");
        int num = MyIO.readInt();
        int maior = num;
        for (int i = 0; i < 9; i++) {
            num = MyIO.readInt();
            if (num > maior) {
                maior = num;
            }
        }
        MyIO.print("Maior = ");
        MyIO.print(maior);
    }
}