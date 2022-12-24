/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_31 {
    /*
     * Declare um vetor com contendo os elementos 10, 5, 8, 2 e 8. Em seguida,
     * mostre os elementos contidos no array
     */
    public static void main(String[] args) {
        int[] array = {10, 5, 8, 2, 8};

        MyIO.print("Valores no array:\n");
        for (int i = 0; i < array.length; i++) {
            MyIO.print(array[i]);
            MyIO.print(" ");
        }
    }
}