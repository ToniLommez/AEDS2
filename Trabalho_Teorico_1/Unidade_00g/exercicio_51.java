/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_51 {
    /*
     * Faça um programa que leia uma string e
     * a converta para número inteiro
     * 
     * conteudo copiado do exemplo fornecido no slide
     */
    public static void main(String[] args) {
        MyIO.print("Digite a String:\n->");
        String s = MyIO.readString();
        int num = 0, tmp;
        for (int i = 0; i < s.length(); i++) {
            tmp = (int) (s.charAt(i) - 48);
            tmp *= (int) Math.pow(10, s.length() - i - 1);
            num += tmp;
        }
        MyIO.print(num);
    }
}