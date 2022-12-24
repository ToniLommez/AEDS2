/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_28 {
    /*
     * Faca um programa que leia os elementos de um array de tamanho n e
     * mostre a posicao do menor elemento do array
     */
    public static void main(String[] args) {
        MyIO.print("Digite o tamanho do array:\n->");
        int n = MyIO.readInt();
        int[] array = new int[n];

        MyIO.print("Digite valores:\n");
        for (int i = 0; i < array.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            array[i] = MyIO.readInt();
        }

        int menor = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[menor]) {
                menor = i;
            }
        }
        MyIO.print("\nIndex do menor elemento: ");
        MyIO.print(menor);
    }
}