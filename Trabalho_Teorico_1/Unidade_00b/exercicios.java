/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

class exercicios {
    /**
     * Metodo que recebe um array e um valor a ser procurado
     * se estiver dentro retorna true
     * 
     * @param array array a ser procurado
     * @param x     valor procurado
     * @return true se achou
     */
    public static boolean isInside(int[] array, int x) {
        boolean have = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                have = true;
            }
        }
        return have;
    }

    /**
     * Metodo que recebe um array sortido e um valor procurado
     * testa se o valor esta antes ou depois da metade
     * e estiver dentro retorna true
     * 
     * @param array array a ser procurado
     * @param x     valor procurado
     * @return true se achou
     */
    public static boolean isInsideSort(int[] array, int x) {
        boolean have = false;
        int length = array.length;
        int middle = (length / 2);
        if (x > array[middle]) {
            for (int i = middle; i < length; i++) {
                if (array[i] == x) {
                    have = true;
                }
            }
        } else {
            for (int i = middle; i >= 0; i--) {
                if (array[i] == x) {
                    have = true;
                }
            }
        }
        return have;
    }

    /**
     * Metodo que recebe um array e printa
     * 
     * @param array array a ser procurado
     * @print bigger maior valor no array
     * @print smaller menor valor no array
     */
    public static void printBiggerSmaller(int[] array) {
        int temp = array[0];
        int bigger = temp;
        int smaller = temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            if (temp > bigger) {
                bigger = temp;
            } else {
                if (temp < smaller) {
                    smaller = temp;
                }
            }
        }
        System.out.printf("Bigger  = %d\n", bigger);
        System.out.printf("Smaller = %d\n", smaller);
    }

    /**
     * O codigo mostrado transforma um caractere em inteiro
     * em seguida compara se o caractere e' uma vogal
     * a funcao retorna true se o caractere for uma vogal
     * 
     * @param c caractere a ser testado
     * @return true se for uma vogal
     */
    public static boolean doidao(char c) {
        boolean resp = false;
        int v = (int) c;
        if (v == 65 || v == 69 || v == 73 || v == 79 || v == 85 || v == 97 || v == 101 || v == 105 ||
                v == 111 || v == 117) {
            resp = true;
        }
        return resp;
    }

    /**
     * Metodo para transformar caractere minusculo em maiusculo
     * 
     * @param c caractere a ser transformado
     * @return caractere maiusculo
     */
    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c;
    }

    /**
     * Metodo para testar se um caractere e' uma vogal
     * O metodo primeiro transforma tudo em maiusculo para depois testar
     * 
     * @param c caractere a ser testado
     * @return True se for uma vogal
     */
    public static boolean isVogal(char c) {
        c = toUpper(c);
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    /**
     * Metodo que testa se valor e uma letra
     * esta entre A-Z ou a-z
     * 
     * @param c caractere a ser testado
     * @return True se for uma letra
     */
    public static boolean isLetra(char c) {
        return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');
    }

    /**
     * Metodo que testa se um caractere e consoante
     * utiliza os metodos isLetra e isVogal
     * 
     * @param c caractere a ser testado
     * @return True se for letra e nao for vogal
     */
    public static boolean isConsoante(char c) {
        return (isLetra(c) == true && isVogal(c) == false);
    }

    /**
     * Metodo recursivo que testa se a String inteira e consoante a partir de um
     * index
     * 
     * @param s String a ser testada
     * @param i index a ser testado
     * @return True se toda a string for consoante
     */
    public static boolean isConsoante(String s, int i) {
        boolean resp = true;
        if (i == s.length()) {
            resp = true;
        } else if (isConsoante(s.charAt(i)) == false) {
            resp = false;
        } else {
            resp = isConsoante(s, i + 1);
        }
        return resp;
    }

    public static void main(String[] args) {
        // inicializa e mostra o array
        int[] array1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.printf("Array:\n");
        for (int i = 0; i < array1.length; i++) {
            System.out.printf("%d ", array1[i]);
        }
        System.out.printf("\n\n");

        // mostra se array contem x
        System.out.printf("3 is inside = %s\n", isInside(array1, 3) ? "True" : "False");
        System.out.printf("10 is inside = %s\n", isInside(array1, 10) ? "True" : "False");
        System.out.printf("\n");

        // mostra se array sortido contem x
        System.out.printf("8 is inside = %s\n", isInside(array1, 8) ? "True" : "False");
        System.out.printf("12 is inside = %s\n", isInsideSort(array1, 12) ? "True" : "False");
        System.out.printf("\n");

        // mostra o maior e menor elemento do array
        printBiggerSmaller(array1);
        System.out.printf("\n");

        /**
         * O metodo construido acima ja realiza os requisitos de
         * diminuir as comparacoes com elementos do array
         */

        // Teste da questao 'O que o codigo abaixo faz?'
        System.out.printf("O que o codigo 'doidao' faz?\n");
        System.out.printf("Ele mostra se uma letra e maiuscula ou minuscula\n");
        System.out.printf("a = %s\n", doidao('a') ? "True" : "False");
        System.out.printf("z = %s\n", doidao('z') ? "True" : "False");
        System.out.printf("\n");

        // Teste da questao 'Um aluno desenvolveu o codigo abaixo, corrija-o:'
        System.out.printf("Corrija o codigo isConsoante\n");
        System.out.printf("String = 'abcd', index 0 = %s\n", isConsoante("abcd", 0) ? "True" : "False");
        System.out.printf("String = 'abcd', index 1 = %s\n", isConsoante("abcd", 1) ? "True" : "False");
        System.out.printf("\n");
    }
}