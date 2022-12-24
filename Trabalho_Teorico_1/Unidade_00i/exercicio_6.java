/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */
class exercicio_6 {
    /*
     * Faca o quadro de memoria do programa abaixo
     */

    public static void main(String[] args) {
        Cliente c1 = null, c2 = null, c3 = null;
        System.out.printf("ADDRs:\nc1(" + c1 + ")\nc2(" + c2 + ")\nc3(" + c3 + ")"+ "\n");
        c1 = new Cliente(1, "aa");
        c2 = c1;
        c3 = new Cliente(2, "bb");
        System.out.printf("ADDRs:\nc1(" + c1 + ")\nc2(" + c2 + ")\nc3(" + c3 + ")"+ "\n");
        c2.setCodigo(3);
        System.out.printf("ATRIBUTOs:\n");
        System.out.printf("c1(" + c1.getCodigo() + " / " + c1.getNome() + ")" + "\n");
        System.out.printf("c2(" + c2.getCodigo() + " / " + c2.getNome() + ")" + "\n");
        System.out.printf("c3(" + c3.getCodigo() + " / " + c3.getNome() + ")" + "\n");
    }
}