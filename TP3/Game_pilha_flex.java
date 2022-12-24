/*
 * Aluno: Marcos Antonio Lommez Candido Ribeiro
 * Matricula: 771157
 * Data: 03/10/2022
 */

import java.io.*;
import java.util.Scanner;

class Games {
    private int app_id;
    private String name;
    private String release_date;
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
    private Games next; // criado para lista encadeada

    /**
     * Construtor padrao da classe
     */
    Games() {
        this.app_id = 0;
        this.name = null;
        this.release_date = null;
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
        this.next = null;
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
        this.next = null;
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
        if (steam.charAt(needle + 1) == '\"') {
            for (needle++; steam.charAt(needle) != ','; needle++) {
                temp += steam.charAt(needle);
            }
            release_date = "";
            release_date += temp.charAt(1);
            release_date += temp.charAt(2);
            release_date += temp.charAt(3);
            release_date += "/";
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

    // METODO PARA ADAPTACAO DA CLASSE EM LISTA ENCADEADA
    public void set_next(Games next) {
        this.next = next;
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

    // METODO PARA ADAPTACAO DA CLASSE EM LISTA ENCADEADA
    public Games get_next() {
        return this.next;
    }

    // METODO PARA ADAPTACAO DA CLASSE EM LISTA ENCADEADA
    public boolean has_next() {
        boolean resp = true;
        if (this.next == null) {
            resp = false;
        }
        return resp;
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

class ListaGames {
    Games topo;

    ListaGames() {
        this.topo = new Games();
    }

    public void insertEnd(Games tmp) {
        Games last = this.topo;
        while (last.has_next()) {
            last = last.get_next();
        }
        last.set_next(tmp.clone());

        // limpeza
        last = null;
        tmp = null;
    }

    public void insertStart(Games tmp) {
        tmp.set_next(this.topo.get_next());
        this.topo.set_next(tmp);

        // limpeza
        tmp = null;
    }

    public void insertMiddle(Games tmp, int pos) {
        Games last = this.topo;
        int i = 0;
        while (last.has_next() && i < pos) {
            last = last.get_next();
            i++;
        }
        tmp.set_next(last.get_next());
        last.set_next(tmp);

        // limpeza
        last = null;
        tmp = null;
    }

    public Games removeStart() {
        Games tmp = this.topo.get_next();
        this.topo.set_next(tmp.get_next());
        tmp.set_next(null);

        return tmp;
    }

    public Games removeMiddle(int pos) {
        Games last = this.topo.get_next();
        Games beforeLast = this.topo;
        int i = 0;
        while (last.has_next() && i < pos) {
            beforeLast = last;
            last = last.get_next();
            i++;
        }
        beforeLast.set_next(last.get_next());
        last.set_next(null);

        // limpeza
        beforeLast = null;

        return last;
    }

    public Games removeEnd() {
        Games last = this.topo.get_next();
        Games beforeLast = this.topo;
        while (last.has_next()) {
            beforeLast = last;
            last = last.get_next();
        }
        beforeLast.set_next(last.get_next());
        last.set_next(null);

        // limpeza
        beforeLast = null;
        return last;
    }

    public Games cloneById(int id) {
        Games last = this.topo;
        Games result = last;
        boolean continuar = true;
        while (continuar) {
            if (last.get_app_id() == id) {
                result = last.clone();
                continuar = false;
            } else if (last.has_next()) {
                last = last.get_next();
            } else {
                System.out.printf("VALOR NAO ENCONTRADO");
                continuar = false;
            }
        }

        // limpeza
        last = null;
        return result;
    }

    public void printall() {
        Games last = this.topo;
        int i = 0;
        while (last.has_next()) {
            last = last.get_next();
            System.out.printf("[%d] %s\n", i, last.toString());
            i++;
        }

        // limpeza
        last = null;
    }
}

class PilhaGames {
    Games topo;

    PilhaGames() {
        this.topo = new Games();
    }

    public void insert(Games tmp) {
        tmp.set_next(this.topo.get_next());
        this.topo.set_next(tmp);

        // limpeza
        tmp = null;
    }

    public Games remove() {
        Games tmp = this.topo.get_next();
        this.topo.set_next(tmp.get_next());
        tmp.set_next(null);

        return tmp;
    }

    public Games cloneById(int id) {
        Games last = this.topo;
        Games result = last;
        boolean continuar = true;
        while (continuar) {
            if (last.get_app_id() == id) {
                result = last.clone();
                continuar = false;
            } else if (last.has_next()) {
                last = last.get_next();
            } else {
                System.out.printf("VALOR NAO ENCONTRADO");
                continuar = false;
            }
        }

        // limpeza
        last = null;
        return result;
    }

    public void printall() {
        this.printall(this.topo.get_next());
    }

    int printall(Games tmp){
        int i;
        if (tmp != null) {
            i = printall(tmp.get_next());
            System.out.printf("[%d] %s\n", i, tmp.toString());
        } else {
            i = -1;
        }
        tmp = null;
        return i+1;
    }
}

public class Game_pilha_flex {

    /**
     * Metodo para encontrar o Fim de leitura, testa se a palavra escrita e' "FIM"
     * 
     * @param s Palavra a ser testada
     * @return True se for "FIM"
     */
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // Driver
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Games games = new Games();
        ListaGames listaInicial = new ListaGames();
        PilhaGames pilha = new PilhaGames();

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
                pilha.insert(listaInicial.cloneById(Integer.parseInt(entrada[i])));
            }

            // Ler o resto das funcoes
            entrada = new String[1000];
            String temp;
            int id;
            temp = MyIO.readLine();
            numEntrada = Integer.parseInt(temp);
            for (int i = 0; i < numEntrada; i++) {
                entrada[i] = MyIO.readLine();
            }

            // para cada linha de entrada realizando a acao desejada

            for (int i = 0; i < numEntrada; i++) {
                temp = "";
                temp += entrada[i].charAt(0);

                if (temp.equals("I")) {
                    temp = new String();
                    for (int j = 2; j < entrada[i].length(); j++) {
                        temp += entrada[i].charAt(j);
                    }
                    id = Integer.parseInt(temp);
                    pilha.insert(listaInicial.cloneById(id));
                } else if (temp.equals("R")) {
                    MyIO.print("(R) ");
                    MyIO.print(pilha.remove().get_name());
                    MyIO.print("\n");
                }
            }
            pilha.printall();
        } catch (Exception e) {
            System.out.print("Arquivo nao encontrado . . . ");
        }
        sc.close();
    }
}