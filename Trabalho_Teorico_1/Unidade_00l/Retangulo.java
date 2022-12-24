/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class Retangulo {
    /*
     * Faca uma classe retangulo contendo os atributos base e
     * altura, pelo menos dois metodos construtores, o metodo
     * double getArea() que retorna a erea do retangulo, o metodo
     * double getPerimetro() que retorna o perimetro do retangulo e
     * o metodo double getDiagonal() que retorna a diagonal do
     * retangulo
     */

    private double base;
    private double altura;

    // Construtor padrao
    Retangulo() {
        this.base = 0;
        this.altura = 0;
    }

    // Construtor inicializando valores
    Retangulo(double b, double h) {
        this.base = b;
        this.altura = h;
    }

    public void setBase(double b) {
        this.base = b;
    }

    public void setAltura(double h) {
        this.altura = h;
    }

    // Retorna Area
    public double getArea() {
        return (base * altura);
    }

    // Retorna perimetro
    public double getPerimetro() {
        return (base * 2 + altura * 2);
    }

    // Retorna diagonal
    public double getDiagonal() {
        return Math.sqrt(base * base + altura * altura);
    }
}