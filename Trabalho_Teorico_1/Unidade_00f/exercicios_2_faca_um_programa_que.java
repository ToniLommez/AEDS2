
/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 13/08/2022
 */

import java.io.*;

public class exercicios_2_faca_um_programa_que {
    /**
     * Metodo para escrever frase em arquivo
     * 
     * @throws Exception
     */
    public static void writeString() throws Exception {
        // Enunciado da questao
        MyIO.print("Leia o nome de um arquivo e uma frase e salve essa frase nesse arquivo\n");

        // Ler dados
        MyIO.print("Digite o nome do arquivo:\n->");
        String nome = MyIO.readString();
        MyIO.print("Digite a frase a guardar:\n->");
        String conteudo = MyIO.readLine();

        // Escrever dados
        RandomAccessFile raf = new RandomAccessFile(nome, "rw");
        raf.writeBytes(conteudo);

        // Fechar arquivo
        raf.close();
        MyIO.print("\nArquivo salvo com sucesso\n");
    }

    /**
     * Metodo para ler conteudo de um arquivo e printar o seu conteudo
     * 
     * @throws Exception
     */
    public static void printFile() throws Exception {
        // Enunciado da questao
        MyIO.print("Leia o nome de um arquivo e mostre seu conteudo na tela\n");

        // Ler dados
        MyIO.print("Digite o nome do arquivo:\n->");
        String nome = MyIO.readString();
        MyIO.print("Conteudo:\n\n");

        // Ler e printar dados
        RandomAccessFile raf = new RandomAccessFile(nome, "rw");
        while (raf.getFilePointer() < raf.length()) {
            MyIO.print(raf.readLine());
            MyIO.print("\n");
        }

        // Fechar arquivo
        raf.close();
    }

    /**
     * Metodo para transformar caractere minusculo em maiusculo
     * 
     * @param c caractere a ser transformado
     * @return caractere maiusculo
     */
    public static char toUpper(char c) {
        return (c >= 'a' && c <= 'z') ? ((char) (c - 32)) : c;
    }

    /**
     * Metodo que transforma uma String em maiusculo
     * 
     * @param s String a ser transformada
     * @return a String em maiusculo
     */
    public static String toUpperCase(String s) {
        String resp = "";
        for (int i = 0; i < s.length(); i++) {
            resp += toUpper(s.charAt(i));
        }
        return resp;
    }

    /**
     * Metodo para ler conteudo de um arquivo e printar o seu conteudo em maiusculo
     * 
     * @throws Exception
     */
    public static void printFileUpperCase() throws Exception {
        // Enunciado da questao
        MyIO.print("Leia o nome de um arquivo e mostre seu conteudo convertido para letras maiusculas\n");

        // Ler dados
        MyIO.print("Digite o nome do arquivo:\n->");
        String nome = MyIO.readString();
        MyIO.print("Conteudo:\n\n");

        // Ler e printar dados
        RandomAccessFile raf = new RandomAccessFile(nome, "rw");
        String temp;
        String resp;
        while (raf.getFilePointer() < raf.length()) {
            temp = raf.readLine();
            resp = toUpperCase(temp);
            MyIO.print(resp);
            MyIO.print("\n");
        }

        // Fechar arquivo
        raf.close();
    }

    /**
     * Metodo para duplicar um arquivo
     * 
     * @param nome nome do arquivo a ser duplicado
     */
    public static void duplicateFile() throws Exception {
        // Enunciado da questao
        MyIO.print("Leia o nome de dois arquivos e copie o conteudo do primeiro para o ultimo\n");

        // Ler dados
        MyIO.print("Digite o nome do arquivo a ser lido:\n->");
        String nome = MyIO.readString();
        MyIO.print("Digite o nome do arquivo a ser gravado:\n->");
        String novoNome = MyIO.readString();

        // Ler e gravar dados
        RandomAccessFile rafRead = new RandomAccessFile(nome, "rw");
        RandomAccessFile rafWrite = new RandomAccessFile(novoNome, "rw");
        String temp;
        while (rafRead.getFilePointer() < rafRead.length()) {
            temp = rafRead.readLine();
            rafWrite.writeBytes(temp);
            rafWrite.writeBytes("\n");
        }

        // Fechar arquivo
        rafWrite.close();
        MyIO.print("\nArquivo salvo com sucesso\n");
        rafRead.close();
    }

    /**
     * Metodo para duplicar um arquivo em letras maiusculas
     * 
     * @param nome nome do arquivo a ser duplicado
     */
    public static void duplicateFileUpperCase() throws Exception {
        // Enunciado da questao
        MyIO.print("Leia o nome de dois arquivos e copie o conteudo do primeiro para o ultimo\n");

        // Ler dados
        MyIO.print("Digite o nome do arquivo a ser lido:\n->");
        String nome = MyIO.readString();
        MyIO.print("Digite o nome do arquivo a ser gravado:\n->");
        String novoNome = MyIO.readString();

        // Ler e gravar dados
        RandomAccessFile rafRead = new RandomAccessFile(nome, "rw");
        RandomAccessFile rafWrite = new RandomAccessFile(novoNome, "rw");
        String temp;
        String resp;
        while (rafRead.getFilePointer() < rafRead.length()) {
            temp = rafRead.readLine();
            resp = toUpperCase(temp);
            rafWrite.writeBytes(resp);
            rafWrite.writeBytes("\n");
        }

        // Fechar arquivo
        rafWrite.close();
        MyIO.print("\nArquivo salvo com sucesso\n");
        rafRead.close();
    }

    /**
     * Metodo para inverter a ordem de uma String
     * 
     * @param s String a ser invertida
     * @return String invertida
     */
    public static String invertString(String s) {
        String resposta = "";
        for (int i = 0; i < s.length(); i++) {
            resposta = s.charAt(i) + resposta;
        }
        return resposta;
    }

    /**
     * Metodo para duplicar um arquivo com os caracteres invertidos
     * 
     * @param nome nome do arquivo a ser duplicado
     */
    public static void duplicateFileInverted() throws Exception {
        // Enunciado da questao
        MyIO.print(
                "Leia o nome de dois arquivos e copie o conteudo do primeiro para o segundo invertendo a ordem dos caracteres. \n");

        // Ler dados
        MyIO.print("Digite o nome do arquivo a ser lido:\n->");
        String nome = MyIO.readString();
        MyIO.print("Digite o nome do arquivo a ser gravado:\n->");
        String novoNome = MyIO.readString();

        // Ler e gravar dados
        RandomAccessFile rafRead = new RandomAccessFile(nome, "rw");
        RandomAccessFile rafWrite = new RandomAccessFile(novoNome, "rw");
        String temp = "";
        while (rafRead.getFilePointer() < rafRead.length()) {
            temp += rafRead.readLine();
            if (rafRead.getFilePointer() < rafRead.length()) {
                temp += "\n";
            }
        }
        temp = invertString(temp);
        rafWrite.writeChars(temp);

        // Fechar arquivo
        rafWrite.close();
        MyIO.print("\nArquivo salvo com sucesso\n");
        rafRead.close();
    }

    /**
     * Metodo para criptografar uma String na cifra de cesar
     * 
     * @param s   String a ser criptografada
     * @param key chave de criptografia
     * @return String criptografada
     */
    public static String encrypt(String s, int key) {
        String resp = "";
        for (int i = 0; i < s.length(); i++) {
            resp += (char) (s.charAt(i) + key);
        }
        return resp;
    }

    /**
     * Metodo que printa um arquivo de forma criptografada na cifra de cesar
     * com chave de criptografia 3
     * 
     * @throws Exception
     */
    public static void showEncrypted() throws Exception {
        // Enunciado da questao
        MyIO.print(
                "Leia o nome de um arquivo e mostre na tela o conteudo desse arquivo criptografado usando o ciframento de Cesar (k = 3)\n");

        // Ler dados
        MyIO.print("Digite o nome do arquivo:\n->");
        String nome = MyIO.readString();
        MyIO.print("Criptografado:\n\n");

        // Ler e printar dados
        RandomAccessFile raf = new RandomAccessFile(nome, "rw");
        String temp;
        String resp;
        while (raf.getFilePointer() < raf.length()) {
            temp = raf.readLine();
            resp = encrypt(temp, 3);
            MyIO.print(resp);
            MyIO.print("\n");
        }

        // Fechar arquivo
        raf.close();
    }

    /**
     * Metodo para descriptografar uma String na cifra de cesar
     * 
     * @param s   String a ser criptografada
     * @param key chave de criptografia
     * @return String criptografada
     */
    public static String decrypt(String s, int key) {
        String resp = "";
        for (int i = 0; i < s.length(); i++) {
            resp += (char) (s.charAt(i) - key);
        }
        return resp;
    }

    /**
     * Metodo que descriptografa um arquivo na cifra de cesar com chave 3
     * e depois printa a mensagem
     * 
     * @throws Exception
     */
    public static void showDecrypted() throws Exception {
        // Enunciado da questao
        MyIO.print(
                "Leia o nome de um arquivo contendo uma mensagem criptografada com o Ciframento de Cesar (k = 3), descriptografe a mensagem e mostre-a na tela\n");

        // Ler dados
        MyIO.print("Digite o nome do arquivo:\n->");
        String nome = MyIO.readString();
        MyIO.print("Descriptografado:\n\n");

        // Ler e printar dados
        RandomAccessFile raf = new RandomAccessFile(nome, "rw");
        String temp;
        String resp;
        while (raf.getFilePointer() < raf.length()) {
            temp = raf.readLine();
            resp = decrypt(temp, 3);
            MyIO.print(resp);
            MyIO.print("\n");
        }

        // Fechar arquivo
        raf.close();
    }

    public static void main(String[] args) throws Exception {
        // Enunciado
        MyIO.print("Neste programa esta contido os exercicios da sessao 'Exercicio: Faca um programa que'");

        // Escolha do exercicio
        int opcao = -1;
        while (opcao != 0) {
            MyIO.print("\n\n");
            MyIO.print("Escolha a questao a realizar:\n\n");
            MyIO.print("0 - Sair\n");
            MyIO.print("1 - Ler nome e frase e escrever em arquivo\n");
            MyIO.print("2 - Ler nome e mostrar conteudo na tela\n");
            MyIO.print("3 - Ler nome e mostrar conteudo em maiusculo\n");
            MyIO.print("4 - Ler nome de dois arquivos e copiar primeiro para o segundo\n");
            MyIO.print("5 - Ler nome de dois arquivos e copiar o primeiro para o segundo em maiusculo\n");
            MyIO.print("6 - Ler dois arquivos e copiar o primeiro para o segundo invertendo a ordem\n");
            MyIO.print("7 - Leia o nome de um arquivo e mostre o seu conteudo na cifra de cesar (k = 3)\n");
            MyIO.print("8 - Leia o nome de um arquivo criptografado (k = 3) e mostre descriptografado\n");
            MyIO.print("->");
            opcao = MyIO.readInt();
            MyIO.print("\n\n");
            switch (opcao) {
                case 0:
                    MyIO.print("\nObrigado!\n");
                    break;
                case 1:
                    writeString();
                    break;
                case 2:
                    printFile();
                    break;
                case 3:
                    printFileUpperCase();
                    break;
                case 4:
                    duplicateFile();
                    break;
                case 5:
                    duplicateFileUpperCase();
                    break;
                case 6:
                    duplicateFileInverted();
                    break;
                case 7:
                    showEncrypted();
                    break;
                case 8:
                    showDecrypted();
                    break;
                default:
                    MyIO.print("Opcao Invalida\n");
                    break;
            }
            MyIO.print("\nAperte ENTER para continuar\n");
            MyIO.readLine();
            MyIO.print("\n---------------------------\n");
        }
    }
}