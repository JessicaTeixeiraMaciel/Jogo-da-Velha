//package teste;
//
//import java.util.Scanner;
//
//public class teste2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[][] boardPositions = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
//        board(boardPositions);
//        System.out.println("Informe sua jogada:");
//        String choice = sc.next();
//        int [] index = getChoiceIndex(choice);
//        boolean available = availablePosition(index,boardPositions);
//        System.out.println(index[0]+ ","+ index[1]);
//        String symbol = "X";
//        changePosition(index,boardPositions,symbol);
//        board(boardPositions);
//    }
//
//    public static int[] getChoiceIndex(String choice){
//        int i = 0,j=0;
//        switch (choice) {
//            case "1":
//                i=0;
//                j=0;
//                break;
//            case "2":
//                i=0;
//                j=1;
//                break;
//            case "3":
//                i=0;
//                j=2;
//                break;
//            case "4":
//                i=1;
//                j=0;
//                break;
//            case "5":
//                i=1;
//                j=1;
//                break;
//            case "6":
//                i=1;
//                j=2;
//                break;
//            case "7":
//                i=2;
//                j=0;
//                break;
//            case "8":
//                i=2;
//                j=1;
//                break;
//            case "9":
//                i=2;
//                j=2;
//                break;
//        }
//        int[] index = {i,j};
//        return index;
//    }
//
//    public static boolean availablePosition(int[] index,String[][] boardPositions) {
//        boolean available = false;
//        int i = index[0];
//        int j = index[1];
//        if ((boardPositions[i][j].equals("x")) && (boardPositions[i][j].equals("O"))) {
//            available = false;
//        } else {
//            available = true;
//        }
//        return available;
//    }
//
//    public static void changePosition(int[] index, String[][] boardPositions, String playerSymbol) {
//        int i = index[0];
//        int j = index[1];
//        boardPositions[i][j] = playerSymbol;
//    }
//
//    public static void board(String[][] positions) {
//        System.out.printf("\n|-----|-----|-----|\n" +
//                "|  %s  |  %s  |  %s  |\n" +
//                "|-----|-----|-----|\n" +
//                "|  %s  |  %s  |  %s  |\n" +
//                "|-----|-----|-----|\n" +
//                "|  %s  |  %s  |  %s  |\n" +
//                "|-----|-----|-----|\n", positions[0][0], positions[0][1], positions[0][2], positions[1][0], positions[1][1], positions[1][2], positions[2][0], positions[2][1], positions[2][2]);
//    }
//
//}
