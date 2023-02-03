// dependencias para a aplicação
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

// metodo para verificar se a entrada eh um palindromo
int isPalindrome (char* entry, int answer) {
    
    // atributos auxiliares para a execucao da aplicação
    int count = 0;
    int auxJ = strlen(entry);

    // percorrendo a entrada e verificando se eh um palindromo
    for (int i = 0; i < strlen(entry); i++) {
        if (entry[i] == entry[strlen(entry) - i - 1]) {
            count++;
            auxJ--;
        }
    }

    // verificando se eh verdadeiro ou não e atribuindo isso a variavel 'resposta'
    if (count == strlen(entry)) {
        answer = 1;
    } else {
        answer = 0;
    }

    // retornando a resposta se eh ou não um palindromo
    return (answer);
}

// metodo para condição de parada do programa
int isEnd(char* entry) {
    
    // atributo auxiliar para o metodo
    int answer = 0;

    // verificando a condicao de parada como entrada sendo: 'FIM'
    if(entry[0] == 'F' && entry[1] == 'I' && entry[2] == 'M') {
		answer = 1;
	}

    // retornando a reposta do metodo
    return (answer);
}

// metodo principal
int main (void) {

    // atributos principais do metodo
    char entry[1000];

    // metodo para repeticao de testes necessarios
    do {
        // resetando a varivel padrao para resposta final
        int answer = 0;
        // registrando a entrada do teclado para a variavel
        fgets(entry, 1000, stdin);
        // eliminando os espaços em branco da entrada
        if( entry[strlen(entry - 1) == '\n']) {
			entry[strlen(entry) - 1] = 0;
		}
        // testando se a entrada eh um palindromo e registando na variavel de resposta final
        answer = isPalindrome(entry, answer);
        // testando o resultado e imprimindo na tela
        if (answer == 1) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

    } while (isEnd(entry) == 0); // condição de parada do programa

    // limpando a memoria ao final do programa
    return 0;
}