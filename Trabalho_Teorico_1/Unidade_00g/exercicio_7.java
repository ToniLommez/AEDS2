/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

class exercicio_7 {
    /*
     * O banco do Ze abriu uma linha de credito para os seus clientes. O valor
     * maximo da prestacao nao podera ultrapassar 40 % do salario bruto. Fazer
     * um algoritmo que permita entrar com o salario bruto e o valor da prestacao
     * e informar se o emprestimo sera concedido.
     */
    public static void main(String[] args) {
        MyIO.print("Digite o salario bruto:\n-> ");
        int salario = MyIO.readInt();
        MyIO.print("Digite o valor da prestacao\n-> ");
        int prestacao = MyIO.readInt();
        
        if ((salario*0.4) < prestacao) {
            MyIO.print("Emprestimo negado");
        } else {
            MyIO.print("Emprestimo concedido\n");
        }

    }
}