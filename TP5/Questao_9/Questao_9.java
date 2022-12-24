import java.io.*;

class No {
    private char valor;
    private No esq;
    private No dir;

    public No() {
        this.valor = 0;
        this.esq = null;
        this.dir = null;
    }

    public No(char valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public No(char valor, No esq, No dir) {
        this.valor = valor;
        this.esq = esq;
        this.dir = dir;
    }

    public char getValor() {
        return this.valor;
    }

    public No getEsq() {
        return this.esq;
    }

    public No getDir() {
        return this.dir;
    }

    public void setValor(char valor) {
        this.valor = valor;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
}

class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(char x) {
        raiz = inserir(x, raiz);
    }

    private No inserir(char x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (x < i.getValor()) {
            i.setEsq(inserir(x, i.getEsq()));
        } else if (x > i.getValor()) {
            i.setDir(inserir(x, i.getDir()));
        } else {
            System.out.printf("Erro ao inserir!");
        }
        return i;
    }

    public boolean pesquisar(char x) {
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(char x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (x == i.getValor()) {
            resp = true;
        } else if (x < i.getValor()) {
            resp = pesquisar(x, i.getEsq());
        } else {
            resp = pesquisar(x, i.getDir());
        }
        return resp;
    }

    public void caminharPre() {
        caminharPre(raiz);
        System.out.printf("\n");
    }

    public void caminharCentral() {
        caminharCentral(raiz);
        System.out.printf("\n");
    }

    public void caminharPos() {
        caminharPos(raiz);
        System.out.printf("\n");
    }

    private void caminharPre(No i) {
        if (i != null) {
            System.out.printf("%s ", i.getValor());
            caminharPre(i.getEsq());
            caminharPre(i.getDir());
        }
    }

    private void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.getEsq());
            System.out.printf("%s ", i.getValor());
            caminharCentral(i.getDir());
        }
    }

    private void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.getEsq());
            caminharPos(i.getDir());
            System.out.printf("%s ", i.getValor());
        }
    }
}

class Questao_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
        String entrada = inReader.readLine();
        ArvoreBinaria ab = new ArvoreBinaria();
        while (entrada != null) {
            if (entrada.compareTo("INFIXA") == 0) {
                ab.caminharCentral();
            } else if (entrada.compareTo("PREFIXA") == 0) {
                ab.caminharPre();
            } else if (entrada.compareTo("POSFIXA") == 0) {
                ab.caminharPos();
            } else if (entrada.charAt(0) == 'I') {
                ab.inserir(entrada.charAt(2));
            } else if (entrada.charAt(0) == 'P') {
                System.out.printf("%s %s\n", entrada.charAt(2), ab.pesquisar(entrada.charAt(2))?"existe":"nao existe");
            }
            entrada = inReader.readLine();
        }
    }
}
