import java.util.Scanner;

public class AppLogic {
    void playerMove(Scanner scan, char[] box) {
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

    void makeComputerMove(char[] box) {
        while (true) {
            byte rand = (byte) (Math.random() * 9 + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    void printGrid(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    boolean checkWin(char[] box, char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((box[i] == symbol && box[i + 3] == symbol && box[i + 6] == symbol) ||
                    (box[i * 3] == symbol && box[i * 3 + 1] == symbol && box[i * 3 + 2] == symbol))
                return true;
        }
        return (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    boolean checkDraw(char[] box) {
        for (char cell : box) {
            if (cell != 'X' && cell != 'O') {
                return false;
            }
        }
        return true;
    }

    void printWinner(WinnerEnum.Winner winner) {
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