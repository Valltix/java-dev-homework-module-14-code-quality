import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] box = new char[9];
        for (int j = 0; j < box.length; j++) box[j] = (char) (49 + j);

        System.out.println("Enter box number to select. Enjoy!\n");

        AppLogic appLogic = new AppLogic();

        while (true) {
            appLogic.printGrid(box);

            appLogic.playerMove(scan, box);
            if (appLogic.checkWin(box, 'X')) {
                appLogic.printWinner(WinnerEnum.Winner.PLAYER);
                break;
            }
            if (appLogic.checkDraw(box)) {
                appLogic.printWinner(WinnerEnum.Winner.DRAW);
                break;
            }

            appLogic.makeComputerMove(box);
            if (appLogic.checkWin(box, 'O')) {
                appLogic.printWinner(WinnerEnum.Winner.COMPUTER);
                break;
            }
        }
    }
}