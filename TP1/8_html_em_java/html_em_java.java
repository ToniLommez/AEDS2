
/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 15/08/2022
 */

import java.io.*;
import java.net.*;

class html_em_java {
    /**
     * Metodo para testar se string esta escrito 'FIM'
     * 
     * @param s String a ser testada
     * @return True se for 'FIM'
     */
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    /**
     * Metodo para recuperar conteudo de um Html
     * 
     * @param endereco
     * @return
     */
    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here
        }

        return resp;
    }

    public static boolean eConsoante(char s) {
        boolean eConsoante = true;
        if ((s >= 'b' && s <= 'z') || (s >= 'B' && s <= 'Z')) {
            if (s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U') {
                eConsoante = false;
            } else {
                if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
                    eConsoante = false;
                }
            }
        }
        return eConsoante;
    }

    public static String contagemHtml(String s) {
        MyIO.setCharset("UTF-8");
        int[] v = new int[25];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                // vogais
                case 'a':
                    v[0]++;
                    break;
                case 'e':
                    v[1]++;
                    break;
                case 'i':
                    v[2]++;
                    break;
                case 'o':
                    v[3]++;
                    break;
                case 'u':
                    v[4]++;
                    break;
                // vogais agudas
                case (char) 225:
                    v[5]++;
                    break;
                case (char) 233:
                    v[6]++;
                    break;
                case (char) 237:
                    v[7]++;
                    break;
                case (char) 243:
                    v[8]++;
                    break;
                case (char) 250:
                    v[9]++;
                    break;
                // vogais craze
                case (char) 224:
                    v[10]++;
                    break;
                case (char) 232:
                    v[11]++;
                    break;
                case (char) 236:
                    v[12]++;
                    break;
                case (char) 242:
                    v[13]++;
                    break;
                case (char) 249:
                    v[14]++;
                    break;
                // til
                case (char) 227:
                    v[15]++;
                    break;
                case (char) 245:
                    v[16]++;
                    break;
                // circunflexo
                case (char) 226:
                    v[17]++;
                    break;
                case (char) 234:
                    v[18]++;
                    break;
                case (char) 238:
                    v[19]++;
                    break;
                case (char) 244:
                    v[20]++;
                    break;
                case (char) 251:
                    v[21]++;
                    break;
                default:
                    if (s.charAt(i) == '<') {
                        if (s.charAt(i + 1) == 'b' && s.charAt(i + 2) == 'r' && s.charAt(i + 3) == '>') {
                            v[23]++;
                            i = i + 2;
                        } else {
                            if (s.charAt(i + 1) == 't' && s.charAt(i + 2) == 'a' && s.charAt(i + 3) == 'b'
                                    && s.charAt(i + 4) == 'l' && s.charAt(i + 5) == 'e' && s.charAt(i + 6) == '>') {
                                v[24]++;
                                i = i + 5;
                            }
                        }
                    } else {
                        if (eConsoante(s.charAt(i))) {
                            v[22]++;
                        }
                    }
                    break;
            }
        }

        return "a(" + v[0] + ") " +
                "e(" + v[1] + ") " +
                "i(" + v[2] + ") " +
                "o(" + v[3] + ") " +
                "u(" + v[4] + ") " +
                "á(" + v[5] + ") " +
                "é(" + v[6] + ") " +
                "í(" + v[7] + ") " +
                "ó(" + v[8] + ") " +
                "ú(" + v[9] + ") " +
                "à(" + v[10] + ") " +
                "è(" + v[11] + ") " +
                "ì(" + v[12] + ") " +
                "ò(" + v[13] + ") " +
                "ù(" + v[14] + ") " +
                "ã(" + v[15] + ") " +
                "õ(" + v[16] + ") " +
                "â(" + v[17] + ") " +
                "ê(" + v[18] + ") " +
                "î(" + v[19] + ") " +
                "ô(" + v[20] + ") " +
                "û(" + v[21] + ") " +
                "consoante(" + v[22] + ") " +
                "<br>(" + v[23] + ") " +
                "<table>(" + v[24] + ") ";
    }

    // Driver
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        // Para cada linha de entrada, gerando uma de saida contendo o a palavra cifrada
        // em chave 3
        for (int i = 0; i < numEntrada; i++) {
            MyIO.print(contagemHtml(getHtml(entrada[i + 1])));
            MyIO.print(entrada[i++]);
            MyIO.print("\n");
        }
    }
}