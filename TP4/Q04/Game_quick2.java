/*
 * Aluno: Marcos Antonio Lommez Candido Ribeiro
 * Matricula: 771157
 * Data: 03/10/2022
 */

import java.io.*;
import java.util.*;

class Games {
    private int app_id;
    private String name;
    private String release_date;
    private int dia;
    private String owner;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;

    /**
     * Construtor padrao da classe
     */
    Games() {
        this.app_id = 0;
        this.name = null;
        this.release_date = null;
        this.dia = 0;
        this.owner = null;
        this.age = 0;
        this.price = 0;
        this.dlcs = 0;
        this.website = null;
        this.windows = false;
        this.mac = false;
        this.linux = false;
        this.upvotes = 0;
        this.avg_pt = 0;
        this.developers = null;
    }

    /**
     * Construtor com inicializacao de todos os argumentos
     */
    Games(int app_id, String name, String release_date, String owner, int age, float price, int dlcs,
            String[] languages,
            String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers,
            String[] genres) {
        this.app_id = app_id;
        this.name = name;
        this.release_date = release_date;
        this.dia = 0;
        this.owner = owner;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg_pt = avg_pt;
        this.developers = developers;
        this.genres = genres;
    }

    /**
     * Metodo de inicializacao das variaveis
     * E' importante entender que mesmo padronizado muitos jogos a serem cadastrados
     * chegam com erros de
     * entrada e por isso precisam de tratamento especial, como por exemplo
     * jogos onde o dia de lancamento nao e' conhecido, jogos que possum virgula no
     * nome e etc...
     * 
     * @param steam String com padrao de saida da Steam contendo todos os dados
     *              tabulados por ',' e '[]'
     */
    public void ler(String steam) {
        // Criacao das variaveis para tratamento e depois atribuicao
        int app_id;
        String name;
        String release_date;
        String owner;
        int age;
        float price;
        int dlcs;
        String[] languages;
        String website;
        boolean windows;
        boolean mac;
        boolean linux;
        float upvotes;
        int avg_pt;
        String developers;
        String[] genres;
        int dia;

        // Este metodo utiliza uma variavel needle para andar pela frase
        int needle = 0;
        String temp;

        // app_id
        temp = "";
        for (; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        app_id = Integer.parseInt(temp);

        // name
        temp = "";
        if (steam.charAt(needle + 1) == '\"') {
            for (needle += 2; steam.charAt(needle) != '\"'; needle++) {
                temp += steam.charAt(needle);
            }
            name = temp;
            for (needle++; steam.charAt(needle) != ','; needle++) {
                // ir ate a virgula
            }
        } else {
            for (needle++; steam.charAt(needle) != ','; needle++) {
                temp += steam.charAt(needle);
            }
            name = temp;
        }

        // release_date
        temp = "";
        String tempdia = "";
        if (steam.charAt(needle + 1) == '\"') {
            for (needle++; steam.charAt(needle) != ','; needle++) {
                temp += steam.charAt(needle);
            }
            release_date = "";
            release_date += temp.charAt(1);
            release_date += temp.charAt(2);
            release_date += temp.charAt(3);
            release_date += "/";
            tempdia += temp.charAt(5);
            if (temp.length() == 7) {
                tempdia += temp.charAt(6);
            }
            dia = Integer.parseInt(tempdia);
            temp = "";
            for (needle++; steam.charAt(needle) != ','; needle++) {
                temp += steam.charAt(needle);
            }
            release_date += temp.charAt(1);
            release_date += temp.charAt(2);
            release_date += temp.charAt(3);
            release_date += temp.charAt(4);
        } else {
            for (needle++; steam.charAt(needle) != ','; needle++) {
                temp += steam.charAt(needle);
            }
            release_date = "";
            release_date += temp.charAt(0);
            release_date += temp.charAt(1);
            release_date += temp.charAt(2);
            release_date += "/";
            release_date += temp.charAt(4);
            release_date += temp.charAt(5);
            release_date += temp.charAt(6);
            release_date += temp.charAt(7);
            dia = 1;
        }

        // owner
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        owner = temp;

        // age
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        age = Integer.parseInt(temp);

        // price
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        price = Float.parseFloat(temp);

        // dlcs
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        dlcs = Integer.parseInt(temp);

        // languages
        temp = "";
        int casas = 0;
        int needle_tmp = needle;
        if (steam.charAt(needle + 2) != ']') {
            for (needle_tmp++; steam.charAt(needle_tmp) != ']'; needle_tmp++) {
                if (steam.charAt(needle_tmp) == ',') {
                    casas++;
                }
            }
            casas++; // transformar numero de virgulas em numero de linguas
            // BUG HARDFIX, um dos jogos possui entrada anomala
            if (steam.charAt(needle_tmp + 1) == '[') {
                casas = 5;
            }
            languages = new String[casas];
            for (int i = 0; i < casas; i++) {
                temp = "";
                // procurar por aspas de abertura
                for (needle++; steam.charAt(needle) != '\''; needle++) {
                }
                for (needle++; steam.charAt(needle) != '\''; needle++) {
                    temp += steam.charAt(needle);
                }
                languages[i] = "";
                for (int j = 0; j < temp.length(); j++) {
                    languages[i] += temp.charAt(j);
                }
            }
        } else {
            languages = null;
        }
        for (needle++; steam.charAt(needle) != ','; needle++) {
            // ir ate a virgula
        }

        // website
        if (steam.charAt(needle + 1) == '\"') {
            temp = "";
            for (needle += 2; steam.charAt(needle) != '\"'; needle++) {
                temp += steam.charAt(needle);
            }
            website = temp;
            for (needle++; steam.charAt(needle) != ','; needle++) {
                // ir ate a virgula
            }
        } else {
            temp = "";
            for (needle++; steam.charAt(needle) != ','; needle++) {
                temp += steam.charAt(needle);
            }
            website = temp;
        }

        // windows
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        if (temp.charAt(0) == 'F') {
            windows = false;
        } else {
            windows = true;
        }

        // mac
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        if (temp.charAt(0) == 'F') {
            mac = false;
        } else {
            mac = true;
        }

        // linux
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        if (temp.charAt(0) == 'F') {
            linux = false;
        } else {
            linux = true;
        }

        // upvotes
        float totalUpVotes;
        float totalOtherVotes;
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        totalUpVotes = Float.parseFloat(temp);
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        totalOtherVotes = Float.parseFloat(temp);
        upvotes = totalUpVotes / (totalOtherVotes + totalUpVotes);

        // avg_pt
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        avg_pt = Integer.parseInt(temp);

        // developers
        temp = "";
        casas = 0;
        needle++; // comecar a contar das aspas duplas
        needle_tmp = needle;
        if (steam.charAt(needle_tmp) == '\"') {
            for (needle_tmp++; steam.charAt(needle_tmp) != '\"'; needle_tmp++) {
                if (steam.charAt(needle_tmp) == ',') {
                    casas++;
                }
            }
        }
        casas++; // transformar numero de virgulas em numero de desenvolvedores
        developers = "";
        for (int i = 0; i < casas; i++) {
            temp = "";
            for (needle += (steam.charAt(needle_tmp) == '\"') ? 1 : 0; steam.charAt(needle) != ','
                    && steam.charAt(needle) != '\"'; needle++) {
                temp += steam.charAt(needle);
            }
            developers += temp;
            if (i < casas - 1) {
                developers += ",";
            }
        }
        if (casas > 1) {
            for (needle++; steam.charAt(needle) != ','; needle++) {
                // ir ate a virgula
            }
        }

        // genres
        temp = "";
        if (needle + 1 < steam.length()) {
            casas = 0;
            needle++; // comecar a contar das aspas duplas
            needle_tmp = needle;
            if (steam.charAt(needle_tmp) == '\"') {
                for (needle_tmp++; steam.charAt(needle_tmp) != '\"'; needle_tmp++) {
                    if (steam.charAt(needle_tmp) == ',') {
                        casas++;
                    }
                }
            }
            casas++; // transformar numero de virgulas em numero de generos
            genres = new String[casas];
            for (int i = 0; i < casas; i++) {
                temp = "";
                for (needle += (steam.charAt(needle_tmp) == '\"') ? 1 : 0; needle < steam.length()
                        && steam.charAt(needle) != ',' && steam.charAt(needle) != '\"'; needle++) {
                    temp += steam.charAt(needle);
                }
                genres[i] = "";
                for (int j = 0; j < temp.length(); j++) {
                    genres[i] += temp.charAt(j);
                }
            }
        } else {
            genres = new String[casas];
        }

        // Atribuicao das variaveis do metodo para as variaveis da classe
        this.set_app_id(app_id);
        this.set_name(name);
        this.set_release_date(release_date);
        this.set_owner(owner);
        this.set_age(age);
        this.set_price(price);
        this.set_dlcs(dlcs);
        this.set_languages(languages);
        this.set_website(website);
        this.set_windows(windows);
        this.set_mac(mac);
        this.set_linux(linux);
        this.set_upvotes(upvotes);
        this.set_avg_pt(avg_pt);
        this.set_developers(developers);
        this.set_genres(genres);
        this.set_dia(dia);
    }

    /**
     * Metodo para transformacao da classe em String printavel
     * Possui alguns tratamentos como:
     * Se a String nao possuir valor cadastrado sera retornado "null"
     */
    public String toString() {
        // Encapsulamento das linguas em chaves
        String lang = "[";
        if (languages != null) {
            for (int i = 0; i < languages.length; i++) {
                lang += languages[i];
                if (i < languages.length - 1) {
                    lang += ", ";
                }
            }
            lang += "]";
        } else {
            lang += "]";
        }
        int percentUpVotes = Math.round(upvotes * 100);

        // Encapsulamento dos generos em chaves
        String genero = "[";
        for (int i = 0; i < genres.length; i++) {
            genero += genres[i];
            if (i < genres.length - 1) {
                genero += ", ";
            } else {
                genero += "]";
            }
        }

        // Transformacao de String varia em "null"
        String name_tmp = name;
        if (name == "") {
            name_tmp = "null";
        }
        String release_date_tmp = release_date;
        if (release_date == "") {
            release_date_tmp = "null";
        }
        String owner_tmp = owner;
        if (owner == "") {
            owner_tmp = "null";
        }
        String website_tmp = website;
        if (website == "") {
            website_tmp = "null";
        }
        String developers_tmp = developers;
        if (developers == "") {
            developers_tmp = "null";
        }
        String price_tmp = "";
        price_tmp += Float.toString(price);
        if (price_tmp.charAt(price_tmp.length() - 1) == '0') {
            price_tmp += '0';
        }

        // Transformacao dos minutos totais em horas
        // Sera printado apenas os valores que existirem
        // Se nao existir minuto sera printado so Hora, e vice-versa
        String hours_tmp = "";
        if (avg_pt != 0) {
            int avg_pt_min = avg_pt % 60;
            int avg_pt_hour = (avg_pt - avg_pt_min) / 60;
            if (avg_pt_hour > 0) {
                hours_tmp += avg_pt_hour + "h";
            }
            if (avg_pt_hour > 0 && avg_pt_min > 0) {
                hours_tmp += " ";
            }
            if (avg_pt_min > 0) {
                hours_tmp += avg_pt_min + "m";
            }
        } else {
            hours_tmp = "null";
        }

        // Construcao da frase
        return app_id + " " +
                name_tmp + " " +
                release_date_tmp + " " +
                owner_tmp + " " +
                age + " " +
                price_tmp + " " +
                dlcs + " " +
                lang + " " +
                website_tmp + " " +
                windows + " " +
                mac + " " +
                linux + " " +
                percentUpVotes + "% " +
                hours_tmp + " " +
                developers_tmp + " " +
                genero;
    }

    /**
     * ------------------------------------------------
     * Inicio dos metodos SET
     * ------------------------------------------------
     */
    public void set_app_id(int app_id) {
        this.app_id = app_id;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_release_date(String release_date) {
        this.release_date = release_date;
    }

    public void set_dia(int dia) {
        this.dia = dia;
    }

    public void set_owner(String owner) {
        this.owner = owner;
    }

    public void set_age(int age) {
        this.age = age;
    }

    public void set_price(float price) {
        this.price = price;
    }

    public void set_dlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void set_new_languages(int size) {
        this.languages = new String[size];
    }

    public void set_languages(String[] languages) {
        this.languages = languages;
    }

    public void set_languages(String language, int index) {
        this.languages[index] = language;
    }

    public void set_website(String website) {
        this.website = website;
    }

    public void set_windows(boolean windows) {
        this.windows = windows;
    }

    public void set_mac(boolean mac) {
        this.mac = mac;
    }

    public void set_linux(boolean linux) {
        this.linux = linux;
    }

    public void set_upvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    public void set_avg_pt(int avg_pt) {
        this.avg_pt = avg_pt;
    }

    public void set_developers(String developers) {
        this.developers = developers;
    }

    public void set_new_genres(int size) {
        this.genres = new String[size];
    }

    public void set_genres(String[] genres) {
        this.genres = genres;
    }

    public void set_genres(String genre, int index) {
        this.genres[index] = genre;
    }

    /**
     * ------------------------------------------------
     * Inicio dos metodos GET
     * ------------------------------------------------
     */
    public int get_app_id() {
        return this.app_id;
    }

    public String get_name() {
        return this.name;
    }

    public String get_release_date() {
        return this.release_date;
    }

    public int get_dia() {
        return this.dia;
    }

    public String get_owner() {
        return this.owner;
    }

    public int get_age() {
        return this.age;
    }

    public float get_price() {
        return this.price;
    }

    public int get_dlcs() {
        return this.dlcs;
    }

    public String[] get_languages() {
        return this.languages;
    }

    public String get_website() {
        return this.website;
    }

    public boolean get_windows() {
        return this.windows;
    }

    public boolean get_mac() {
        return this.mac;
    }

    public boolean get_linux() {
        return this.linux;
    }

    public float get_upvotes() {
        return this.upvotes;
    }

    public int get_avg_pt() {
        return this.avg_pt;
    }

    public String get_developers() {
        return this.developers;
    }

    public String[] get_genres() {
        return this.genres;
    }

    /**
     * Metodo de clonagem
     * 
     * @return Um objeto clonado identico ao referenciado
     */
    public Games clone() {
        Games game = new Games();
        game.set_app_id(this.app_id);
        game.set_name(this.name);
        game.set_release_date(this.release_date);
        game.set_owner(this.owner);
        game.set_age(this.age);
        game.set_price(this.price);
        game.set_dlcs(this.dlcs);
        game.set_website(this.website);
        game.set_windows(this.windows);
        game.set_mac(this.mac);
        game.set_linux(this.linux);
        game.set_upvotes(this.upvotes);
        game.set_avg_pt(this.avg_pt);
        game.set_developers(this.developers);

        if (this.languages != null) {
            game.set_new_languages(this.languages.length);
            for (int i = 0; i < this.languages.length; i++) {
                game.set_languages(this.languages[i], i);
            }
        }

        if (this.genres != null) {
            game.set_new_genres(this.genres.length);
            for (int i = 0; i < this.genres.length; i++) {
                game.set_genres(this.genres[i], i);
            }
            game.set_genres(this.genres);
        }

        return game;
    }
}

class Node {
    Games game;
    Node prev;
    Node next;
}

class ListaGames {
    // Para lista normal
    Node inicio;
    Node fim;
    int length = 0;
    int comparacoes = 0;
    int movimentacoes = 0;

    ListaGames() {
        this.inicio = this.fim = new Node();
        this.length = 0;
        this.comparacoes = 0;
        this.movimentacoes = 0;
    }

    public void insertEnd(Games novo) {
        Node novoNode = new Node();
        novoNode.game = novo;
        this.fim.next = novoNode;
        novoNode.prev = this.fim;
        this.fim = novoNode;
        length++;

        // limpeza
        novo = null;
    }

    public void printAll() {
        Node tmp = this.inicio.next;
        while (tmp.next != null) {
            System.out.printf("%s\n", tmp.game.toString());
            tmp = tmp.next;
        }
        System.out.printf("%s\n", tmp.game.toString());
        // limpeza
        tmp = null;
    }

    public Games cloneById(int id) {
        Node last = this.inicio.next;
        Games result = last.game;
        boolean continuar = true;
        while (continuar) {
            if (last.game.get_app_id() == id) {
                result = last.game;
                continuar = false;
            } else if (last.next != null) {
                last = last.next;
            } else {
                System.out.printf("VALOR NAO ENCONTRADO");
                continuar = false;
            }
        }

        // limpeza
        last = null;
        return result;
    }

    // ---------------------------- QUICK SORT --------------------------- //
    public Games get(int index) {
        if (index >= 0 && index < this.length) {
            int i = 0;
            Node ptr = this.inicio.next;

            while ((ptr.next != null) && i < index) {
                ptr = ptr.next;
                i++;
            }

            Games game = ptr.game;
            ptr = null;

            return game;
        }

        return null;
    }

    public void quicksort() {
        this.quicksort(0, this.length - 1);
    }

    public void quicksort(int left, int right) {
        int i = left;
        int j = right;
        Games pivot = this.get((left + right) / 2);
        this.movimentacoes++;
        Node ptr1 = this.inicio.next;
        Node ptr2 = this.fim;
        for (int l = 0; l < left; l++)
            ptr1 = ptr1.next;
        for (int l = this.length - 1; l > right; l--)
            ptr2 = ptr2.prev;
        while (i <= j) {
            this.comparacoes += 2;
            while (eMaiorQuick(ptr1.game, pivot) < 0) {
                ptr1 = ptr1.next;
                this.comparacoes++;
                i++;
            }
            while (eMaiorQuick(ptr2.game, pivot) > 0) {
                ptr2 = ptr2.prev;
                this.comparacoes++;
                j--;
            }
            if (i <= j) {
                Games tmp = ptr1.game;
                ptr1.game = ptr2.game;
                ptr2.game = tmp;
                this.movimentacoes += 3;
                tmp = null;
                ptr1 = ptr1.next;
                ptr2 = ptr2.prev;
                i++;
                j--;
            }
        }
        pivot = null;
        ptr1 = ptr2 = null;
        if (left < j) {
            this.quicksort(left, j);
        }
        if (i < right) {
            this.quicksort(i, right);
        }
    }

    // contar comparacoes heapsort
    int eMaiorQuick(Games a, Games b) {
        int mes_a;
        int mes_b;
        int ano_a;
        int ano_b;
        String temp_a = "";
        String temp_b = "";
        // recuperar valor do mes
        temp_a += a.get_release_date().charAt(0);
        temp_a += a.get_release_date().charAt(1);
        temp_a += a.get_release_date().charAt(2);
        temp_b += b.get_release_date().charAt(0);
        temp_b += b.get_release_date().charAt(1);
        temp_b += b.get_release_date().charAt(2);
        mes_a = getMonthNumber(temp_a);
        mes_b = getMonthNumber(temp_b);
        // recuperar valor do ano
        temp_a = "";
        temp_b = "";
        temp_a += a.get_release_date().charAt(4);
        temp_a += a.get_release_date().charAt(5);
        temp_a += a.get_release_date().charAt(6);
        temp_a += a.get_release_date().charAt(7);
        temp_b += b.get_release_date().charAt(4);
        temp_b += b.get_release_date().charAt(5);
        temp_b += b.get_release_date().charAt(6);
        temp_b += b.get_release_date().charAt(7);
        ano_a = Integer.parseInt(temp_a);
        ano_b = Integer.parseInt(temp_b);

        // decidir qual e maior
        int diferenca = 0;
        if (ano_a > ano_b) {
            diferenca = 1;
        } else if (ano_a < ano_b) {
            diferenca = -1;
        } else if (ano_a == ano_b) {
            if (mes_a > mes_b) {
                diferenca = 1;
            } else if (mes_a < mes_b) {
                diferenca = -1;
            } else if (ano_a == ano_b) {
                this.comparacoes += 1;
                if (a.get_dia() > b.get_dia()) {
                    diferenca = 1;
                } else {
                    this.comparacoes += 1;
                    if (a.get_dia() < b.get_dia()) {
                        diferenca = -1;
                    } else {
                        this.comparacoes += 1;
                        if (a.get_dia() == b.get_dia()) {
                            this.comparacoes += 1;
                            if (a.get_name().compareTo(b.get_name()) > 0) {
                                diferenca = 1;
                            } else {
                                this.comparacoes += 1;
                                if (a.get_name().compareTo(b.get_name()) < 0) {
                                    diferenca = -1;
                                } else {
                                    this.comparacoes += 1;
                                    if (a.get_name().compareTo(b.get_name()) == 0) {
                                        diferenca = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return diferenca;
    }

    int getMonthNumber(String month) {
        if (month.compareTo("Jan") == 0)
            return 1;
        else if (month.compareTo("Feb") == 0)
            return 2;
        else if (month.compareTo("Mar") == 0)
            return 3;
        else if (month.compareTo("Apr") == 0)
            return 4;
        else if (month.compareTo("May") == 0)
            return 5;
        else if (month.compareTo("Jun") == 0)
            return 6;
        else if (month.compareTo("Jul") == 0)
            return 7;
        else if (month.compareTo("Aug") == 0)
            return 8;
        else if (month.compareTo("Sep") == 0)
            return 9;
        else if (month.compareTo("Oct") == 0)
            return 10;
        else if (month.compareTo("Nov") == 0)
            return 11;
        else if (month.compareTo("Dec") == 0)
            return 12;
        else
            return 0;
    }
}

public class Game_quick2 {

    /**
     * Metodo para encontrar o Fim de leitura, testa se a palavra escrita e' "FIM"
     * 
     * @param s Palavra a ser testada
     * @return True se for "FIM"
     */
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void matriculaQuicksort2(int comparacoes, int movimentacoes, long tempo) {
        try {
            Formatter file = new Formatter("matricula_quicksort2.txt");
            file.format("771157\t%d\t%d\t%d", comparacoes, movimentacoes, tempo);
            file.close();
        } catch (FileNotFoundException e) {
            MyIO.println("e... deu erro, aff");
        }
    }

    // Driver
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Games games = new Games();
        ListaGames listaInicial = new ListaGames();
        ListaGames lista = new ListaGames();

        try {
            // Abertura dos metodos de entrada e saida
            BufferedReader br = new BufferedReader(new FileReader("/tmp/games.csv"));
            MyIO.setCharset("UTF-8");

            // leitura e armazenamento das strings em array
            String linha = "";
            for (int i = 0; i < 4403; i++) {
                linha = br.readLine();
                games = new Games();
                games.ler(linha);
                listaInicial.insertEnd(games);
            }
            br.close();

            // Leitura da entrada padrao
            String[] entrada = new String[1000];
            int numEntrada = 0;
            do {
                entrada[numEntrada] = MyIO.readLine();
            } while (isFim(entrada[numEntrada++]) == false);
            numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
            // para cada linha de entrada gravando os dados pedidos
            for (int i = 0; i < numEntrada; i++) {
                lista.insertEnd(listaInicial.cloneById(Integer.parseInt(entrada[i])));
            }

            long start = new Date().getTime();
            lista.quicksort();
            long end = new Date().getTime();
            long total_time = end - start;
            matriculaQuicksort2(lista.comparacoes, lista.movimentacoes, total_time);
            lista.printAll();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        sc.close();
    }
}