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
 * Faca um programa que leia n numeros inteiros, armazene-os em um
 * arquivo, leia-os do arquivo e mostre-os na tela
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
        for (int i = size-1; i >= 0; i--) // size-1 ignora o FEOF no fim do arquivo
        {
            fseek(file, i, SEEK_SET);
            fread(&tmp, sizeof(char), 1, file);
            printf("%c", tmp);
        }
    }
    fclose(file);

    return 0;
}