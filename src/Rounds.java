//Classe que exibe a rodada atual.

public class Rounds {


    public static void rounds(int roundNumber){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";
        System.out.printf(ANSI_PURPLE + "------------------------------------------------" + ANSI_RESET + " RODADA %s" + ANSI_PURPLE +" ------------------------------------------------\n" + ANSI_RESET,roundNumber);
    }
}
