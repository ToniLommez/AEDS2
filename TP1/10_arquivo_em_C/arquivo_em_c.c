/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 21/08/2022
 */

#include <stdio.h>

// Driver
int main()
{
    int n = 0;
    scanf("%d", &n);
    double entrada[n];
    double temp = 0;

    // Leitura da entrada padrao
    for (int i = 0; i < n; i++)
    {
        scanf("%lf", &temp);
        entrada[i] = temp;
    }

    // Abrindo arquivo e salvando Doubles
    FILE *escrita = fopen("arquivo", "wb+");
    for (int i = 0; i < n; i++)
    {
        temp = entrada[i];
        fwrite(&temp, 8, 1, escrita);
    }

    // fechando raf
    fclose(escrita);

    // Lendo inversamente e printando na tela
    FILE *leitura = fopen("arquivo", "rb+");

    for (int i = 0; i < n; i++)
    {
        fseek(leitura, (n - i - 1) * 8, SEEK_SET);
        fread(&temp, 8, 1, leitura);
        printf("%g\n", temp);
    }

    // fechando raf
    fclose(leitura);

    return 0;
}