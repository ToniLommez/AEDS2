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
typedef struct Cliente
{
    int codigo;
    double salario;
} Cliente;

int main()
{
    Cliente c;
    c.codigo = 5;
    Cliente *p = NULL;
    p = (Cliente *)malloc(sizeof(Cliente));
    p->codigo = 6;
    Cliente *p2 = &c;
    p2->codigo = 7;
    return 0;
}