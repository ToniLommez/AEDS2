/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_8 {
    /*
     * Leia dois numeros reais e imprima a raiz cubica do menor e o logaritmo do
     * menor considerando o maior como a base desse logaritmo.
     */
    public static void main(String[] args) {
        MyIO.print("Digite dois numeros:\n");
        MyIO.print("-> ");
        float num1 = MyIO.readFloat();
        MyIO.print("-> ");
        float num2 = MyIO.readFloat();

        float maior;
        float menor;
        if (num1 > num2) {
            maior = num1;
            menor = num2;
        } else {
            menor = num1;
            maior = num2;
        }

        MyIO.print("raiz cubica do menor = ");
        MyIO.print(Math.cbrt(menor));
        MyIO.print("\n");
        MyIO.print("logaritimo do menor com maior como base = ");
        MyIO.print(Math.log(menor) / Math.log(maior));

    }
}