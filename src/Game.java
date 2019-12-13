import java.util.regex.Pattern;

class Game {
    private String[][] board;
    private String currentPlayerMark;

    Game() {
        board = new String[3][3];
        currentPlayerMark = "X";  // Can be changed between X and O
        initializeBoard();
    }

    String getCurrentPlayerMark()
    {
        return currentPlayerMark;
    }

    // Set/Reset the board back to all empty values.
    private void initializeBoard() {
        int coord = 0;

        // Loop through rows
        for (int i = 0; i < 3; i++) {
            // Loop through columns
            for (int j = 0; j < 3; j++) {
                coord++;
                board[i][j] = String.valueOf(coord);
                //System.out.println(coord);
            }
        }
    }

    // Print the current board
    void printBoard() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Pattern.matches("\\d", board[i][j])) {
                    isFull = false;
                }
            }
        }

        return isFull;
    }

    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    boolean checkForWin() {
        return (!checkRowsForWin() && !checkColumnsForWin() && !checkDiagonalsForWin());
    }

    // Loop through rows and see if any are winners.
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    // Loop through columns and see if any are winners.
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    // Check to see if all three values are not empty indicating a win.
    private boolean checkRowCol(String c1, String c2, String c3) {
        return (c1.equals("X") && c2.equals("X") && c3.equals("X") || c1.equals("O") && c2.equals("O") && c3.equals("O"));
        //return (!Pattern.matches("\\d", c1) && !Pattern.matches("\\d", c2) && !Pattern.matches("\\d", c3));
    }

    // Change player marks back and forth.
    void changePlayer() {
        if (currentPlayerMark.equals("X")) {
            currentPlayerMark = "O";
        }
        else {
            currentPlayerMark = "X";
        }
    }

    // Places a mark at the cell specified by row and col with the mark of the current player.
    boolean placeMark(String coord) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(coord)) {
                    board[i][j] = currentPlayerMark;
                    return true;
                }
            }
        }
        return false;
    }


}
