/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_45 {
    /*
     * Facca um programa que leia os elementos de uma matriz quadrada com N
     * linhas e N colunas e mostre as diagonais principal e secundaria
     */
    public static void main(String[] args) {
        MyIO.print("Digite o numero de Linhas e Colunas:\n->");
        int n = MyIO.readInt();
        int[][] matriz = new int[n][n];

        // Lendo
        MyIO.print("Digite valores:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                MyIO.print(i);
                MyIO.print(" ");
                MyIO.print(j);
                MyIO.print(" -> ");
                matriz[i][j] = MyIO.readInt();
            }
        }

        // Printando diagonal principal
        MyIO.print("\n");
        MyIO.print("Diagonal principal:\n");
        for (int i = 0; i < n; i++) {
            MyIO.print(matriz[i][i]);
            MyIO.print(" ");
        }
        MyIO.print("\n");

        // Printando diagonal secundaria
        MyIO.print("\n");
        MyIO.print("Diagonal secundaria:\n");
        for (int i = 0; i < n; i++) {
            MyIO.print(matriz[n-i-1][i]);
            MyIO.print(" ");
        }
        MyIO.print("\n");
    }
}