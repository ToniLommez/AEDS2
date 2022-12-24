/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

class exercicio_1 {
    /*
     * Faca um programa que leia a nota de um aluno e escreva na tela:
     * 'Parabens, muito bom' (se a nota >= 80)
     * 'Parabens, aprovado' (se a nota >= 70 && nota < 80)
     * e, caso contrário, 'Infelizmente, reprovado'
     */
    public static void main(String[] args) {
        MyIO.print("Digite a nota:\n->");
        int nota = MyIO.readInt();
        if (nota >= 80) {
            MyIO.print("Parabens, muito bom");
        } else if (nota >= 70) {
            MyIO.print("Parabens, aprovado");
        } else {
            MyIO.print("Infelizmente, reprovado");
        }
    }
}