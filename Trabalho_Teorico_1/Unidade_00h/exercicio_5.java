/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class exercicio_5 {
    /*
     * Faca um metodo recursivo que receba um array de numeros inteiros e um
     * numero inteiro n indicando o tamanho do array e retorne o maior elemento
     * 
     * metodo copiado a partir do slide do exercicio
     */
    public static int maior(int vet[], int n) {
        return maior(vet, n, 0);
    }

    public static int maior(int vet[], int n, int i) {
        int resp;
        if (i == n - 1) {
            resp = vet[n - 1];
        } else {
            resp = maior(vet, n, i + 1);
            if (resp < vet[i]) {
                resp = vet[i];
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        int[] num = { 3, 4, 8, 6, 9, 2 };
        MyIO.print(maior(num, 6));
    }
}
