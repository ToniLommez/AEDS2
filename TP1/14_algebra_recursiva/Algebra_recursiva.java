/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 21/08/2022
 */

class Algebra_recursiva {

    /**
     * Metodo que testa se a String indica um FEOF, representado por um '0'
     * 
     * @param s String a ser testada
     * @return True se for '0'
     */
    public static boolean isFim(String s) {
        return (s.charAt(0) == '0');
    }

    /**
     * Metodo driver do metodo recursivo
     * Primeiro prepara a string para ser resolvida
     * em seguida chama o metodo recursivo
     * 
     * @param s expressao a ser resolvida
     * @return resultado da expressao em boolean
     */
    public static String algebraBooleana(String s) {
        // quantas variaveis existem?
        int variables = s.charAt(0) - '0';

        // iniciar um array para guardar variaveis
        int[] v = new int[variables];
        // recuperar parametros
        for (int i = 0; i < variables; i++) {
            v[i] = s.charAt(2 + (i * 2)) - '0';
        }

        // Reconstruir parametros
        // not(A) >> not(1)
        char c;
        String str = "";
        for (int i = 2 + (variables * 2); i < s.length(); i++) {
            c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                str += v[(c - 'A')];
            } else {
                str += c;
            }
        }

        // CHAMADA DO METODO RECURSIVO
        String temp = algebraBooleanaRec(str);
        String resp = "";
        resp += temp.charAt(0);
        return resp;
    }

    /**
     * Metodo de resolucao de String com algebra booleana
     * de forma recursiva
     * 
     * O metodo esta reenvia recursivamente a String com uma parte resolvida
     * ate que o todo tenha sido resolvido
     * 
     * E importante dizer que para utilizar este metodo a String precisa
     * estar tratada, por isso use o metodo algebraBooleana() para inicializa-la
     * 
     * @param s String a ser passada recursivamente
     * @return String com o ultimo parenteses resolvido
     */
    public static String algebraBooleanaRec(String s) {
        String resp = "";
        if (s.charAt(0) == '1' || s.charAt(0) == '0') {
            resp = s;
        } else {
            // procurar ultimo parenteses aberto
            int abertura = 0;
            for (int i = s.length() - 1; i > 0; i--) {
                if (s.charAt(i) == '(') {
                    abertura = i;
                    i = 0;
                }
            }

            // procurar parenteses fechado complementar
            int fechamento = 0;
            for (int i = abertura + 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    fechamento = i;
                    i = s.length();
                }
            }

            // descobrir e realizar operacao
            int apagarInicio = abertura;
            int apagarFim = fechamento;
            char resultado = '0';
            char temp = s.charAt(abertura - 1);
            switch (temp) {
                case 'd': // d = and
                    resultado = '1';
                    for (int i = abertura + 1; i < fechamento; i++) {
                        if (s.charAt(i) == '0') {
                            resultado = '0';
                        }
                    }
                    apagarInicio -= 3;
                    break;
                case 'r': // r = or
                    resultado = '0';
                    for (int i = abertura + 1; i < fechamento; i++) {
                        if (s.charAt(i) == '1') {
                            resultado = '1';
                        }
                    }
                    apagarInicio -= 2;
                    break;
                case 't': // t = not
                    if (s.charAt(abertura+1) == '0') {
                        resultado = '1';
                    } else {
                        resultado = '0';
                    }
                    apagarInicio -= 3;
                    break;
            }

            // substituir String
            for (int i = 0; i < apagarInicio; i++) {
                resp += s.charAt(i);
            }
            resp += resultado;
            for (int i = apagarFim+1; i < s.length(); i++) {
                resp += s.charAt(i);
            }
            resp = algebraBooleanaRec(resp);
        }
        return resp;
    }

    // Driver
    public static void main(String[] args) { // main
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        // Para cada linha de entrada, gerando uma de saida contendo a palavra
        // embaralhada
        for (int i = 0; i < numEntrada; i++) {
            MyIO.println(algebraBooleana(entrada[i]));
        }
    }
}