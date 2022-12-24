import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Formatter;

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

class No {
    private Games valor;
    private No esq;
    private No dir;

    public No() {
        this.valor = null;
        this.esq = null;
        this.dir = null;
    }

    public No(Games valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public No(Games valor, No esq, No dir) {
        this.valor = valor;
        this.esq = esq;
        this.dir = dir;
    }

    public Games getValor() {
        return this.valor;
    }

    public No getEsq() {
        return this.esq;
    }

    public No getDir() {
        return this.dir;
    }

    public void setValor(Games valor) {
        this.valor = valor;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public Boolean eMaior(Games tmp) {
        return tmp.get_name().compareTo(this.getValor().get_name()) > 0;
    }

    public Boolean eMaior(String tmp) {
        return tmp.compareTo(this.getValor().get_name()) > 0;
    }

    public Boolean eMenor(Games tmp) {
        return tmp.get_name().compareTo(this.getValor().get_name()) < 0;
    }

    public Boolean eMenor(String tmp) {
        return tmp.compareTo(this.getValor().get_name()) < 0;
    }

    public Boolean eIgual(String tmp) {
        return tmp.compareTo(this.getValor().get_name()) == 0;
    }

    public String toString() {
        return this.valor.toString();
    }
}

class ArvoreBinaria {
    private No raiz;
    private int comparacoes;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Games x) {
        if (x != null) {
            raiz = inserir(x, raiz);
        }
    }

    private No inserir(Games x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (i.eMenor(x)) {
            i.setEsq(inserir(x, i.getEsq()));
        } else if (i.eMaior(x)) {
            i.setDir(inserir(x, i.getDir()));
        } else {
            System.out.printf("Erro ao inserir!\n");
        }
        return i;
    }

    public void remover(String s) {
        raiz = remover(s, raiz);
    }

    private No remover(String s, No i) {
        if (i == null) {
            System.out.printf("Nao encontrou");
        } else if (i.eMenor(s)) {
            i.setEsq(remover(s, i.getEsq()));
        } else if (i.eMaior(s)) {
            i.setDir(remover(s, i.getDir())); // Sem no a direita.
        } else if (i.getDir() == null) {
            i = i.getEsq(); // Sem no a esquerda.
        } else if (i.getEsq() == null) {
            i = i.getDir(); // No a esquerda e no a direita.
        } else {
            i.setEsq(maiorEsq(i, i.getEsq()));
        }
        return i;
    }

    private No maiorEsq(No i, No j) {
        // Encontrou o maximo da subarvore esquerda.
        if (j.getDir() == null) {
            i.setValor(j.getValor()); // Substitui i por j.
            j = j.getEsq(); // Substitui j por j.ESQ.
            // Existe no a direita.
        } else {
            // Caminha para direita.
            j.setDir(maiorEsq(i, j.getDir()));
        }
        return j;
    }

    public boolean pesquisar(String s) {
        comparacoes = 0;
        return pesquisar(s, raiz);
    }

    private boolean pesquisar(String s, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (i.eIgual(s)) {
            comparacoes += 1;
            resp = true;
        } else if (i.eMenor(s)) {
            comparacoes += 2;
            System.out.printf("esq ");
            resp = pesquisar(s, i.getEsq());
        } else {
            comparacoes += 3;
            System.out.printf("dir ");
            resp = pesquisar(s, i.getDir());
        }
        return resp;
    }

    public void caminharPre() {
        caminharPre(raiz);
    }

    public void caminharCentral() {
        caminharCentral(raiz);
    }

    public void caminharPos() {
        caminharPos(raiz);
    }

    private void caminharPre(No i) {
        if (i != null) {
            System.out.printf(" %s", i.toString());
            caminharPre(i.getEsq());
            caminharPre(i.getDir());
        }
    }

    private void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.getEsq());
            System.out.printf("%s\n", i.getValor().get_name());
            caminharCentral(i.getDir());
        }
    }

    private void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.getEsq());
            caminharPos(i.getDir());
            System.out.printf(" %s", i.toString());
        }
    }

    public int getComparacoes() {
        return this.comparacoes;
    }
}

class NoArvore {
    private char letra;
    private ArvoreBinaria ab;
    private NoArvore esq;
    private NoArvore dir;

    public NoArvore(char letra) {
        this.letra = letra;
        this.ab = new ArvoreBinaria();
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public ArvoreBinaria getAb() {
        return ab;
    }

    public void setAb(ArvoreBinaria ab) {
        this.ab = ab;
    }

    public NoArvore getEsq() {
        return esq;
    }

    public void setEsq(NoArvore esq) {
        this.esq = esq;
    }

    public NoArvore getDir() {
        return dir;
    }

    public void setDir(NoArvore dir) {
        this.dir = dir;
    }

    public Boolean eMaior(char tmp) {
        return tmp > this.getLetra();
    }

    public Boolean eMenor(char tmp) {
        return tmp < this.getLetra();
    }

    public Boolean eIgual(char tmp) {
        return tmp == this.getLetra();
    }
}

class ArvoreArvore {
    private NoArvore raiz;
    private int comparacoes;

    public ArvoreArvore() {
        this.raiz = null;
        char letras[] = { 'D', 'R', 'Z', 'X', 'V', 'B', 'F', 'P', 'U', 'I', 'G', 'E', 'J', 'L', 'H', 'T', 'A', 'W', 'S',
                'O', 'M', 'N', 'K', 'C', 'Y', 'Q' };
        for (char c : letras) {
            this.inserirLetra(c);
        }
    }

    public NoArvore getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore raiz) {
        this.raiz = raiz;
    }

    private void inserirLetra(char c) {
        raiz = inserirLetra(c, raiz);
    }

    private NoArvore inserirLetra(char c, NoArvore i) {
        if (i == null) {
            i = new NoArvore(c);
        } else if (i.eMenor(c)) {
            i.setEsq(inserirLetra(c, i.getEsq()));
        } else if (i.eMaior(c)) {
            i.setDir(inserirLetra(c, i.getDir()));
        } else {
            System.out.printf("Erro ao inserir!\n");
        }
        return i;
    }

    public void inserir(Games s) {
        inserir(s, raiz);
    }

    public void inserir(Games novo, NoArvore i) {
        if (i == null) {
            System.out.printf("Erro ao inserir: caractere invalido!");
        } else if (novo.get_name().charAt(0) < i.getLetra()) {
            inserir(novo, i.getEsq());
        } else if (novo.get_name().charAt(0) > i.getLetra()) {
            inserir(novo, i.getDir());
        } else {
            i.getAb().inserir(novo);
        }
    }

    public boolean pesquisar(String s) {
        boolean resp = pesquisar(raiz, s, "raiz ");
        System.out.printf(" %s\n", resp ? "SIM" : "NAO");
        return resp;
    }

    private boolean pesquisar(NoArvore no, String s, String print) {
        System.out.printf("%s", print);
        boolean resp = false;

        if (no == null) {
            resp = false;
        } else {
            resp = no.getAb().pesquisar(s);
            comparacoes += no.getAb().getComparacoes();
            if (!resp) {
                resp = pesquisar(no.getEsq(), s, " ESQ ");
            }
            if (!resp) {
                resp = pesquisar(no.getDir(), s, " DIR ");
            }
        }
        return resp;
    }

    public void remover(String s) {
        remover(s, raiz);
    }

    private void remover(String s, NoArvore i) {
        if (i == null) {
            System.out.printf("Erro ao remover: caractere invalido!");
        } else if (s.charAt(0) < i.getLetra()) {
            remover(s, i.getEsq());
        } else if (s.charAt(0) > i.getLetra()) {
            remover(s, i.getDir());
        } else {
            i.getAb().remover(s);
        }
    }

    public void caminharCentral() {
        caminharCentral(raiz);
    }

    private void caminharCentral(NoArvore i) {
        if (i != null) {
            caminharCentral(i.getEsq());
            i.getAb().caminharCentral();
            caminharCentral(i.getDir());
        }
    }

    public int getComparacoes() {
        return this.comparacoes;
    }
}

public class Questao_2 {
    public static Games[] lerArquivo() {
        Games[] arrayGames = new Games[4403];
        try {
            BufferedReader br = new BufferedReader(new FileReader("/tmp/games.csv"));

            String linha = "";
            for (int i = 0; i < arrayGames.length; i++) {
                linha = br.readLine();
                arrayGames[i] = new Games();
                arrayGames[i].ler(linha);
            }

            br.close();

        } catch (Exception e) {
            arrayGames = null;
            System.out.print("Arquivo nao encontrado . . . ");
        }

        return arrayGames;
    }

    public static String[] lerParte1() {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        entrada[--numEntrada] = null;
        return entrada;
    }

    public static String[] lerParte2() {
        String[] entrada = new String[1000];
        int numEntrada = Integer.parseInt(MyIO.readLine());
        for (int i = 0; i < numEntrada; i++) {
            entrada[i] = MyIO.readLine();
        }
        return entrada;
    }

    public static String[] lerParte3() {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        entrada[--numEntrada] = null;
        return entrada;
    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static Games encontrarGame(int id, Games[] arrayGames) {
        Games target = null;
        for (int i = 0; i < arrayGames.length; i++) {
            if (arrayGames[i].get_app_id() == id) {
                target = arrayGames[i];
            }
        }
        return target;
    }

    public static void matriculaArvoreArvore(long tempo, int comparacoes) {
        try {
            Formatter file = new Formatter("matricula_arvoreArvore.txt");
            file.format("771157\t%d\t%d", tempo, comparacoes);
            file.close();
        } catch (FileNotFoundException e) {
            MyIO.println("e... deu erro, aff");
        }
    }

    public static void main(String[] args) {
        ArvoreArvore aa = new ArvoreArvore();
        Games[] arrayGames = lerArquivo();
        String[] populacao = lerParte1();
        String[] comandos = lerParte2();
        String[] pesquisas = lerParte3();

        for (int i = 0; populacao[i] != null; i++) {
            aa.inserir(encontrarGame(Integer.parseInt(populacao[i]), arrayGames));
        }

        long start = new Date().getTime();

        for (int i = 0; comandos[i] != null; i++) {
            if (comandos[i].charAt(0) == 'I') {
                aa.inserir(encontrarGame(Integer.parseInt(comandos[i].substring(2)), arrayGames));
            } else if (comandos[i].charAt(0) == 'R') {
                // aa.remover(comandos[i].substring(2));
            }
        }

        for (int i = 0; pesquisas[i] != null; i++) {
            System.out.printf("%s\n", pesquisas[i]);
            aa.pesquisar(pesquisas[i]);
        }

        long end = new Date().getTime();
        long tempo = end - start;
        matriculaArvoreArvore(tempo, aa.getComparacoes());
    }
}
