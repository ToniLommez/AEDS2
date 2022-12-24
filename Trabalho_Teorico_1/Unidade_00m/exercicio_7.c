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
 * Execute o programa abaixo, supondo os atributos
 * código (int) e salário (double) para cada Cliente
 *
 * c.codigo = 5
 * p->codigo = 6
 * c.codigo = 7
 */
typedef struct Celula
{
    int elemento;
    struct Celula *prox;
} Celula;

Celula *novaCelula(int elemento)
{
    Celula *nova = (Celula *)malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->prox = NULL;
    return nova;
}

int main(){
    Celula* celula = novaCelula(5);
    printf("%d", celula->elemento);
    return 0;
}