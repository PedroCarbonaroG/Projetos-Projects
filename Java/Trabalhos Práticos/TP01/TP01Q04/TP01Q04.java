// dependencias para a aplicação
import java.util.*;

// classe principal da aplicação
public class TP01Q04 {

    // metodo principal da classe
    public static void main(String[] args) {
        // instanciando objeto da classe do exercicio em questao
        AlteracaoAleatoriaEmJava alteracaoAleatoriaEmJava = new AlteracaoAleatoriaEmJava();
        alteracaoAleatoriaEmJava.mainMethod();
    }
}

// classe ultilizada para tratar o exercicio em questao
class AlteracaoAleatoriaEmJava {
    
    // metodo para fazer a troca na entrada principal com o numero ou letra gerado aleatoriamente
    String randomChange(String entry) {

        // atributos auxiliares para o metodo
        char auxChar[] = new char[500];
        String auxString;
        
        // percorrer o dado de entrada e salvar os caracteres
        for (int i = 0; i < entry.length(); i++) {
            auxChar[i] = entry.charAt(i);
        }
        // transposição para a string auxiliar
        auxString = entry;

        // definindo as letras ou numeros aleatorios a serem trocados
        char aux1 = letterGenerator();
        char aux2 = letterGenerator();

        // percorrendo o dado a ser tratado e fazendo a troca necessaria referente ao criterio de geração acima
        for (int i = 0; i < entry.length(); i++) {
            if (aux1 == auxChar[i]) {
                auxString = entry.replace(aux1, aux2);
            }
        }

        // retornando o dado tratado
        return (auxString);
    }

    // funcao para gerar letra ou numero aleatorio para a aplicação
    char letterGenerator() {
        // gerador aleatorio dos numeros ou letras
        Random generator = new Random();
        generator.setSeed(4);
        
        // atributo auxiliar
        char c;
        
        // transformando a entrada com o gerador aleatorio
        c = (char)('a' + (Math.abs(generator.nextInt()) % 26));

        // retornando resultado da funcao
        return (c);
    }

    // metodo usado para condição de parada do programa
    boolean isEnd(String entry) {
        return (entry.length() == 3 
        && entry.charAt(0) == 'F'
        && entry.charAt(1) == 'I'
        && entry.charAt(2) == 'M'
        );
    }

    // metodo principal da classe do exercicio
    void mainMethod() {
        // instanciando objeto da classe SCANNER para entrada de dados
        Scanner read = new Scanner(System.in, "UTF-8");
        // atributo principal do metodo
        String entry = read.nextLine();
        
        // estrutura de repeticao para os testes necessarios
        while (isEnd(entry) == false) {

            // atributo auxiliar para a aplicação
            String answer;

            // chamando metodo para fazer a alteração na entrada
            answer = randomChange(entry);

            // imprimindo na tela o resultado final da entrada
            System.out.println(answer);

            // recebendo nova entrada para teste
            entry = read.nextLine();
        }

        // encerrando o objeto de entrada de dados
        read.close();
    }
}