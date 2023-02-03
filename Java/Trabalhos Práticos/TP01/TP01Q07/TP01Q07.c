// dependencias para a aplicação
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

// metodo para verificar se a entrada eh composta por apenas numeros inteiros
int isIntNum(char* entry) {
    // atributos principais do metodo
    int answer = 0, count = 0;

    // percorrendo o dado de entrada e checando cada caracter e se for um numero inteiro, aumenta no contador
    for (int i = 0; i < strlen(entry); i++) {
        if (entry[i] >= '0' && entry[i] <= '9') {
            count++;
        }
    }

    // caso o contador de inteiros seja igual ao numero de caracteres da entrada, significa que todos são inteiros
    if (count == strlen(entry)) {
        answer = 1;
    } else {
        answer = 0;
    }

    // retorno do resultado do metodo depois do tratamento da entrada
    return (answer);
}

// metodo para verificar se a entrada eh composta por apenas numeros reais
int isRealNum(char* entry) {
    // atributos principais do metodo
    int answer = 0;
    int dotCount = 0, count = 0, auxCount = 0, intAux = 0;

    /*  Forma de segurança para garantir que o ponto flutuante não esta na primeira ou ultima posição no dado de entrada
        fazendo com que talvez a saida seja errada. Apos o teste ja começa a verificação se há apenas numeros na entrada
        começando da segunda posição do dado de entrada para não ter o custo de testar a primeira posição novamente.
        
        if (entry[0] == '.' && entry[strlen(entry) - 1] == '.'
            || entry[0] == ',' && entry[strlen(entry) - 1] == ',') {
            dotCount++;
        } else {
            count++;
        } 
        
        Obs.:
        Apos isso o contador do for abaixo devera começar em 1 para evitar erro nas posicoes da string.
    */

    /* Percorrendo o dado de entrada e verificando se há um ponto flutuante entre ela para considerar como um numero real
    e também verificando se há somente numeros. */
    for (int i = 0; i < strlen(entry); i++) {
        if (entry[i] == '.' || entry[i] == ',') {
            count++;
            dotCount++;
        } else if (entry[i] >= '0' && entry[i] <= '9') {
            count++;
        }
    }

    // testando caso seja apenas um numero inteiro (se enquadra nos numeros reais)
    intAux = isIntNum(entry);

    // teste final para verificar se há somente numeros e somente um ponto flutuante no dado de entrada
    if (count == strlen(entry) && dotCount == 1 || intAux == 1) {
        auxCount++;
    }

    // caso o contador de numeros reais seja compativel aos testes, retornar o resultado
    if (auxCount == 1) {
        answer = 1;
    } else {
        answer = 0;
    }

    // retorno do resultado do metodo depois do tratamento da entrada
    return (answer);
}

// metodo para verificar se a entrada eh composta por apenas consoantes
int isCons(char* entry) {
    // atributos principais do metodo
    int answer = 0, count = strlen(entry);

    // percorrendo o dado de entrada pra verificar se contem apenas consoantes
    for (int i = 0; i < strlen(entry); i++) {
        if (entry[i] >= 'a' && entry[i] <= 'z' || entry[i] >= 'A' && entry[i] <= 'Z') {
                if (entry[i] != 'A' && entry[i] != 'E' && entry[i] != 'I' &&
                    entry[i] != 'O' && entry[i] != 'U' && entry[i] != 'a' &&
                    entry[i] != 'e' && entry[i] != 'i' && entry[i] != 'o' &&
                    entry[i] != 'u' ) {
                        count--;
                    }
            }
    }

    // testando se a entrada contem apenas consoantes e definindo o valor da variavel auxiliar a ser retornada
    if (count == 0) {
        answer = 1;
    } else {
        answer = 0;
    }

    // retorno do resultado do metodo depois do tratamento da entrada
    return (answer);
}

// metodo para verificar se a entrada eh composta por apenas vogais
int isVowal(char* entry) {
    // atributos principais do metodo
    int answer = 0, count = 0;

    // percorrendo o dado de entrada pra verificar se contem apenas vogais
    for (int i = 0; i < strlen(entry); i++) {
        if (entry[i] == 'a' || entry[i] == 'e' || entry[i] == 'i' || entry[i] == 'o' || entry[i] == 'u' ||
            entry[i] == 'A' || entry[i] == 'E' || entry[i] == 'I' || entry[i] == 'O' || entry[i] == 'U') {
                count++;
            }
    }

    // testando se a entrada contem apenas vogais e definindo o valor da variavel auxiliar a ser retornada
    if (count == strlen(entry)) {
        answer = 1;
    } else {
        answer = 0;
    }

    // retorno do resultado do metodo depois do tratamento da entrada
    return (answer);
}

// metodo para mostrar todas as respostas de forma formatada
void show(int isVowalResp, int isConsResp, int isIntNumResp, int isRealNumResp) {

    // pegando os valores das variaveis ja testadas e imprimindo SIM ou NAO correspondente com seus valores
    if (isVowalResp == 1) { printf("SIM "); } else { printf("NAO "); }
    if (isConsResp == 1) { printf("SIM "); } else { printf("NAO "); }
    if (isIntNumResp == 1) { printf("SIM "); } else { printf("NAO "); }
    if (isRealNumResp == 1) { printf("SIM\n"); } else { printf("NAO\n"); }
}

// metodo para ser usado como condição de parada do programa
int isEnd(char* entry) {
    // atributo auxiliar para o metodo
    int answer = 0;

    // verificando a condicao de parada como entrada sendo: 'FIM'
    if (entry[0] == 'F' && entry[1] == 'I' && entry[2] == 'M') {
        answer = 1;
    }

    // retornando a reposta do metodo
    return (answer);
}

// metodo principal
int main (void) {
    // atributo principal
    char entry[1000];

    do {
        // registrando a entrada do teclado para a variavel
        fgets(entry, 1000, stdin);

        // eliminando os espaços em branco da entrada
        if( entry[strlen(entry - 1) == '\n']) {
			entry[strlen(entry) - 1] = 0;
		}

        // instanciando como zerado para todos os testes necessarios
        int isVowalResp = 0, isConsResp = 0, isIntNumResp = 0, isRealNumResp = 0;

        // atribuindo os valores booleanos para cada variavel para saida final
        isVowalResp = isVowal(entry);
        isConsResp = isCons(entry);
        isIntNumResp = isIntNum(entry);
        isRealNumResp = isRealNum(entry);

        // imprimindo na tela de forma formatada todos as respostas
        show(isVowalResp, isConsResp, isIntNumResp, isRealNumResp);

    } while (isEnd(entry) == 0); // condição de parada do programa

    // limpando a memoria ao final do programa
    return (0);
}
