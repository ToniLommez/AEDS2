/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_55 {
    /*
     * Faca um programa para ler uma palavra. Em seguida, mostre os numeros
     * de caracteres, letras, nao letras, vogais e consoantes.
     */
    public static void main(String[] args) {
        MyIO.print("Digite a String:\n->");
        String s = MyIO.readLine();
        int caracteres = s.length();
        int letras = 0;
        int naoLetras = 0;
        int vogais = 0;
        int consoantes = 0;
        char temp;
        for (int i = 0; i < caracteres; i++) {
            temp = s.charAt(i);
            if ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z')) {
                letras++;
                if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                    vogais++;
                } else if (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U' ) {
                    vogais++;
                } else {
                    consoantes++;
                }
            } else {
                naoLetras++;
            }
        }


        // printar quantidades
        MyIO.print("\n");
        MyIO.print("Numero de caracteres: ");
        MyIO.print(caracteres);
        MyIO.print("\n");
        MyIO.print("Numero de letras: ");
        MyIO.print(letras);
        MyIO.print("\n");
        MyIO.print("Numero de nao letras: ");
        MyIO.print(naoLetras);
        MyIO.print("\n");
        MyIO.print("Numero de vogais: ");
        MyIO.print(vogais);
        MyIO.print("\n");
        MyIO.print("Numero de consoantes: ");
        MyIO.print(consoantes);
    }
}