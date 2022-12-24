/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_20 {
    /*
     * Faca um programa que leia a nota e o nome de 5 alunos e mostre na tela
     * o nome daqueles que ficaram acima da media do grupo
     */
    public static void main(String[] args) {
        String[] nomes = new String[5];
        int[] notas = new int[5];
        float media = 0;
        MyIO.print("Digite o nome e nota de 5 alunos:\n");
        for (int i = 0; i < 5; i++) {
            MyIO.print("Nome ->");
            nomes[i] = MyIO.readLine();
            MyIO.print("Nota ->");
            notas[i] = MyIO.readInt();
            media += notas[i];
            MyIO.print("\n");
        }
        media /= 5;
        MyIO.print("Alunos acima da media:\n");
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > media) {
                MyIO.print(nomes[i]);
                MyIO.print("\n");
            }
        }
    }
}