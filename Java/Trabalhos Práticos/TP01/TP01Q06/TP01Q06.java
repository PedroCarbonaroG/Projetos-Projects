// dependencias para a execução da aplicação
import java.util.*;

// classe principal da aplicação
public class TP01Q06 {
    // metodo principal da classe
    public static void main(String[] args) {
        // instanciando objeto da classe auxiliar para execução da aplicação
        IsEmJava isEmJava = new IsEmJava();
        isEmJava.mainMethod();
    }
}

// classe auxiliar para executar funções de tratamento da classe principal
class IsEmJava {

    // metodo para checar se o dado tratado eh composto por apenas numeros reais
    boolean isRealNum(String entry) {
        // atributo auxiliar do metodo
        boolean aux = false, intAux = false;
        int dotCount = 0, count = 0, auxCount = 0;

        /*  Forma de segurança para garantir que o ponto flutuante não esta na primeira ou ultima posição no dado de entrada
            fazendo com que talvez a saida seja errada. Apos o teste ja começa a verificação se há apenas numeros na entrada
            começando da segunda posição do dado de entrada para não ter o custo de testar a primeira posição novamente.
        
            if (entry.charAt(0) == '.' && entry.charAt(entry.length() - 1) == '.'
                || entry.charAt(0) == ',' && entry.charAt(entry.length() - 1) == ',') {
                dotCount++;
            } else {
                count++;
            } 
        
            Obs.:
            Apos isso o contador do for abaixo devera começar em 1 para evitar erro nas posicoes da string.
        */

        /*  Percorrendo o dado de entrada e verificando se há um ponto flutuante entre ela para considerar como um numero real
            e também verificando se há somente numeros.
        */ 
        for (int i = 0; i < entry.length(); i++) {
            if (entry.charAt(i) == '.' || entry.charAt(i) == ',') {
                count++;
                dotCount++;
            } else if (entry.charAt(i) >= '0' && entry.charAt(i) <= '9') {
                count++;
            }
        }

        intAux = isIntNum(entry);

        // teste final para verificar se há somente numeros e somente um ponto flutuante no dado de entrada
        if (count == entry.length() && dotCount == 1 || intAux == true) {
            auxCount++;
        }

        // caso o contador de numeros reais seja compativel aos testes, retornar o resultado
        if (auxCount == 1) {
            aux = true;
        } else {
            aux = false;
        }

        // retornando o valor da variavel auxiliar
        return (aux);
    }

    // metodo para checar se o dado tratado eh composto por apenas numeros inteiros
    boolean isIntNum(String entry) {
        // atributo auxiliar do metodo
        boolean aux = false;
        int cout = 0;

        // metodo para percorrer o dado de entrada e checar cada caracter e se for um numero inteiro, aumenta no contador
        for (int i = 0; i < entry.length(); i++) {
            if (entry.charAt(i) >= '0' && entry.charAt(i) <= '9') {
                cout++;
            }
        }

        // caso o contador de inteiros seja igual ao numero de caracteres da entrada, significa que todos são inteiros
        if (cout == entry.length()) {
             // retornando verdadeiro caso bata a condição anterior
            aux = true;
        } else {
            // forçando retornar falso caso não bata a condição anterior
            aux = false;
        }

        // retornando o valor da variavel auxiliar
        return (aux);
    }

    // metodo para checar se o dado tratado eh composto por apenas consoantes
    boolean isCons(String entry) {
        // atributo auxiliar do metodo
        boolean aux = false;

        int count = entry.length();

        // metodo para percorrer o dado de entrada e checar cada caracter e se for uma consoante, aumenta no contador
        for (int i = 0; i < entry.length(); i++) {
            if (entry.charAt(i) >= 'a' && entry.charAt(i) <= 'z' || entry.charAt(i) >= 'A' && entry.charAt(i) <= 'Z') {
                if (entry.charAt(i) != 'A' && entry.charAt(i) != 'E' && entry.charAt(i) != 'I' &&
                    entry.charAt(i) != 'O' && entry.charAt(i) != 'U' && entry.charAt(i) != 'a' &&
                    entry.charAt(i) != 'e' && entry.charAt(i) != 'i' && entry.charAt(i) != 'o' &&
                    entry.charAt(i) != 'u' ) {
                        count--;
                    }
            }
        }

        // caso o contador de consoantes seja igual ao numero de caracteres da entrada, significa que todas são consoantes
        if (count == 0) {
            // retornando verdadeiro caso bata a condição anterior
            aux = true;
        } else {
            // forçando retornar falso caso não bata a condição anterior
            aux = false;
        }

        // retornando o valor da variavel auxiliar
        return (aux);
    }

    // metodo para checar se o dado tratado eh composto por apenas vogais
    boolean isVowal(String entry) {
        // atributo auxiliar do metodo
        boolean aux = false;
        int cout = 0;

        // metodo para percorrer o dado de entrada e checar cada caracter e se for uma vogal, aumenta no contador
        for (int i = 0; i < entry.length(); i++) {
            if (entry.charAt(i) == 'A' || entry.charAt(i) == 'E' || entry.charAt(i) == 'I' ||
                entry.charAt(i) == 'O' || entry.charAt(i) == 'U' || entry.charAt(i) == 'a' ||
                entry.charAt(i) == 'e' || entry.charAt(i) == 'i' || entry.charAt(i) == 'o' ||
                entry.charAt(i) == 'u' ) {
                    cout++;
                }
        }

        // caso o contador de vogais seja igual ao numero de caracteres da entrada, significa que todas são vogais
        if (cout == entry.length()) {
            // retornando verdadeiro caso bata a condição anterior
            aux = true;
        } else {
            // forçando retornar falso caso não bata a condição anterior
            aux = false;
        }

        // retornando o valor da variavel auxiliar
        return (aux);
    }

    // metodo para mostrar todos os resultados formatados na tela
    void show(boolean vowals, boolean cons, boolean intNum, boolean realNum) {

        // pegando os valores das variaveis ja testadas e imprimindo SIM ou NAO correspondente com seus valores
        if (vowals == true) { System.out.print("SIM "); } else { System.out.print("NAO "); }
        if (cons == true) { System.out.print("SIM "); } else { System.out.print("NAO "); }
        if (intNum == true) { System.out.print("SIM "); } else { System.out.print("NAO "); }
        if (realNum == true) { System.out.println("SIM"); } else { System.out.println("NAO"); }
    }

    // metodo para condição de parada do programa
    boolean isEnd(String entry) {
        return (entry.length() == 3 
        && entry.charAt(0) == 'F'
        && entry.charAt(1) == 'I'
        && entry.charAt(2) == 'M'
        );
    }
    
    // metodo principal da classe
    void mainMethod() {
        // instanciando objeto da classe SCANNER para entrada de dados
        Scanner read = new Scanner(System.in, "UTF-8");

        // atributo principal do metodo
        String entry = read.nextLine();

        // laço de repetições para diversos testes na aplicação
        while (isEnd(entry) == false) {

            // atributos auxiliares para a aplicação
            boolean vowals, cons, intNum, realNum;

            // chamando os metodos de verificação de cada teste
            vowals = isVowal(entry);
            cons = isCons(entry);
            intNum = isIntNum(entry);
            realNum = isRealNum(entry);

            // chamando metodo para mostrar todos os resultados já formatados
            show(vowals, cons, intNum, realNum);
        
            // coletando proximo dado de entrada para teste
            entry = read.nextLine();
        }

        // encerrando o objeto da classe SCANNER para entrada de dados
        read.close();
    }
}