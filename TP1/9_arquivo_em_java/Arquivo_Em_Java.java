/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 21/08/2022
 */
import java.io.RandomAccessFile;
import java.io.IOException;
class Arquivo_Em_Java {
    // Driver
    public static void main(String[] args) throws IOException{
        int n = MyIO.readInt();
        Double[] entrada = new Double[n];

        // Leitura da entrada padrao
        for (int i = 0; i < n; i++) {
            entrada[i] = MyIO.readDouble();
        }

        // Abrindo arquivo e salvando Doubles
        RandomAccessFile raf = new RandomAccessFile("arquivo", "rw");
        for (int i = 0; i < n; i++) {
            raf.writeDouble(entrada[i]);
        }

        // fechando raf
        raf.close();

        // Lendo inversamente e printando na tela
        raf = new RandomAccessFile("arquivo", "r");

        for(int i = 0; i < n; i++){
            raf.seek((n - i - 1) * 8);
            double number = raf.readDouble();

            if (number == (int)number) {
                MyIO.print((int)number);
            } else {
                MyIO.print(number);
            }
            MyIO.print("\n");
        }

        raf.close();
    }
}