/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

class exercicio_6 {
    /*
     * Seja uma partida de futebol, leia os numeros de gols do mandante e do
     * visitante e imprima quem foi o vencedor ou se foi empate.
     */
    public static void main(String[] args) {
        MyIO.print("Digite o numero de gols:\n");
        MyIO.print("Time 1 -> ");
        int num1 = MyIO.readInt();
        MyIO.print("Time 2 -> ");
        int num2 = MyIO.readInt();
        if (num1 > num2) {
            MyIO.print("Time 1 ganhou");
        } else if (num2 > num1) {
            MyIO.print("Time 2 ganhou");
        } else {
            MyIO.print("Empate");
        }
    }
}