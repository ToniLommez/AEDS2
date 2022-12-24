/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_26 {
    /*
     * Faca um programa que leia dois arrays e mostre na tela seus
     * elementos intercalados
     */
    public static void main(String[] args) {
        MyIO.print("Digite o tamanho do array 1:\n->");
        int n1 = MyIO.readInt();
        int[] array1 = new int[n1];

        MyIO.print("Digite valores:\n");
        for (int i = 0; i < array1.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            array1[i] = MyIO.readInt();
        }

        MyIO.print("Digite o tamanho do array 2:\n->");
        int n2 = MyIO.readInt();
        int[] array2 = new int[n2];

        MyIO.print("Digite valores:\n");
        for (int i = 0; i < array2.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            array2[i] = MyIO.readInt();
        }

        int maiorArray = (n1 > n2)?n1:n2;
        for (int i = 0; i < maiorArray; i++) {
            if (i < n1) {
                MyIO.print(array1[i]);
                MyIO.print(" ");
            }
            if (i < n2) {
                MyIO.print(array2[i]);
                MyIO.print(" ");
            }
        }
    }
}