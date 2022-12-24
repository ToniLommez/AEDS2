/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_13 {
    /*
     * Faca um programa que mostre os 10 primeiros numeros inteiros positivos.
     */
    public static void main(String[] args) {
        MyIO.print("Os 10 primeiros numeros positivos sao:\n");
        int i = 1;
        while (i<=10) {
            MyIO.print(i);
            MyIO.print(" ");
            i++;
        }
    }
}