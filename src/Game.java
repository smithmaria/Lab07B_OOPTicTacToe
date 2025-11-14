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
        gui = new TicTacToeGUI(/*this*/);
    }

    public void handleMove(int row, int col) {
        if (gameOver) return;

        if (!board.isValidMove(row, col)) return;

        board.makeMove(row, col, currentPlayer);

        // TODO: update gui

        if (board.isWin(currentPlayer)) {
            gameOver = true;
            // TODO: tell gui it's a win — gui.showWin(currentPlayer);
            return;
        }

        if (board.isTie()) {
            gameOver = true;
            // TODO: tell gui it's a tie — gui.showTie();
            return;
        }

        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public void startNewGame() {
        currentPlayer = "X";
        gameOver = false;

        board.clearBoard();

        // TODO: clear gui board
        // gui.reset();
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
