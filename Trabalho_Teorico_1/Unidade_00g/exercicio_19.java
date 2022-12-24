/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_19 {
    /*
     * Faca um programa que leia a nota de 5 alunos e 
     * mostre na tela a media das notas cujo valor e maior ou igual a oitenta
     */
    public static void main(String[] args) {
        MyIO.print("Digite a nota de 5 alunos:\n");
        float media = 0;
        int count = 0;
        int temp;
        for (int i = 0; i < 5; i++) {
            MyIO.print("->");
            temp = MyIO.readInt();
            if (temp >= 80) {
                media += temp;
                count++;
            }
        }
        if (count > 0) {
            media /= count;
        }
        MyIO.print("A media dos maiores que 80 e: ");
        MyIO.print(media);
    }
}