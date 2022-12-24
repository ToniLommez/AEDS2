/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_39 {
    /*
     * Faca um programa para ler dois vetores contendo N elementos cada. Em
     * seguida, mostre os elementos de forma intercalada
     */
    public static void main(String[] args) {
        MyIO.print("Digite o tamanho do array 1:\n->");
        int n1 = MyIO.readInt();
        int[] array1 = new int[n1];

        MyIO.print("Digite valores do array1:\n");
        for (int i = 0; i < array1.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            array1[i] = MyIO.readInt();
        }

        int[] array2 = new int[n1];
        MyIO.print("Digite valores do array 2:\n");
        for (int i = 0; i < array2.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            array2[i] = MyIO.readInt();
        }

        // Mostrar Uniao
        MyIO.print("Uniao:\n");
        for (int i = 0; i < n1; i++) {
            MyIO.print(array1[i]);
            MyIO.print(" ");
            MyIO.print(array2[i]);
            MyIO.print(" ");
        }
    }
}