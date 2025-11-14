public class Game {
    private Board board;
    private TicTacToeGUI gui;
    private String currentPlayer;
    private boolean gameOver;

    // Constructor
    public Game() {
        board = new Board();
        currentPlayer = "X";
        gameOver = false;
        gui = new TicTacToeGUI(this);
    }

    public void handleMove(int row, int col) {
        if (gameOver) return;

        if (!board.isValidMove(row, col)) return;

        board.makeMove(row, col, currentPlayer);
        gui.updateTile(row, col, currentPlayer);

        if (board.isWin(currentPlayer)) {
            gameOver = true;
             gui.showWinner(currentPlayer);
            return;
        }

        if (board.isTie()) {
            gameOver = true;
             gui.showTie();
            return;
        }

        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public void startNewGame() {
        currentPlayer = "X";
        gameOver = false;

        board.clearBoard();
        gui.reset();
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
