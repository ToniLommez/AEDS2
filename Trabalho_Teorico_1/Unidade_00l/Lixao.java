/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class Lixao {
    /*
     * Faca tambem uma classe Lixao contendo um metodo main
     * sendo que esse tera dois objetos do tipo retangulo e chamara
     * os metodos desenvolvidos na classe retangulo
     */

    public static void main(String[] args) {
        // Inicializando valores
        Retangulo a = new Retangulo();
        MyIO.print("Entre com a base:\n->");
        a.setBase(MyIO.readDouble());
        MyIO.print("Entre com a altura:\n->");
        a.setAltura(MyIO.readDouble());
        
        // Printando relacoes
        MyIO.print("\nArea do retangulo:\n->");
        MyIO.print(a.getArea());
        MyIO.print("\nPerimetro do retangulo:\n->");
        MyIO.print(a.getPerimetro());
        MyIO.print("\nDiagonal do retangulo:\n->");
        MyIO.print(a.getDiagonal());
    }
}
