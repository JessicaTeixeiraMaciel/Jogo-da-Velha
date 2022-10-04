//Classe que exibe o menu de opções no MEIO do jogo.

import java.util.Scanner;

public class OptionsMenu {
    public static void optionsMenu(String[] args){
        Scanner sc = new Scanner(System.in);
        CleanScreen.cleanScreen();
        System.out.println(
                "|---------------------------------------------------------------------------------------------------------|\n" +
                        "|                                                  MENU                                                   |\n" +
                        "|---------------------------------------------------------------------------------------------------------|\n" +
                        "| Insira 'i' para ver instruções                                                                          |\n" +
                        "| Insira 'r' para reiniciar o jogo                                                                        |\n" +
                        "| Insira 's' para sair                                                                                    |\n" +
                        "| Ou insira qualquer outro digito para retomar a partida                                                  |\n" +
                        "|---------------------------------------------------------------------------------------------------------|\n" +
                "Insira sua opção aqui:");

        String choose = sc.next().toLowerCase();

        switch (choose) {
            case "s":
                EndGame.endGame();
            case "i":
                Instructions.instructions();
                optionsMenu(args);
                break;
            case "r":
                Main.main(args);
                break;

            default:
                CleanScreen.cleanScreen();
        }
    }
}
