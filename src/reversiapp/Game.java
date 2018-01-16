package reversiapp;

import java.util.List;

public class Game {
    private Display display;
    private Board board;
    private Logic logic;
    private Player player1;
    private Player player2;
    private ScoreTracker tracker;
    private boolean player1Moves;
    private boolean player2Moves;

    /**
     * C'tor.
     * @param newDisplay
     *            - a display.
     * @param newBoard
     *            - a board.
     * @param newLogic
     *            - game logic.
     * @param newP1
     *            - first player.
     * @param newP2
     *            - second player
     */
    public Game(Display newDisplay, Board newBoard, Logic newLogic,
                Player newP1, Player newP2, ScoreTracker newTracker) {
        this.display = newDisplay;
        this.board = newBoard;
        this.logic = newLogic;
        this.player1 = newP1;
        this.player2 = newP2;
        this.tracker = newTracker;
        this.player1Moves = true;
        this.player2Moves = true;
    }

    /**
     * plays the game.
     */
    public void play() {
        while (player1Moves || player2Moves) {
            playTurn(player1);
            System.out.println("PLAYER 1 SCORE: " + tracker.getPlayer1Score());
            System.out.println("PLAYER 2 SCORE: " + tracker.getPlayer2Score());
            playTurn(player2);
            System.out.println("PLAYER 1 SCORE: " + tracker.getPlayer1Score());
            System.out.println("PLAYER 2 SCORE: " + tracker.getPlayer2Score());
        }
        this.determineHighScore(player1, player2);
    }

    /**
     * plays a turn.
     * @param player - a player to play the turn for.
     */
    private void playTurn(Player player) {
        display.displayBoard(board);
        List<Piece> moves = logic.getPossibleMoves(player, board);
        if (moves.size() == 0) {
            this.updateMoves(player, false);
            display.displayNoMoves(player);
            return;
        }
        this.updateMoves(player, true);
        Piece piece = player.pickMove(moves);
        // EVENT ON CELL CLICK
        Piece changedPiece = board.getCell(piece.getRow(), piece.getCol());
        changedPiece.setDisk(player.getColor());
        logic.flip(player, changedPiece, board);
    }

    /**
     * Displays the high score.
     * @param player1 - player 1.
     * @param player2 - player 2.
     */
    private void determineHighScore(Player player1, Player player2) {
//        char player1Disk = player1.getColor();
//        char player2Disk = player2.getColor();
//        int player1Score = 0, player2Score = 0;
//        int bSize = board.getSize();
//        for (int i = 0; i < bSize; i++) {
//            for (int j = 0; j < bSize; j++) {
//                Piece current = board.getCell(i, j);
//                char disk = current.getDisk();
//                if (disk == player1Disk) {
//                    player1Score++;
//                } else if (disk == player2Disk) {
//                    player2Score++;
//                }
//            }
//        }
        int player1Score = tracker.getPlayer1Score();
        int player2Score = tracker.getPlayer2Score();
        display.displayEndScreen(player1, player2, board, player1Score,
                player2Score);
        // ################### REMOVE THIS
        System.out.println("PLAYER 1 SCORE: " + player1Score);
        System.out.println("PLAYER 2 SCORE: " + player2Score);
    }
    /**
     * updates the available moves for the player.
     * @param player - a player.
     * @param hasMoves - moves value.
     */
    private void updateMoves(Player player, boolean hasMoves) {
        char disk = player.getColor();
        if (disk == Sign.kWhites) {
            this.player2Moves = hasMoves;
        } else if (disk == Sign.kBlacks) {
            this.player1Moves = hasMoves;
        }
    }

}