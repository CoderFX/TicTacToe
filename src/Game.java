public class Game {
    private String[][] board;
    private String currentPlayerMark;

    public Game() {
        board = new String[3][3];
        currentPlayerMark = "X";  // Can be changed between X and O
        initializeBoard();
    }

    public String getCurrentPlayerMark()
    {
        return currentPlayerMark;
    }

    // Set/Reset the board back to all empty values.
    public void initializeBoard() {
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
    public void printBoard() {
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
    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("-")) {
                    isFull = false;
                }
            }
        }

        return isFull;
    }

    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
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

    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(String c1, String c2, String c3) {
        return ((!c1.equals("-")) && (c1 == c2) && (c2 == c3));
    }

    // Change player marks back and forth.
    public void changePlayer() {
        if (currentPlayerMark.equals("X")) {
            currentPlayerMark = "O";
        }
        else {
            currentPlayerMark = "X";
        }
    }

    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col) {

        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col].equals("-")) {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }

        return false;
    }


}
