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
int main(){
    printf("Escolha quantos numeros escrever:\n->");
    int n;
    scanf("%d", &n);
    printf("\nEscreva os numeros:\n");
    FILE* arquivo = fopen("exemplo.txt", "w");
    for(int i = 0; i < n; i++){
        int tmp;
        printf("[%d]->", i);
        scanf("%d", &tmp);
        fflush(stdin);
        fprintf(arquivo, "%d\n", tmp);
    }
    fclose(arquivo);
    printf("Arquivo salvo com sucesso\n");
    arquivo = fopen("exemplo.txt", "r");
    for(int i = 0; i < n; i++){
        int tmp;
        fscanf(arquivo, "%d", &tmp);
        printf("\n%d", tmp);
    }

    fclose(arquivo);

    return 0;
}