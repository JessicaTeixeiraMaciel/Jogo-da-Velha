package teste;

import java.util.Scanner;

public class teste2 {
    public static void main(String[] args) {
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
    }
}
