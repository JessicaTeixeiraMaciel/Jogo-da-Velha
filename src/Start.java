//Classe que exibe a tela inicial do jogo.

import java.util.Scanner;
public class Start {

    public static void start(){
        CleanScreen.cleanScreen();
        Title.title();
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira qualquer digito para iniciar ou insira 'm' para acessar o menu de opções:");

        String choose = sc.next().toLowerCase();

        if (choose.equals("m")) {
            HomeMenu.homeMenu();
        }

    }
}
