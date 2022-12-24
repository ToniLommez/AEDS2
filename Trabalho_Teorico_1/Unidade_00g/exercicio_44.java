/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_44 {
    /*
     * Faca um programa que leia duas matrizes com os mesmos numeros de
     * linhas e colunas, faca a soma das mesmas e imprima na tela a matriz
     * resultante
     */
    public static void main(String[] args) {
        MyIO.print("Digite o numero de Linhas:\n->");
        int l = MyIO.readInt();
        MyIO.print("Digite o numero de Colunas:\n->");
        int c = MyIO.readInt();
        int[][] matriz1 = new int[l][c];
        int[][] matriz2 = new int[l][c];
        int[][] soma    = new int[l][c];

        // Lendo matriz1
        MyIO.print("Digite valores da matriz 1:\n");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                MyIO.print(i);
                MyIO.print(" ");
                MyIO.print(j);
                MyIO.print(" -> ");
                matriz1[i][j] = MyIO.readInt();
            }
        }
        // Lendo matriz2
        MyIO.print("Digite valores da matriz 2:\n");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                MyIO.print(i);
                MyIO.print(" ");
                MyIO.print(j);
                MyIO.print(" -> ");
                matriz2[i][j] = MyIO.readInt();
            }
        }

        // Somando
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                soma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        // Printando
        MyIO.print("\n");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                MyIO.print(soma[i][j]);
                MyIO.print(" ");
            }
            MyIO.print("\n");
        }
    }
}