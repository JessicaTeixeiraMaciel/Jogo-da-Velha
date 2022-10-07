//Classe que exibe o menu de opções no INICIO do jogo.
import java.util.Scanner;

public class HomeMenu {
    public static void homeMenu(){
            Scanner sc = new Scanner(System.in);
            CleanScreen.cleanScreen();

        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";

        System.out.println(ANSI_PURPLE +
                    "|---------------------------------------------------------------------------------------------------------|\n" +
                            "|                                                  " + ANSI_RESET + "MENU" + ANSI_PURPLE + "                                                   |\n" +
                            "|---------------------------------------------------------------------------------------------------------|\n" +
                            "| "+ ANSI_RESET + "Insira 'i' para ver instruções" + ANSI_PURPLE + "                                                                          |\n" +
                            "| "+ ANSI_RESET + "Insira 'r' para reiniciar o jogo" + ANSI_PURPLE + "                                                                        |\n" +
                            "| "+ ANSI_RESET + "Insira 's' para sair" + ANSI_PURPLE + "                                                                                    |\n" +
                            "| "+ ANSI_RESET + "Ou insira qualquer outro digito para retornar ao menu principal" + ANSI_PURPLE + "                                         |\n" +
                            "|---------------------------------------------------------------------------------------------------------|\n"  + ANSI_RESET +
                            "Insira sua opção aqui:");

            String choose = sc.next().toLowerCase();

            if (choose.equals("s")) {
                EndGame.endGame();
            } else if (choose.equals("i")) {
                Instructions.instructions();
                homeMenu();
            } else {
                Start.start();
            }
    }
}
