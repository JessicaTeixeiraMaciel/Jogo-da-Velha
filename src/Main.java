import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Tela inicial do jogo
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
            boolean winner = false;

            Scanner sc = new Scanner(System.in);
            while ((!winner && turn <= 8))
            {

            //Intercala as jogadas entre os jogadores '1' e '2'.
            turn++;
            if (turn % 2 == 1) {
                player = playerOne;
                playerSymbol = playerOneSymbol;
            } else {
                player = playerTwo;
                playerSymbol = playerTwoSymbol;
            }

            System.out.printf("\nÉ a vez do '%s' jogar! %s, escolha uma posição livre.", playerSymbol, player);

            //Chama método que exibe o tabuleiro.
            board(boardPositions);

            // Tratar as entradas do jogador
            System.out.println("Informe sua jogada:");

            // transformar a posição escolhida em um array com os índices
            int[] index = getChoiceIndex(sc);

            // Checa a posição está disponível
            while (!availablePosition(index,boardPositions)){
                System.err.println("Posição inválida.");
                System.out.println("Informe novamente a sua jogada:");
                index = getChoiceIndex(sc);;
            }

            //Muda a posição escolhida pelo jogador pelo seu símbolo
            changePosition(index, boardPositions, playerSymbol);
            winner = checkWinner(boardPositions);
        }

            if(winner)
                win(boardPositions,player,playerOne,scoreBoard, playerTwo,playerSymbol,args);
            else
                tie(boardPositions,playerOne,scoreBoard, playerTwo,args);

            round++;

            // limpa o tabuleiro
            boardPositions = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        } while (rematch);
        CleanScreen.cleanScreen();
    }

    //Função que imprime o tabuleiro a partir do vetor de posições atuais

    public static void board(String[][] positions) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";
        System.out.printf(ANSI_PURPLE + "\n|-----|-----|-----|\n" +
                "|  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |\n" +
                "|-----|-----|-----|\n" +
                "|  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |\n" +
                "|-----|-----|-----|\n" +
                "|  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |  " + ANSI_RESET + "%s" + ANSI_PURPLE + "  |\n" +
                "|-----|-----|-----|\n" + ANSI_RESET, positions[0][0], positions[0][1], positions[0][2], positions[1][0], positions[1][1], positions[1][2], positions[2][0], positions[2][1], positions[2][2]);
    }

    // armazena em um vetor as posições na matriz da escolha
    public static int[] getChoiceIndex(Scanner sc){
        int i = 0,j=0, numberChoice = 0;

        while (true)
        {
            try
            {
                String choice = sc.next();
                int n = Integer.parseInt(choice);

                if(n > 0 && n < 10)
                {
                    numberChoice = n;
                    break;
                }
            }

            catch (Exception e){}

            String ANSI_RESET = "\u001B[0m";
            String ANSI_RED = "\u001B[31m";

            System.out.println(ANSI_RED + "Caracter inválido." +  ANSI_RESET);
            System.out.println("Informe novamente a sua jogada:");

        }
        switch (numberChoice) {
            case 1:
                i=0;
                j=0;
                break;
            case 2:
                i=0;
                j=1;
                break;
            case 3:
                i=0;
                j=2;
                break;
            case 4:
                i=1;
                j=0;
                break;
            case 5:
                i=1;
                j=1;
                break;
            case 6:
                i=1;
                j=2;
                break;
            case 7:
                i=2;
                j=0;
                break;
            case 8:
                i=2;
                j=1;
                break;
            case 9:
                i=2;
                j=2;
                break;
        }
        int[] index = {i,j};
        return index;
    }

    // Função que checa se a posição está disponível e se é válida
    public static boolean availablePosition(int[] index,String[][] boardPositions){
        boolean available = false;
        int i = index[0];
        int j = index[1];
        boolean equalsX = boardPositions[i][j].equals("X");
        boolean equals0 = boardPositions[i][j].equals("O");
        if ((equalsX) || (equals0)){
            available = false;
        } else {
            available = true;
        }
        return available;
    }

    //Função que muda o símbolo conforme a opção escolhida
    public static void changePosition(int[] index, String[][] boardPositions, String playerSymbol) {
            int i = index[0];
            int j = index[1];
            boardPositions[i][j] = playerSymbol;
    }

    // Função que retorna a variável de controle do DoWhile caso haja vencedor
    public static void win(String[][] boardPositions, String player, String playerOne, int[] scoreBoard, String playerTwo, String playerSymbol,String[] args){

        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";

        if (player.equals(playerOne)){
            scoreBoard[0]++;
        } else{
            scoreBoard[1]++;
        }
        System.out.printf(ANSI_PURPLE + "\n'%s' VENCEU A RODADA! %s MARCA +1 PONTO.\n" + ANSI_RESET , playerSymbol, player);
        score(playerOne,scoreBoard, playerTwo);
        endRound(boardPositions, "Revanche?",playerOne,scoreBoard, playerTwo,args);
    }

    public static void tie(String[][] boardPositions, String playerOne, int[] scoreBoard, String playerTwo,String[] args){

        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";

        System.out.println(ANSI_YELLOW + "\nDEU VELHA!!! NINGUÉM MARCA PONTO." + ANSI_RESET);
        score(playerOne,scoreBoard, playerTwo);
        endRound(boardPositions, "Jogar novamente?",playerOne,scoreBoard, playerTwo,args);
    }

    public static void endRound (String[][] boardPositions, String playAgain, String playerOne, int[] scoreBoard, String playerTwo,String[] args){
        Scanner sc = new Scanner(System.in);
        board(boardPositions);
        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";
        System.out.println(ANSI_PURPLE + "\n---------------------------------------------- "+ ANSI_RESET +"FIM DA RODADA"+ ANSI_PURPLE +" ----------------------------------------------" + ANSI_RESET);
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
