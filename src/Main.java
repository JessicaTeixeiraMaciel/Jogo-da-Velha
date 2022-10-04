import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Classe com a tela inicial do jogo.
        Start.start();

        //Classe que limpa a tela
        CleanScreen.cleanScreen();

        //Informa para o usuário que o jogo irá iniciar.
        System.out.println("\nOk, vamos começar!\n");

        //Pergunta o nome dos jogadores. Armazena os nomes nas Strings player1 e player2. Também incializa os símbolos de cada jogador.
        String[] playersNames = playerNames();
        String[] playersSymbol = {"X", "O"};

        //Informa para o usuário os simbólos de cada jogador.
        System.out.printf("\nEntendido! %s jogará com o xis 'X' e %s jogará com o círculo 'O'.\n", playersNames[0], playersNames[1]);

        //Chama a função, dentro da classe Main, que roda o jogo.
        Game(playersNames[0], playersSymbol[0], playersNames[1], playersSymbol[1]);

        // finalizar jogo dizendo obrigado
    }

    private static String[] playerNames() {
        Scanner sc = new Scanner(System.in);
        String[] playersArray = {"abc","cde"};

        for (int i = 0; i < 2; i++) {
            System.out.printf("Insira o nome do %dª jogador:\n", i + 1);
            playersArray[i] = sc.next().toUpperCase();
        }
        return playersArray;
    }

    //Função principal que roda o jogo (incompleta).
    public static void Game(String player1, String player1Symbol, String player2, String player2Symbol) {

        //Armazena a numeração de cada rodada.
        int round = 1;

        //array para contabilizar o placar
        int[] scoreBoard = {0,0};

        //inicializa o jogador e o símbolo
        String player = player1;
        String playerSymbol = player1Symbol;

        //Cria a matriz de posições do tabuleiro
        String[][] boardPositions = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

        //Indica quando a rodada deve terminar, cumprindo as seguintes condições:
        //- Alguém vencer (quando a função checkWinner retornar 'true');
        //- Ou tiver mais de 9 jogadas (automáticamente o resultado será 'velha').

        boolean rematch = true;
        do {
            //Chama as classes que exibem a rodada e placar.
            Rounds.rounds(round);
            //score(player1, player2);

            //Armazenará a numeração partida
            int turn = 0;

            Scanner sc = new Scanner(System.in);
            while ((!checkWinner) && (turn <= 8)) {
            //Intercala as jogadas entre os jogadores '1' e '2'.
            // Devo usar o round para testar a rodada atual, para poder puxa-lo no winner
            turn++;
            if (turn % 2 == 1) {
                player = player1;
                playerSymbol = player1Symbol;
            } else {
                player = player2;
                playerSymbol = player2Symbol;
            }

            System.out.printf("\nÉ a vez do '%s' jogar! %s, escolha uma posição livre:", playerSymbol, player);

            //Chama método que exibe o tabuleiro.
            board(boardPositions);

            System.out.println("Informe sua jogada:");
            String choice = sc.next();

            // muda a posição escolhida pelo jogador pelo seu símbolo
            changePosition(choice, boardPositions, playerSymbol);
        }
            if (turn>=8){
                rematch = tie(boardPositions);
            } else {
                rematch = win(boardPositions,player);
                if (player.equals(player1)){
                    scoreBoard[0]++;
                } else{
                    scoreBoard[1]++;
                }
                System.out.printf("RODADA %d PLACAR: %s %d VS %d %s\n", round, player1, scoreBoard[0], scoreBoard[1], player2);
            }
            round++;
        } while (rematch);

        // colocar mensagem de obrigado por jogar
        CleanScreen.cleanScreen();
    }

    //Função que imprime o tabuleiro a partir do vetor de posições atuais
    public static void board(String[][] positions) {
        System.out.printf("\n|-----|-----|-----|\n" +
                "|  %s  |  %s  |  %s  |\n" +
                "|-----|-----|-----|\n" +
                "|  %s  |  %s  |  %s  |\n" +
                "|-----|-----|-----|\n" +
                "|  %s  |  %s  |  %s  |\n" +
                "|-----|-----|-----|\n", positions[0][0], positions[0][1], positions[0][2], positions[1][0], positions[1][1], positions[1][2], positions[2][0], positions[2][1], positions[2][2]);
    }

    //Função que muda o símbolo conforme a opção escolhida
    public static void changePosition(String choice, String[][] boardPositions, String playerSymbol) {
        switch (choice) {
            case "1":
                boardPositions[0][0] = playerSymbol;
                break;
            case "2":
                boardPositions[0][1] = playerSymbol;
                break;
            case "3":
                boardPositions[0][2] = playerSymbol;
                break;
            case "4":
                boardPositions[1][0] = playerSymbol;
                break;
            case "5":
                boardPositions[1][1] = playerSymbol;
                break;
            case "6":
                boardPositions[1][2] = playerSymbol;
                break;
            case "7":
                boardPositions[2][0] = playerSymbol;
                break;
            case "8":
                boardPositions[2][1] = playerSymbol;
                break;
            case "9":
                boardPositions[2][2] = playerSymbol;
                break;
        }
    }

    // Função que retorna a variável de controle do DoWhile caso haja vencedor
    public static boolean win(String[][] boardPositions, String player){
        Scanner sc = new Scanner(System.in);

        System.err.printf("\n%s VENCEU A RODADA. JOGADOR MARCA +1 PONTO.", player);
        board(boardPositions);
        System.out.println("\n---------------------------------------------- FIM DA RODADA ----------------------------------------------\n");
        boolean revanche;
        System.out.println("Revanche? (s/n)");
        String choose = sc.next().toLowerCase();
        if (choose.equals("s")) {
            return revanche = true;
        }else{
            return revanche = false;
        }
    }
    //Método (devido a maior facilidade de acessar board positions) para quando há EMPATE no jogo

    public static boolean tie(String[][] boardPositons){
        System.err.println("\nDEU VELHA!!! NINGUÉM MARCA PONTO.");
        board(boardPositons);
        System.out.println("\n---------------------------------------------- FIM DA RODADA ----------------------------------------------\n");
        boolean revanche;
        Scanner sc = new Scanner(System.in);
        System.out.println("Jogar novamente? (s/n)");
        String choose = sc.next().toLowerCase();
        if (choose.equals("s")) {
            return revanche = true;
        }else{
            return revanche = false;
        }
    }

    //Função que checa se há um vencedor (incompleta).
    public static boolean checkWinner(){

        return false;
    }

    //Função que soma e exibe o placar (incompleta).
//    public static void score(String player1,String player1, String player2,int[] scoreBoard){
//        System.out.printf("PLACAR: %s %d VS %d %s\n",player1,scoreBoard[0],scoreBoard[1],player2);
//    }
}
