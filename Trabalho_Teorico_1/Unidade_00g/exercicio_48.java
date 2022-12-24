/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_48 {
    /*
     * Faca um programa que leia os elementos de uma matriz e mostre a media
     * dos elementos de cada coluna
     */
    public static void main(String[] args) {
        MyIO.print("Digite o numero de Linhas:\n->");
        int l = MyIO.readInt();
        MyIO.print("Digite o numero de Colunas:\n->");
        int c = MyIO.readInt();
        int[][] matriz = new int[l][c];

        // Lendo e calculando media
        MyIO.print("Digite valores:\n");
        int temp = 0;
        int[] media = new int[l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                MyIO.print(i);
                MyIO.print(" ");
                MyIO.print(j);
                MyIO.print(" -> ");
                temp = MyIO.readInt();
                media[j] += temp;
                matriz[i][j] = temp;
            }
        }

        // Calculando media
        for (int i = 0; i < media.length; i++) {
            media[i] /= c;
        }

        // Printando media das colunas
        MyIO.print("A media dos elementos e:\n");
        for (int i = 0; i < media.length; i++) {
            MyIO.print(media[i]);
            MyIO.print(" ");
        }
    }
}