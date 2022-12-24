import java.io.*;
import java.util.Date;
import java.util.Formatter;

class Games {
    private int app_id;
    private String name;
    private String release_date;
    private String owner;
    private int age;
    private double price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private double upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;
    private int dia; // para desempate de ordenacao por data
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
        this.dia = 0;
        this.next = null;
    }

    /**
     * Construtor com inicializacao de todos os argumentos
     */
    Games(int app_id, String name, String release_date, String owner, int age, double price, int dlcs,
            String[] languages,
            String website, boolean windows, boolean mac, boolean linux, double upvotes, int avg_pt, String developers,
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
        this.dia = 0;
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
        double price;
        int dlcs;
        String[] languages;
        String website;
        boolean windows;
        boolean mac;
        boolean linux;
        double upvotes;
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
        price = Double.parseDouble(temp);

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
        double totalUpVotes;
        double totalOtherVotes;
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        totalUpVotes = Double.parseDouble(temp);
        temp = "";
        for (needle++; steam.charAt(needle) != ','; needle++) {
            temp += steam.charAt(needle);
        }
        totalOtherVotes = Double.parseDouble(temp);
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
        int percentUpVotes = Math.round((float) upvotes * 100);

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
        price_tmp += Double.toString(price);
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

    public void set_price(double price) {
        this.price = price;
    }

    public void set_dlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    public void set_languages(String[] languages) {
        this.languages = languages;
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

    public void set_upvotes(double upvotes) {
        this.upvotes = upvotes;
    }

    public void set_avg_pt(int avg_pt) {
        this.avg_pt = avg_pt;
    }

    public void set_developers(String developers) {
        this.developers = developers;
    }

    public void set_genres(String[] genres) {
        this.genres = genres;
    }

    public void set_dia(int dia) {
        this.dia = dia;
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

    public double get_price() {
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

    public double get_upvotes() {
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

    public int get_dia() {
        return this.dia;
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

    // metodo para lista encadeada
    public void addEnd(int app_id, String name, String release_date, String owner, int age, double price, int dlcs,
            String[] languages,
            String website, boolean windows, boolean mac, boolean linux, double upvotes, int avg_pt, String developers,
            String[] genres) {
        Games last = this;
        while (last.has_next()) {
            last = last.get_next();
        }
        last.set_next(new Games());
        last = last.get_next();
        last.set_app_id(app_id);
        last.set_name(name);
        last.set_release_date(release_date);
        last.set_owner(owner);
        last.set_age(age);
        last.set_price(price);
        last.set_dlcs(dlcs);
        last.set_languages(languages);
        last.set_website(website);
        last.set_windows(windows);
        last.set_mac(mac);
        last.set_linux(linux);
        last.set_upvotes(upvotes);
        last.set_avg_pt(avg_pt);
        last.set_developers(developers);
        last.set_genres(genres);
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
        game.set_languages(this.languages);
        game.set_website(this.website);
        game.set_windows(this.windows);
        game.set_mac(this.mac);
        game.set_linux(this.linux);
        game.set_upvotes(this.upvotes);
        game.set_avg_pt(this.avg_pt);
        game.set_developers(this.developers);
        game.set_genres(this.genres);
        return game;
    }
}

class ListaGames {
    Games[] games;
    int n_games;
    boolean is_Sorted;
    int comparacoes; // contar o numero de comparacoes
    int movimentacoes; // contar o numero de movimentacoes

    ListaGames() {
        this.games = null;
        this.n_games = 0;
        this.is_Sorted = false;
        this.comparacoes = 0;
        this.movimentacoes = 0;
    }

    ListaGames(int total) {
        this.games = new Games[total];
        this.n_games = 0;
        this.is_Sorted = false;
        this.comparacoes = 0;
        this.movimentacoes = 0;
    }

    public void swap(int i, int j) {
        Games temp;
        temp = this.games[i];
        this.games[i] = this.games[j];
        this.games[j] = temp;
        this.movimentacoes += 3;
    }

    public void insertEnd(Games game) {
        this.games[this.n_games] = game;
        this.n_games++;
    }

    public boolean search(String nome) {
        boolean find = false;
        if (this.is_Sorted) { // pesquisa binaria
            int left = 0;
            int right = this.n_games - 1;
            while (left <= right) {
                int needle = (left + right) / 2;
                if (this.games[needle].get_name().equals(nome)) {
                    find = true;
                    left = right + 1; // break
                } else {
                    if (this.games[needle].get_name().compareTo(nome) < 0) {
                        left = needle + 1;
                    } else {
                        right = needle - 1;
                    }
                }
            }
        } else { // pesquisa sequencial
            for (int i = 0; i < this.n_games; i++) {
                if (this.games[i].get_name().equals(nome)) {
                    find = true;
                    i = this.n_games;
                }
            }
        }
        return find;
    }

    // -------------------------- SELECTION SORT ------------------------- //
    // ordenar por nome
    public void selection_sort() {
        Games temp;
        for (int i = 0; i < (n_games - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n_games; j++) {
                this.comparacoes++;
                if (this.games[menor].get_name().compareTo(this.games[j].get_name()) > 0) {
                    menor = j;
                }
            }
            temp = this.games[i];
            this.games[i] = this.games[menor];
            this.games[menor] = temp;
            this.movimentacoes += 3;
        }
        this.is_Sorted = true;
    }

    // -------------------------- INSERTION SORT ------------------------- //
    // ordenar por id
    public void insertion_sort() {
        Games temp;
        for (int i = 1; i < n_games; i++) {
            this.movimentacoes += 1;
            temp = this.games[i]; // Movimentacao
            int j = i - 1;
            while ((j >= 0) && eMaior(j, temp)) { // Comparacao
                this.movimentacoes += 1;
                this.games[j + 1] = this.games[j]; // Movimentacao
                j--;
            }
            this.movimentacoes += 1;
            this.games[j + 1] = temp; // Movimentacao
        }
        this.is_Sorted = true;
    }

    // contar comparacoes do insertion
    boolean eMaior(int j, Games temp) {
        this.comparacoes += 1;
        if ((this.games[j].get_app_id() > temp.get_app_id())) {
            return true;
        }
        return false;
    }

    // ---------------------------- HEAP SORT ---------------------------- //
    // ordenar por release_date
    public void heapsort() {
        // Alterar o vetor ignorando a posicao zero
        Games[] tmp = new Games[n_games + 1];
        for (int i = 0; i < n_games; i++) {
            tmp[i + 1] = games[i];
        }
        games = tmp;

        // Contrucao do heap
        for (int tamHeap = 2; tamHeap <= n_games; tamHeap++) {
            construir(tamHeap);
        }

        // Ordenacao propriamente dita
        int tamHeap = n_games;
        while (tamHeap > 1) {
            swap(1, tamHeap--);
            reconstruir(tamHeap);
        }

        // Alterar o vetor para voltar a posicao zero
        tmp = games;
        games = new Games[n_games];
        for (int i = 0; i < n_games; i++) {
            games[i] = tmp[i + 1];
        }
    }

    public void construir(int tamHeap) {
        for (int i = tamHeap; i > 1 && eMaiorHeap(i, i / 2); i /= 2) {
            swap(i, i / 2);
        }
    }

    public void reconstruir(int tamHeap) {
        int i = 1;
        while (i <= (tamHeap / 2)) {
            int filho = getMaiorFilho(i, tamHeap);
            if (eMaiorHeap(filho, i)) {
                swap(i, filho);
                i = filho;
            } else {
                i = tamHeap;
            }
        }
    }

    int getMaiorFilho(int i, int tamHeap) {
        int filho;
        if (2 * i == tamHeap || eMaiorHeap((2 * i), (2 * i + 1))) {
            filho = 2 * i;
        } else {
            filho = 2 * i + 1;
        }
        return filho;
    }

    // contar comparacoes heapsort
    boolean eMaiorHeap(int a, int b) {

        this.comparacoes += 1;
        int mes_a;
        int mes_b;
        int ano_a;
        int ano_b;
        String temp_a = "";
        String temp_b = "";
        // recuperar valor do mes
        temp_a += this.games[a].get_release_date().charAt(0);
        temp_a += this.games[a].get_release_date().charAt(1);
        temp_a += this.games[a].get_release_date().charAt(2);
        temp_b += this.games[b].get_release_date().charAt(0);
        temp_b += this.games[b].get_release_date().charAt(1);
        temp_b += this.games[b].get_release_date().charAt(2);
        mes_a = getMonthNumber(temp_a);
        mes_b = getMonthNumber(temp_b);
        // recuperar valor do ano
        temp_a = "";
        temp_b = "";
        temp_a += this.games[a].get_release_date().charAt(4);
        temp_a += this.games[a].get_release_date().charAt(5);
        temp_a += this.games[a].get_release_date().charAt(6);
        temp_a += this.games[a].get_release_date().charAt(7);
        temp_b += this.games[b].get_release_date().charAt(4);
        temp_b += this.games[b].get_release_date().charAt(5);
        temp_b += this.games[b].get_release_date().charAt(6);
        temp_b += this.games[b].get_release_date().charAt(7);
        ano_a = Integer.parseInt(temp_a);
        ano_b = Integer.parseInt(temp_b);

        // decidir qual e maior
        boolean eMaior = false;
        if (ano_a > ano_b) {
            eMaior = true;
        } else if (ano_a == ano_b && mes_a > mes_b) {
            eMaior = true;
        } else if (ano_a == ano_b && mes_a == mes_b && this.games[a].get_dia() > this.games[b].get_dia()) {
            eMaior = true;
        } else if (ano_a == ano_b && mes_a == mes_b && this.games[a].get_dia() == this.games[b].get_dia()
                && this.games[a].get_name().compareTo(this.games[b].get_name()) > 0) {
            eMaior = true;
        }

        return eMaior;
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

    // ---------------------------- QUICK SORT --------------------------- //
    // encapsulamento
    public void quick_sort() {
        this.quicksort(0, this.n_games - 1);
        this.is_Sorted = true;
    }

    public void quicksort(int esq, int dir) {
        int i = esq;
        int j = dir;
        this.movimentacoes += 1;
        Games pivo = this.games[(esq + dir) / 2];
        while (i <= j) {
            while (eMaiorQuick(i, pivo) < 0)
                i++;
            while (eMaiorQuick(j, pivo) > 0)
                j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)
            quicksort(esq, j);
        if (i < dir)
            quicksort(i, dir);
    }

    // contar comparacoes heapsort
    int eMaiorQuick(int a, Games game_b) {
        this.comparacoes += 1;
        int mes_a;
        int mes_b;
        int ano_a;
        int ano_b;
        String temp_a = "";
        String temp_b = "";
        // recuperar valor do mes
        temp_a += this.games[a].get_release_date().charAt(0);
        temp_a += this.games[a].get_release_date().charAt(1);
        temp_a += this.games[a].get_release_date().charAt(2);
        temp_b += game_b.get_release_date().charAt(0);
        temp_b += game_b.get_release_date().charAt(1);
        temp_b += game_b.get_release_date().charAt(2);
        mes_a = getMonthNumber(temp_a);
        mes_b = getMonthNumber(temp_b);
        // recuperar valor do ano
        temp_a = "";
        temp_b = "";
        temp_a += this.games[a].get_release_date().charAt(4);
        temp_a += this.games[a].get_release_date().charAt(5);
        temp_a += this.games[a].get_release_date().charAt(6);
        temp_a += this.games[a].get_release_date().charAt(7);
        temp_b += game_b.get_release_date().charAt(4);
        temp_b += game_b.get_release_date().charAt(5);
        temp_b += game_b.get_release_date().charAt(6);
        temp_b += game_b.get_release_date().charAt(7);
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
                if (this.games[a].get_dia() > game_b.get_dia()) {
                    diferenca = 1;
                } else if (this.games[a].get_dia() < game_b.get_dia()) {
                    diferenca = -1;
                } else if (this.games[a].get_dia() == game_b.get_dia()) {
                    if (this.games[a].get_name().compareTo(game_b.get_name()) > 0) {
                        diferenca = 1;
                    } else if (this.games[a].get_name().compareTo(game_b.get_name()) < 0) {
                        diferenca = -1;
                    } else if (this.games[a].get_name().compareTo(game_b.get_name()) == 0) {
                        diferenca = 0;
                    }
                }
            }
        }

        return diferenca;
    }

    // --------------------------- BUBBLE SORT -------------------------- //
    // ordenar por developers
    public void Bubble_Sort() {
        int tmp;
        for (int i = (n_games - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                this.comparacoes += 1;
                tmp = games[j].get_developers().compareTo(games[j + 1].get_developers());
                if (tmp > 0) {
                    swap(j, j + 1);
                } else {
                    if (tmp == 0) {
                        this.comparacoes += 1;
                        if (games[j].get_name().compareTo(games[j + 1].get_name()) > 0) {
                            swap(j, j + 1);
                        }
                    }
                }
            }
        }
    }

    // --------------------------- MERGE SORT --------------------------- //
    public void mergesort() {
        mergesort(0, n_games - 1);
    }

    private void mergesort(int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(esq, meio);
            mergesort(meio + 1, dir);
            intercalar(esq, meio, dir);
        }
    }

    public void intercalar(int esq, int meio, int dir) {
        int n1, n2, i, j, k;

        // Definir tamanho dos dois subarrays
        n1 = meio - esq + 1;
        n2 = dir - meio;

        Games[] a1 = new Games[n1 + 1];
        Games[] a2 = new Games[n2 + 1];

        // Inicializar primeiro subarray
        for (i = 0; i < n1; i++) {
            this.movimentacoes += 1;
            a1[i] = games[esq + i];
        }

        // Inicializar segundo subarray
        for (j = 0; j < n2; j++) {
            this.movimentacoes += 1;
            a2[j] = games[meio + j + 1];
        }

        // Sentinela no final dos dois arrays
        this.movimentacoes += 2;
        a1[i] = a2[j] = null;

        // Intercalacao propriamente dita
        for (i = j = 0, k = esq; k <= dir; k++) {
            this.movimentacoes += 1;
            games[k] = (compareUpvotes(a1[i], a2[j])) ? a1[i++] : a2[j++];
        }
    }

    public boolean compareUpvotes(Games a1, Games a2) {
        boolean result = false;
        if (a1 == null) {
            result = false;
        } else if (a2 == null) {
            result = true;
        } else {
            this.comparacoes += 1;
            if (a1.get_upvotes() < a2.get_upvotes()) {
                result = true;
            } else {
                this.comparacoes += 2;
                if (a1.get_upvotes() == a2.get_upvotes()) {
                    if (a1.get_name().compareTo(a2.get_name()) < 0) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}

public class Game_merge {

    /**
     * Metodo para encontrar o Fim de leitura, testa se a palavra escrita e' "FIM"
     * 
     * @param s Palavra a ser testada
     * @return True se for "FIM"
     */
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void matriculaMergesort(int comparacoes, int movimentacoes, long tempo) {
        try {
            Formatter file = new Formatter("matricula_mergesort.txt");
            file.format("771157\t%d\t%d\t%d", comparacoes, movimentacoes, tempo);
            file.close();
        } catch (FileNotFoundException e) {
            MyIO.println("e... deu erro, aff");
        }
    }

    // Driver
    public static void main(String[] args) throws IOException {
        Games[] games = new Games[4403];

        ListaGames lista = new ListaGames(100);
        try {
            // Abertura dos metodos de entrada e saida
            BufferedReader br = new BufferedReader(new FileReader("/tmp/games.csv"));
            MyIO.setCharset("UTF-8");

            // leitura e armazenamento das strings em array
            String linha = "";
            for (int i = 0; i < games.length; i++) {
                linha = br.readLine();
                games[i] = new Games();
                games[i].ler(linha);
            }
            br.close();

            // Leitura da entrada padrao
            String[] entrada = new String[1000];
            int numEntrada = 0;
            do {
                entrada[numEntrada] = MyIO.readLine();
            } while (isFim(entrada[numEntrada++]) == false);
            numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

            // para cada linha de entrada procurando por ID compativel e inserindo
            for (int i = 0; i < numEntrada; i++) {
                for (int j = 0; j < games.length; j++) {
                    if (games[j].get_app_id() == Integer.parseInt(entrada[i])) {
                        lista.insertEnd(games[j]);
                    }
                }
            }

            // contando tempo, movimentacoes e comparacoes
            long start = new Date().getTime();
            // ordenando
            lista.mergesort();
            // calculando tempo
            long end = new Date().getTime();
            long total_time = end - start;
            // criando log
            matriculaMergesort(lista.comparacoes, lista.movimentacoes, total_time);
            // printando
            for (int i = 0; i < numEntrada; i++) {
                System.out.printf("%s\n", lista.games[i].toString());
            }

        } catch (Exception e) {
            System.out.print("Arquivo nao encontrado . . . ");
        }
    }
}