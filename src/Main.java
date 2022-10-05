import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Tela inicial do jogo.
        Start.start();

        //Limpa a tela
        CleanScreen.cleanScreen();

        System.out.println("\nOk, vamos começar!\n");

        String[] playersNames = playerNames();
        String[] playersSymbol = {"X", "O"};

        System.out.printf("\nEntendido! %s jogará com o xis 'X' e %s jogará com o círculo 'O'.\n\n", playersNames[0], playersNames[1]);

        Game(playersNames[0], playersSymbol[0], playersNames[1], playersSymbol[1],args);
    }

    private static String[] playerNames() {
        Scanner sc = new Scanner(System.in);
        String[] playersArray = {"abc","cde"};

        for (int i = 0; i < 2; i++) {
            System.out.printf("Insira nome do %dª jogador:\n", i + 1);
            String name = sc.nextLine();
            if (name.trim().equals("")){
                i--;
            } else{
                playersArray[i] = name.toUpperCase();
            }
        }
        return playersArray;
    }

    public static void Game(String playerOne, String playerOneSymbol, String playerTwo, String playerTwoSymbol,String[] args) {

        //Armazena a numeração de cada rodada.
        int round = 1;

        //array para contabilizar o placar
        int[] scoreBoard = {0,0};

        //inicializa o jogador e o símbolo
        String player = playerOne;
        String playerSymbol = playerOneSymbol;

        //Cria a matriz de posições do tabuleiro
        String[][] boardPositions = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

        boolean rematch = true;
        do {
            //Chama as classes que exibem a rodada e placar.
            Rounds.rounds(round);

            //score(playerOne, playerTwo);
            score(playerOne,scoreBoard, playerTwo);

            //Armazenará a numeração partida
            int turn = 0;

            Scanner sc = new Scanner(System.in);
            while ((!checkWinner(boardPositions)) && (turn <= 8)) {

            //Intercala as jogadas entre os jogadores '1' e '2'.
            turn++;
            if (turn % 2 == 1) {
                player = playerOne;
                playerSymbol = playerOneSymbol;
            } else {
                player = playerTwo;
                playerSymbol = playerTwoSymbol;
            }

            System.out.printf("\nÉ a vez do '%s' jogar! %s, escolha uma posição livre:", playerSymbol, player);

            //Chama método que exibe o tabuleiro.
            board(boardPositions);

            // Tratar as entradas do jogador
            System.out.println("Informe sua jogada:");
            String choice = sc.next();

            //Muda a posição escolhida pelo jogador pelo seu símbolo
            changePosition(choice, boardPositions, playerSymbol);
        }
            if (turn>=8){
                tie(boardPositions,playerOne,scoreBoard, playerTwo,args);
            } else {
                win(boardPositions,player,playerOne,scoreBoard, playerTwo,playerSymbol,args);
            }
            round++;

            // limpa o tabuleiro
            boardPositions = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        } while (rematch);

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
    public static void win(String[][] boardPositions, String player, String playerOne, int[] scoreBoard, String playerTwo, String playerSymbol,String[] args){

        if (player.equals(playerOne)){
            scoreBoard[0]++;
        } else{
            scoreBoard[1]++;
        }
        System.err.printf("\n'%s' VENCEU A RODADA! %s MARCA +1 PONTO.\n", playerSymbol, player);
        score(playerOne,scoreBoard, playerTwo);
        endRound(boardPositions, "Revanche?",playerOne,scoreBoard, playerTwo,args);
    }

    public static void tie(String[][] boardPositions, String playerOne, int[] scoreBoard, String playerTwo,String[] args){
        System.err.println("\nDEU VELHA!!! NINGUÉM MARCA PONTO.");
        score(playerOne,scoreBoard, playerTwo);
        endRound(boardPositions, "Jogar novamente?",playerOne,scoreBoard, playerTwo,args);
    }

    public static void endRound (String[][] boardPositions, String playAgain, String playerOne, int[] scoreBoard, String playerTwo,String[] args){
        Scanner sc = new Scanner(System.in);
        board(boardPositions);
        System.out.println("\n---------------------------------------------- FIM DA RODADA ----------------------------------------------");
        System.out.println(playAgain + " (s/n)\n" +
                "Para acessar o menu de opções insira qualquer outro digito:");
        String choose = sc.next().toLowerCase();
        if (choose.equals("s")) {
            CleanScreen.cleanScreen();
        }else if (choose.equals("n")){
            System.out.println("\nFIM DE JOGO!");
            score(playerOne,scoreBoard, playerTwo);
            EndGame.endGame();
        }else {
            OptionsMenu.optionsMenu(args);
        }
    }

    //Função que checa se há um vencedor.
    public static boolean checkWinner(String[][] boardPositions){

        if((boardPositions[0][0].equals(boardPositions[0][1])) && (boardPositions[0][1].equals(boardPositions[0][2]))){
            return true;
        } else if ((boardPositions[1][0].equals(boardPositions[1][1])) && (boardPositions[1][1].equals(boardPositions[1][2]))) {
            return true;
        }else if ((boardPositions[2][0].equals(boardPositions[2][1])) && (boardPositions[2][1].equals(boardPositions[2][2]))) {
            return true;
        }else if ((boardPositions[0][0].equals(boardPositions[1][0])) && (boardPositions[1][0].equals(boardPositions[2][0]))) {
            return true;
        }else if ((boardPositions[0][1].equals(boardPositions[1][1])) && (boardPositions[1][1].equals(boardPositions[2][1]))) {
            return true;
        }else if ((boardPositions[0][2].equals(boardPositions[1][2])) && (boardPositions[1][2].equals(boardPositions[2][2]))) {
            return true;
        }else if ((boardPositions[0][0].equals(boardPositions[1][1])) && (boardPositions[1][1].equals(boardPositions[2][2]))) {
            return true;
        }else return (boardPositions[0][2].equals(boardPositions[1][1])) && (boardPositions[1][1].equals(boardPositions[2][0]));
    }

    public static void score(String player1, int[] scoreBoard, String player2){
        System.out.printf("PLACAR: %s %d VS %d %s\n", player1, scoreBoard[0], scoreBoard[1], player2);
    }
}
