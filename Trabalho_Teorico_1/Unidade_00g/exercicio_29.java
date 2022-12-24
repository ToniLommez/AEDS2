/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_29 {
    /*
     * Faca um programa que receba um array e ordene os elementos desse
     * array
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

        // ordenando
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array [j-1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            MyIO.print(array[i]);
            MyIO.print(" ");
        }
    }
}