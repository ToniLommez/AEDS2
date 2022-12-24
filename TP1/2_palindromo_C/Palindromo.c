/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 10/08/2022
 */

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

/**
 * Metodo que recebe uma String e testa se
 * a mesma e' um palindromo, exemplo:
 * arara, reviver, ama, ovo
 *
 * @param s String a ser testada
 * @return True se for um palindromo
 */
bool ePalindromo(char s[])
{
    if (strlen(s) == 0)
    {
        return false;
    }

    for (int i = 0, j = (strlen(s) - 1); i < j; i++, j--)
    {
        if (s[i] != s[j])
        {
            return false;
        }
    }
    return true;
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
