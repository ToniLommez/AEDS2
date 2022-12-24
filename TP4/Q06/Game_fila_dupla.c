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
#include <time.h>

bool isFim(char s[])
{
    return (s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

struct games
{
    int app_id;
    char *name;
    char *release_date;
    int dia;
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

        char tempdia[20];
        tempdia[0] = temp[5];
        if (strlen(temp) == 7) {
            tempdia[1] = temp[6];
            tempdia[2] = '\0';
        } else{
            tempdia[1] = '\0';
        }
        x.dia = atoi(tempdia);

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
        } else {
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
        x.dia = 1;
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
    printf("%d ", x.app_id);

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
    if (decimal_part >= 0.5)
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
    y.dia = x.dia;
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
    struct games temp = game[3930];
    game[3930].app_id = 1939810;
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

typedef struct ListaDupla {
	struct games game;        
	struct ListaDupla* next; // Aponta a celula prox.
    struct ListaDupla* prev;  // Aponta a celula anterior.
} ListaDupla;

typedef struct ControleLista {
    struct ListaDupla* inicio;
    struct ListaDupla* fim;
    int length;
} ControleLista;

ListaDupla* novaListaDupla(struct games game) {
   ListaDupla* nova = (ListaDupla*) malloc(sizeof(ListaDupla));
   nova->game = game;
   nova->next = NULL;
   nova->prev = NULL;
   return nova;
}

ControleLista* start() {
    ControleLista* controle = (ControleLista*) malloc(sizeof(ControleLista));
    ListaDupla* nova = (ListaDupla*) malloc(sizeof(ListaDupla));
    nova->next = NULL;
    nova->prev = NULL;
    controle->inicio = controle->fim = nova;
    controle->length = 0;
    return controle;
}

void insertStart(ControleLista* controle, struct games game)
{
    ListaDupla* novo = novaListaDupla(game);
    novo->next = controle->inicio;
    novo->prev = NULL;
    controle->inicio->prev = novo;
    controle->inicio = novo;
    controle->length += 1;
}

void insertEnd(ControleLista* controle, struct games game)
{
    ListaDupla* novo = novaListaDupla(game);
    novo->next = NULL;
    novo->prev = controle->fim;
    controle->fim->next = novo;
    controle->fim = novo;
    controle->length++;
}

void printAllRec(ListaDupla* atual, int i)
{
    if (atual->next != NULL)
    {
        printAllRec(atual->next, i);
        toString(atual->game);
        printf("\n");
    }
}

void printAll(ListaDupla* topo)
{
    printAllRec(topo, -1);
}

// ---------------------------- QUICK SORT --------------------------- //

int getMonthNumber(char month[]) {
    if (strcmp(month, "Jan") == 0)
        return 1;
    else if (strcmp(month, "Feb") == 0)
        return 2;
    else if (strcmp(month, "Mar") == 0)
        return 3;
    else if (strcmp(month, "Apr") == 0)
        return 4;
    else if (strcmp(month, "May") == 0)
        return 5;
    else if (strcmp(month, "Jun") == 0)
        return 6;
    else if (strcmp(month, "Jul") == 0)
        return 7;
    else if (strcmp(month, "Aug") == 0)
        return 8;
    else if (strcmp(month, "Sep") == 0)
        return 9;
    else if (strcmp(month, "Oct") == 0)
        return 10;
    else if (strcmp(month, "Nov") == 0)
        return 11;
    else if (strcmp(month, "Dec") == 0)
        return 12;
    else
        return 0;
}

int eMaiorQuick(struct games a, struct games b, int *comparacoes) {
    int mes_a;
    int mes_b;
    int ano_a;
    int ano_b;
    char temp_a[30];
    temp_a[0] = '\0';
    char temp_b[30];
    temp_b[0] = '\0';
    // recuperar valor do mes
    temp_a[0] = a.release_date[0];
    temp_a[1] = a.release_date[1];
    temp_a[2] = a.release_date[2];
    temp_a[3] = '\0';
    temp_b[0] = b.release_date[0];
    temp_b[1] = b.release_date[1];
    temp_b[2] = b.release_date[2];
    temp_b[3] = '\0';
    mes_a = getMonthNumber(temp_a);
    mes_b = getMonthNumber(temp_b);
    // recuperar valor do ano
    temp_a[0] = '\0';
    temp_b[0] = '\0';

    temp_a[0] = a.release_date[4];
    temp_a[1] = a.release_date[5];
    temp_a[2] = a.release_date[6];
    temp_a[3] = a.release_date[7];
    temp_a[4] = '\0';

    temp_b[0] = b.release_date[4];
    temp_b[1] = b.release_date[5];
    temp_b[2] = b.release_date[6];
    temp_b[3] = b.release_date[7];
    temp_b[4] = '\0';

    ano_a = atoi(temp_a);
    ano_b = atoi(temp_b);

    // decidir qual e maior
    int diferenca = 0;
    if (ano_a > ano_b) {
        diferenca = 1;
    } else if (ano_a < ano_b) {
        diferenca = -1;
    } else if (ano_a == ano_b) {
        if (mes_a > mes_b) {
            diferenca = 1;
        } else if (mes_a < mes_b) {
            diferenca = -1;
        } else if (ano_a == ano_b) {
            *comparacoes += 1;
            if (a.dia > b.dia) {
                diferenca = 1;
            } else {
                *comparacoes += 1;
                if (a.dia < b.dia) {
                    diferenca = -1;
                } else {
                    *comparacoes += 1;
                    if (a.dia == b.dia) {
                        *comparacoes += 1;
                        if (strcmp(a.name, b.name) > 0) {
                            diferenca = 1;
                        } else {
                            *comparacoes += 1;
                            if (strcmp(a.name, b.name) < 0) {
                                diferenca = -1;
                            } else {
                                *comparacoes += 1;
                                if (strcmp(a.name, b.name) == 0) {
                                    diferenca = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    return diferenca;
}

struct games get(int index, ControleLista* controle) {
    int i = 0;
    ListaDupla* ptr = controle->inicio;
    while ((ptr->next != NULL) && i < index) {
        ptr = ptr->next;
        i++;
    }
    struct games game = ptr->game;

    return game;
}

void quicksort(ControleLista* controle, int left, int right, int *comparacoes, int *movimentacoes) {
    int i = left;
    int j = right;
    struct games pivot = get(((left + right) / 2), controle);
    *movimentacoes += 1;
    ListaDupla* ptr1 = controle->inicio;
    ListaDupla* ptr2 = controle->fim->prev;
    for (int l = 0; l < left; l++)
        ptr1 = ptr1->next;
    for (int l = controle->length - 1; l > right; l--)
        ptr2 = ptr2->prev;
    while (i <= j) {
        *comparacoes += 2;
        while (eMaiorQuick(ptr1->game , pivot, comparacoes) > 0) {
            ptr1 = ptr1->next;
            *comparacoes += 1;
            i++;
        }
        while (eMaiorQuick(ptr2->game, pivot, comparacoes) < 0) {
            ptr2 = ptr2->prev;
            *comparacoes += 1;
            j--;
        }
        if (i <= j) {
            struct games tmp = ptr1->game;
            ptr1->game = ptr2->game;
            ptr2->game = tmp;
            *movimentacoes += 3;
            ptr1 = ptr1->next;
            ptr2 = ptr2->prev;
            i++;
            j--;
        }
    }
    if (left < j) {
        quicksort(controle, left, j, comparacoes, movimentacoes);
    }
    if (i < right) {
        quicksort(controle, i, right, comparacoes, movimentacoes);
    }
}

void sort(ControleLista* controle, int *comparacoes, int *movimentacoes) {
    quicksort(controle, 0, (controle->length - 1), comparacoes, movimentacoes);
}


int main()
{
    char entrada[1000];
    struct games game[4403];
    ControleLista* controle = start();

    // ler arquivo e salvar em array
    FILE *arquivo = fopen("/tmp/games.csv", "r");

    for (int i = 0; !feof(arquivo); i++)
    {
        fgets(entrada, 4403, arquivo);
        game[i] = ler(entrada);
    }
    fclose(arquivo);
    
    // armazenando strings em array
    entrada[0] = '\0';
    for (int i = 0; i < 4403; i++)
    {
        scanf(" %1000[^\n]", entrada);
        if (!isFim(entrada))
        {
            struct games tmp = procurarGame(game, atoi(entrada));
            insertStart(controle, tmp);
        }
    }

    // contando tempo, movimentacoes e comparacoes
    int comparacoes = 0;
    int movimentacoes = 0;
    // inicio da contagem
    clock_t t1 = clock();
    // Ordenando
    sort(controle, &comparacoes, &movimentacoes);
    // calculando tempo
    clock_t t2 = clock();
    int diff = (int)((((double)t2 - (double)t1) / (double)CLOCKS_PER_SEC) * 1000);
    // criando log
    FILE *log = fopen("matricula_quicksort3.txt", "w");
    fprintf(log, "771157\t%d\t%d\t%d", comparacoes, movimentacoes, diff);
    fclose(log);

    printAll(controle->inicio);

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