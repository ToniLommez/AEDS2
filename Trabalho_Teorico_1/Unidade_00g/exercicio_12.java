/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_12 {
    /*
     * Faca um programa que leia a nota de 5 alunos e mostre na tela a media
     * das mesmas
     */
    public static void main(String[] args) {
        MyIO.print("Digite a nota dos alunos\n");
        int i = 0;
        float media = 0;
        while (i < 5) {
            MyIO.print("->");
            media += MyIO.readFloat();
            i++;
        }
        media /= i;
        MyIO.print("A media e: ");
        MyIO.print(media);
    }
}