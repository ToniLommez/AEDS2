/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_52 {
    /*
     * Faça um programa que leia uma string e
     * mostre se ela é um palíndromo
     * 
     * conteudo copiado do exemplo fornecido no slide
     */
    public static void main(String[] args) {
        MyIO.print("Digite a String:\n->");
        String s = MyIO.readLine();
        boolean resp = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                resp = false;
                i = s.length();
            }
        }
        System.out.println(resp);
    }
}