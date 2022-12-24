/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_8 {
    /*
     * Na verdade, no comando c2 = c1 do exercício anterior, o
     * programador gostaria que os atributos do objeto apontado
     * por c2 fossem iguais aos do objeto apontado por c1, contudo,
     * apontando para objetos distintos. Como podemos ajudá-lo?
     */

    public static Cliente setar2(Cliente y) {
        y.setCodigo(6);
        y.setNome("ff");
        return y;
    }

    public static void setar1(Cliente x) {
        x.setCodigo(4);
        x.setNome("dd");
        x = new Cliente(5, "ee");
    }

    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "aa");
        Cliente c2 = null;
        Cliente c3 = new Cliente(2, "bb");
        c2 = c1.clone();
        setar1(c1);
        c3 = setar2(c2);

        System.out.printf("c1(" + c1.getCodigo() + " / " + c1.getNome() + ")" + "\n");
        System.out.printf("c2(" + c2.getCodigo() + " / " + c2.getNome() + ")" + "\n");
        System.out.printf("c3(" + c3.getCodigo() + " / " + c3.getNome() + ")" + "\n");
    }
}