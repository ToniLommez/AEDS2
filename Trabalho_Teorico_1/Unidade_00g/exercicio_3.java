/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

class exercicio_3 {
    /*
     * Leia 3 numeros inteiros, selecione o menor e o maior e imprima os seus
     * respectivos valores na tela
     */
    public static void main(String[] args) {
        MyIO.print("Digite 3 numeros inteiros:\n");
        MyIO.print("1 -> ");
        int num1 = MyIO.readInt();
        MyIO.print("2 -> ");
        int num2 = MyIO.readInt();
        MyIO.print("3 -> ");
        int num3 = MyIO.readInt();

        int menor = num1;
        if (num2 < menor) {
            menor = num2;
        }
        if (num3 < menor) {
            menor = num3;
        }

        int maior = num1;
        if (num2 > maior) {
            maior = num2;
        }
        if (num3 > maior) {
            maior = num3;
        }

        MyIO.print("Maior = ");
        MyIO.print(maior);
        MyIO.print("\n");
        MyIO.print("Menor = ");
        MyIO.print(menor);

    }
}