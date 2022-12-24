/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_9 {
    /*
     * Faca um metodo recursivo que receba 
     * um array de inteiros e os ordene
     */
    public static int[] selectionSort(int[] array) {
        return selectionSort(array, 0);
    }

    public static int[] selectionSort(int[] array, int i) {
        if (i < array.length) {
            int temp = array[i];
            int menor = temp;
            int menorIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < menor) {
                    menor = array[j];
                    menorIndex = j;
                }
            }
            array[i] = array[menorIndex];
            array[menorIndex] = temp;
            selectionSort(array, i + 1);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 6, 1};
        array = selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            MyIO.print(array[i]);
            MyIO.print(" ");
        }
    }
}
