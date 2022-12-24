/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_21 {
    /*
     * Faca um programa que leia n numeros e os armazene em um array
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
        
        MyIO.print("\nValores salvos:\n");
        for (int i = 0; i < array.length; i++) {
            MyIO.print(array[i]);
            MyIO.print(" ");
        }
    }
}