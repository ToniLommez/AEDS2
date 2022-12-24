
/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

import java.io.*;

class exercicios_1_exemplos_e_duplicar {
    /**
     * Metodo proposto para teste de escrita em arquivo
     */
    public static void exemploArq01Escrita() {
        Arq.openWrite("exemplo.txt");

        // Escrever no arquivo texto
        Arq.println(1);
        Arq.println(5.3);
        Arq.println('X');
        Arq.println(true);
        Arq.println("Algoritmos");

        // Fechar o arquivo texto
        Arq.close();
    }

    /**
     * Metodo proposto para teste de leitura de arquivo
     */
    public static void exemploArq02Leitura() {
        // Abrir o arquivo texto
        Arq.openRead("exemplo.txt");

        // Ler o arquivo texto
        int inteiro = Arq.readInt();
        double real = Arq.readDouble();
        char caractere = Arq.readChar();
        boolean boleano = Arq.readBoolean();
        String str = Arq.readString();

        // Fechar o arquivo texto
        Arq.close();

        // Mostrar os valores lidos na tela
        MyIO.println("inteiro: " + inteiro);
        MyIO.println("real: " + real);
        MyIO.println("caractere: " + caractere);
        MyIO.println("boleano: " + boleano);
        MyIO.println("str: " + str);
    }

    /**
     * Metodo de exemplo para Escrita em arquivo usando a classe RandomAccessFile
     */
    public static void exemploRAF01Escrita() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");

        raf.writeInt(1);
        raf.writeDouble(5.3);
        raf.writeChar('X');
        raf.writeBoolean(true);
        raf.writeBytes("Algoritmos");

        raf.close();
    }

    /**
     * Metodo de exemplo para Leitura de arquivo usando a classe RandomAccessFile
     */
    public static void exemploRAF02Leitura() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");

        int inteiro = raf.readInt();
        double real = raf.readDouble();
        char caractere = raf.readChar();
        boolean boleano = raf.readBoolean();
        String str = raf.readLine();

        raf.close();

        System.out.println("inteiro: " + inteiro);
        System.out.println("real: " + real);
        System.out.println("caractere: " + caractere);
        System.out.println("boleano: " + boleano);
        System.out.println("str: " + str);
    }

    /**
     * Metodo para Exemplo de uso do Cabecote da classe RandomAccessFile
     */
    public static void exemploRAF03Cabecote() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");

        raf.writeInt(1);
        raf.writeDouble(5.3);
        raf.writeChar('X');
        raf.writeBoolean(true);
        raf.writeBytes("Algoritmos");

        raf.seek(0); // Retornando o cabecote para a posicao 0
        System.out.println(raf.readInt()); // imprimindo o inteiro

        raf.seek(12); // Setando o cabecote na posicao 12 (do caractere,
                      // 12 = 4 do int + 8 do double)
        System.out.println(raf.readChar());

        raf.seek(12); // Setando o cabecote novamente na posicao 12
        raf.writeChar('@'); // Substituindo o caractere

        raf.seek(12);
        System.out.println(raf.readChar());

        raf.close();
    }

    /**
     * Metodo para duplicar um arquivo
     * 
     * @param nome nome do arquivo a ser duplicado
     */
    public static void duplicateFile(String nome, String novoNome) {

        // Abrir o arquivo de leitura
        Arq.openRead(nome);

        // Armazenar arquivo
        String str = Arq.readAll();

        // Fechar o arquivo texto
        Arq.close();

        // Abrir o arquivo de Escrita
        Arq.openWrite(novoNome);

        // Duplicar arquivo
        Arq.println(str);

        // Fechar o arquivo texto
        Arq.close();
    }

    public static void main(String[] args) throws Exception {
        // Exercicio, execute e brinque com os arquivos ...
        System.out.printf("Realizando exemploArq01Escrita\n");
        exemploArq01Escrita();
        System.out.printf("\n");
        System.out.printf("Realizando exemploArq02Leitura\n");
        exemploArq02Leitura();
        System.out.printf("\n");

        // Faça um programa que abre um arquivo e cria uma copia
        System.out.printf("Exercicio: Faça um programa que abre um arquivo e cria uma copia\n");
        duplicateFile("exemplo.txt", "exemplo2.txt");
        System.out.printf("exemplo.txt duplicado com sucesso em exemplo2.txt\n");
        System.out.printf("\n");

        // Exercicio, execute e brinque com os arquivos ...
        System.out.printf("Realizando exemploRAF01Escrita\n");
        exemploRAF01Escrita();
        System.out.printf("\n");
        System.out.printf("Realizando exemploRAF02Leitura\n");
        exemploRAF02Leitura();
        System.out.printf("\n");
        System.out.printf("Realizando exemploRAF03Cabecote\n");
        exemploRAF03Cabecote();
        System.out.printf("\n");
    }
}