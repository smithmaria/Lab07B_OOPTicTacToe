import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI extends JFrame {
    private Game game;
    private TicTacToeTile[][] tiles;
    private JLabel statusLabel;
    private JButton newGameButton;

    private static final int ROW = 3;
    private static final int COL = 3;

    public TicTacToeGUI(Game game) {
        this.game = game;

        setTitle("Tic Tac Toe");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

         createGameBoard();
         createControlPanel();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void createGameBoard() {
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(ROW, COL, 5, 5));

        tiles = new TicTacToeTile[ROW][COL];

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                tiles[row][col] = new TicTacToeTile(row, col);
                tiles[row][col].setFont(new Font("Arial", Font.BOLD, 72));

                tiles[row][col].addActionListener(e -> {
                    TicTacToeTile tile = (TicTacToeTile) e.getSource();
                    game.handleMove(tile.getRow(), tile.getCol());
                });

                gamePanel.add(tiles[row][col]);
            }
        }

        add(gamePanel, BorderLayout.CENTER);
    }

    public void createControlPanel() {
        JPanel controlPanel = new JPanel();

        statusLabel = new JLabel("Player X's turn");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));

        newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Arial", Font.BOLD, 18));
        newGameButton.addActionListener(e -> game.startNewGame());

        controlPanel.add(statusLabel);
        controlPanel.add(newGameButton);

        add(controlPanel, BorderLayout.SOUTH);
    }

    public void updateTile(int row, int col, String player) {
        tiles[row][col].setText(player);
        if (player.equals("X")) {
            statusLabel.setText("Player O's turn");
        } else {
            statusLabel.setText("Player X's turn");
        }
    }

    public void showWinner(String player) {
        statusLabel.setText("Player " + player + " wins!");
    }

    public void showTie() {
        statusLabel.setText("It's a tie!");
    }

    public void reset() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                tiles[row][col].setText(" ");
            }
        }
        statusLabel.setText("Player X's turn");
    }
}
