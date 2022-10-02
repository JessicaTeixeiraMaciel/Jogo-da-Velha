//Classe que exibe as instruções do jogo.
import java.util.Scanner;

public class Instructions {
    public static void instructions(){
        CleanScreen.cleanScreen();
        Scanner sc = new Scanner(System.in);
        System.out.println("|---------------------------------------------------------------------------------------------------------|\n" +
                "|                                              INSTRUÇÕES                                                 |\n" +
                "|---------------------------------------------------------------------------------------------------------|\n" +
                "| Objetivo do jogo:                                                                                       |\n" +
                "| Ser o primeiro a fazer uma sequência de três símbolos iguais, seja em uma linha, coluna ou diagonal.    |\n" +
                "|                                                                                                         |                \n" +
                "| Regras:                                                                                                 |\n" +
                "| - Um jogador joga com o círculo 'O' e outro com o xis 'X'.                                              |\n" +
                "| - Cada jogador, na sua vez, marca uma lacuna que esteja vazia.                                          |\n" +
                "| - Quando um jogador conquista o objetivo, ganha 1 ponto.                                                |\n" +
                "| - Quando há empate, o jogo informa que “deu velha”, e ninguém marca ponto.                              |\n" +
                "| - O jogador que joga com os xis 'X' sempre é o primeiro jogar.                                          |\n" +
                "|---------------------------------------------------------------------------------------------------------|");
        System.out.println("Insira qualquer digito para voltar:");
        sc.next();
        CleanScreen.cleanScreen();
    }
}
