import java.util.Scanner;

public class App {
    enum Winner {
        PLAYER, COMPUTER, DRAW
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] box = new char[9];
        for (int j = 0; j < box.length; j++) box[j] = (char) (49 + j);

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            printGrid(box);

            playerMove(scan, box);
            if (checkWin(box, 'X')) {printWinner(Winner.PLAYER); break;}
            if (checkDraw(box)) {printWinner(Winner.DRAW);   break;}

            makeComputerMove(box);
            if (checkWin(box, 'O')) {printWinner(Winner.COMPUTER);break;}
        }
    }
    static void playerMove(Scanner scan, char[] box) {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O') {
                    System.out.println("That one is already in use. Enter another.");
                } else {
                    box[input - 1] = 'X';
                    break;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }
    static void makeComputerMove(char[] box) {
        while (true) {
            byte rand = (byte) (Math.random() * 9 + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }
    static void printGrid(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
    static boolean checkWin(char[] box, char symbol) { // Перевірка горизонталей, вертикалей, діагоналей
        for (int i = 0; i < 3; i++) {
            if ((box[i] == symbol && box[i + 3] == symbol && box[i + 6] == symbol) ||
                (box[i * 3] == symbol && box[i * 3 + 1] == symbol && box[i * 3 + 2] == symbol))
                return true;
        }
        return (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }
    static boolean checkDraw(char[] box) {
        for (char cell : box) {
            if (cell != 'X' && cell != 'O') {
                return false;
            }
        }
        return true;
    }
    static void printWinner(Winner winner) {
        switch (winner) {
            case PLAYER:
                System.out.println("You won the game! Created by Shreyas Saha. Thanks for playing!");
                break;
            case COMPUTER:
                System.out.println("You lost the game! Created by Shreyas Saha. Thanks for playing!");
                break;
            case DRAW:
                System.out.println("It's a draw! Created by Shreyas Saha. Thanks for playing!");
                break;
        }
    }
}