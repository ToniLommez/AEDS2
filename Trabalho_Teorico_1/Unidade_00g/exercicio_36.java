/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_36 {
    /*
     * Faca um programa para ler um numero inteiro N e N elementos de um
     * array. Em seguida, calcular e mostrar o numero de elementos pares e o de
     * divisíveis por tres.
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

        int pares = 0;
        int divTres = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                pares++;
            }
            if (array[i] % 3 == 0) {
                divTres++;
            }
        }
        MyIO.print("\nElementos pares: ");
        MyIO.print(pares);
        MyIO.print("\nDivisiveis por tres: ");
        MyIO.print(divTres);
    }
}