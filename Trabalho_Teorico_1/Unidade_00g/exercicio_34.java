/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_34 {
    /*
     * Faca um programa para ler um numero inteiro N e N elementos de um
     * array. Em seguida, se N for par mostrar na tela a soma do 1o e 2o
     * elemento, 3o e 4o, ...
     */
    public static void main(String[] args) {
        MyIO.print("Digite o tamanho do array:\n->");
        int n = MyIO.readInt();
        int[] array = new int[n];

        MyIO.print("Digite valores:\n");
        for (int i = 0; i < array.length; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            array[i] = MyIO.readInt();
        }

        // se for par printar a soma
        if (n % 2 == 0) {
            int temp1;
            int temp2;
            for (int i = 0; i < array.length; i = i + 2) {
                temp1 = array[i];
                temp2 = array[i+1];
                MyIO.print(temp1);
                MyIO.print(" + ");
                MyIO.print(temp2);
                MyIO.print(" = ");
                MyIO.print(temp1 + temp2);
                MyIO.print("\n");
            }
        }
    }
}