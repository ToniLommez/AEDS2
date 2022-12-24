/* 
 * Marcos Antonio Lommez Candido Ribeiro
 * 771157
 * 28/10/2022
 */

class Nodo {
    private int valor;
    private Nodo acima;
    private Nodo abaixo;
    private Nodo esquerda;
    private Nodo direita;

    Nodo() {
        this.valor = 0;
        this.acima = null;
        this.abaixo = null;
        this.esquerda = null;
        this.direita = null;
    }

    Nodo(int valor) {
        this.valor = valor;
        this.acima = null;
        this.abaixo = null;
        this.esquerda = null;
        this.direita = null;
    }

    Nodo(int valor, Nodo acima, Nodo abaixo, Nodo esquerda, Nodo direita) {
        this.valor = valor;
        this.acima = acima;
        this.abaixo = abaixo;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public int getValor() {
        return this.valor;
    }

    public Nodo getAcima() {
        return this.acima;
    }

    public Nodo getAbaixo() {
        return this.abaixo;
    }

    public Nodo getEsquerda() {
        return this.esquerda;
    }

    public Nodo getDireita() {
        return this.direita;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setAcima(Nodo acima) {
        this.acima = acima;
    }

    public void setAbaixo(Nodo abaixo) {
        this.abaixo = abaixo;
    }

    public void setEsquerda(Nodo esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(Nodo direita) {
        this.direita = direita;
    }
}

class Matriz {
    private int linhas;
    private int colunas;
    private Nodo inicial;

    Matriz() {
        this.linhas = 0;
        this.colunas = 0;
        this.inicial = null;
    }

    Matriz(int linhas, int colunas) {
        // iniciando valores
        this.colunas = colunas;
        this.linhas = linhas;
        this.inicial = new Nodo();

        // variaveis necessarias
        Nodo colunaAtual = inicial;
        Nodo linhaAtual = inicial;
        Nodo tmp;

        // Criar a primeira linha das colunas, ligadas
        // 0-0-0
        for (int i = 1; i < colunas; i++) {
            tmp = new Nodo();
            colunaAtual.setDireita(tmp);
            tmp.setEsquerda(colunaAtual);
            colunaAtual = tmp;
        }

        // Preenche a linha das colunas ligado so na vertical
        // 0-0-0
        // | | |
        // 0 0 0
        // | | |
        // 0 0 0
        colunaAtual = inicial;
        for (int i = 0; i < colunas; i++) {
            linhaAtual = colunaAtual;
            for (int j = 1; j < linhas; j++) {
                tmp = new Nodo();
                linhaAtual.setAbaixo(tmp);
                tmp.setAcima(linhaAtual);
                linhaAtual = tmp;
            }
            colunaAtual = colunaAtual.getDireita();
        }

        // Iterar pelas colunas ligando horizontalmente
        // 0-0-0
        // | | |
        // 0-0-0
        // | | |
        // 0-0-0
        Nodo ref1 = inicial;
        Nodo ref2 = inicial.getDireita();
        Nodo tmp1 = ref1.getAbaixo();
        Nodo tmp2 = ref2.getAbaixo();
        for (int i = 1; i < colunas; i++) {
            for (int j = 1; j < linhas; j++) {
                tmp1.setDireita(tmp2);
                tmp2.setEsquerda(tmp1);
                tmp1 = tmp1.getAbaixo();
                tmp2 = tmp2.getAbaixo();
            }
            ref1 = ref2;
            ref2 = ref2.getDireita();
            if (ref2 != null) {
                tmp1 = ref1.getAbaixo();
                tmp2 = ref2.getAbaixo();
            }
        }

        // Limpeza de variaveis
        colunaAtual = null;
        linhaAtual = null;
        tmp = null;
        ref1 = null;
        ref2 = null;
        tmp1 = null;
        tmp2 = null;
    }

    Matriz(int linhas, int colunas, int valores[][]) {
        // iniciando valores
        this.colunas = colunas;
        this.linhas = linhas;
        this.inicial = new Nodo();

        // variaveis necessarias
        Nodo colunaAtual = inicial;
        Nodo linhaAtual = inicial;
        Nodo tmp;

        // Criar a primeira linha das colunas, ligadas
        // 0-0-0
        for (int i = 1; i < colunas; i++) {
            tmp = new Nodo();
            colunaAtual.setDireita(tmp);
            tmp.setEsquerda(colunaAtual);
            colunaAtual = tmp;
        }

        // Preenche a linha das colunas ligado so na vertical
        // 0-0-0
        // | | |
        // 0 0 0
        // | | |
        // 0 0 0
        colunaAtual = inicial;
        for (int i = 0; i < colunas; i++) {
            linhaAtual = colunaAtual;
            for (int j = 1; j < linhas; j++) {
                tmp = new Nodo();
                linhaAtual.setAbaixo(tmp);
                tmp.setAcima(linhaAtual);
                linhaAtual = tmp;
            }
            colunaAtual = colunaAtual.getDireita();
        }

        // Iterar pelas colunas ligando horizontalmente
        // 0-0-0
        // | | |
        // 0-0-0
        // | | |
        // 0-0-0
        Nodo ref1 = inicial;
        Nodo ref2 = inicial.getDireita();
        Nodo tmp1 = ref1.getAbaixo();
        Nodo tmp2 = ref2.getAbaixo();
        for (int i = 1; i < colunas; i++) {
            for (int j = 1; j < linhas; j++) {
                tmp1.setDireita(tmp2);
                tmp2.setEsquerda(tmp1);
                tmp1 = tmp1.getAbaixo();
                tmp2 = tmp2.getAbaixo();
            }
            ref1 = ref2;
            ref2 = ref2.getDireita();
            if (ref2 != null) {
                tmp1 = ref1.getAbaixo();
                tmp2 = ref2.getAbaixo();
            }
        }

        // Atribuir os valores
        tmp1 = inicial;
        tmp2 = inicial;
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                tmp2.setValor(valores[i][j]);
                tmp2 = tmp2.getDireita();
            }
            tmp1 = tmp1.getAbaixo();
            tmp2 = tmp1;
        }

        // Limpeza de variaveis
        colunaAtual = null;
        linhaAtual = null;
        tmp = null;
        ref1 = null;
        ref2 = null;
        tmp1 = null;
        tmp2 = null;
    }

    public int getLinhas() {
        return this.linhas;
    }

    public int getColunas() {
        return this.colunas;
    }

    public Nodo getInicial() {
        return this.inicial;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public void setInicial(Nodo inicial) {
        this.inicial = inicial;
    }

    public void mostrar() {
        Nodo linha = inicial;
        Nodo atual = inicial;

        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                System.out.printf("%d ", atual.getValor());
                atual = atual.getDireita();
            }
            System.out.printf("\n");
            linha = linha.getAbaixo();
            atual = linha;
        }

        linha = null;
        atual = null;
    }

    public int getPosicao(int coluna, int linha) {
        Nodo tmp = inicial;
        for (int i = 0; i < coluna; i++) {
            tmp = tmp.getDireita();
        }
        for (int i = 0; i < linha; i++) {
            tmp = tmp.getAbaixo();
        }
        return tmp.getValor();
    }

    public void setPosicao(int coluna, int linha, int valor) {
        Nodo tmp = inicial;
        for (int i = 0; i < coluna; i++) {
            tmp = tmp.getDireita();
        }
        for (int i = 0; i < linha; i++) {
            tmp = tmp.getAbaixo();
        }
        tmp.setValor(valor);
        tmp = null;
    }

    public static Matriz somar(Matriz a, Matriz b) {
        int colunas = a.colunas;
        int linhas = a.linhas;
        int[][] soma = new int[a.colunas][a.linhas];

        Nodo tmpA1 = a.getInicial();
        Nodo tmpA2 = a.getInicial();
        Nodo tmpB1 = b.getInicial();
        Nodo tmpB2 = b.getInicial();
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                soma[i][j] = tmpA2.getValor();
                soma[i][j] += tmpB2.getValor();
                tmpA2 = tmpA2.getDireita();
                tmpB2 = tmpB2.getDireita();
            }
            tmpA1 = tmpA1.getAbaixo();
            tmpB1 = tmpB1.getAbaixo();
            tmpA2 = tmpA1;
            tmpB2 = tmpB1;
        }

        tmpA1 = null;
        tmpA2 = null;
        tmpB1 = null;
        tmpB2 = null;

        return (new Matriz(colunas, linhas, soma));
    }

    public boolean eQuadrada() {
        return this.colunas == this.linhas;
    }

    public static Matriz multiplicar(Matriz a, Matriz b) {
        Matriz c = null;
        if ((a.eQuadrada() && b.eQuadrada()) && (a.getColunas() == b.getLinhas())) {
            c = new Matriz(a.getColunas(), a.getLinhas());
            for (int i = 0; i < a.getLinhas(); i++) {
                for (int j = 0; j < a.getLinhas(); j++) {
                    for (int l = 0; l < a.getLinhas(); l++) {
                        c.setPosicao(i, j, (c.getPosicao(i, j) + (b.getPosicao(i, l) * a.getPosicao(l, j))));
                    }
                }
            }
        }
        return c;
    }

    public void mostrarDiagonalPrincipal() {
        Nodo atual = inicial;
        for (int i = 0; i < this.linhas; i++) {
            System.out.printf("%d ", atual.getValor());
            atual = atual.getAbaixo();
            if (atual != null) {
                atual = atual.getDireita();
            }
        }
        System.out.printf("\n");
    }

    public void mostrarDiagonalSecundaria() {
        Nodo atual = inicial;
        for (int i = 1; i < this.linhas; i++) {
            atual = atual.getDireita();
        }
        for (int i = 0; i < this.linhas; i++) {
            System.out.printf("%d ", atual.getValor());
            atual = atual.getAbaixo();
            if (atual != null) {
                atual = atual.getEsquerda();
            }
        }
        System.out.printf("\n");
    }
}

class MatrizDriver {
    public static void main(String[] args) {
        int n = MyIO.readInt();
        Matriz a;
        Matriz b;
        int linhas;
        int colunas;
        int[][] valores;
        for (int i = 0; i < n; i++) {
            linhas = MyIO.readInt();
            colunas = MyIO.readInt();
            valores = new int[linhas][colunas];
            for (int j = 0; j < linhas; j++) {
                for (int k = 0; k < colunas; k++) {
                    valores[j][k] = MyIO.readInt();
                }
            }
            a = new Matriz(linhas, colunas, valores);

            linhas = MyIO.readInt();
            colunas = MyIO.readInt();
            valores = new int[linhas][colunas];
            for (int j = 0; j < linhas; j++) {
                for (int k = 0; k < colunas; k++) {
                    valores[j][k] = MyIO.readInt();
                }
            }
            b = new Matriz(linhas, colunas, valores);

            a.mostrarDiagonalPrincipal();
            a.mostrarDiagonalSecundaria();
            Matriz.somar(a, b).mostrar();
            Matriz.multiplicar(a, b).mostrar();
        }
    }
}