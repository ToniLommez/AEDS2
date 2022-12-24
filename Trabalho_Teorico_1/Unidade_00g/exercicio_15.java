/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_15 {
    /*
     * Faca um programa que leia um número inteiro N e mostre na tela os N
     * primeiros numeros da sequencia 1, 5, 12, 16, 23, 27, 34.
     */
    public static void main(String[] args) {
        MyIO.print("Digite quantos numeros mostrar:\n->");
        int n = MyIO.readInt();
        int i = 0;
        int count = 1;
        while (i < n) {
            MyIO.print(count);
            MyIO.print(" ");
            count += 4;
            i++;
            if (i < n) {
                MyIO.print(count);
                MyIO.print(" ");
                count += 7;
                i++;
            }
        }
    }
}