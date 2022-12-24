/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class Cliente {
    String nome;
    int codigo;

    public Cliente(int a, String b) {
        codigo = a;
        nome = b;
    }

    public Cliente() {
    }

    public void setCodigo(int x) {
        codigo = x;
    }

    public void setNome(String s) {
        nome = s;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public Cliente clone() {
        Cliente resp = new Cliente();
        resp.codigo = this.codigo;
        resp.nome = this.nome;
        return resp;
    }
}