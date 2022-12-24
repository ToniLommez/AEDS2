/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_43 {
    /*
     * Faca um programa que leia os elementos de uma matriz com L linhas e C
     * colunas e mostre na tela os elementos da matriz Transposta
     */
    public static void main(String[] args) {
        MyIO.print("Digite o numero de Linhas:\n->");
        int l = MyIO.readInt();
        MyIO.print("Digite o numero de Colunas:\n->");
        int c = MyIO.readInt();
        int[][] matriz = new int[l][c];

        // Lendo
        MyIO.print("Digite valores:\n");
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                MyIO.print(i);
                MyIO.print(" ");
                MyIO.print(j);
                MyIO.print(" -> ");
                matriz[i][j] = MyIO.readInt();
            }
        }

        // Printando
        MyIO.print("\n");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < l; j++) {
                MyIO.print(matriz[j][i]);
                MyIO.print(" ");
            }
            MyIO.print("\n");
        }
    }
}