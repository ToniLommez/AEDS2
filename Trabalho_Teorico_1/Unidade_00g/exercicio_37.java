/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_37 {
    /*
     * Faca um programa que leia N numeros inteiros e
     * mostre na tela a soma do primeiro e do ultimo,
     * a do segundo e do penultimo, a do terceiro e do
     * antepenultimo, ...
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

        for (int i = 0, j = array.length-1; i <= j; i++, j--) {
            MyIO.print(i);
            MyIO.print(" + ");
            MyIO.print(j);
            MyIO.print(" = ");
            MyIO.print(i+j);
            MyIO.print("\n");
        }
    }
}