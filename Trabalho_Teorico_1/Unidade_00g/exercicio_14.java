/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_14 {
    /*
     * Faca um programa que leia um numero inteiro N e mostre na tela os N
     * primeiros numeros inteiros impares.
     */
    public static void main(String[] args) {
        MyIO.print("Digite quantos numeros impares mostrar:\n->");
        int n = MyIO.readInt();
        int i = 0;
        int count = 0;
        while (count < n) {
            if (i % 2 != 0) {
                MyIO.print(i);
                MyIO.print(" ");
                count++;
            }
            i++;
        }
    }
}