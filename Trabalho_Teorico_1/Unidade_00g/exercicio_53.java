/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_53 {
    /*
     * Faca um programa para ler uma palavra. Em seguida, mostre o numero de
     * caracteres da mesma e seu numero de caracteres maiusculos
     */
    public static void main(String[] args) {
        MyIO.print("Digite a String:\n->");
        String s = MyIO.readString();
        int caracteres = s.length();
        int maiusculos = 0;
        for (int i = 0; i < caracteres; i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                maiusculos++;
            }
        }
        
        MyIO.print("\n");
        MyIO.print("Numero de caracteres: ");
        MyIO.print(caracteres);
        MyIO.print("\n");
        MyIO.print("Numero de maiusculas: ");
        MyIO.print(maiusculos);
    }
}