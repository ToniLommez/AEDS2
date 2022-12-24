/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_46 {
    /*
     * Faca um programa que leia os elementos de uma matriz e mostre a media
     * dos elementos
     */
    public static void main(String[] args) {
        MyIO.print("Digite o numero de Linhas:\n->");
        int l = MyIO.readInt();
        MyIO.print("Digite o numero de Colunas:\n->");
        int c = MyIO.readInt();
        int[][] matriz = new int[l][c];

        // Lendo
        MyIO.print("Digite valores:\n");
        int temp = 0;
        int media = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                MyIO.print(i);
                MyIO.print(" ");
                MyIO.print(j);
                MyIO.print(" -> ");
                temp = MyIO.readInt();
                media += temp;
                matriz[i][j] = temp;
            }
        }
        media /= l + c;

        // Printando media
        MyIO.print("\n");
        MyIO.print("A media dos elementos e:");
        MyIO.print(media);
    }
}