//Classe que exibe o menu de opções no MEIO do jogo.

import java.util.Scanner;

public class OptionsMenu {
    public static void optionsMenu(){
        Scanner sc = new Scanner(System.in);
        CleanScreen.cleanScreen();
        System.out.println(
                "|---------------------------------------------------------------------------------------------------------|\n" +
                        "|                                                  MENU                                                   |\n" +
                        "|---------------------------------------------------------------------------------------------------------|\n" +
                        "| Insira 'i' para ver instruções                                                                          |\n" +
                        "| Insira 'r' para reiniciar o jogo                                                                        |\n" +
                        "| Insira 's' para sair                                                                                    |\n" +
                        "| Ou insira qualquer digito para ir para próxima rodada                                                   |\n" +
                        "|---------------------------------------------------------------------------------------------------------|\n" +
                "Insira sua opção aqui:");

        String choose = sc.next().toLowerCase();

        switch (choose) {
            case "s":
                System.out.print("OBRIGADA POR JOGAR O JOGO DA VELHA! ATÉ MAIS!");
                System.exit(0);
            case "i":
                Instructions.instructions();
                optionsMenu();
                break;
            case "r":
                Start.start();
                break;
        }
    }
}
