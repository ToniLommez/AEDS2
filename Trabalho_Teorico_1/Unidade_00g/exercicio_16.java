/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */
class exercicio_16 {
    /*
     * Faca um programa que leia um numero inteiro N indicando a nota maxima
     * em uma prova P. Em seguida, leia a nota de 20 alunos (entre 0 e N) e
     * mostre na tela: (i) a media da turma, (ii) o numero de alunos cuja nota foi
     * menor que a media da Universidade (suponha 60%) e (iii) a quantidade de
     * alunos com conceito A (mais de 90%).
     * 
     */
    public static void main(String[] args) {
        MyIO.print("Digite a nota maxima:\n->");
        int n = MyIO.readInt();
        
        float[] alunos = new float[20];
        float media = 0;
        float temp;
        for (int i = 0; i < 20; i++) {
            MyIO.print(i);
            MyIO.print(" -> ");
            temp = MyIO.readFloat();
            if (temp > n) {
                temp = n;
            }
            media += temp;
            alunos[i] = temp;
        }
        media /= 20;

        int reprovados = 0;
        int conceitoA = 0;
        for (int i = 0; i < 20; i++) {
            if (alunos[i] < (n*0.6)) {
                reprovados++;
            }
            if (alunos[i] >= (n*0.9)) {
                conceitoA++;
            }
        }

        MyIO.print("Media da turma = ");
        MyIO.print(media);
        MyIO.print("\n");
        MyIO.print("Numero de reprovados = ");
        MyIO.print(reprovados);
        MyIO.print("\n");
        MyIO.print("Numero de alunos com conceito A = ");
        MyIO.print(conceitoA);
        MyIO.print("\n");
    }
}