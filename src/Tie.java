//Classe para quando há EMPATE no jogo.

import java.util.Scanner;
public class Tie {
    public static void tie(){
        Scanner sc = new Scanner(System.in);

        System.err.println("\nDEU VELHA!!! NINGUÉM MARCA PONTO.");
        Board.board();
        System.out.println("\n---------------------------------------------- FIM DA RODADA ----------------------------------------------\n");

        System.out.println("Insira qualquer digito para continuar, ou insira 'm' para ver o menu de opções:");

        String choose = sc.next().toLowerCase();
        if (choose.equals("m")) {
            OptionsMenu.optionsMenu();
        }
    }
}
