/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 21/08/2022
 */

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

/**
 * Metodo recursivo que recebe uma String e testa se
 * a mesma e' um palindromo, exemplo:
 * arara, reviver, ama, ovo
 *
 * @param s String a ser testada
 * @param i Inicio da String
 * @param j Final da String
 * @return True se for um palindromo
 */
bool ePalindromoRec(char s[], int i, int j)
{
    bool resp = true;
    if (i >= j)
    {
        resp = true;
    }
    else if (s[i] != s[j])
    {
        resp = false;
    }
    else
    {
        resp = ePalindromoRec(s, i + 1, j - 1);
    }
    return resp;
}

/**
 * Metodo inicializador do metodo de recursivo
 * @param s String a ser testada
 * @return True se for um palindromo
 */
bool ePalindromo(char s[])
{
    return ePalindromoRec(s, 0, (strlen(s) - 1));
}

/**
 * Metodo para testar se a String contem a palavra 'FIM'
 *
 * @param s String a testar
 * @return True se for 'FIM'
 */
bool isFim(char s[])
{
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

// Driver
int main()
{
    char entrada[1000];

    for (; !isFim(entrada);)
    {
        scanf(" %1000[^\n]", entrada);
        if (!isFim(entrada))
            printf("%s\n", ePalindromo(entrada) ? "SIM" : "NAO");
    }

    return 0;
}
