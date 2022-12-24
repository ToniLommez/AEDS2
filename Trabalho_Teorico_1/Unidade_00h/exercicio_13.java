/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_13 {
    /*
     * Pesquisar e implementar uma solucao recursiva para o problema das
     * Torres de Hanoi, dado o numero de pinos
     * 
     * resolucao retirada e adaptada de:
     * https://acervolima.com/programa-java-para-torre-de-hanoi/
     */

    // Funcao recursiva em java para resolver a torre de hanoi
    public static void hanoi(int n, char from_pino, char to_pino, char aux_pino) {
        if (n == 1) {
            System.out.println("Mover disco 1 do pino " + from_pino + " para o pino " + to_pino);
            return;
        }
        hanoi(n - 1, from_pino, aux_pino, to_pino);
        System.out.println("Mover disco " + n + " do pino " + from_pino + " para o pino " + to_pino);
        hanoi(n - 1, aux_pino, to_pino, from_pino);
    }

    public static void main(String args[]) {
        MyIO.print("Digite o numero de discos:\n->");
        int n = MyIO.readInt(); // Number de discos
        hanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods
    }
}