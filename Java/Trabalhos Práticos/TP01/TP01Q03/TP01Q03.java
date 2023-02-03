// dependencias para a aplicação
import java.util.*;

// classe principal do exercicio
public class TP01Q03 {
    
    // metodo principal da classe
    public static void main(String[] args) {
        // instanciando o objeto da classe especifica para o exercicio
        CiframentoDeCesarEmJava ciframentoDeCesarEmJava = new CiframentoDeCesarEmJava();
        ciframentoDeCesarEmJava.method01();
    }
}

// classe para execuções dos metodos necessarios para o exercicio
class CiframentoDeCesarEmJava {
    
    // metodo usado para cifrar o dado de entrada
    String encryptMethod(String entry, String answer) {
        
        // atributo auxiliar para conversão de caracter
        char aux;

        // metodo para percorrer a entrada, caracter por caracter, cifrando cada um com o codigo 3 (exigido pelo exercicio)
        for (int i = 0; i < entry.length(); i++) {
            // usado o metodo de conversão para um caracter : (char)
            aux = (char) (entry.charAt(i) + 3);
            // concatenando para a String de resultado final com os caracteres cifrados
            answer += aux;
        }

        // retornando a entrada cifrada
        return answer;
    }
    
    // metodo usado para condição de parada do programa
    boolean isEnd(String entry) {
        return (entry.length() == 3 
        && entry.charAt(0) == 'F'
        && entry.charAt(1) == 'I'
        && entry.charAt(2) == 'M'
        );
    }
    
    // metodo principal da classe para resolução do exercicio
    void method01() {
        // instanciando objeto da classe Scanner para entrada de dados
        Scanner read = new Scanner(System.in, "UTF-8");
        
        // atributo principal do metodo
        String entry = read.nextLine();

        // looping de repeticao com a condicao de parada desejada
        while (isEnd(entry) == false) {
            // atributo auxiliar para resposta do exercicio
            String answer = "";

            // chamando metodo para cifrar o dado de entrada
            answer = encryptMethod(entry, answer);

            // mostrando na tela a resposta cifrada
            System.out.println(answer);

            // coletando proximo dado para teste (caso haja)
            entry = read.nextLine();
        }

        // encerrando o objeto para entrada de dados
        read.close();
    }
}