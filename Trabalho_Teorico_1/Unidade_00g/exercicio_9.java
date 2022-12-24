/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_9 {
    /*
     * Leia 10 numeros inteiros, selecione o menor e o maior e imprima os seus
     * respectivos valores na tela.
     */
    public static void main(String[] args) {
        MyIO.print("Digite 10 numeros inteiros:\n");
        int num = MyIO.readInt();
        int maior = num;
        int menor = num;
        for (int i = 0; i < 9; i++) {
            num = MyIO.readInt();
            if (num > maior) {
                maior = num;
            }
            if (num < menor) {
                menor = num;
            }
        }
        MyIO.print("Maior = ");
        MyIO.print(maior);
        MyIO.print("\n");
        MyIO.print("Menor = ");
        MyIO.print(menor);
    }
}