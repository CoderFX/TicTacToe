// It works!

import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game game = new Game();
        System.out.println("Let's play Tic-Tac-Toe!");
        do {
            System.out.println("Current board layout:");
            game.printBoard();
            String coord;
            do {
                System.out.println("Player " + game.getCurrentPlayerMark() + ", enter an empty row and column to place your mark!");
                coord = scan.nextLine();
            }
            while (!game.placeMark(coord));
            game.changePlayer();
        }
        while (game.checkForWin() && !game.isBoardFull());
        if (game.isBoardFull() && game.checkForWin()){
            System.out.println("Game is a tie!");
        } else {
            System.out.println("Current board layout:");
            game.printBoard();
            game.changePlayer();
            System.out.println(game.getCurrentPlayerMark() + " wins!");
        }
    }

}
