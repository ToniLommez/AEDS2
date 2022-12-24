/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_17 {
    /*
     * Faca um programa que leia um numero inteiro n e
     * mostre na tela o n-esimo termo da sequencia de Fibonacci
     */
    public static void main(String[] args) {
        MyIO.print("Digite quantos numeros de fibonacci mostrar:\n->");
        int n1 = 1;
        int n2 = 1;
        int temp;
        int n = MyIO.readInt();
        if (n <= 0) {
            MyIO.print("");
        } else if (n == 1) {
            MyIO.print("1");
        } else if (n == 2) {
            MyIO.print("1 1 ");
        } else {
            MyIO.print("1 1 ");
            for (int i = 0; i < n-2; i++) {
                temp = n1;
                n1 = n2;
                n2 = n1 + temp;
                MyIO.print(n2);
                MyIO.print(" ");
            }
        }
    }
}