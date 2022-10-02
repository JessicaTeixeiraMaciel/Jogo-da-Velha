import java.util.Scanner;

public class PlayerNames {
    public static String playersNames(String playerNumber){

        Scanner sc = new Scanner(System.in);
        System.out.printf("Insira o nome do %s jogador:\n",playerNumber);
        return sc.next().toUpperCase();

    }
}
