import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Classe com a tela inicial do jogo.
        Start.start();

        //Classe que limpa a tela.
        CleanScreen.cleanScreen();

        //Informa para o usuário que o jogo irá iniciar.
        System.out.println("\nOk, vamos começar!\n");

        //Classe que pergunta o nome dos jogadores e armazena os nomes nas Strings player1 e player2.
        String player1 = PlayerNames.playersNames("primeiro");
        String player2 = PlayerNames.playersNames("segundo");

        //Informa para o usuário os simbólos de cada jogador.
        System.out.printf("\nEntendido! %s jogará com o xis 'X' e %s jogará com o círculo 'O'.\n\n",player1,player2);

        //Chama a função, dentro da classe Main, que roda o jogo.
        game(player1, player2);

    }

    //Função principal que roda o jogo (incompleta).
    public static void game(String player1, String player2){

        //Armazena a numeração de cada rodada.
        int r = 1;

        //Inicia o jogo com o player '1' e simbolo 'X'.
        String player = player1;
        String simbol = "X";

        Scanner sc = new Scanner(System.in);

        //Mantém jogo rodando, rodada após rodada.
        while (true){

            //Chama as classes que exibem a rodada e placar.
            Rounds.rounds(r);
            score(player1, player2);

            int j = 1;

            //Indica quando a rodada deve terminar, cumprindo as seguintes condições:
            //- Alguém vencer (quando a função checkWinner retornar 'true');
            //- Ou tiver mais de 9 jogadas (automáticamente o resultado será 'velha').
            while ((!checkWinner()) && (j <= 9 )) {

                System.out.printf("\nÉ a vez do '%s' jogar! %s, escolha uma posição livre:",simbol,player);

                //Chama classe que exibe o tabuleiro.
                Board.board();

                System.out.println("Informe sua jogada:");
                sc.next();

                //Intercala as jogadas entre os jogadores '1' e '2'.
                if (player.equals(player1)) {
                    player = player2;
                } else {
                    player = player1;
                }

                //Intercala as jogadas entre 'X' e 'O'.
                if (player.equals(player1)) {
                    simbol = "X";
                } else {
                    simbol = "O";
                }

                j++;
            }
        //Classe para quando o jogo dá empate.
        Tie.tie();

        r++;
        CleanScreen.cleanScreen();
        }
    }

    //Função que checa se há um vencedor (incompleta).
    public static boolean checkWinner(){

        return false;
    }

    //Função que soma e exibe o placar (incompleta).
    public static void score(String player1, String player2){
        int scoreX = 0;
        int scoreO = 0;
        System.out.printf("PLACAR: %s %d VS %d %s\n",player1,scoreX,scoreO,player2);
    }



}
