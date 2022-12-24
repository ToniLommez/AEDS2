/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_18 {
    /*
     * Faca um programa que leia a nota de 5 alunos e 
     * mostre na tela a media das mesmas usando o comando for
     */
    public static void main(String[] args) {
        MyIO.print("Digite a nota de 5 alunos:\n");
        float media = 0;
        for (int i = 0; i < 5; i++) {
            MyIO.print("->");
            media += MyIO.readFloat();
        }
        media /= 5;
        MyIO.print("A media e: ");
        MyIO.print(media);
    }
}