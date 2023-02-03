// dependencias para a aplicação
import java.util.*;

// classe principal do exercicio
public class TP01Q01 {
    public static void main(String[] args) {
        // instanciando objeto da classe para solução
        PalindromoEmJava palindromoEmJava = new PalindromoEmJava();
        palindromoEmJava.entries();
    }
}

// classe que possui os metodos para solução e execução do exercicio
class PalindromoEmJava {

    // metodo para verificar se a palavra eh um palindromo
    boolean isPalindrome(String entry, boolean answer) {

        // atributos auxiliares para execucao do programa
        int count = 0;
        int j = (entry.length() - 1);

        // metodo para verificar se eh um palindromo, adicionando na contagem auxiliar
        for (int i = 0; i < entry.length(); i++) {
            if (entry.charAt(i) == entry.charAt(j)) {
                count++;
                j--;
            }
        }

        // testando se a contagem auxiliar for igual o tamanho da entrada, significa que eh um palindromo
        if (count == entry.length()) {
            answer = true;
        } else {
            answer = false;
        }

        // retornando o resultado do metodo
        return answer;
    }

    // metodo para checar a condicao de parada do programa
    boolean isEnd(String entry) {
        return (entry.length() == 3 
        && entry.charAt(0) == 'F'
        && entry.charAt(1) == 'I'
        && entry.charAt(2) == 'M'
        );
    }

    // metodo para entrada de dados
    void entries() {
        // instanciando objeto da classe SCANNER para entrada de dados
        Scanner read = new Scanner(System.in, "UTF-8");
        
        // atribulo principal necessario para o exercicio
        String entry = read.nextLine();

        // metodo de repeticao para pausar quando a condicação for necessaria
        while (isEnd(entry) == false) {
            boolean answer = false;
            answer = isPalindrome(entry, answer);
            
            // imprimir na tela o resultado final 
            if (answer == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }

            // colhendo o proximo teste
            entry = read.nextLine();
        }

        // encerrar o objeto para entrada de dados
        read.close();
    }
}