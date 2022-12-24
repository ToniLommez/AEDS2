/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_23 {
    /*
     * Faca um programa que leia n numeros e mostre a soma do i-esimo com o
     * (2*i+1)-esimo termo ate que (2*i+1) < n
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

        MyIO.print("\nSomas:\n");
        for (int i = 0; (2 * i + 1) < n; i++) {
            System.out.printf("%d + %d = %d\n", array[i], array[(2 * i + 1)], array[i] + array[(2 * i + 1)]);
        }
    }
}