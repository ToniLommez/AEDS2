/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

/**
 * Classe de controle e manipulacao de String
 * criada para a resolucao dessa atividade
 * 
 * Essa classe recebe a String a ser manipulada e
 * atraves de um "seek" anda para frente e para tras na String
 * podendo fazer isso de forma segura e nao procedural
 * 
 * O metodo utiliza utiliza um needle que aponta para o
 * caractere que esta sendo lido no momento
 * podendo andar para frente ou para tras, ou apenas
 * recuperar aquele que esta no na ponta da agulha
 */
class My_String {
    String s;
    int size = 0;
    int needle = 0;

    /**
     * Construtor padrao
     * 
     * @param temp String a ser salva
     */
    public My_String(String temp) {
        s = temp;
        if (temp != null) {
            size = temp.length();
        }
    }

    /**
     * Metodo para resetar a agulha
     * para o inicio da palavra
     */
    public void reset_needle() {
        needle = 0;
    }

    /**
     * Metodo que anda com a agulha 1 valor a frente
     * e retorna o valor contido na agulha
     * 
     * Caso ja esteja no ultimo valor retornara
     * o caractere atual
     * 
     * @return Proximo caractere na sequencia da String
     */
    public char next_value() {
        char value;
        if (needle + 1 == size) { // if have next
            value = s.charAt(needle);
        } else {
            value = s.charAt(needle); // finally return
            needle++;
            if (value == ' ') {
                value = next_value();
            }
        }
        return value;
    }

    /**
     * Realiza o metodo next_value() juntamente
     * com uma conversao do valor para um numero inteiro
     * 
     * Nao e um metodo seguro, devera ser utilizado
     * APENAS caso voce conheca o dado que esta lidando
     * 
     * @return Proximo caractere na sequencia da String convertido em Inteiro
     */
    public int next_value_int() {
        char value = next_value(); // next_value
        int value_int = value - '0'; // convert
        return value_int;
    }

    /**
     * Metodo que anda com a agulha 1 valor para tras
     * e retorna o valor contido na agulha
     * 
     * Caso ja esteja no primeiro valor retornara
     * o caractere atual
     * 
     * @return Caractere anterior na sequencia da String
     */
    public char previous_value() {
        char value;
        if (needle == 0) { // if have previous
            value = s.charAt(0);
        } else {
            value = s.charAt(needle); // finally return
            needle--;
            if (value == ' ') {
                value = previous_value();
            }
        }
        return value;
    }

    /**
     * Realiza o metodo previous_value() juntamente
     * com uma conversao do valor para um numero inteiro
     * 
     * Nao e um metodo seguro, devera ser utilizado
     * APENAS caso voce conheca o dado que esta lidando
     * 
     * @return Caractere anterior na sequencia da String convertido em Inteiro
     */
    public int previous_value_int() {
        char value = previous_value(); // previous_value
        int value_int = value - '0'; // convert
        return value_int;
    }

    /**
     * Metodo que conta quantos parenteses estao contidos
     * na String armazenada
     * 
     * O metodo nao faz a utilizacao da agulha para se mover na String
     * 
     * @return
     */
    public int count_parentheses() {
        int parentheses = 0;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '(') {
                parentheses++;
            }
        }
        return parentheses;
    }

    /**
     * Metodo que Recria a String armazenada
     * deletando tudo aquilo que esta anterior a agulha
     */
    public void pop_all_behind() { // delete all behind needle
        String temp = "";
        if (s.charAt(needle) == ' ') {
            this.next_value();
        }
        for (int i = ((needle == 0) ? needle : needle - 1); i < size; i++) {
            temp += s.charAt(i);
        }
        needle = 0;
        s = temp;
        size = s.length();
    }

    /**
     * Metodo que substitui caracteres alvos na String
     * por um novo valor, exemplo:
     * String = teste, a = e, b = x
     * saida; txstx
     * 
     * @param a Caractere a ser substituido
     * @param b Caractere a substituir
     */
    public void swap(char a, int b) {
        String temp = "";
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == a) {
                temp += b;
            } else {
                temp += s.charAt(i);
            }
        }
        s = temp;
    }

    /**
     * @return Retorna o valor apontado pela agulha no formato inteiro
     */
    public int int_at_needle() {
        return s.charAt(needle) - '0';
    }

    /**
     * Metodo que conta quantos numeros estao entre as posicoes
     * 'a' e 'b' na string
     * 
     * @param a posicao de inicio da procura
     * @param b posicao de final da procura
     * @return quantidade de numeros encontrados
     */
    public int numbers_between(int a, int b) {
        int numbers = 0;
        for (; a <= b; a++) {
            if (s.charAt(a) >= '0' && s.charAt(a) <= '9') {
                numbers++;
            }
        }
        return numbers;
    }

    /**
     * Metodo que substitui uma substring por um valor inteiro
     * Embora os valores e tratado como inteiro, ao ser inserido
     * e convertido em Char para se adaptar a string
     * 
     * @param init ponto de inicio
     * @param end  ponto de fim
     * @param swap valor a substituir a substring
     */
    public void swap_substring_to_int(int init, int end, int swap) { // delete all between
        String temp = "";
        for (int i = 0; i < init; i++) {
            temp += s.charAt(i);
        }

        temp += (char) (swap + '0');

        for (int i = end + 1; i < size; i++) {
            temp += s.charAt(i);
        }
        needle = 0;
        s = temp;
        size = s.length();
    }
}

class AlgebraBooleana {

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
     * Metodo de operacao booleana 'and'
     * o metodo opera recebendo um array com os valores
     * em formato de Inteiro, 0 ou 1
     * 
     * @param array array de valores a ser operado
     * @return True se todos os valores forem True/1
     */
    public static int and(int[] array) {
        int answer = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                answer = 0;
            }
        }
        return answer;
    }

    /**
     * Metodo de operacao booleana 'or'
     * o metodo opera recebendo um array com os valores
     * em formato de Inteiro, 0 ou 1
     * 
     * @param array array de valores a ser operado
     * @return True se qualquer um dos valores forem True/1
     */
    public static int or(int[] array) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                answer = 1;
            }
        }
        return answer;
    }

    /**
     * Metodo de operacao booleana 'Not'
     * Embora o metodo trabalhe recebendo um array
     * seu fim e avaliar apenas um unico valor
     * o motivo de receber um array e para evitar possiveis erros
     * e facilitar a escrita do codigo
     * 
     * os valores aceitos para operacao precisam estar em formato inteiro
     * 0 ou 1
     * 
     * @param array array com 1 valor a ser testado
     * @return True se for False/0, False se for True/1
     */
    public static int not(int[] value) {
        int answer;
        if (value[0] == 0) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }

    /**
     * Metodo que recebe uma operacao booleana no formato
     * 2 0 0 and(not(A) , not(B))
     * onde:
     * 2 > numero de variaveis
     * 0 0 > valor das variaveis
     * and/not/or > operacoes a realizar
     * A/B/C > variaveis
     * 
     * O metodo trabalha com a manipulacao da String para chegar a um valor final
     * sendo este o resultado da operacao booleana proposta
     * e por fim retorna seu resultado
     * 
     * @param tempArgs String com operacao a ser calculada
     * @return True/False de acordo com o resultado da operacao proposta
     */
    public static String algebraBooleana(String tempArgs) {
        My_String s = new My_String(tempArgs);

        // Recuperar parametros de dentro da String
        int variables = s.next_value_int(); // quantas variaveis existem?
        int[] variable_values = new int[variables]; // iniciar um array para guardar variaveis
        for (int i = 0; i < variables; i++) {
            variable_values[i] = s.next_value_int(); // recuperar parametros
        }

        // Contar o total de parenteses
        int total_parentheses = s.count_parentheses();

        // Reconstruir parametros
        // not(A) >> not(1)
        s.pop_all_behind();
        for (int i = 0; i < variables; i++) {
            s.swap((char) ('A' + i), variable_values[i]); // 'A'+i = A B C D...
        }

        // Aqui comeca a resolucao
        // Seleciona-se o parenteses mais interno e o resolve
        // ate que nao sobre mais nenhum
        //
        // Este metodo procura o ultimo parenteses aberto e o resolve de traz para frente
        int last_bracket; // posicao a ser resolvida
        int closing_bracket; // final da posicao
        int local_result;
        char temp_char;
        for (; total_parentheses > 0; total_parentheses--) {
            s.reset_needle();
            int temp = 0;
            for (int j = 0; j < total_parentheses;) { // procurar ultimo '('
                temp = s.next_value();
                if (temp == '(') {
                    j++;
                }
            }
            last_bracket = s.needle - 1;

            for (boolean found = true; found;) { // procura parenteses complementar ')'
                temp_char = s.next_value();
                if (temp_char == ')') {
                    found = false;
                }
            }
            closing_bracket = s.needle - 1;

            // Recuperar os valores dentro dos parenteses selecionado
            int numbers = s.numbers_between(last_bracket, closing_bracket);
            int[] to_calculate = new int[numbers];
            s.needle = last_bracket;
            for (int count = 0; count < numbers;) {
                temp = s.next_value_int();
                if (temp == 0 || temp == 1) {
                    to_calculate[count] = temp;
                    count++;
                }
            }

            // Calcular resultado e substituir
            // And(1, 0, 1) >> 0
            // Not(0) >> 1
            // 
            // Este metodo decide a operacao a partir da ultima letra
            // and = d, or = r, not = t
            // isso diminui a quantidade de movimentacoes e testes
            temp_char = s.s.charAt(last_bracket - 1);
            switch (temp_char) {
                case 'd':
                    local_result = and(to_calculate);
                    s.swap_substring_to_int(last_bracket - 3, closing_bracket, local_result);
                    break;
                case 'r':
                    local_result = or(to_calculate);
                    s.swap_substring_to_int(last_bracket - 2, closing_bracket, local_result);
                    break;
                case 't':
                    local_result = not(to_calculate);
                    s.swap_substring_to_int(last_bracket - 3, closing_bracket, local_result);
                    break;
            }
        }

        s.reset_needle(); // Reinicia a agulha para a proxima operacao
        String result = ""; // Cria o resultado a ser devolvido
        result += s.next_value(); // Atribui o resultado
        return (result);
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