/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_10 {
    /*
     * Faca um metodo recursivo para cada um dos problemas abaixo
     * T(0) = 1
     * T(1) = 2
     * T(n) = T(n-1) * T(n-2) - T(n-1)
     * 
     * T(0) = 1
     * T(n) = T(n-1)2
     */

    public static int p1(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else {
            return ((p1(n-1) * p1(n-2)) + p1(n-1));
        }
    }

    public static int p2(int n) {
        if (n == 0) {
            return 1;
        } else {
            int temp = p2(n-1);
            return (temp*temp);
        }
    }

    public static void main(String[] args) {
        MyIO.print("Testando com n = 5\n");
        MyIO.print(p1(5));
        MyIO.print("\n");
        MyIO.print(p2(5));
    }
}
