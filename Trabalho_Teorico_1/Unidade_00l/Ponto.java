/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

class Ponto {
    /*
     * • Um aluno desenvolveu a classe abaixo e pediu sua ajuda para compilá-la.
     * Para ajudar, você deve criar uma classe Ponto com as seguintes regras:
     * • Quatro atributos privados: double x, double y, int id e int nextID
     * • Os atributos id e nextID serão alterados somente por um método construtor.
     * • Implemente os métodos get e set tanto para o atributo x como para o y
     * • Na declaração do atributo nextID, o mesmo deve receber zero. Além disso, a
     * alteração do valor desse
     * atributo por um objeto sempre será compartilhada com qualquer objeto da
     * classe ponto
     * • Implemente dois construtores sendo que o primeiro não recebe parâmetros e
     * inicializa os valores de x e
     * y com zero. O segundo recebe dois parâmetros (cujos nomes são
     * obrigatoriamente x e y) e devem ser
     * utilizados para inicializar os valores dos atributos x e y, respectivamente
     * • Os dois construtores devem atribuir o valor corrente do atributo nextID ao
     * atributo id e incrementar o
     * valor de nextID. Observe que cada objeto terá um ID distinto
     * • Implemente qualquer método que seja necessário para compilar a classe
     * LixaoPonto
     */

    private double x;
    private double y;
    private int id;
    private static int nextID = 0;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getID() {
        return id;
    }

    public static int getNextID(){
        return nextID;
    }

    Ponto (){
        this.x = 0;
        this.y = 0;
        this.id = nextID++;
    }

    Ponto (double x, double y){
        this.x = x;
        this.y = y;
        this.id = nextID++;
    }

    public double dist (Ponto p2){
        double x1 = this.x;
        double y1 = this.y;
        double x2 = p2.getX();
        double y2 = p2.getY();
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distancia;
    }

    public double dist (double x2, double y2){
        double x1 = this.x;
        double y1 = this.y;
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distancia;
    }

    public double getAreaRetangulo(Ponto p2) {
        double base = (this.x - p2.x);
        double altura = (this.y - p2.y);
        double area = Math.abs(base * altura);
        return area;
    }

    public static double dist (double x1, double y1, double x2, double y2){
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distancia;
    }

    public static boolean isTriangulo(Ponto p1, Ponto p2, Ponto p3){
        double[][] a = new double[3][3];
        a[0][0] = p1.getX();
        a[1][0] = p2.getX();
        a[2][0] = p3.getX();
        a[0][1] = p1.getY();
        a[1][1] = p2.getY();
        a[2][1] = p3.getY();
        a[0][2] = 1;
        a[1][2] = 1;
        a[2][2] = 1;
        double area = (Math.abs((a[0][0] * a[1][1])
                                - (a[0][0] * a[2][1])
                                + (a[1][0] * a[2][1])
                                - (a[1][0] * a[0][1])
                                + (a[2][0] * a[0][1])
                                - (a[2][0] * a[1][1]))) / 2;
        return ((area > 0)?true:false);
    }


}
