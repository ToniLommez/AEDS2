/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 15/08/2022
 */

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

/**
 * Transforma um caractere em maiusculo
 *
 * @param c Caractere a ser transformado
 * @return Se este for minusculo, retornara em maiusculo
 */
char toMaiusculo(char c)
{
    return ((c >= 'a' && c <= 'z') ? (char)(c - 32) : c);
}

/**
 * Testa se uma String possui apenas vogais
 * Primeiro transforma em maiusculo para diminuir a quantidade de testes
 *
 * @param s String a ser testada
 * @return True se todos os caracteres forem apenas vogais
 */
bool eVogal(char s[])
{
    bool eVogal = true;
    for (int i = 0; i < strlen(s); i++)
    {
        char c = toMaiusculo(s[i]);
        if (!(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'))
        {
            eVogal = false;
            i = strlen(s);
        }
    }
    return eVogal;
}

/**
 * Testa se uma String possui apenas consoantes
 * Primeiro transforma em maiusculo para diminuir a quantidade de testes
 *
 * @param s String a ser testada
 * @return True se todos os caracteres forem apenas consoantes
 */
bool eConsoante(char s[])
{
    bool eConsoante = true;
    for (int i = 0; i < strlen(s); i++)
    {
        char c = toMaiusculo(s[i]);
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c <= 'A' || c >= 'Z')
        {
            eConsoante = false;
            i = strlen(s);
        }
    }
    return eConsoante;
}

/**
 * Testa se uma String e' um numero inteiro
 *
 * @param s String a ser testada
 * @return True se for um numero inteiro
 */
bool eInteiro(char s[])
{
    bool eInteiro = true;
    for (int i = 0; i < strlen(s); i++)
    {
        char c = s[i];
        if (c < '0' || c > '9')
        {
            eInteiro = false;
            i = strlen(s);
        }
    }
    return eInteiro;
}

/**
 * Testa se uma String e' um numero real
 * pode ou nao possuir '.' ou ',' mas nao mais do que 1
 *
 * @param s String a ser testada
 * @return True se for um numero real
 */
bool eReal(char s[])
{
    bool eReal = true;
    int pontos = 0;
    for (int i = 0; i < strlen(s); i++)
    {
        char c = s[i];
        if (c < '0' || c > '9' || c == '.' || c == ',')
        {
            if ((c == '.' || c == ',') && pontos < 1)
            {
                pontos++;
                continue;
            }
            eReal = false;
            i = strlen(s);
        }
    }
    return eReal;
}

/**
 * @brief Metodo para testar se string esta escrito 'FIM'
 *
 * @param s       String a ser testada
 * @return true   se String for 'FIM'
 * @return false  se nao for
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
        {
            printf("%s ", eVogal(entrada) ? "SIM" : "NAO");
            printf("%s ", eConsoante(entrada) ? "SIM" : "NAO");
            printf("%s ", eInteiro(entrada) ? "SIM" : "NAO");
            printf("%s\n", eReal(entrada) ? "SIM" : "NAO");
        }
    }

    return 0;
}
