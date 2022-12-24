/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_49 {
    /*
     * Faca um programa que leia uma String e um caractere e
     * mostre na tela quantas vezes esse caractere aparece na String
     */
    public static void main(String[] args) {
        MyIO.print("Digite a String:\n->");
        String s = MyIO.readString();
        MyIO.print("Digite o caractere:\n->");
        char c = MyIO.readChar();
        boolean estaInserido = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                estaInserido = true;
                i = s.length();
            }
        }
        MyIO.print(estaInserido ? "Esta inserido" : "Nao esta inserido");
    }
}