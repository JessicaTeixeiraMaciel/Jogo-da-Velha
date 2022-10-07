//Classe que exibe as instruções do jogo.
import java.util.Scanner;

public class Instructions {
    public static void instructions(){
        CleanScreen.cleanScreen();
        Scanner sc = new Scanner(System.in);
        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";

        System.out.println(ANSI_PURPLE + "|---------------------------------------------------------------------------------------------------------|\n" +
                "|" + ANSI_RESET + "                                              INSTRUÇÕES" + ANSI_PURPLE + "                                                 |\n" +
                "|---------------------------------------------------------------------------------------------------------|\n" +
                "|" + ANSI_RESET + " Objetivo do jogo:" + ANSI_PURPLE + "                                                                                       |\n" +
                "|" + ANSI_RESET + " Ser o primeiro a fazer uma sequência de três símbolos iguais, seja em uma linha, coluna ou diagonal." + ANSI_PURPLE + "    |\n" +
                "|                                                                                                         |                \n" +
                "|" + ANSI_RESET + " Regras:" + ANSI_PURPLE + "                                                                                                 |\n" +
                "|" + ANSI_RESET + " - Um jogador joga com o círculo 'O' e outro com o xis 'X'." + ANSI_PURPLE + "                                              |\n" +
                "|" + ANSI_RESET + " - Cada jogador, na sua vez, marca uma lacuna que esteja vazia." + ANSI_PURPLE + "                                          |\n" +
                "|" + ANSI_RESET + " - Quando um jogador conquista o objetivo, ganha 1 ponto." + ANSI_PURPLE + "                                                |\n" +
                "|" + ANSI_RESET + " - Quando há empate, o jogo informa que “deu velha”, e ninguém marca ponto." + ANSI_PURPLE + "                              |\n" +
                "|" + ANSI_RESET + " - O jogador que joga com os xis 'X' sempre é o primeiro jogar." + ANSI_PURPLE + "                                          |\n" +
                "|---------------------------------------------------------------------------------------------------------|" + ANSI_RESET);
        System.out.println("Insira qualquer digito para voltar:");
        sc.next();
        CleanScreen.cleanScreen();
    }
}
