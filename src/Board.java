public class Board {
    private static final int ROW = 3;
    private static final int COL = 3;
    private String[][] board;

    // Constructor
    public Board() {
        board = new String[ROW][COL];
         clearBoard();
    }

    public void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    public void makeMove(int row, int col, String player) {
        board[ROW][COL] = player;
    }

    public String getMarkAt(int row, int col) {
        return board[ROW][COL];
    }

    public boolean isWin(String player) {
        return (isRowWin(player) || isColWin(player) || isDiagonalWin(player));
    }

    public boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[ROW][0].equals(player) ||
                board[ROW][1].equals(player) ||
                board[ROW][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean isColWin(String player) {
        for (int col = 0; col < ROW; col++) {
            if (board[0][col].equals(player) ||
                    board[1][col].equals(player) ||
                    board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) &&
            board[1][1].equals(player) &&
            board[2][2].equals(player)) {
            return true;
        }

        if (board[0][2].equals(player) &&
            board[1][1].equals(player) &&
            board[2][0].equals(player)) {
            return true;
        }

        return false;
    }

    public boolean isTie() {
        boolean xFlag = false;
        boolean oFlag = false;

        for (int row = 0; row < ROW; row++) {
            xFlag = board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X");

            oFlag = board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O");

            if (!(xFlag && oFlag)) {
                return false;
            }

            xFlag = oFlag = false;
        }

        for (int col = 0; col < COL; col++) {
            xFlag = board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X");

            oFlag = board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O");

            if (!(xFlag && oFlag)) {
                return false;
            }

            xFlag = oFlag = false;
        }

        xFlag = board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X");

        oFlag = board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O");

        if (!(xFlag && oFlag)) {
            return false;
        }

        xFlag = oFlag = false;

        xFlag = board[0][2].equals("X") ||
                board[1][1].equals("X") ||
                board[2][0].equals("X");

        oFlag = board[0][2].equals("O") ||
                board[1][1].equals("O") ||
                board[2][0].equals("O");

        if (!(xFlag && oFlag)) {
            return false;
        }

        return true;
    }
}
