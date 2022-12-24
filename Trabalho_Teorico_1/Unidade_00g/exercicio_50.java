/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_50 {
    /*
     * Faça um programa que leia uma string e
     * mostre se ela é composta apenas por dígitos
     */
    public static void main(String[] args) {
        MyIO.print("Digite a String:\n->");
        String s = MyIO.readString();
        boolean soPossuiDigitos = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '0' || s.charAt(i) >= '9') {
                soPossuiDigitos = false;
                i = s.length();
            }
        }
        MyIO.print(soPossuiDigitos ? "So possui digitos" : "Possui nao digito");
    }
}