/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_27 {
    /*
     * Faca um programa que leia um array, encontre e mostre na tela os
     * maior e o menor elementos
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

        int maior = array[0];
        int menor = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
            if (array[i] < menor) {
                menor = array[i];
            }
        }
        MyIO.print("\nMaior do array: ");
        MyIO.print(maior);
        MyIO.print("\nMenor do array: ");
        MyIO.print(menor);
    }
}