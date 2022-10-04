package teste;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
//        String [] playersArray = new String[2];
//        playersArray = PlayerNames01();
//        for (int i=0;i<2;i++){
//            System.out.println(playersArray[i]);
//        }
        int r=1;
        String[][] boardPositions = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};
        while (r<10){
            board(boardPositions);
            Scanner sc = new Scanner(System.in);
            String playerSymbol="X";
            System.out.println("informe a posição");
            String choice = sc.nextLine();
            changePosition(choice,boardPositions,playerSymbol);
            board(boardPositions);
            r++;
        }
    }

    public static void changePosition(String choice, String[][] boardPositions, String playerSymbol){

        switch (choice){
            case "1": boardPositions[0][0]=playerSymbol;
                break;
            case "2": boardPositions[0][1]=playerSymbol;
                break;
            case "3": boardPositions[0][2]=playerSymbol;
                break;
            case "4": boardPositions[1][0]=playerSymbol;
                break;
            case "5": boardPositions[1][1]=playerSymbol;
                break;
            case "6": boardPositions[1][2]=playerSymbol;
                break;
            case "7": boardPositions[2][0]=playerSymbol;
                break;
            case "8": boardPositions[2][1]=playerSymbol;
                break;
            case "9": boardPositions[2][2]=playerSymbol;
                break;
        }
    }


    public static void board(String [][] positions){
        System.out.printf("\n|-----|-----|-----|\n" +
                "|  %s  |  %s  |  %s  |\n" +
                "|-----|-----|-----|\n" +
                "|  %s  |  %s  |  %s  |\n" +
                "|-----|-----|-----|\n" +
                "|  %s  |  %s  |  %s  |\n" +
                "|-----|-----|-----|\n",positions[0][0],positions[0][1],positions[0][2],positions[1][0],positions[1][1],positions[1][2],positions[2][0],positions[2][1],positions[2][2]);
    }

    private static String [] PlayerNames01(){
        Scanner sc = new Scanner(System.in);
        String[] playersArray = {"abc", "cde"};
        for(int i=0; i<2;i++){
            System.out.printf("Insira o nome do %dª jogador:\n",i+1);
            playersArray[i]=sc.next().toUpperCase();
        }
        return playersArray;
    }

}
