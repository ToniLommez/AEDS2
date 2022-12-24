/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 14/08/2022
 */

#include <stdlib.h>
#include <stdio.h>
#include <math.h>

/**
 * Faça um programa que leia n números inteiros e os mostre a soma do
 * primeiro e último, segundo e penúltimo e assim sucessivamente.
 * Novamente, sem usar arrays
 */
int main()
{
    FILE *file = fopen("exemplo.txt", "r");

    if (!file)
    {
        printf("exemplo.txt nao encontrado! saindo");
    }
    else
    {
        char tmp = '\0';
        fseek(file, 0L, SEEK_END);
        int size = ftell(file);
        int valor1 = 0;
        int valor2 = 0;
        for (int i = size-1, j = 0; i >= j; i--, j++) // size-1 ignora o FEOF no fim do arquivo
        {
            fseek(file, j, SEEK_SET);
            fread(&tmp, sizeof(char), 1, file);
            valor1 = tmp - '0';
            fseek(file, i, SEEK_SET);
            fread(&tmp, sizeof(char), 1, file);
            valor2 = tmp - '0';
            printf("%d + %d = %d\n", valor1, valor2, valor1+valor2);
        }
    }
    fclose(file);

    return 0;
}