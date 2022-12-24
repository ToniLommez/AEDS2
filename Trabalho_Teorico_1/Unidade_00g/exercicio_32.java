/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_32 {
    /*
     * Faca um programa para ler a nota de cinco alunos, calcular e mostrar: a
     * soma e a media das mesmas e a menor nota
     */
    public static void main(String[] args) {
        int[] notas = new int[5];
        float soma = 0;
        float media = 0;

        // receber valores e calcular soma
        MyIO.print("Digite a nota de 5 alunos:\n");
        for (int i = 0; i < 5; i++) {
            MyIO.print("Nota -> ");
            notas[i] = MyIO.readInt();
            soma += notas[i];
        }

        // calcular media
        media = soma / 5;

        // calcular menor
        int menor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }

        MyIO.print("\nSoma das notas: ");
        MyIO.print(soma);
        MyIO.print("\nMedia das notas: ");
        MyIO.print(media);
        MyIO.print("\nMenor das notas: ");
        MyIO.print(menor);
    }
}