/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_54 {
    /*
     * Faca um programa para ler uma palavra. Em seguida, mostre a primeira
     * ocorrencia da letra A
     */
    public static void main(String[] args) {
        MyIO.print("Digite a String:\n->");
        String s = MyIO.readString();
        int caracteres = s.length();
        int indexDeA = -1;
        for (int i = 0; i < caracteres; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A') {
                indexDeA = i;
            }
        }

        MyIO.print("\n");
        if (indexDeA == -1) {
            MyIO.print("'A' nao esta inserido");
        } else {
            MyIO.print("Index de 'A': ");
            MyIO.print(indexDeA);
        }
    }
}