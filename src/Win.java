//Classe para quando há um VENCEDOR no jogo.
//Está incompleta.
import java.util.Scanner;

public class Win {
    public static void win(){
        Scanner sc = new Scanner(System.in);

        System.err.printf("\n'-' VENCEU A RODADA. JOGADOR MARCA +1 PONTO.");
        Board.board();
        System.out.println("\n---------------------------------------------- FIM DA RODADA ----------------------------------------------\n");

        System.out.println("Insira qualquer digito para continuar, ou insira 'm' para ver o menu de opções:");

        String choose = sc.next().toLowerCase();
        if (choose.equals("m")) {
            OptionsMenu.optionsMenu();
        }
    }
}
