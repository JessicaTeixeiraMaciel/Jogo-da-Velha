//Esta é formatação do tabuleiro. Falta criar a matriz e substituir os '%s' por posições na matriz.
//Podemos fazer dentro desta classe ou levar tudo pra classe principal. O que for mais fácil... rsrs
public class Board {
    public static void board(){

        System.out.printf("\n|-----|-----|-----|\n" +
                "| %s | %s | %s |\n" +
                "|-----|-----|-----|\n" +
                "| %s | %s | %s |\n" +
                "|-----|-----|-----|\n" +
                "| %s | %s | %s |\n" +
                "|-----|-----|-----|\n","(1)","(2)","(3)","(4)","(5)","(6)","(7)","(8)","(9)");

    }

}
