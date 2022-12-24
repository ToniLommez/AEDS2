/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_38 {
    /*
     * Faca um programa que leia N numeros inteiros e mostre na tela a soma
     * daqueles que forem multiplos de tres
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

        int soma = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                soma += array[i];
            }
        }
        MyIO.print("\nSoma dos divisiveis por 3: ");
        MyIO.print(soma);
    }
}