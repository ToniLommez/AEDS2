/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_3 {
    /*
     * Faca o quadro de memoria do programa abaixo
     */
    public static void passagemDeTipoPrimitivo(int a) {
        System.out.printf("a: " + a + "\n");
        a = 10;
        System.out.printf("a: " + a + "\n");
    }

    public static void main(String[] args) {
        int x = 5;
        System.out.printf("x: " + x + "\n");
        passagemDeTipoPrimitivo(x);
        System.out.printf("x: " + x + "\n");
    }

}
