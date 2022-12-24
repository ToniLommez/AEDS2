/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_1 {
    /*
     * Faca metodos ITERATIVO e RECURSIVO para mostrar os numeros 0 a 3
     */
    public static void mostrar() {
        for (int i = 0; i < 4; i = i + 1) {
            System.out.println(i);
        }
    }

    public static void mostrar(int i) {
        if (i < 4) {
            System.out.println(i);
            mostrar(i + 1);
        }
    }

    public static void main(String[] args) {
        mostrar();
        System.out.println("\n");
        mostrar(0);
    }
}
