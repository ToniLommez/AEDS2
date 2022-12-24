/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_33 {
    /*
     * Faça um programa para ler N numeros inteiros, calcular a media deles e
     * mostrar aqueles que forem maiores que a media
     */
    public static void main(String[] args) {
        MyIO.print("Digite o tamanho do array:\n->");
        int n = MyIO.readInt();
        int[] array = new int[n];

        MyIO.print("Digite valores:\n");
        int temp;
        int media = 0;
        for (int i = 0; i < array.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            temp = MyIO.readInt();
            media += temp;
            array[i] = temp;
        }
        media /= n;

        MyIO.print("\nValores maiores que a media:\n");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > media) {
                MyIO.print(array[i]);
                MyIO.print(" ");
            }
        }
    }
}