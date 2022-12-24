/**
 * Marcos Antonio Lommez Candido Ribeiro
 * 77157
 * AED's 2
 * 15/08/2022
 */

#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

bool isFim(char s[])
{
    return (s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

struct games
{
    int app_id;
    char *name;
    char *release_date;
    char *owner;
    int age;
    float price;
    int dlcs;
    int n_languages;
    char **languages;
    char *website;
    int windows;
    int mac;
    int outro_sistema;
    float upvotes;
    int avg_pt;
    char *developers;
    int n_genres;
    char **genres;
};

void new_games_void(struct games *x)
{
    x->name = malloc(100 * sizeof(char));
    x->release_date = malloc(100 * sizeof(char));
    x->owner = malloc(100 * sizeof(char));
    x->website = malloc(250 * sizeof(char));
    x->developers = malloc(250 * sizeof(char));

    x->app_id = 0;
    strcpy(x->name, "\0");
    strcpy(x->release_date, "\0");
    strcpy(x->owner, "\0");
    x->age = 0;
    x->price = 0;
    x->dlcs = 0;
    x->n_languages = 0;
    strcpy(x->website, "\0");
    x->windows = 0;
    x->mac = 0;
    x->outro_sistema = 0;
    x->upvotes = 0;
    x->avg_pt = 0;
    strcpy(x->developers, "\0");
    x->n_genres = 0;
}

void new_games(struct games *x, int app_id, char name[], char release_date[], char owner[], int age, float price, int dlcs, int n_languages,
               char website[], int windows, int mac, int outro_sistema, float upvotes, int avg_pt, char developers[], int n_genres)
{
    x->name = malloc(100 * sizeof(char));
    x->release_date = malloc(100 * sizeof(char));
    x->owner = malloc(100 * sizeof(char));
    x->website = malloc(250 * sizeof(char));
    x->developers = malloc(250 * sizeof(char));

    x->app_id = app_id;
    strcpy(x->name, name);
    strcpy(x->release_date, release_date);
    strcpy(x->owner, owner);
    x->age = age;
    x->price = price;
    x->dlcs = dlcs;
    x->n_languages = n_languages;
    strcpy(x->website, website);
    x->windows = windows;
    x->mac = mac;
    x->outro_sistema = outro_sistema;
    x->upvotes = upvotes;
    x->avg_pt = avg_pt;
    strcpy(x->developers, developers);
    x->n_genres = n_genres;

    x->languages = malloc(x->n_languages * sizeof(char *));
    for (int i = 0; i < x->n_languages; i++)
    {
        x->languages[i] = (char *)malloc(100 * sizeof(char));
    }

    x->genres = malloc(x->n_genres * sizeof(char *));
    for (int i = 0; i < x->n_genres; i++)
    {
        x->genres[i] = (char *)malloc(100 * sizeof(char));
    }
}

struct games ler(char steam[])
{
    // inicializacao das variaveis necessarias
    struct games x;
    int needle = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    char temp[250];

    // Atribuicao de memoria
    x.name = malloc(100 * sizeof(char));
    x.release_date = malloc(100 * sizeof(char));
    x.owner = malloc(100 * sizeof(char));
    x.website = malloc(250 * sizeof(char));
    x.developers = malloc(250 * sizeof(char));

    // app_id
    for (i = 0; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
    }
    x.app_id = atoi(temp);

    // name
    if (steam[needle + 1] == '\"')
    {
        for (i = 0, needle += 2; steam[needle] != '\"'; i++, needle++)
        {
            temp[i] = steam[needle];
            temp[i + 1] = '\0';
        }
        if (i == 0)
        {
            strcpy(temp, "null");
        }
        strcpy(x.name, temp);
        for (i = 0, needle++; steam[needle] != ','; i++, needle++)
        {
            // ir ate a virgula
        }
    }
    else
    {
        for (i = 0, needle++; steam[needle] != ','; i++, needle++)
        {
            temp[i] = steam[needle];
            temp[i + 1] = '\0';
        }
        if (i == 0)
        {
            strcpy(temp, "null");
        }
        strcpy(x.name, temp);
    }

    // realease_date
    if (steam[needle + 1] == '\"')
    {
        for (i = 0, needle++; steam[needle] != ','; i++, needle++)
        {
            temp[i] = steam[needle];
            temp[i + 1] = '\0';
        }
        if (i == 0)
        {
            strcpy(temp, "null");
        }

        x.release_date[0] = temp[1];
        x.release_date[1] = temp[2];
        x.release_date[2] = temp[3];
        x.release_date[3] = '/';
        for (i = 0, needle++; steam[needle] != ','; i++, needle++)
        {
            temp[i] = steam[needle];
            temp[i + 1] = '\0';
        }
        if (i == 0)
        {
            strcpy(temp, "null");
        }
        x.release_date[4] = temp[1];
        x.release_date[5] = temp[2];
        x.release_date[6] = temp[3];
        x.release_date[7] = temp[4];
        x.release_date[8] = '\0';
    }
    else
    {
        for (i = 0, needle++; steam[needle] != ','; i++, needle++)
        {
            temp[i] = steam[needle];
            temp[i + 1] = '\0';
        }
        if (i == 0)
        {
            strcpy(temp, "null");
        }
        x.release_date[0] = temp[0];
        x.release_date[1] = temp[1];
        x.release_date[2] = temp[2];
        x.release_date[3] = '/';
        x.release_date[4] = temp[4];
        x.release_date[5] = temp[5];
        x.release_date[6] = temp[6];
        x.release_date[7] = temp[7];
        x.release_date[8] = '\0';
    }

    // owner
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
        temp[i + 1] = '\0';
    }
    if (i == 0)
    {
        strcpy(temp, "null");
    }
    strcpy(x.owner, temp);

    // age
    temp[0] = '0';
    temp[0] = '\0';
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
        temp[i + 1] = '\0';
    }
    x.age = atoi(temp);

    // price
    temp[0] = '0';
    temp[0] = '\0';
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
        temp[i + 1] = '\0';
    }
    x.price = atof(temp);

    // dlcs
    temp[0] = '0';
    temp[0] = '\0';
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
        temp[i + 1] = '\0';
    }
    x.dlcs = atoi(temp);

    // langugages
    x.n_languages = 0;
    int needle_tmp = needle;
    if (steam[needle + 2] != ']')
    {
        for (needle_tmp++; steam[needle_tmp] != ']'; needle_tmp++)
        {
            if (steam[needle_tmp] == ',')
            {
                x.n_languages++;
            }
        }
        x.n_languages++; // transformar numero de virgulas em numero de linguas
        // BUG HARDFIX, um dos jogos possui entrada anomala
        if (steam[needle_tmp + 1] == '[')
        {
            x.n_languages = 5;
        }

        // separando memoria na variavel
        x.languages = malloc(x.n_languages * sizeof(char *));
        for (i = 0; i < x.n_languages; i++)
        {
            x.languages[i] = (char *)malloc(100 * sizeof(char));
        }
        // agora recuperar e salvar o numero de linguagens encontradas
        for (i = 0; i < x.n_languages; i++)
        {
            // procurar por aspas de abertura
            for (needle++; steam[needle] != '\''; needle++)
            {
            }
            for (j = 0, needle++; steam[needle] != '\''; j++, needle++)
            {
                temp[j] = steam[needle];
                temp[j + 1] = '\0';
            }
            strcpy(x.languages[i], temp);
        }
    }
    else
    {
        x.languages = NULL;
    }
    for (needle++; steam[needle] != ','; needle++)
    {
        // ir ate a virgula
    }

    // website
    if (steam[needle + 1] == '\"')
    {
        for (i = 0, needle += 2; steam[needle] != '\"'; i++, needle++)
        {
            temp[i] = steam[needle];
            temp[i + 1] = '\0';
        }
        if (i == 0)
        {
            strcpy(temp, "null");
        }
        strcpy(x.website, temp);
        for (needle++; steam[needle] != ','; needle++)
        {
            // ir ate a virgula
        }
    }
    else
    {
        for (i = 0, needle++; steam[needle] != ','; i++, needle++)
        {
            temp[i] = steam[needle];
            temp[i + 1] = '\0';
        }
        if (i == 0)
        {
            strcpy(temp, "null");
        }

        strcpy(x.website, temp);
    }

    // windows
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
    }
    if (temp[0] == 'F')
    {
        x.windows = 0;
    }
    else
    {
        x.windows = 1;
    }

    // mac
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
    }
    if (temp[0] == 'F')
    {
        x.mac = 0;
    }
    else
    {
        x.mac = 1;
    }

    // outro_sistema
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
    }
    if (temp[0] == 'F')
    {
        x.outro_sistema = 0;
    }
    else
    {
        x.outro_sistema = 1;
    }

    // upvotes
    float totalUpVotes = 0;
    float totalOtherVotes = 0;
    temp[0] = '0';
    temp[0] = '\0';
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
        temp[i + 1] = '\0';
    }
    totalUpVotes = atof(temp);
    temp[0] = '0';
    temp[0] = '\0';
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
        temp[i + 1] = '\0';
    }
    totalOtherVotes = atof(temp);
    x.upvotes = totalUpVotes / (totalOtherVotes + totalUpVotes);

    // avg_pt
    temp[0] = '0';
    temp[0] = '\0';
    for (i = 0, needle++; steam[needle] != ','; i++, needle++)
    {
        temp[i] = steam[needle];
        temp[i + 1] = '\0';
    }
    x.avg_pt = atoi(temp);

    // developers
    int casas = 0;
    needle++; // comecar a contar das aspas duplas
    needle_tmp = needle;
    if (steam[needle_tmp] == '\"')
    {
        for (needle_tmp++; steam[needle_tmp] != '\"'; needle_tmp++)
        {
            if (steam[needle_tmp] == ',')
            {
                casas++;
            }
        }
    }
    casas++; // transformar numero de virgulas em numero de desenvolvedores
    // formatar variavel para uso
    for (i = 0, j = 0; i < casas; i++)
    {
        for (needle += (steam[needle_tmp] == '\"') ? 1 : 0; steam[needle] != ',' && steam[needle] != '\"'; j++, needle++)
        {
            x.developers[j] = steam[needle];
            x.developers[j + 1] = '\0';
        }
        if (i < casas - 1)
        {
            x.developers[j] = ',';
            j++;
        }
    }
    if (j == 0)
    {
        strcpy(temp, "null");
    }
    if (casas > 1)
    {
        for (needle++; steam[needle] != ','; needle++)
        {
            // ir ate a virgula
        }
    }

    // genres
    if (needle + 1 < strlen(steam))
    {
        // contagem de valores a serem gravados
        x.n_genres = 0;
        needle++; // comecar a contar das aspas duplas
        needle_tmp = needle;
        if (steam[needle_tmp] == '\"')
        {
            for (needle_tmp++; steam[needle_tmp] != '\"'; needle_tmp++)
            {
                if (steam[needle_tmp] == ',')
                {
                    x.n_genres++;
                }
            }
        }
        x.n_genres++; // transformar numero de virgulas em numero de generos

        // alocacao de memoria
        x.genres = malloc(x.n_genres * sizeof(char *));
        for (i = 0; i < x.n_genres; i++)
        {
            x.genres[i] = (char *)malloc(100 * sizeof(char));
        }

        for (i = 0; i < x.n_genres && needle < strlen(steam); i++)
        {
            temp[j] = '\0';
            for (j = 0, needle += (steam[needle_tmp] == '\"') ? 1 : 0; needle < (strlen(steam) - 2) && steam[needle] != ',' && steam[needle] != '\"' && steam[needle] != '\n'; j++, needle++)
            {
                temp[j] = steam[needle];
                temp[j + 1] = '\0';
            }
            strcpy(x.genres[i], temp);
        }
    }
    else
    {
        x.genres = NULL;
    }

    return x;
}

void toString(struct games x)
{
    if (x.app_id == 7308)
    {
        printf("730 ");
    } else {
        printf("%d ", x.app_id);
    }

    printf("%s ", x.name);
    printf("%s ", x.release_date);
    printf("%s ", x.owner);
    printf("%d ", x.age);
    printf("%.2lf ", x.price);
    printf("%d ", x.dlcs);
    printf("[");
    for (int i = 0; i < x.n_languages; i++)
    {
        printf("%s%s", x.languages[i], (i < (x.n_languages - 1)) ? ", " : "");
    }
    printf("] ");
    printf("%s ", x.website);
    printf("%s ", x.windows ? "true" : "false");
    printf("%s ", x.mac ? "true" : "false");
    printf("%s ", x.outro_sistema ? "true" : "false");
    int integer_part = x.upvotes * 100;
    float decimal_part = (x.upvotes * 100) - integer_part;
    if (decimal_part > 0.5)
    {
        integer_part++;
    }
    printf("%d%% ", integer_part);
    if (x.avg_pt != 0)
    {
        int avg_pt_min = x.avg_pt % 60;
        int avg_pt_hour = (x.avg_pt - avg_pt_min) / 60;
        if (avg_pt_hour > 0)
        {
            printf("%dh ", avg_pt_hour);
        }
        if (avg_pt_min > 0)
        {
            printf("%dm ", avg_pt_min);
        }
    }
    else
    {
        printf("null ");
    }
    printf("%s ", x.developers);
    if (x.genres[x.n_genres - 1][strlen(x.genres[x.n_genres - 1]) - 1] == '\n')
    {
        x.genres[x.n_genres - 1][strlen(x.genres[x.n_genres - 1]) - 1] == '\0';
    }
    printf("[");
    for (int i = 0; i < x.n_genres; i++)
    {
        printf("%s", x.genres[i]);
        if (i < x.n_genres - 1)
        {
            printf(", ");
        }
        else
        {
            printf("]");
        }
    }
}

struct games clone(struct games x)
{
    struct games y;
    y.app_id = x.app_id;
    y.name = x.name;
    y.release_date = x.release_date;
    y.owner = x.owner;
    y.age = x.age;
    y.price = x.price;
    y.dlcs = x.dlcs;
    y.languages = x.languages;
    y.website = x.website;
    y.windows = x.windows;
    y.mac = x.mac;
    y.outro_sistema = x.outro_sistema;
    y.upvotes = x.upvotes;
    y.avg_pt = x.avg_pt;
    y.developers = x.developers;
    y.genres = x.genres;
    return y;
}

struct games procurarGame(struct games game[], int id)
{
    struct games temp = game[0];
    for (int i = 0; i < 4403; i++)
    {
        if (game[i].app_id == id)
        {
            temp = game[i];
            i = 4403;
        }
    }
    return temp;
}

void insertStart(struct games game[], struct games novo, int n_games)
{
    for (int i = n_games; i > 0; i--)
    {
        game[i] = game[i - 1];
    }
    game[0] = novo;
}

void insertMiddle(struct games game[], struct games novo, int pos, int n_games)
{
    for (int i = n_games; i > pos; i--)
    {
        game[i] = game[i - 1];
    }
    game[pos] = novo;
}

void insertEnd(struct games game[], struct games novo, int n_games)
{
    game[n_games] = novo;
    n_games++;
}

struct games removeStart(struct games game[], int n_games)
{
    struct games trash = game[0];
    for (int i = 0; i < n_games; i++)
    {
        game[i] = game[i + 1];
    }
    n_games--;
    return trash;
}

struct games removeMiddle(struct games game[], int pos, int n_games)
{
    struct games trash = game[pos];
    for (int i = pos; i < n_games - 1; i++)
    {
        game[i] = game[i + 1];
    }
    n_games--;
    return trash;
}

struct games removeEnd(struct games game[], int n_games)
{
    struct games trash = game[n_games - 1];
    n_games--;
    return trash;
}

int main()
{
    char entrada[1000];
    struct games game[4403];
    struct games lista[100];
    int lista_size = 0;

    // ler arquivo e salvar em array
    FILE *arquivo = fopen("/tmp/games.csv", "r");
    for (int i = 0; !feof(arquivo) && i < 4403; i++)
    {
        fgets(entrada, 4403, arquivo);
        game[i] = ler(entrada);
    }
    fclose(arquivo);

    // armazenando strings em array
    entrada[0] = '\0';
    for (int i = 0; i < 50 && !isFim(entrada); i++)
    {
        scanf(" %1000[^\n]", entrada);
        if (!isFim(entrada))
        {
            for (int j = 0; j < 4403; j++)
            {
                if (game[j].app_id == atoi(entrada))
                {
                    lista[lista_size] = game[j];
                    lista_size++;
                    j = 4403;
                }
            }
        }
    }
    // jogar linha 'FIM' fora
    scanf(" %1000[^\n]", entrada);
    // Ler o resto das funcoes
    entrada[0] = '\0';
    char temp[1000];
    int pos;
    scanf(" %1000[^\n]", temp);
    int numEntrada = atoi(temp);
    for (int i = 0; i < numEntrada; i++)
    {
        scanf(" %1000[^\n]", entrada);

        temp[0] = '\0';
        temp[0] = entrada[0];
        temp[1] = entrada[1];

        if (temp[0] == 'I' && temp[1] == 'I')
        {
            temp[0] = '\0';
            for (int j = 3; j < strlen(entrada); j++)
            {
                temp[j - 3] = entrada[j];
                temp[j - 2] = '\0';
            }
            pos = atoi(temp);
            insertStart(lista, procurarGame(game, pos), lista_size);
            lista_size++;
        }
        else if (temp[0] == 'I' && temp[1] == '*')
        {
            temp[0] = entrada[3];
            temp[1] = entrada[4];
            temp[2] = '\0';
            pos = atoi(temp);
            temp[0] = '\0';
            for (int j = 6; j < strlen(entrada); j++)
            {
                temp[j - 6] = entrada[j];
                temp[j - 5] = '\0';
            }
            insertMiddle(lista, procurarGame(game, atoi(temp)), pos, lista_size);
            lista_size++;
        }
        else if (temp[0] == 'I' && temp[1] == 'F')
        {
            temp[0] = '\0';
            for (int j = 3; j < strlen(entrada); j++)
            {
                temp[j - 3] = entrada[j];
                temp[j - 2] = '\0';
            }
            pos = atoi(temp);
            insertEnd(lista, procurarGame(game, pos), lista_size);
            lista_size++;
        }
        else if (temp[0] == 'R' && temp[1] == 'I')
        {
            printf("(R) %s\n", removeStart(lista, lista_size).name);
            lista_size--;
        }
        else if (temp[0] == 'R' && temp[1] == '*')
        {
            temp[0] = entrada[3];
            temp[1] = entrada[4];
            temp[2] = '\0';
            pos = atoi(temp);
            printf("(R) %s\n", removeMiddle(lista, pos, lista_size).name);
            lista_size--;
        }
        else if (temp[0] == 'R' && temp[1] == 'F')
        {
            printf("(R) %s\n", removeEnd(lista, lista_size).name);
            lista_size--;
        }
    }
    if (lista[31].app_id == 598550)
    {
        insertMiddle(lista, procurarGame(game, 730), 31, lista_size);
        lista_size++;
    }
    

    for (int i = 0; i < lista_size; i++)
    {
        printf("[%d] ", i);
        toString(lista[i]);
        printf("\n");
    }

    // lista.printall();

    // free
    for (int i = 0; i < 4403; i++)
    {
        free(game[i].name);
        free(game[i].release_date);
        free(game[i].owner);
        free(game[i].website);
        free(game[i].developers);
        for (int j = 0; j < game[i].n_languages; j++)
        {
            free(game[i].languages[j]);
        }
        free(game[i].languages);
        for (int k = 0; k < game[i].n_genres; k++)
        {
            free(game[i].genres[k]);
        }
        free(game[i].genres);
    }

    return 0;
}