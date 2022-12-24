/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

class exercicio_2 {
    /*
     * Faca um programa que leia tres numeros reais representando os lados
     * de um triangulo e informe se seu triangulo e Equilatero, Isosceles ou
     * Escaleno
     */
    public static void main(String[] args) {
        MyIO.print("Digite os lados:\n");
        MyIO.print("1 ->");
        int lado1 = MyIO.readInt();
        MyIO.print("2 ->");
        int lado2 = MyIO.readInt();
        MyIO.print("3 ->");
        int lado3 = MyIO.readInt();

        if (lado1 == lado2 && lado2 == lado3) {
            MyIO.print("O triangulo e Equilatero");
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            MyIO.print("O triangulo e Isosceles");
        } else {
            MyIO.print("O triangulo e Escaleno");
        }
    }
}