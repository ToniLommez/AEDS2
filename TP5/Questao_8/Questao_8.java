import java.util.*;

class No {
    private int valor;
    private No esq;
    private No dir;

    public No() {
        this.valor = 0;
        this.esq = null;
        this.dir = null;
    }

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public No(int valor, No esq, No dir) {
        this.valor = valor;
        this.esq = esq;
        this.dir = dir;
    }

    public int getValor() {
        return this.valor;
    }

    public No getEsq() {
        return this.esq;
    }

    public No getDir() {
        return this.dir;
    }

    public void setValor(int valor) {
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

    public void inserir(int x) {
        raiz = inserir(x, raiz);
    }

    private No inserir(int x, No i) {
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

    public boolean pesquisar(int x) {
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(int x, No i) {
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
    }
    
    public void caminharCentral() {
        caminharCentral(raiz);
    }
    
    public void caminharPos() {
        caminharPos(raiz);
    }

	private void caminharPre(No i) {
		if (i != null) {
			System.out.printf(" %d", i.getValor());
			caminharPre(i.getEsq());
			caminharPre(i.getDir());
		}
	}

    private void caminharCentral(No i) {
		if (i != null) {
            caminharCentral(i.getEsq());
			System.out.printf(" %d", i.getValor());
			caminharCentral(i.getDir());
		}
	}

    private void caminharPos(No i) {
		if (i != null) {
            caminharPos(i.getEsq());
			caminharPos(i.getDir());
			System.out.printf(" %d", i.getValor());
		}
	}
}

class Questao_8 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int repeticoes = sc.nextInt();
        for (int i = 0; i < repeticoes; i++) {
            ArvoreBinaria ab = new ArvoreBinaria();
            for (int j = sc.nextInt(); j > 0; j--) {
                ab.inserir(sc.nextInt());
            }
            System.out.printf("Case %d:", i+1);
            System.out.printf("\nPre.:");
            ab.caminharPre();
            System.out.printf("\nIn..:");
            ab.caminharCentral();
            System.out.printf("\nPost:");
            ab.caminharPos();

            System.out.printf("\n");
            if (i < repeticoes - 1) {
                System.out.printf("\n");
            }
        }
    }
}
