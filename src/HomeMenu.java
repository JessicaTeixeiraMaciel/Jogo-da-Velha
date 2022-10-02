//Classe que exibe o menu de opções no INICIO do jogo.
import java.util.Scanner;

public class HomeMenu {
    public static void homeMenu(){
            Scanner sc = new Scanner(System.in);
            CleanScreen.cleanScreen();
            System.out.println(
                    "|---------------------------------------------------------------------------------------------------------|\n" +
                            "|                                                  MENU                                                   |\n" +
                            "|---------------------------------------------------------------------------------------------------------|\n" +
                            "| Insira 'i' para ver instruções                                                                          |\n" +
                            "| Insira 'r' para reiniciar o jogo                                                                        |\n" +
                            "| Insira 's' para sair                                                                                    |\n" +
                            "| Ou insira qualquer digito para retornar ao menu principal                                               |\n" +
                            "|---------------------------------------------------------------------------------------------------------|\n" +
                            "Insira sua opção aqui:");

            String choose = sc.next().toLowerCase();

            if (choose.equals("s")) {
                System.out.print("OBRIGADA POR JOGAR O JOGO DA VELHA! ATÉ MAIS!");
                System.exit(0);
            } else if (choose.equals("i")) {
                Instructions.instructions();
                homeMenu();
            } else {
                Start.start();
            }
    }
}
