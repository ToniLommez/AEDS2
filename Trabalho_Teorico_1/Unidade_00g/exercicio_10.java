/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_10 {
    /*
     * Faca um programa que mostre na tela os 10 primeiros numeros pares
     */
    public static void main(String[] args) {
        MyIO.print("Os 10 primeiros numeros pares sao:\n");
        int count = 0;
        int num = 0;
        while (count < 10) {
            if ((num % 2) == 0) {
                MyIO.print(num);
                MyIO.print(" ");
                count++;
            }
            num++;
        }
    }
}