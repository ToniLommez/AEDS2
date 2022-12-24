/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

class exercicio_5 {
    /*
     * Leia dois numeros. Se um deles for maior que 45, realize a soma dos
     * mesmos. Caso contrario, se os dois forem maior que 20,
     * realize a subtracao do maior pelo menor, senao, se um deles for menor do que
     * 10 e o outro
     * diferente de 0 realize a divisao do primeiro pelo segundo. Finalmente, se
     * nenhum dos casos solicitados for valido, mostre seu nome na tela.
     */
    public static void main(String[] args) {
        MyIO.print("Digite 2 numeros inteiros:\n");
        int num1 = MyIO.readInt();
        int num2 = MyIO.readInt();
        if (num1 > 45 || num2 > 45) {
            MyIO.print(num1 + num2);
        } else if (num1 > 20 && num2 > 20) {
            if (num1 > num2) {
                MyIO.print(num1 - num2);
            } else {
                MyIO.print(num2 - num1);
            }
        } else if ((num1 > 10 && num2 != 0) || (num2 > 10 && num1 != 0)) {
            MyIO.print(num1 / num2);
        } else {
            MyIO.print("Marcos Antonio Lommez Candido Ribeiro - 771157");
        }
    }
}