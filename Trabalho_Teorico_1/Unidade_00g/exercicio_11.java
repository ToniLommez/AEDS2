/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_11 {
    /*
     * Faca um programa que mostre na tela o logaritmo na base 10 dos
     * números 1 a 10
     */
    public static void main(String[] args) {
        MyIO.print("Os logaritimos dos numeros entre 1 e 10 sao:\n");
        int count = 1;
        while (count <= 10) {
            MyIO.print(count);
            MyIO.print(" = ");
            MyIO.print(Math.log10(count));
            MyIO.print("\n");
            count++;
        }
    }
}