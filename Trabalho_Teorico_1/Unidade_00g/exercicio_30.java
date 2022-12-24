/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_30 {
    /*
     * Faca um programa que leia dois Introducao ao Java de int e
     * mostre a uniao e a intercessao entre os elementos desses arrays
     */
    public static void main(String[] args) {
        MyIO.print("Digite o tamanho do array 1:\n->");
        int n1 = MyIO.readInt();
        int[] array1 = new int[n1];

        MyIO.print("Digite valores:\n");
        for (int i = 0; i < array1.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            array1[i] = MyIO.readInt();
        }

        MyIO.print("Digite o tamanho do array 2:\n->");
        int n2 = MyIO.readInt();
        int[] array2 = new int[n2];

        MyIO.print("Digite valores:\n");
        for (int i = 0; i < array2.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            array2[i] = MyIO.readInt();
        }
        
        // Mostrar Uniao
        MyIO.print("Uniao:\n");
        int maiorArray = (n1 > n2)?n1:n2;
        for (int i = 0; i < maiorArray; i++) {
            if (i < n1) {
                MyIO.print(array1[i]);
                MyIO.print(" ");
            }
            if (i < n2) {
                MyIO.print(array2[i]);
                MyIO.print(" ");
            }
        }
        MyIO.print("\n");
        
        MyIO.print("Intersecao:\n");
        // Mostrar Intersecao
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    MyIO.print(array1[i]);
                    MyIO.print(" ");
                }
            }
        }
    }
}