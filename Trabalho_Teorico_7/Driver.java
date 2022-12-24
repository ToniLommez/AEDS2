/* 
 * Algoritmo e Estrutura de Dados 2
 * Trabalho Teorico 7
 * 
 * Marcos Antonio Lommez Candido Ribeiro
 * 771157
 * 31/10/2022 
*/

import java.util.Scanner;

class Contato {
    private String nome;
    private String telefone;
    private String email;
    private int cpf;

    public Contato() {
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.cpf = -1;
    }

    public Contato(String nome, String telefone, String email, int cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public int getCpf() {
        return this.cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}

class Celula {
    private Contato contato;
    private Celula prox;

    public Celula() {
        this.contato = new Contato();
        this.prox = null;
    }

    public Celula(Contato contato, Celula prox) {
        this.contato = contato;
        this.prox = prox;
    }

    public Contato getContato() {
        return this.contato;
    }

    public Celula getProx() {
        return this.prox;
    }

    public String getNome() {
        return this.contato.getNome();
    }

    public int getCpf() {
        return this.contato.getCpf();
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }

    public boolean hasProx() {
        return (this.prox != null);
    }

    public void inserir(Contato contato) {
        Celula nova = new Celula(contato, prox);
        setProx(nova);
        nova = null;
    }

    public String toString() {
        String tmp = "";
        tmp += "Nome:  " + getContato().getNome() + "\n";
        tmp += "Tel.:  " + getContato().getTelefone() + "\n";
        tmp += "Email: " + getContato().getEmail() + "\n";
        tmp += "Cpf:   " + Integer.toString(getContato().getCpf()) + "\n";
        return tmp;
    }
}

class No {
    private char letra;
    private No esq;
    private No dir;
    private Celula primeiro;
    private Celula ultimo;

    public No(char letra) {
        this.letra = letra;
        this.esq = null;
        this.dir = null;
        this.primeiro = new Celula();
        this.ultimo = primeiro;
    }

    public char getLetra() {
        return this.letra;
    }

    public No getEsq() {
        return this.esq;
    }

    public No getDir() {
        return this.dir;
    }

    public Celula getPrimeiro() {
        return this.primeiro;
    }

    public Celula getUltimo() {
        return this.ultimo;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public void setPrimeiro(Celula primeiro) {
        this.primeiro = primeiro;
    }

    public void setUltimo(Celula ultimo) {
        this.ultimo = ultimo;
    }

    public void printAll() {
        Celula tmp = getPrimeiro();
        while (tmp.hasProx()) {
            tmp = tmp.getProx();
            System.out.printf("%s\n", tmp.toString());
        }
    }

    public boolean pesquisar(String nome) {
        Celula atual = primeiro;
        boolean achou = false;
        while (atual.hasProx() && !achou) {
            atual = atual.getProx();
            if (atual.getNome().compareTo(nome) == 0) {
                System.out.printf("\n%s", atual.toString());
                achou = true;
            }
        }
        return achou;
    }

    public boolean pesquisar(int cpf) {
        Celula atual = primeiro;
        boolean achou = false;
        while (atual.hasProx() && !achou) {
            atual = atual.getProx();
            if (atual.getCpf() == cpf) {
                System.out.printf("\n%s", atual.toString());
                achou = true;
            }
        }
        return achou;
    }
}

class Agenda {
    private No raiz;

    public Agenda() {
        char letras[] = { 'M', 'F', 'T', 'C', 'I', 'P', 'W',
                'A', 'B', 'D', 'E', 'G', 'H', 'J', 'K', 'L',
                'N', 'O', 'Q', 'R', 'S', 'U', 'V', 'X', 'Y', 'Z' };
        for (char c : letras) {
            this.inserir(c);
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public No getLetra(char letra) {
        return getLetra(letra, getRaiz());
    }

    private No getLetra(char letra, No no) {
        if (letra != no.getLetra()) {
            if (letra < no.getLetra()) {
                no = getLetra(letra, no.getEsq());
            } else {
                no = getLetra(letra, no.getDir());
            }
        }
        return no;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    private void inserir(char c) {
        setRaiz(inserir(c, getRaiz()));
    }

    private No inserir(char c, No tmp) {
        if (tmp == null) {
            tmp = new No(c);
        } else if (tmp.getLetra() > c) {
            tmp.setEsq(inserir(c, tmp.getEsq()));
        } else if (tmp.getLetra() < c) {
            tmp.setDir(inserir(c, tmp.getDir()));
        }
        return tmp;
    }

    public boolean inserir(Contato contato) {
        boolean sucesso = true;
        char letra = contato.getNome().charAt(0);
        No no = getLetra(letra);

        Celula celula = no.getPrimeiro();
        while (sucesso && celula.hasProx() && celula.getProx().getNome().compareTo(contato.getNome()) <= 0) {
            celula = celula.getProx();
        }
        if (celula.getNome().compareTo(contato.getNome()) != 0) {
            celula.inserir(contato);
        } else {
            sucesso = false;
            celula.setContato(contato);
        }
        if (!celula.hasProx()) {
            no.setUltimo(celula);
        }
        return sucesso;
    }

    public boolean remover(String nome) {
        boolean apagado = false;
        char letra = nome.charAt(0);
        No no = this.getRaiz();
        while (no.getLetra() != letra) {
            if (no.getLetra() > letra) {
                no = no.getEsq();
            } else {
                no = no.getDir();
            }
        }
        Celula anterior = no.getPrimeiro();
        Celula atual = anterior;

        do {
            anterior = atual;
            atual = atual.getProx();
            if (atual.getNome().compareTo(nome) == 0) {
                anterior.setProx(atual.getProx());
                atual.setProx(null);
                apagado = true;
            }
        } while (atual.hasProx() && !apagado);
        if (!atual.hasProx()) {
            no.setUltimo(atual);
        }
        return apagado;
    }

    public void printAll() {
        printAll(getRaiz());
    }

    private void printAll(No no) {
        if (no != null) {
            this.printAll(no.getEsq());
            no.printAll();
            this.printAll(no.getDir());
        }
    }

    public boolean pesquisar(String nome) {
        char letra = nome.charAt(0);
        No no = getLetra(letra);
        return no.pesquisar(nome);
    }

    public boolean pesquisar(int cpf) {
        return pesquisar(cpf, getRaiz(), false);
    }

    private boolean pesquisar(int cpf, No no, boolean achou) {
        if (!achou && (no != null)) {
            achou = no.pesquisar(cpf) || pesquisar(cpf, no.getEsq(), achou) || pesquisar(cpf, no.getDir(), achou);
        }
        return achou;
    }

}

class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("\033[H\033[2J");
        System.out.printf("Marcos Antonio Lommez Candido Ribeiro - 771157\n");
        System.out.printf("Trabalho Teorico 7\n\n");
        System.out.printf("Aperte ENTER para comecar");

        String opcaoStr = sc.nextLine();
        Agenda agenda = new Agenda();
        int cpf, opcaoInt = 0;
        String nome, telefone, email;
        boolean inserido, removido, encontrado;

        do {
            System.out.printf("\033[H\033[2J");
            System.out.printf("========= Menu =========\n");
            System.out.printf("1 - Adicionar\n");
            System.out.printf("2 - Remover\n");
            System.out.printf("3 - Pesquisar por nome\n");
            System.out.printf("4 - Pesquisar por cpf\n");
            System.out.printf("5 - Mostrar todos\n");
            System.out.printf("6 - sair\n");
            System.out.printf("========================\n");
            System.out.printf("\n");
            System.out.printf("> ");
            opcaoStr = sc.nextLine();
            opcaoInt = Integer.parseInt(opcaoStr);
            System.out.printf("\n");

            switch (opcaoInt) {
                case 1: // Adicionar
                    System.out.printf("Nome: ");
                    nome = sc.nextLine();
                    System.out.printf("Telefone: ");
                    telefone = sc.nextLine();
                    System.out.printf("Email: ");
                    email = sc.nextLine();
                    System.out.printf("Cpf: ");
                    cpf = Integer.parseInt(sc.nextLine());
                    nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
                    inserido = agenda.inserir(new Contato(nome, telefone, email, cpf));
                    System.out.printf("\n%s\n", inserido ? "Usuario inserido!" : "Usuario atualizado!");
                    break;

                case 2: // Remover
                    System.out.printf("Nome: ");
                    nome = sc.nextLine().trim();
                    nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
                    removido = agenda.remover(nome);
                    System.out.printf("\n%s\n", removido ? "Usuario apagado!" : "Usuario nao encontrado!");
                    break;

                case 3: // Pesquisar por nome
                    System.out.printf("Nome: ");
                    nome = sc.nextLine().trim();
                    nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
                    encontrado = agenda.pesquisar(nome);
                    System.out.printf("%s", encontrado ? " " : "\nUsuario nao encontrado!\n");
                    break;

                case 4: // Pesquisar por cpf
                    System.out.printf("Cpf: ");
                    cpf = Integer.parseInt(sc.nextLine().trim());
                    encontrado = agenda.pesquisar(cpf);
                    System.out.printf("%s", encontrado ? " " : "\nUsuario nao encontrado!\n");
                    break;

                case 5: // Mostrar todos
                    System.out.printf("\033[H\033[2J");
                    agenda.printAll();
                    break;

                case 6:
                    sc.close();
                    System.out.printf("byebye!\n\n");
                    break;

                default:
                    System.out.printf("Opcao Invalida!\n");
                    break;

            }
            if (opcaoInt != 6) {
                System.out.printf("\n> Aperte ENTER para continuar <\n");
                sc.nextLine();
            }
        } while (opcaoInt != 6);

    }
}