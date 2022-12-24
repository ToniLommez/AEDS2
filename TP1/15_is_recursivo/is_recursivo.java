/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 21/08/2022
 */

class is_recursivo {
    /**
     * Metodo para testar se string esta escrito 'FIM'
     * 
     * @param s String a ser testada
     * @return True se for 'FIM'
     */
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    /**
     * Transforma um caractere em maiusculo
     * 
     * @param c Caractere a ser transformado
     * @return Se este for minusculo, retornara em maiusculo
     */
    public static char toMaiusculo(char c) {
        return ((c >= 'a' && c <= 'z') ? (char) (c - 32) : c);
    }

    /**
     * Metodo Driver para o metodo recursivo eVogal
     * que testa se uma string possui apenas vogais
     * 
     * @param s String a ser testada se possui apenas vogais
     * @return True se for constituida apenas de vogais
     */
    public static boolean eVogal(String s) {
        return eVogal(s, 0);
    }

    /**
     * Metodo Recursivo que:
     * testa se uma String possui apenas vogais
     * Primeiro transforma em maiusculo para diminuir a quantidade de testes
     * 
     * @param s String a ser testada
     * @param i charAt a ser testado
     * @return True se todos os caracteres forem apenas vogais
     */
    public static boolean eVogal(String s, int i) {
        boolean eVogal;
        if (i == s.length()) {
            eVogal = true;
        } else {
            char c = toMaiusculo(s.charAt(i));
            if (!(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
                eVogal = false;
            } else {
                eVogal = eVogal(s, i + 1);
            }
        }
        return eVogal;
    }

    /**
     * Metodo Driver para o metodo recursivo eConsoante
     * que testa se uma string possui apenas consoantes
     * 
     * @param s String a ser testada se possui apenas consoantes
     * @return True se for constituida apenas de consoantes
     */
    public static boolean eConsoante(String s) {
        return eConsoante(s, 0);
    }

    /**
     * Metodo Recursivo que:
     * testa se uma String possui apenas consoantes
     * Primeiro transforma em maiusculo para diminuir a quantidade de testes
     * 
     * @param s String a ser testada
     * @param i charAt a ser testado
     * @return True se todos os caracteres forem apenas consoantes
     */
    public static boolean eConsoante(String s, int i) {
        boolean eConsoante;
        if (i == s.length()) {
            eConsoante = true;
        } else {
            char c = toMaiusculo(s.charAt(i));
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c <= 'A' || c >= 'Z') {
                eConsoante = false;
            } else {
                eConsoante = eConsoante(s, i + 1);
            }
        }
        return eConsoante;
    }

    /**
     * Metodo Driver para o metodo recursivo eInteiro
     * que testa se uma string e' um numero inteiro
     * 
     * @param s String a ser testada se possui apenas numeros
     * @return True se for constituida apenas de numeros
     */
    public static boolean eInteiro(String s) {
        return eInteiro(s, 0);
    }

    /**
     * Metodo Recursivo que:
     * testa se uma String e' um numero inteiro
     * 
     * @param s String a ser testada
     * @param i charAt a ser testado
     * @return True se todos os caracteres forem apenas vogais
     */
    public static boolean eInteiro(String s, int i) {
        boolean eInteiro;
        if (i == s.length()) {
            eInteiro = true;
        } else {
            char c = toMaiusculo(s.charAt(i));
            if (c < '0' || c > '9') {
                eInteiro = false;
            } else {
                eInteiro = eInteiro(s, i + 1);
            }
        }
        return eInteiro;
    }

    /**
     * Metodo Driver para o metodo recursivo eReal
     * que testa se uma string e' um numero real
     * ou seja, pode possui '.' ou ',' mas nao mais do que 1 desses simbolos
     * 
     * @param s String a ser testada se possui apenas numeros
     * @return True se for constituida apenas de numeros
     */
    public static boolean eReal(String s) {
        return eReal(s, 0, 0);
    }

    /**
     * Metodo Recursivo que:
     * testa se uma String e' um numero real
     * pode ou nao possuir '.' ou ',' mas nao mais do que 1
     * 
     * @param s String a ser testada
     * @param i charAt a ser testado
     * @return True se todos os caracteres forem apenas vogais
     */
    public static boolean eReal(String s, int i, int pontos) {
        boolean eReal;
        if (i == s.length()) {
            eReal = true;
        } else {
            char c = toMaiusculo(s.charAt(i));
            // se nao extrapolou os pontos ou se nao for digito e nem ponto/virgula
            if (((c < '0' || c > '9') && !(c == '.' || c == ',')) || (pontos > 1)) {
                eReal = false;
            } else {
                if (c == '.' || c == ',') {
                    eReal = eReal(s, i + 1, pontos + 1);
                } else {
                    eReal = eReal(s, i + 1, pontos);
                }
            }
        }
        return eReal;
    }

    // Driver
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        // Para cada linha de entrada, gerando uma de saida contendo o a palavra cifrada
        // em chave 3
        for (int i = 0; i < numEntrada; i++) {
            MyIO.print(eVogal(entrada[i]) ? "SIM" : "NAO");
            MyIO.print(" ");
            MyIO.print(eConsoante(entrada[i]) ? "SIM" : "NAO");
            MyIO.print(" ");
            MyIO.print(eInteiro(entrada[i]) ? "SIM" : "NAO");
            MyIO.print(" ");
            MyIO.print(eReal(entrada[i]) ? "SIM" : "NAO");
            MyIO.print("\n");
        }
    }
}